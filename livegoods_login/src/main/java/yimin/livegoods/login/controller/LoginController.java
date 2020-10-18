package yimin.livegoods.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.login.service.LoginService;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 16:36
 *   @Description :
 *
 */
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * User login with phone and verification
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public LivegoodsResult login(String username, String password){
        return loginService.login(username, password);
    }

    /**
     * Sending the verification code
     * @param phone
     * @return
     */
    @PostMapping("/sendyzm")
    public LivegoodsResult sendVerificationCode(String phone){
        return loginService.sendVerificationCode(phone);
    }
}
