package yimin.livegoods.recommendation.dao;

import org.springframework.data.mongodb.core.query.Query;
import yimin.livegoods.search.pojo.Item;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:04
 *   @Description :
 *
 */
public interface ItemDao {

    /**
     * Query for the items under recommendations
     * @param query
     * @return
     */
    List<Item> selectRecommendation(Query query);
}
