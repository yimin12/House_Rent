package yimin.livegoods.login.service;

import yimin.livegoods.commons.vo.LivegoodsResult;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:58
 *   @Description :
 *
 */
public interface LoginService {

    /**
     * Send verification code
     * @param phone
     * @return
     */
    LivegoodsResult sendVerificationCode(String phone);

    /**
     * User login
     * @param username
     * @param password
     * @return
     */
    LivegoodsResult login(String username, String password);
}
