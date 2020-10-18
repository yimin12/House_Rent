package yimin.livegoods.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.service.SearchService;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 0:27
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public LivegoodsResult search(String city, String content, int page, @RequestParam(defaultValue = "4") int rows){
        return searchService.search(city, content, page, rows);
    }
}
