package com.qiang.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/13.
 * Time: 下午8:42.
 * 主题模式 消费者
 */
public class AppConsumer {

    // 61616端口是Activemq默认的端口
    private static final String url = "tcp://192.168.0.107:61616";

    private static final String topicName = "topic-demo";

    public static void main(String[] args) throws JMSException {
        // 1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // 2.创建Connection
        final Connection connection = connectionFactory.createConnection();

        // 3.启动连接
        connection.start();

        // 4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5.创建一个目标
        Destination destination = session.createTopic(topicName);

        // 6.创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7.创建一个消息监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("Sussess " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
