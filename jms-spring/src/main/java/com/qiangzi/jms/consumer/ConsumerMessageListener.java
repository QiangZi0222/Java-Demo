package com.qiangzi.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/14.
 * Time: 上午12:21.
 * 消息监听者
 */
public class ConsumerMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("sussess: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
