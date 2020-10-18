package yimin.livegoods.details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.details.service.DetailsService;
import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 12:05
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    /**
     * Query the details of the product
     * @param id
     * @return
     */
    @GetMapping("/details")
    public Item findDetails(String id){
        return detailsService.getDetails(id);
    }
}
