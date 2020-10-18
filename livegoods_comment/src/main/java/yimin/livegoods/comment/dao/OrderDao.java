package yimin.livegoods.comment.dao;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 12:17
 *   @Description :
 *      Query the order from mongodb
 */

import yimin.livegoods.search.pojo.Order;

public interface OrderDao {

    /**
     * return Order by given orderId
     * @param orderId
     * @return
     */
    Order findById(String orderId);

    /**
     * Update the commentState by given orderId
     * @param orderId
     * @param
     */
    void updateCommentState(String orderId, int commentState);
}
