package yimin.livegoods.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import yimin.livegoods.search.SearchApp;
import yimin.livegoods.search.dao.ItemDao4ES;
import yimin.livegoods.search.pojo.Item;
import yimin.livegoods.search.pojo.Item4ES;

import java.util.ArrayList;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 0:30
 *   @Description :
 *
 */
@SpringBootTest(classes={SearchApp.class})
@RunWith(SpringRunner.class)
public class TestSearch {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ItemDao4ES itemDao4ES;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    @Test
    public void testInitES(){
        // parsing all product's info from mongodb to elastic search
        List<Item> items = mongoTemplate.findAll(Item.class);
        List<Item4ES> item4ESList = new ArrayList<>();
        for(Item item:items){
            Item4ES item4ES= new Item4ES();
            Item4ES i = new Item4ES();
            i.setId(item.getId());
            i.setTitle(item.getTitle());
            i.setCity(item.getCity());
            i.setHouseType(item.getHouseType4Searcyh());
            i.setImgUrl(nginxPrefix + item.getImg());
            i.setPrice("<h3>" + item.getPrice() + "</h3>");
            i.setRentType(item.getRentType());
            item4ESList.add(i);
        }
        itemDao4ES.batchIndex(item4ESList);
    }
}
