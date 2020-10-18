package yimin.livegoods.comment.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yimin.livegoods.comment.dao.CommentDao;
import yimin.livegoods.search.pojo.Comment;

import java.util.List;
import java.util.Map;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 12:22
 *   @Description :
 *
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Comment> findCommentsByPage(Query query) {
        return mongoTemplate.find(query, Comment.class);
    }

    @Override
    public Long countByQuery(String itemId) {
        TypedAggregation<Comment> typedAggregation = new TypedAggregation<Comment>(Comment.class, Aggregation.group("itemId").count().as("count"));
        AggregationResults<Map> results = mongoTemplate.aggregate(typedAggregation, Map.class);
        long count = Long.parseLong(results.getUniqueMappedResult().get("count").toString());
        return count;
    }

    @Override
    public void save(Comment comment) {
        mongoTemplate.save(comment);
    }
}
