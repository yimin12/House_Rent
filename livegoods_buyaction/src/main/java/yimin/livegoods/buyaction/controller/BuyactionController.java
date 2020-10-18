package yimin.livegoods.buyaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.buyaction.service.BuyactionService;
import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:02
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class BuyactionController {

    @Autowired
    private BuyactionService buyactionService;

    /**
     * Reserve house, apartment
     * @param id
     * @param user
     * @return
     */
    @GetMapping("/buyaction")
    public LivegoodsResult buyaction(String id, String user){
        return buyactionService.buyaction(id, user);
    }

}
