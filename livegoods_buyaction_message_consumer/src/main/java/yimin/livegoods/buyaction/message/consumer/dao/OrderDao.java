package yimin.livegoods.buyaction.message.consumer.dao;

import yimin.livegoods.search.pojo.Order;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:07
 *   @Description :
 *
 */
public interface OrderDao {

    /**
     * Update the order status
     * @param order
     */
    void save(Order order);
}
