package yimin.livegoods.buytime.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import yimin.livegoods.buytime.dao.ItemDao;
import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 16:56
 *   @Description :
 *
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Item findById(String id) {
        return mongoTemplate.findById(id, Item.class);
    }
}
