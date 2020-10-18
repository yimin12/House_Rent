package yimin.livegoods.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yimin.livegoods.order.dao.OrderDao;
import yimin.livegoods.order.service.OrderService;
import yimin.livegoods.search.pojo.Order;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 19:44
 *   @Description :
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrders(String user) {
        return orderDao.getOrders(user);
    }

}
