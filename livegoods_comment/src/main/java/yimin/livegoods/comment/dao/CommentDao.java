package yimin.livegoods.comment.dao;

import org.springframework.data.mongodb.core.query.Query;
import yimin.livegoods.search.pojo.Comment;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 12:20
 *   @Description :
 *      Access the comment of product in mongodb
 */
public interface CommentDao {

    /**
     * paging query the comments from mongodb
     * @param query
     * @return
     */
    List<Comment> findCommentsByPage(Query query);

    /**
     * query the number of comments
     * @param itemId
     * @return
     */
    Long countByQuery(String itemId);

    /**
     * add new comments
     * @param comment
     */
    void save(Comment comment);
}
