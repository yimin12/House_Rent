package yimin.livegoods.details.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import yimin.livegoods.details.dao.ItemDao;
import yimin.livegoods.details.service.DetailsService;
import yimin.livegoods.search.pojo.Item;

import java.util.ArrayList;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 12:00
 *   @Description :
 *
 */
@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private ItemDao itemDao;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;

    /**
     * Query by primary key,
     * change the relative path to absolute path
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "yimin:livegoods:details", key = "'getDetails('+#id+')'")
    public Item getDetails(String id) {
        Item item = itemDao.findItemById(id);
        List<String> newImgs = new ArrayList<>();
        for(String img : item.getImgs()){
            newImgs.add(nginxPrefix + img);
        }
        item.setImgs(newImgs);
        return item;
    }
}
