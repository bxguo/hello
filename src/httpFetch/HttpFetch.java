package httpFetch;

import jdk.nashorn.internal.scripts.JD;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by bxguo on 2018/4/2 20:36
 */
public class HttpFetch {
    public static void main(String[] args) {
        try {
            String str = JDKFetch("http://www.baidu.com", "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String JDKFetch(String request, String charset) throws Exception{
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36"
                + " (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = conn.getInputStream();
            StringBuffer sb = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
            String s;
            while ((s = reader.readLine()) != null){
                sb.append(s + "\n");
            }
            inputStream.close();
            conn.disconnect();
            return sb.toString();
        }
        return "";
    }

}
