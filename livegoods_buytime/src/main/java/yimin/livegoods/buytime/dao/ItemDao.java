package yimin.livegoods.buytime.dao;

import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 16:56
 *   @Description :
 *
 */
public interface ItemDao {

    /**
     * Search item by given item's id
     * @param id
     * @return
     */
    Item findById(String id);
}
