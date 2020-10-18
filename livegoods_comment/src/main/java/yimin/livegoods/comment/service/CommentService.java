package yimin.livegoods.comment.service;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 13:03
 *   @Description :
 *      Interface for comment
 */

import yimin.livegoods.commons.vo.LivegoodsResult;

public interface CommentService {

    /**
     * Add new comment
     * @param orderId
     * @param comment
     * @return
     */
    LivegoodsResult fellback(String orderId, String comment);

    /**
     * search comment by given item's id under paging
     * @param itemId
     * @param page
     * @param rows
     * @return
     */
    LivegoodsResult findCommentByItemId(String itemId, int page, int rows);

}
