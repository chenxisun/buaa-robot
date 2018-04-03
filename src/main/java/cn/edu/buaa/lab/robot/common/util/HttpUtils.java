package cn.edu.buaa.lab.robot.common.util;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipCompressingEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger("HttpUtils");

    private static final String UTF8 = "UTF-8";
    private static final int DEFAULT_MAX_CONNECTIONS = 100;
    private static final int DEFAULT_SO_TIMEOUT = 60000;
    private static CloseableHttpClient httpClient = null;
    private static final String GZIP = "gzip";
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String GITF_UPLOAD_FILE_PARAMS = "filecontent";


    public final static PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
    private static final ConnectionKeepAliveStrategy strategy =
            new ConnectionKeepAliveStrategy() {
                @Override
                public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                    // Honor 'keep-alive' header
                    HeaderElementIterator it = new BasicHeaderElementIterator(
                            response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                    while (it.hasNext()) {
                        HeaderElement he = it.nextElement();
                        String param = he.getName();
                        String value = he.getValue();
                        if (value != null && param.equalsIgnoreCase("timeout")) {
                            try {
                                return Long.parseLong(value) * 1000;
                            } catch (NumberFormatException ignore) {
                                logger.error("", ignore);
                            }
                        }
                    }
                    // default keep alive 30s
                    return 30 * 1000;
                }

            };

    static {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(DEFAULT_SO_TIMEOUT)
                .setSocketTimeout(DEFAULT_SO_TIMEOUT)
                .setConnectTimeout(DEFAULT_SO_TIMEOUT)
                .setConnectionRequestTimeout(DEFAULT_SO_TIMEOUT)
                .build();
//        logger.info("socketTimeOut={}, connecteTimeOut={}", requestConfig.getSocketTimeout(), requestConfig
//                .getConnectTimeout());
        SocketConfig socketConfig = SocketConfig.custom()
                .setTcpNoDelay(true).build();
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setMaxTotal(DEFAULT_MAX_CONNECTIONS);
        connManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTIONS);
        // Create connection configuration
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .build();
        connManager.setDefaultConnectionConfig(connectionConfig);
        //connMrg.setMaxPerRoute(new HttpRoute(new HttpHost(host, port)), maxTotal);

        httpClient = HttpClients.custom()
                .evictIdleConnections(1, TimeUnit.SECONDS)
                .setConnectionTimeToLive(DEFAULT_SO_TIMEOUT, TimeUnit.SECONDS)
                .setConnectionManager(connManager)
                .setKeepAliveStrategy(strategy)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    public static String get(String url, int timeout) throws Exception {
        return get(url, null, UTF8, timeout);
    }

    public static String get(String url) throws Exception {
        return get(url, null);
    }

    public static String get(String url, Map<String, String> params) throws Exception {
        return get(url, params, UTF8, DEFAULT_SO_TIMEOUT);
    }

    public static String get(String url, Map<String, String> params, String charset, int timeout) throws Exception {
        HttpGet get = generateCommonGetRequest(url, params, timeout);
        String response = null;
        try {

            HttpEntity entity = httpClient.execute(get).getEntity();
            response = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            logger.error(url, e);
            throw new RuntimeException(url, e);
        } finally {
            logger.info("url:" + url + "," + params);
            get.releaseConnection();
        }

        if (logger.isDebugEnabled()) {
            logger.debug(response);
        }
        return response;
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers, String charset, int
            timeout) throws Exception {
        HttpGet get = generateCommonGetRequest(url, params, timeout);
        String response = null;
        try {
            if (headers != null) {
                for (Map.Entry<String, String> e : headers.entrySet()) {
                    get.addHeader(e.getKey(), e.getValue());
                }
            }

            HttpEntity entity = httpClient.execute(get).getEntity();
            response = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            logger.error(url, e);
            throw new RuntimeException(url, e);
        } finally {
            logger.info("url:" + url + "," + params);
            get.releaseConnection();
        }

        if (logger.isDebugEnabled()) {
            logger.debug(response);
        }

        return response;
    }

    public static String post(String url, String body) {
        String result = post(url, body, getDefaultJsonHeader(), 3 * 60 * 1000);
        return result;
    }

    public static String post(String url, String body,
                              Map<String, String> headers, int timeout) {
        HttpPost post = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        post.setConfig(requestConfig);
        BasicHttpEntity requestBody = null;
        try {
            requestBody = new BasicHttpEntity();
            requestBody.setContent(new ByteArrayInputStream(body.getBytes(UTF8)));
            requestBody.setContentLength(body.getBytes(UTF8).length);
        } catch (UnsupportedEncodingException impossiable) {
            // shouldn't happen
            throw new RuntimeException("UTF-8 is not surportted", impossiable);
        }
        if (headers != null) {
            for (Map.Entry<String, String> e : headers.entrySet()) {
                post.addHeader(e.getKey(), e.getValue());
            }
            if (GZIP.equals(headers.get(CONTENT_ENCODING))) {
                GzipCompressingEntity gzipCompressingEntity = new GzipCompressingEntity(requestBody);
                post.setEntity(gzipCompressingEntity);
            } else {
                //
                post.setEntity(requestBody);
            }
        } else {
            post.setEntity(requestBody);
        }
        String response = null;
        try {
            HttpEntity entity = httpClient.execute(post).getEntity();
            response = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
        } catch (Exception e) {
            throw new RuntimeException(url, e);
        } finally {
            post.releaseConnection();
        }

        if (logger.isDebugEnabled()) {
            logger.debug(response);
        }

        return response;
    }

    public static String put(String url, String body,
                             Map<String, String> headers, int timeout) {
        HttpPut put = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        put.setConfig(requestConfig);
        if (headers != null) {
            for (Map.Entry<String, String> e : headers.entrySet()) {
                put.addHeader(e.getKey(), e.getValue());
            }
        }
        try {
            BasicHttpEntity requestBody = new BasicHttpEntity();
            requestBody.setContent(new ByteArrayInputStream(body.getBytes(UTF8)));
            requestBody.setContentLength(body.getBytes(UTF8).length);
            put.setEntity(requestBody);
        } catch (UnsupportedEncodingException impossiable) {
            // shouldn't happen
            throw new RuntimeException("UTF-8 is not surportted", impossiable);
        }
        String response = null;
        try {
            HttpEntity entity = httpClient.execute(put).getEntity();
            response = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
        } catch (Exception e) {
            throw new RuntimeException(url, e);
        } finally {
            put.releaseConnection();
        }

        if (logger.isDebugEnabled()) {
            logger.debug(response);
        }

        return response;
    }

    public static String delete(String url, Map<String, String> headers, int timeout) {
        HttpDelete delete = new HttpDelete(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        delete.setConfig(requestConfig);
        if (headers != null) {
            for (Map.Entry<String, String> e : headers.entrySet()) {
                delete.addHeader(e.getKey(), e.getValue());
            }
        }

        String response = null;
        try {
            HttpEntity entity = httpClient.execute(delete).getEntity();
            response = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
        } catch (Exception e) {
            throw new RuntimeException(url, e);
        } finally {
            delete.releaseConnection();
        }

        if (logger.isDebugEnabled()) {
            logger.debug(response);
        }

        return response;
    }

    private static HttpGet generateCommonGetRequest(String uri, Map<String, String> params, int timeout)
            throws Exception {
        HttpGet get = new HttpGet(uri);
        if (params != null
                && !params.isEmpty()) {
            URIBuilder uriBuilder = new URIBuilder(get.getURI());
            for (String key : params.keySet()) {
                String value = params.get(key);
                uriBuilder.addParameter(key, value);
            }
            get.setURI(uriBuilder.build());
        }
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        get.setConfig(requestConfig);
        return get;
    }

    /**
     * 上传文件
     */
    public static String uploadImage(String url, File file) {
        String response = null;
        HttpPost post = new HttpPost(url);
        try {
            //文件必须存在
            if (file != null && file.exists() && file.isFile()) {
                FileBody fileBody = new FileBody(file);
                HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                        .addPart(GITF_UPLOAD_FILE_PARAMS, fileBody).setCharset(CharsetUtils.get("UTF-8")).build();
                post.setEntity(reqEntity);
                response = EntityUtils.toString(httpClient.execute(post).getEntity(), CharsetUtils.get("UTF-8"));
            }
        } catch (Exception e) {
            throw new RuntimeException("post " + url, e);
        } finally {
            post.releaseConnection();
        }
        return response;
    }

    public static Map<String, String> getDefaultJsonHeader() {
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        return header;
    }

}