package com.djxc.study.web.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解压kmz文件
 */
public class unzipKMZ {
    public static void main(String args[]) {
        unzipKMZ uz = new unzipKMZ();
        try{
            uz.unzipfile("/home/djxc/2019/tree.kmz", "/home/djxc/2019/");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    /**
     *
     * @param filePath
     * @param outputPath
     */
    public void unzipfile(String filePath, String outputPath) throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        ZipInputStream zis = new ZipInputStream(bis);
        ZipEntry zipEntry;
        File targetFile;
        while ((zipEntry = zis.getNextEntry())!=null){
            int BUFFER = 2048;
            String temp = outputPath + zipEntry.getName();
            targetFile = new File(temp);
//            if(!targetFile.exists()||targetFile.isFile()&&zipEntry.isDirectory()){
//                targetFile.mkdirs();
//            }
            if(zipEntry.isDirectory()){
                continue;
            }
            FileOutputStream fos = new FileOutputStream(targetFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER);
            int count = 0;
            byte[] data = new byte[BUFFER];
            while ((count = zis.read(data, 0, BUFFER))!=-1){
                bos.write(data, 0, count);
            }
            bos.flush();
            bos.close();
        }
        zis.close();
    }
}
