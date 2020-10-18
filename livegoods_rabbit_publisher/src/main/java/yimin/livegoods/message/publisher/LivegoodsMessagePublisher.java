package yimin.livegoods.message.publisher;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 14:07
 *   @Description :
 *      Message Publisher
 */

import org.springframework.amqp.core.AmqpTemplate;
import yimin.livegoods.commons.message.LivegoodsMessage;

public class LivegoodsMessagePublisher {

    private AmqpTemplate amqpTemplate;

    /**
     * publish the message in synchronize way. This method will not terminate if nothing return
     * @param exchange
     * @param routingKey
     * @param message
     * @return
     */
    public Object sendMessageSync(String exchange, String routingKey, LivegoodsMessage message){
        return amqpTemplate.convertSendAndReceive(exchange, routingKey, message);
    }

    /**
     * publish the message in as-synchronize way
     * @param exchange
     * @param routingKey
     * @param message
     * @return
     */
    public void sendMessageAsync(String exchange, String routingKey, LivegoodsMessage message){
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }

    public AmqpTemplate getAmqpTemplate(){
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
}
