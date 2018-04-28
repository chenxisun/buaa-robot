package cn.edu.buaa.lab.robot.common.util;

import java.io.*;
import java.util.StringTokenizer;

public class FileUtils {
    /**
     * 新建目录
     *
     * @param path 目录
     * @return 返回信息
     */
    public static String createFolder(String path) {
        String res = "目录不能为空";
        if (null != path && !path.isEmpty()) {
            File folderPath = new File(path);
            try {
                if (folderPath.exists()) {
                    res = "创建目录失败  :" + path;
                } else {
                    folderPath.mkdirs();
                    res = "创建目录成功  :" + path;
                }
            } catch (Exception e) {
                e.printStackTrace();
                res = "创建目录操作出错  :" + path;
            }
        }
        return res;
    }

    /**
     * 多级目录创建
     *
     * @param folderPath 准备要在本级目录下创建新目录的目录路径 例如 c:myf
     * @param paths      无限级目录参数，各级目录以单数线区分 例如 a|b|c
     * @return 返回创建文件后的路径 例如 c:myfac or error
     */
    public static String createFolders(String folderPath, String paths) {
        String txts = folderPath;
        try {
            String txt;
            txts = folderPath;
            StringTokenizer st = new StringTokenizer(paths, "|");
            for (int i = 0; st.hasMoreTokens(); i++) {
                txt = st.nextToken().trim();
                if (txts.lastIndexOf("/") != -1) {
                    txts = createFolder(txts + txt);
                } else {
                    txts = createFolder(txts + txt + "/");
                }
            }
        } catch (Exception e) {
            txts = "创建目录操作出错！";
            e.printStackTrace();
        }
        return txts;
    }

    /**
     * 新建文件
     *
     * @param fileName    文本文件完整绝对路径及文件名
     * @param fileContent 文本文件内容
     * @return
     */
    public static boolean createFile(String fileName, String fileContent) {
        boolean res = false;
        try {
            String filePath = fileName;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if (myFilePath.exists()) {
                myFilePath.delete();
            }
            // 如果路径不存在,则创建
            if (!myFilePath.getParentFile().exists()) {
                myFilePath.getParentFile().mkdirs();
            }
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            String strContent = fileContent;
            myFile.println(strContent);
            myFile.close();
            resultFile.close();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 删除文件
     *
     * @param fileName 文本文件完整绝对路径及文件名
     * @return Boolean 成功删除返回true遭遇异常返回false
     */
    public static boolean deleteFile(String fileName) {
        boolean res = false;
        File myDelFile = new File(fileName);
        try {
            res = myDelFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 有编码方式的文件创建
     *
     * @param filePathAndName 文本文件完整绝对路径及文件名
     * @param fileContent     文本文件内容
     * @param encoding        编码方式 例如 GBK 或者 UTF-8
     * @return
     */
    public static boolean createFile(String filePathAndName, String fileContent, String encoding) {
        boolean res = false;

        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            PrintWriter myFile = new PrintWriter(myFilePath, encoding);
            String strContent = fileContent;
            myFile.println(strContent);
            myFile.close();
            res = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 删除文件夹
     *
     * @param folderPath 文件夹完整绝对路径
     * @return
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除指定文件夹下所有文件
     *
     * @param path 文件夹完整绝对路径
     * @return
     */
    public static boolean delAllFile(String path) {
        boolean bea = false;
        File file = new File(path);
        if (!file.exists()) {
            return bea;
        }
        if (!file.isDirectory()) {
            return bea;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                bea = true;
            }
        }
        return bea;
    }


    /**
     * 复制单个文件
     *
     * @param oldPathFile 准备复制的文件源
     * @param newPathFile 拷贝到新绝对路径带文件名
     * @return
     */
    public static void copyFile(String oldPathFile, String newPathFile) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPathFile);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPathFile); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPathFile);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
//                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 复制整个文件夹的内容
     *
     * @param oldPath 准备拷贝的目录
     * @param newPath 指定绝对路径的新目录
     * @return
     */
    public static void copyFolder(String oldPath, String newPath) {
        try {
            new File(newPath).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 移动文件
     *
     * @param oldPath
     * @param newPath
     * @return
     */
    public static void moveFile(String oldPath, String newPath) {
        copyFile(oldPath, newPath);
        deleteFile(oldPath);
    }


    /**
     * 移动目录
     *
     * @param oldPath
     * @param newPath
     * @return
     */
    public static void moveFolder(String oldPath, String newPath) {
        copyFolder(oldPath, newPath);
        delFolder(oldPath);
    }

}
