package yimin.livegoods.topproduct.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yimin.livegoods.search.pojo.Item;
import yimin.livegoods.topproduct.dao.ItemDao;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 14:15
 *   @Description :
 *
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Item> getTopProduct(Query query) {
        return mongoTemplate.find(query, Item.class);
    }
}
