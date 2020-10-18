package yimin.livegoods.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yimin.livegoods.commons.vo.LivegoodsResult;
import yimin.livegoods.login.dao.LoginLogDao;
import yimin.livegoods.login.pojo.ValidateCode;
import yimin.livegoods.login.redisdao.ValidateCodeDao;
import yimin.livegoods.login.service.LoginService;
import yimin.livegoods.search.pojo.LoginLog;

import java.util.Date;
import java.util.Random;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 16:00
 *   @Description :
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ValidateCodeDao validateCodeDao;
    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * Sending verification code, generate 4 digit random number dynamically.
     * Store the phone number, verification to redis, max-alive time is 2 minutes.
     * When the verification is still validate, we apply another verification code
     *      1. Generate new verification code, max-alive time is new 2 minutes, overwrite the old VC. But the server will face much more pressure in this method.
     *      2. Announce client, the old VC is still validate. Suggest to use old one. Decrease the user friendly, but the also decrease the server's stress, save a lot
     * @param phone
     * @return
     */
    @Override
    public LivegoodsResult sendVerificationCode(String phone) {
        ValidateCode oldCode = validateCodeDao.get(phone); // get the old from redis
        if(oldCode != null){
            return LivegoodsResult.error("Old verification code is still validate");
        }
        StringBuilder builder = new StringBuilder("");
        Random random = new Random();
        for(int i = 0; i < 4; i++){
            builder.append(random.nextInt(10));
        }
        // Generate new VC
        String validateCode = builder.toString();
        ValidateCode code = new ValidateCode();
        code.setPhone(phone);
        code.setValidateCode(validateCode);
        validateCodeDao.set(code.getPhone(), code);

        LivegoodsResult result = LivegoodsResult.ok();
        result.setMsg("Sending verification successfully");
        return result;
    }

    /**
     * Login, all operations should be recorded in LoginLog
     *      1. Search phone's mapping values in redis. If there no record in redis, return fail
     *      2. Validation, send the verification code and check it in redis. If it does not match, return login fail
     *      3. If validation success, write it in LoginLog. Delete the VC in redis. return login success
     * @param username
     * @param password
     * @return
     */
    @Override
    public LivegoodsResult login(String username, String password) {
        // Create LoginLog Object
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username); // record the username, know which user login
        loginLog.setLoginTime(new Date()); // record login timestamp
        loginLog.setType("1"); // login type , 1 - login by verification code

        ValidateCode validateCode = validateCodeDao.get(username);
        if(null == validateCode){
            // if verification is null or not validate
            loginLog.setIsSuccess(false); // login fail
            loginLog.setMessage("Verification is out of date"); // error message
            loginLogDao.insertLoginLog(loginLog);
            return LivegoodsResult.error("Username and password do not match, or the verification is out of date");
        }
        if(!password.equals(validateCode.getValidateCode())){
            loginLog.setIsSuccess(false);
            loginLog.setMessage("Verification is out of date");
            loginLogDao.insertLoginLog(loginLog);
            return LivegoodsResult.error("Username and password do not match, or the verification is out of date");
        }
        loginLog.setIsSuccess(true);
        loginLog.setMessage("User Login Message");
        validateCodeDao.delete(username);
        loginLogDao.insertLoginLog(loginLog);
        return LivegoodsResult.ok("Login successfully");
    }
}
