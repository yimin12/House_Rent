package yimin.livegoods.buyaction.service;

import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 14:42
 *   @Description :
 *
 */
public interface BuyactionService {

    /**
     * service for purchasing items
     * @param id
     * @param user
     * @return
     */
    LivegoodsResult buyaction(String id, String user);
}
