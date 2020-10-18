package yimin.livegoods.banner.dao;
import org.springframework.data.mongodb.core.query.Query;
import yimin.livegoods.search.pojo.Banner;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/11 18:40
 *   @Description :
 *
 */

/**
 * Query the mongodb Database and return the result
 */
public interface BannerDao {

    List<Banner> selectBanners(Query query);
}
