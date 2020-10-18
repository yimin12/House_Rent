package yimin.livegoods.buyaction.message.consumer.dao.impl;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import yimin.livegoods.buyaction.message.consumer.dao.ItemDao;
import yimin.livegoods.search.pojo.Item;


/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:08
 *   @Description :
 *
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Update commodities' status (especially for the whether it has been rented)
     * Update operation in mongodb : db.item.update({},{"$set":{"rented":false}}, false, true);
     * @param id
     * @param rented
     * @return
     */
    @Override
    public long update(String id, Boolean rented) {
        Query query = new Query();
        // update criteria
        query.addCriteria(Criteria.where("id").is(id));
        Update update = Update.update("isRented", rented);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Item.class);
        return result.getModifiedCount();
    }
}
