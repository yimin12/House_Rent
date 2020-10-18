package yimin.livegoods.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import yimin.livegoods.comment.dao.CommentDao;
import yimin.livegoods.comment.dao.OrderDao;
import yimin.livegoods.comment.service.CommentService;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.search.pojo.Comment;
import yimin.livegoods.search.pojo.Order;

import java.util.List;


/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 13:14
 *   @Description :
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private OrderDao orderDao;

    /**
     * Add new item's comment
     * @param orderId
     * @param comment
     * @return
     */
    @Override
    public LivegoodsResult fellback(String orderId, String comment) {
        try{
            // search the order by given orderId first
            Order order = orderDao.findById(orderId);
            // create an new object of comment
            Comment commentObj = new Comment();
            commentObj.setUsername(order.getUsername());
            commentObj.setComment(comment);
            commentObj.setItemId(order.getItemId());
            commentObj.setStar(3);  // 3 stars is the default value required from frontend side

            // save the updated comment to mongodb
            commentDao.save(commentObj);
            orderDao.updateCommentState(orderId, 2);
            return LivegoodsResult.ok();
        } catch(Exception e){
            e.printStackTrace();
            return LivegoodsResult.error();
        }
    }

    /**
     * paging query for the comment of the items, the searching criteria is primary key of the items
     * @param itemId
     * @param page
     * @param rows
     * @return
     */
    @Override
    public LivegoodsResult findCommentByItemId(String itemId, int page, int rows) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("itemId").is(itemId)
        );
        // paging
        query.with(
                PageRequest.of(page, rows)
        );
        List<Comment> commentList = this.commentDao.findCommentsByPage(query);
        long count = this.commentDao.countByQuery(itemId);

        // convert 7473126772 -> 747 312 **** for security concerns
        for(Comment comment : commentList){
            String username = comment.getUsername().replace("(\\d{3})(\\d{3})\\d{4}","$1$2****");
            comment.setUsername(username);
        }
        LivegoodsResult result = LivegoodsResult.ok(commentList);
        // count the total number of page
        long totalPages = ((count % rows == 0) ? (count / rows) : ((count / rows) + 1));
        if((page + 1) < totalPages){
            result.setHasMore(true);
        } else {
            result.setHasMore(false);
        }
        return result;
    }
}
