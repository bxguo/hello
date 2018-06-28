package algorithm;

import java.io.*;

/**
 * Created by bxguo on 2018/4/10 22:25
 */
public class FileCopy {
    public static void main(String[] args) {
        getFileName();
    }
    public static void getFileName() {
        String path = "E:\\music\\jay"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }
        File[] fa = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            String[] list = fs.list();
            System.out.println(list.toString());

            /*String oldName = fs.getName();
            String newName = oldName.substring(oldName.indexOf("-")+2, oldName.length());
            fs.renameTo(new File("E:\\music\\jay\\"+newName));
            System.out.println(newName);*/
        }
    }
    public static void BufferInputStreamBufferOutputStream(String src, String out) {
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(out));
            bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
            byte[] bytes = new byte[1024];
            int num = 0;
            while ((num = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, num);
                bufferedOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
