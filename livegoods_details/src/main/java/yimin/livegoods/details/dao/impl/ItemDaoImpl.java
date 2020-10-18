package yimin.livegoods.details.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import yimin.livegoods.details.dao.ItemDao;
import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 11:57
 *   @Description :
 *
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Search item by given id
     * @param id
     * @return
     */
    @Override
    public Item findItemById(String id) {
        return mongoTemplate.findById(id, Item.class);
    }
}
