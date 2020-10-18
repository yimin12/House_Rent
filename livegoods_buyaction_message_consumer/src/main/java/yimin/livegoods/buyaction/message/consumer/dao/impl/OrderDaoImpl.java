package yimin.livegoods.buyaction.message.consumer.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import yimin.livegoods.buyaction.message.consumer.dao.OrderDao;
import yimin.livegoods.search.pojo.Order;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:14
 *   @Description :
 *
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Order order) {
        mongoTemplate.save(order);
    }
}
