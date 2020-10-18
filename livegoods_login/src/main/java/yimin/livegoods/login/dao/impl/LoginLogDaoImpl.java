package yimin.livegoods.login.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import yimin.livegoods.login.dao.LoginLogDao;
import yimin.livegoods.search.pojo.LoginLog;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:32
 *   @Description :
 *
 */
@Repository
public class LoginLogDaoImpl implements LoginLogDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertLoginLog(LoginLog loginLog) {
        mongoTemplate.save(loginLog);
    }
}
