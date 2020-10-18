package yimin.livegoods.login.dao;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:29
 *   @Description :
 *     User login data access interface
 */

import yimin.livegoods.search.pojo.LoginLog;

public interface LoginLogDao {

    /**
     * insert new log in the Mongodb
     * @param loginLog
     */
    void insertLoginLog(LoginLog loginLog);
}
