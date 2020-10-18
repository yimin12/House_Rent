package yimin.livegoods.topproduct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.pojo.Item;
import yimin.livegoods.topproduct.dao.ItemDao;
import yimin.livegoods.topproduct.service.TopProductService;

import java.util.*;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 14:22
 *   @Description :
 *
 */
@Service
public class TopProductServiceImpl implements TopProductService {

    @Autowired
    private ItemDao itemDao;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    @Override
    public LivegoodsResult getTopProducts(String city) {
        // Start query
        Query query = new Query();
        // Add searching criteria
        query.addCriteria(Criteria.where("city").is(city));
        // Start sorting and paging
        query.with(
                PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "sales"))
        );
        List<Item> items = itemDao.getTopProduct(query);
        // case 1: if the number of items are less than 4
        if(items.size() < 4){
            // when the result is not enough, query another top items from other city
            Query otherQuery = new Query();
            otherQuery.addCriteria(Criteria.where("city").ne(city));
            otherQuery.with(
                    PageRequest.of(0, 4 - items.size(), Sort.by(Sort.Direction.DESC, "sales"))
            );
            List<Item> others = itemDao.getTopProduct(otherQuery);
            items.addAll(others);
        }

        // case 2: if the size is still less than 4
        if(items.size() <4){
            for(int i = items.size(); i < 4; i++){
                items.add(fallbackItem());
            }
        }
        items = this.changeImgsUrl(items); // update the urls
        return LivegoodsResult.ok(items);
    }

    private List<Item> changeImgsUrl(List<Item> items){
        for(Item item:items){
            List<String> newImgs = new ArrayList<String>();
            for(String img : item.getImgs()){
                newImgs.add(nginxPrefix + img);
            }
            item.setImgs(newImgs);
        }
        return items;
    }

    private Item fallbackItem(){
        Item item = new Item();
        item.setId("5ec1ec6b7f56a946fb7fdffa");
        item.setCity("北京");
        item.setHouseType("150 ㎡");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/01/wKhZjF6_UkuAGCsJABLGy04UWBI573.png",
                        "group1/M00/00/01/wKhZjF6_UlyANqRfAAjIoXS-cuE984.png",
                        "group1/M00/00/01/wKhZjF6_UmmAQsntAAro96E3Lio262.png"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte)9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("北京高档公寓");
        Map<String, String> info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        return item;
    }
}
