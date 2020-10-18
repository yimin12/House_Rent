package yimin.livegoods.buyaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yimin.livegoods.buyaction.redisdao.ItemDao;
import yimin.livegoods.buyaction.service.BuyactionService;
import yimin.livegoods.commons.message.LivegoodsBuyMessage;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.message.publisher.LivegoodsMessagePublisher;
import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 14:43
 *   @Description :
 *
 */
@Service
public class BuyactionServiceImpl implements BuyactionService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private LivegoodsMessagePublisher messagePublisher;
    @Value("${livegoods.cache.names.item.prefix}")
    private String itemPrefix;
    @Value("${livegoods.cache.names.item.suffix}")
    private String itemSuffix;
    @Value("${livegoods.rabbit.buy.exchange}")
    private String exchange;
    @Value("${livegoods.rabbit.buy.routingKey}")
    private String routingKey;

    /**
     * Step 1: Access to the redis
     * Step 2: Encapsulate a message class, sending to message queue and waiting to consume
     * Step 3: Return based on the response code
     * @param id
     * @param user
     * @return
     */
    @Override
    public LivegoodsResult buyaction(String id, String user) {
        String key = itemPrefix + "::" + itemSuffix + "(" + id + ")";
        Item item = this.itemDao.get(key);
        if(item.getRented()){
            LivegoodsResult result = LivegoodsResult.error();
            result.setMsg("Already sold out");
            return result;
        }
        LivegoodsBuyMessage message = new LivegoodsBuyMessage();
        message.setItemId(id);
        message.setUsername(user);

        Boolean messageResult = (Boolean) messagePublisher.sendMessageSync(exchange, routingKey, message);
        if(messageResult){
            LivegoodsResult result = LivegoodsResult.ok();
            result.setMsg("reserved successfully");
            return result;
        } else {
            LivegoodsResult result = LivegoodsResult.error();
            result.setMsg("Already sold out");
            return result;
        }
    }
}
