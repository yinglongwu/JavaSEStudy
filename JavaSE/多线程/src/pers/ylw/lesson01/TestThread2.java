package pers.ylw.lesson01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 implements Runnable{

    private String url;
    private String name;

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://www.baidu.com/img/dong_f6764cd1911fae7d460b25e31c7e342c.gif","百度劳动节1.gif");
        TestThread2 t2 = new TestThread2("http://a4.att.hudong.com/72/82/19300000009075130804824786610.jpg","恐龙2.jpg");
        TestThread2 t3 = new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588579963142&di=69d697e367f8b3bc144a759a51377c5a&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171110%2Fbd4b16a2eaa74eb683704ff4f85dc813.jpeg","一人之下3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            //FileUtils.copyURLToFile用的外部jar包commons.io
            FileUtils.copyURLToFile(new URL(url),new File(name));//把url变成文件
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download方法出现问题");
        }
    }
}
