package yimin.livegoods.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yimin.livegoods.order.dao.OrderDao;
import yimin.livegoods.search.pojo.Order;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 19:39
 *   @Description :
 *
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Search the order details based on cell phone
     * @param user
     * @return
     */
    @Override
    public List<Order> getOrders(String user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(user));
        return mongoTemplate.find(query, Order.class);
    }
}
