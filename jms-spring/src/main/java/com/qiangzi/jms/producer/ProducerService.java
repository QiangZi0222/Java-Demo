package com.qiangzi.jms.producer;

/**
 * Created by IntelliJ IDEA.
 * Author: 付石强.
 * Date: 2017/8/13.
 * Time: 下午10:56.
 * 消息提供者 接口
 */
public interface ProducerService {

    /** 发送消息 */
    void sendMessage(String message);

}
