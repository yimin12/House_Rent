package yimin.livegoods.search.dao;

import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import yimin.livegoods.search.pojo.Item4ES;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:55
 *   @Description :
 *
 */
public interface ItemDao4ES {

    /**
     * search the items based on city and content from elastic search
     * @param city
     * @param content
     * @param page
     * @param rows
     * @return
     */
    AggregatedPage<Item4ES> query4Page(String city, String content, int page, int rows);

    /**
     * batch insert new items to elastic search
     * @param items
     */
    void batchIndex(List<Item4ES> items);

    /**
     * insert one item to elastic search
     * @param item
     */
    void index(Item4ES item);
}
