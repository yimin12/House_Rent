package yimin.livegoods.topproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.topproduct.service.TopProductService;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 17:39
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class TopProductController {

    @Autowired
    private TopProductService topProductService;

    /**
     * query the top 4 product and display it in the banner
     * @param city
     * @return
     */
    @GetMapping("/hotProduct")
    public LivegoodsResult getTopProduct(String city){
        return topProductService.getTopProducts(city);
    }
}
