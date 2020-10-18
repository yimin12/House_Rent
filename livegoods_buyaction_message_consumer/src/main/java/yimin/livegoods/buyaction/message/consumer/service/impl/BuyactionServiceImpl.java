package yimin.livegoods.buyaction.message.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yimin.livegoods.buyaction.message.consumer.dao.ItemDao;
import yimin.livegoods.buyaction.message.consumer.dao.OrderDao;
import yimin.livegoods.buyaction.message.consumer.redisdao.ItemDao4Redis;
import yimin.livegoods.buyaction.message.consumer.service.BuyactionService;
import yimin.livegoods.search.pojo.Item;
import yimin.livegoods.search.pojo.Order;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:32
 *   @Description :
 *
 */
@Service
public class BuyactionServiceImpl implements BuyactionService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ItemDao4Redis itemDao4Redis;
    @Autowired
    private OrderDao orderDao;
    @Value("${livegoods.cache.names.item.prefix}")
    private String itemPrefix;
    @Value("${livegoods.cache.names.item.suffix}")
    private String itemSuffix;

    /**
     * Purchasing phrase
     * 1. update the commodity's status in redis and determine the result of this buying. Atomic operation
     * 2. Update it to the mongoDB
     * 3. Store the order details
     * 4. Return the result
     * @param id
     * @param user
     * @return
     */
    @Override
    public boolean buyaction(String id, String user) {
        String key = itemPrefix + "::" + itemSuffix+ "(" + id + ")";
        Item value = itemDao4Redis.get(key);
        value.setRented(true); // mark as rented
        boolean isUpdateRedis = itemDao4Redis.set(key, value);
        if(isUpdateRedis){
            // if this does not match the record in redis, we should also update the data in mongodb
            long rows = itemDao.update(id, true);
            if(rows == 1){
                // only update one data
                Order order = new Order();
                order.setCommentState(0);
                order.setHouseType(value.getHouseType4Searcyh());
                order.setImgUrl(value.getImg());
                order.setItemId(value.getId());
                order.setPrice(value.getPrice().toString());
                order.setRentType(value.getRentType());
                order.setTitle(value.getTitle());
                order.setUsername(user);
                return true;
            }
        }
        return false; // Purchase operation failed
    }
}
