package pers.ylw.lesson02;

import org.apache.commons.io.FileUtils;
import pers.ylw.lesson01.TestThread2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//多线程创建爱你方式三：实现callable接口
//好处
//1、有返回值
//2、可以抛出异常
public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws Exception{
        TestCallable t1 = new TestCallable("https://www.baidu.com/img/dong_f6764cd1911fae7d460b25e31c7e342c.gif","百度劳动节1.gif");
        TestCallable t2 = new TestCallable("http://a4.att.hudong.com/72/82/19300000009075130804824786610.jpg","恐龙2.jpg");
        TestCallable t3 = new TestCallable("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588579963142&di=69d697e367f8b3bc144a759a51377c5a&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171110%2Fbd4b16a2eaa74eb683704ff4f85dc813.jpeg","一人之下3.jpg");

        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3); //线程池
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdown();

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
