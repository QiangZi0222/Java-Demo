package com.qiangzi.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/13.
 * Time: 下午11:25.
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    // 指定目的地
    @Resource(name = "topicDestination")
    private Destination destination;

    @Override
    public void sendMessage(final String message) {
        /** 使用jmsTemplate发送消息 */
        jmsTemplate.send(destination, new MessageCreator() {
            /** 创建消息 */
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("Sussess: " + message);
    }
}
