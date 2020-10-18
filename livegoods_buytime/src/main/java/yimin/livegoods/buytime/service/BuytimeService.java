package yimin.livegoods.buytime.service;

import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 16:58
 *   @Description :
 *
 */
public interface BuytimeService {

    /**
     * Search the item by given item's id and set the counting time
     * @param id
     * @return
     */
    LivegoodsResult getBuytimeById(String id);
}
