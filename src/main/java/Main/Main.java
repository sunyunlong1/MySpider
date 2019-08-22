package Main;

import Boot.custom.DemoBoot;
import DataService.mybatis.YouthNewsService;
import DownLoader.custom.StreamDownloader;
import MySpiderStart.MySpider;
import Processor.custom.YouthProcessor;
import ScheduleQueue.custom.DemoScheduleQueue;
import Util.MyLogger;
import Util.MySpiderFactory;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 网络爬虫入口程序
 */
public class Main {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static URL[] urls;
    public static boolean useThreads = false;


    public static void main(String[] args) throws Exception {

        //URL数据demo
        urls = new URL[]{
                new URL("http://nc.mofcom.gov.cn/channel/jghq2017/price_list.shtml?par_craft_index=13075&craft_index=20413&par_p_index=&p_index=&startTime=2019-05-17&endTime=2019-08-15"),
                new URL("http://nc.mofcom.gov.cn/channel/jghq2017/price_list.shtml?par_craft_index=13075&craft_index=20411&par_p_index=&p_index=&startTime=2019-05-17&endTime=2019-08-15"),
                new URL("http://nc.mofcom.gov.cn/channel/jghq2017/price_list.shtml?par_craft_index=13075&craft_index=13811&par_p_index=&p_index=&startTime=2019-05-17&endTime=2019-08-15"),
                new URL("http://nc.mofcom.gov.cn/channel/jghq2017/price_list.shtml?par_craft_index=13075&craft_index=13515&par_p_index=&p_index=&startTime=2019-05-17&endTime=2019-08-15"),
                new URL("http://nc.mofcom.gov.cn/channel/jghq2017/price_list.shtml?par_craft_index=13075&craft_index=13509&par_p_index=&p_index=&startTime=2019-05-17&endTime=2019-08-15")
        };

        //单线程启动demo
        if(!useThreads){
            //从工厂类中获得一个爬虫实例
            MySpider mySpider =  MySpiderFactory.getYouthNewsSpiderNoDataService(urls);
            mySpider.start();
        }
        //多线程启动demo
        else{
            for (URL url:
                    urls) {
                executorService.submit(() -> {
                    try {
                        MySpider mySpider =  MySpiderFactory.getYouthNewsSpiderNoDataServiceForTheads(url);
                        mySpider.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            executorService.shutdown();
        }

        MyLogger.log("Main ended");
    }

}
