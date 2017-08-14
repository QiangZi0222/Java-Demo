package com.qiang.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/13.
 * Time: 下午8:07.
 * 生产者
 */
public class AppProducer {

    // 61616端口是Activemq默认的端口
    private static final String url = "failover:(tcp://192.168.0.107:61617,tcp://192.168.0.107:61618)?randomize=true";

    private static final String queueName = "queue-demo";

    public static void main(String[] args) throws JMSException {
        // 1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2.创建Connection
        Connection connection = connectionFactory.createConnection();

        // 3.启动连接
        connection.start();

        // 4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5.创建一个目标
        Destination destination = session.createQueue(queueName);

        // 6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            // 7.创建消息
            TextMessage textMessage = session.createTextMessage("text" + i);
            // 8.发送消息
            producer.send(textMessage);
            System.out.println("Success" + textMessage.getText());
        }
        // 9.关闭连接
        connection.close();
    }

}
