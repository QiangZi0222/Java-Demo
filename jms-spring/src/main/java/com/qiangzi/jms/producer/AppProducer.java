package com.qiangzi.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/13.
 * Time: 下午11:47.
 * 启动生产者
 */
public class AppProducer {

    public static void main(String[] args) {
        /** 加载Spring配置文件 */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }
        // 关闭连接 这个close方法只有ClassPathXmlApplicationContext才有
        context.close();
    }

}