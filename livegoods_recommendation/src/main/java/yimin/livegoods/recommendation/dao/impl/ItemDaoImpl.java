package yimin.livegoods.recommendation.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yimin.livegoods.search.pojo.Item;
import yimin.livegoods.recommendation.dao.ItemDao;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:05
 *   @Description :
 *
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Query the recommendation items
     * @param query
     * @return
     */
    @Override
    public List<Item> selectRecommendation(Query query) {
        return mongoTemplate.find(query, Item.class);
    }
}
