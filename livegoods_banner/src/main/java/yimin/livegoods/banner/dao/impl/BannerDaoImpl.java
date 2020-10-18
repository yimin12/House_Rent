package yimin.livegoods.banner.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yimin.livegoods.banner.dao.BannerDao;
import yimin.livegoods.search.pojo.Banner;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/11 18:54
 *   @Description :
 *
 */

/**
 * Implementation for querying mongo db
 */
@Repository
public class BannerDaoImpl implements BannerDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Banner> selectBanners(Query query) {
        List<Banner> result = mongoTemplate.find(query, Banner.class);
        return result;

    }
}
