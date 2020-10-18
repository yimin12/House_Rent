package yimin.livegoods.order.dao;

import yimin.livegoods.search.pojo.Order;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 19:38
 *   @Description :
 *      Interface for order details
 */
public interface OrderDao {

    /**
     * Query based on phone number
     * @param user
     * @return
     */
    List<Order> getOrders(String user);

}
