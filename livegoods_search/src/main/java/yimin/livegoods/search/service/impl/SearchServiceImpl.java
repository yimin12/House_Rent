package yimin.livegoods.search.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Service;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.dao.ItemDao4ES;
import yimin.livegoods.search.pojo.Item4ES;
import yimin.livegoods.search.service.SearchService;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 0:24
 *   @Description :
 *
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ItemDao4ES itemDao4ES;

    /**
     * Searching logic
     * @param city
     * @param content
     * @param page
     * @param rows
     * @return
     */
    @Override
    public LivegoodsResult search(String city, String content, int page, int rows) {
        AggregatedPage<Item4ES> resultPage = this.itemDao4ES.query4Page(city, content, page, rows);
        LivegoodsResult result = LivegoodsResult.ok(resultPage.getContent());
        if(page < (resultPage.getTotalPages() - 1)){
            result.setHasMore(true);
        } else {
            result.setHasMore(false);
        }
        return result;
    }
}
