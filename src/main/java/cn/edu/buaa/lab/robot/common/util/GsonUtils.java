package cn.edu.buaa.lab.robot.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class GsonUtils {
    private GsonUtils() {}
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    public static <T> T gToObject(String json, Class<T> cls) throws IOException {
        return gson.fromJson(json, cls);
    }

    public static String gToJson(Object o) {
        return gson.toJson(o);
    }
}
