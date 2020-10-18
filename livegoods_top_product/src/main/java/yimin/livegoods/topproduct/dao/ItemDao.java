package yimin.livegoods.topproduct.dao;

import org.springframework.data.mongodb.core.query.Query;
import yimin.livegoods.search.pojo.Item;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 14:09
 *   @Description :
 *
 */
public interface ItemDao {

    /**
     * query the popular product from mongodb database
     * The result will display in descending order of sales volume
     * Searching criteria is city
     * @param query
     * @return top 4 data
     */
    List<Item> getTopProduct(Query query);
}
