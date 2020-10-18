package yimin.livegoods.details.service;

import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 11:59
 *   @Description :
 *
 */
public interface DetailsService {

    /**
     * service of Searching by primary key
     * @param id
     * @return
     */
    Item getDetails(String id);
}
