package yimin.livegoods.topproduct.service;

import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 14:16
 *   @Description :
 *
 */
public interface TopProductService {

    /**
     * Search Top product from database
     * Searching Criteria will return top 4 products
     *  if the results are larger than 4, only return the top 4 result under the same city
     *  if the results are less than 4, return the top product under the other city
     * @param city
     * @return
     */
    LivegoodsResult getTopProducts(String city);
}
