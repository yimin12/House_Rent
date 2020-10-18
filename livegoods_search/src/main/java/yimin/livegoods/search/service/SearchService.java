package yimin.livegoods.search.service;

import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 0:22
 *   @Description :
 *
 */
public interface SearchService {

    /**
     * Implement the searching service based on given city and content
     * @param city
     * @param content
     * @param page
     * @param rows
     * @return
     */
    LivegoodsResult search(String city, String content, int page, int rows);
}
