package yimin.livegoods.buytime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.buytime.service.BuytimeService;
import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 17:00
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class BuytimeController {

    @Autowired
    private BuytimeService buytimeService;

    /**
     * Search the item by given id and set the counting time
     * @param id
     * @return
     */
    @GetMapping("/buytime")
    public LivegoodsResult getBuytime(String id){
        return buytimeService.getBuytimeById(id);
    }
}
