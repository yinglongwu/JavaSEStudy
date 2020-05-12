package pers.ylw.lesson04;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDown {
    public static void main(String[] args) throws IOException {
        //随便网上找一个下载地址
        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588093919567&di=8d3df5a53cc6043bf0c3a833ca9da6e5&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F35%2F34%2F19300001295750130986345801104.jpg");
        //连接到这个资源
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        //获得流
        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("图片.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len); //写出这个数据
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
