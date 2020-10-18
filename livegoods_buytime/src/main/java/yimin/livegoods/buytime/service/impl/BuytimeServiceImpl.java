package yimin.livegoods.buytime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yimin.livegoods.buytime.dao.ItemDao;
import yimin.livegoods.buytime.service.BuytimeService;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 16:58
 *   @Description :
 *
 */
@Service
public class BuytimeServiceImpl implements BuytimeService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public LivegoodsResult getBuytimeById(String id) {
        Item item = this.itemDao.findById(id);
        LivegoodsResult result = LivegoodsResult.ok();
        result.setTime(item.getBuytime().getTime());
        return result;
    }
}
