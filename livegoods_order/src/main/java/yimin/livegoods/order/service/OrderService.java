package yimin.livegoods.order.service;

import yimin.livegoods.search.pojo.Order;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 19:43
 *   @Description :
 *
 */
public interface OrderService {

    /**
     * return list of orders of a user
     * @param user
     * @return
     */
    List<Order> getOrders(String user);
}
