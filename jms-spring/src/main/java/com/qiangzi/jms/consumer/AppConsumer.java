package com.qiangzi.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/14.
 * Time: 上午12:31.
 * 消费者
 */
public class AppConsumer {

    public static void main(String[] args) {
        /** 加载Spring配置文件 */
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }

}
