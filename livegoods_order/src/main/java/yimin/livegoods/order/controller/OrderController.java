package yimin.livegoods.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.order.service.OrderService;
import yimin.livegoods.search.pojo.Order;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 19:49
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public List<Order> getOrders(String user){
        return orderService.getOrders(user);
    }
}
