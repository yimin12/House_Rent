package yimin.livegoods.recommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.recommendation.service.RecommendationService;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:32
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public LivegoodsResult getRecommendation(String city){
        return recommendationService.getRecommendation(city);
    }
}
