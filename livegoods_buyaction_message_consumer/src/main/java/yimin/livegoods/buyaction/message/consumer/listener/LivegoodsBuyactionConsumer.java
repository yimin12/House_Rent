package yimin.livegoods.buyaction.message.consumer.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yimin.livegoods.buyaction.message.consumer.service.BuyactionService;
import yimin.livegoods.commons.message.LivegoodsBuyMessage;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:30
 *   @Description :
 *
 */
@Component
public class LivegoodsBuyactionConsumer {

    @Autowired
    private BuyactionService buyactionService;

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(name = "${livegoods.rabbit.buy.queue}", autoDelete = "false"),
        exchange = @Exchange(name = "${livegoods.rabbit.buy.exchange}"), key = "${livegoods.rabbit.buy.routingKey}")})
    public Object onMessage(LivegoodsBuyMessage message){
        // Commodity's primary key
        String itemId = message.getItemId();
        // User's phone
        String user = message.getUsername();

        boolean result = buyactionService.buyaction(itemId, user);

        return result;
    }
}
