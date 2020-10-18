package yimin.livegoods.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yimin.livegoods.comment.service.CommentService;
import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 13:42
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * Add new comment for trade
     * @param orderId
     * @param feelback
     * @return
     */
    @PostMapping("/feelback")
    public LivegoodsResult feelback(String orderId, String feelback){
        return commentService.fellback(orderId, feelback);
    }

    /**
     * search the comment by given item's primary key
     * The default size of page is five
     * @param itemId
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/comment")
    public LivegoodsResult getCommentByItemId(@RequestParam(value="id") String itemId, int page, @RequestParam(defaultValue = "5") int rows){
        return commentService.findCommentByItemId(itemId, page, rows);
    }
}
