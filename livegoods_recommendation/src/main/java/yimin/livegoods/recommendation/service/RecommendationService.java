package yimin.livegoods.recommendation.service;

import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:08
 *   @Description :
 *
 */
public interface RecommendationService {

    /**
     * Query the items of recommendation, searching criteria is city.
     * The banner's size is 4. If the result's size is larger than 4. Return the top 4 results
     * If the result's size is smaller than 4, return the recommendation's product under other city
     * If all result's size is still smaller than 4,return the prerequisite product
     * @param city
     * @return
     */
    LivegoodsResult getRecommendation(String city);
}
