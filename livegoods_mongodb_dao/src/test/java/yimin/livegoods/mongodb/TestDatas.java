package yimin.livegoods.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import yimin.livegoods.search.pojo.Banner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/11 20:09
 *   @Description :
 *
 */
@SpringBootTest(classes = {MongoDBApp.class})
@RunWith(SpringRunner.class)
public class TestDatas {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertBanners(){
        List<Banner> list = new ArrayList<Banner>();
        Banner banner1 = new Banner();
        banner1.setCreateTime(new Date());
        banner1.setUrl("group1/M00/00/00/wKh3CF-DQ8eATnDGAAuC40wnByU652.png");
        Banner banner2 = new Banner();
        banner2.setCreateTime(new Date());
        banner2.setUrl("group1/M00/00/00/wKh3CF-DQ8uAFkPLABS0LiTh-88913.png");
        Banner banner3 = new Banner();
        banner3.setCreateTime(new Date());
        banner3.setUrl("group1/M00/00/00/wKh3CF-DQ8-AJ-IrABHVEPBnO7M340.png");
        Banner banner4 = new Banner();
        banner4.setCreateTime(new Date());
        banner4.setUrl("group1/M00/00/00/wKh3CF-DQ5eAJc9EABLGy04UWBI573.png");
        Banner banner5 = new Banner();
        banner5.setCreateTime(new Date());
        banner5.setUrl("group1/M00/00/00/wKh3CF-DQ8GALBQ1AAjIoXS-cuE843.png");
        Banner banner6 = new Banner();
        banner6.setCreateTime(new Date());
        banner6.setUrl("group1/M00/00/00/wKh3CF-DQ8GALBQ1AAjIoXS-cuE843.png");

        list.add(banner1);
        list.add(banner2);
        list.add(banner3);
        list.add(banner4);
        list.add(banner5);
        list.add(banner6);
        mongoTemplate.insert(list, Banner.class);
        System.out.println(list);
    }
}
