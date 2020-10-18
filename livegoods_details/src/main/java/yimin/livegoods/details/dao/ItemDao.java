package yimin.livegoods.details.dao;

import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 11:54
 *   @Description :
 *      Query for the details for the product
 */
public interface ItemDao {

    /**
     * Search the item's details by given id
     * @param id
     * @return
     */
    Item findItemById(String id);
}
