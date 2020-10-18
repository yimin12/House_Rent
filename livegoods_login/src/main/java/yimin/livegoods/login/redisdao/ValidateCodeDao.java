package yimin.livegoods.login.redisdao;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:34
 *   @Description :
 *      User login verification code data access interface, access the redis
 */

import yimin.livegoods.login.pojo.ValidateCode;

public interface ValidateCodeDao {

    /**
     * store the verfication in redis, set the max-alive time to 2 minutes
     * @param key
     * @param value
     */
    void set(String key, Object value);

    /**
     * query the key by given cell phone in redis
     * @param key
     * @return
     */
    ValidateCode get(String key);

    /**
     * delete the verfication code
     * @param key
     * @return
     */
    Boolean delete(String key);
}
