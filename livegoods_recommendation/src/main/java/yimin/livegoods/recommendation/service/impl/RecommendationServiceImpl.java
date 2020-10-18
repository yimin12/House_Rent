package yimin.livegoods.recommendation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.pojo.Item;
import yimin.livegoods.recommendation.dao.ItemDao;
import yimin.livegoods.recommendation.service.RecommendationService;

import java.util.*;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:13
 *   @Description :
 *
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private ItemDao itemDao;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    /**
     * Searching Criteria is city = method params and isRecommendation = true
     * @param city
     * @return
     */
    @Override
    public LivegoodsResult getRecommendation(String city) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("city").is(city),
                Criteria.where("recommendation").is(true)
        );
        query.addCriteria(criteria);
        query.with(
                PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "recoSort"))
        );
        List<Item> items = itemDao.selectRecommendation(query);
        if(items.size() < 4){
            Query others = new Query();
            Criteria otherCriteria = new Criteria();
            otherCriteria.andOperator(
                    Criteria.where("city").ne(city),
                    Criteria.where("recommendation").is(true)
            );
            others.addCriteria(otherCriteria);
            others.with(
                PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "recoSort"))
            );
            List<Item> otherList = itemDao.selectRecommendation(others);
            items.addAll(otherList);
        }
        if(items.size() < 4){
            for(int i = items.size(); i < 4; i++){
                items.add(fallbackItem());
            }
        }
        items = this.changeImgs(items);
        return LivegoodsResult.ok(items);
    }

    private List<Item> changeImgs(List<Item> items){
        for(Item item:items){
            List<String> newImgs = new ArrayList<String>();
            for(String img : item.getImgs()){
                newImgs.add(nginxPrefix + img);
            }
            item.setImgs(newImgs);
        }
        return items;
    }

    // prerequisite basic data
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
