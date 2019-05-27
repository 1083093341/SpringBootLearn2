package com.zwr.springboot.service;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 自动监听消费消息
     * @param message
     */
    @RabbitListener(queues = "amqpadmin.queue")
    public void progressMessage(Message message){

        System.out.println(message.toString());
    }

    /**
     * 手动消费消息
     */
    public String receiveMessage() {
        Object o =  rabbitTemplate.receiveAndConvert("amqpadmin.queue");
        System.out.println(o);
        return "receive2";

    }

}
