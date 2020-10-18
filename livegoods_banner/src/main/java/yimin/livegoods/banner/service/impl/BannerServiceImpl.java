package yimin.livegoods.banner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import yimin.livegoods.banner.dao.BannerDao;
import yimin.livegoods.banner.service.BannerService;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.pojo.Banner;

import java.util.ArrayList;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/11 19:02
 *   @Description :
 *
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    /**
     * query the object from mongoDB, search banner data
     * sorted in query time, we query the forth 4 items
     * @return
     */
    @Override
    public LivegoodsResult getBanners() {
        LivegoodsResult result = new LivegoodsResult();
        try{
            Query query = new Query();
            query.with(
                    PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "createTime"))
            );
            List<Banner> banners = bannerDao.selectBanners(query);
            result.setStatus(200);
            List<String> imgResults = new ArrayList<String>();
            for(Banner banner : banners){
                imgResults.add(nginxPrefix + banner.getUrl());
            }
            // parsing the urls to the result
            result.setResults(imgResults);
        } catch (Exception e){
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("Query picture failed");
        }
        return result;
    }
}
