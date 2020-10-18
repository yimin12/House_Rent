package yimin.livegoods.search.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 13:29
 *   @Description :
 *      Login log entity
 *      Record a user's activity.
 *      The current system is a system with no registration logic. As long as users provide a valid phone number, they can log in through verification code
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginLog {

    private String id;
    private String username; // username, which is phone in un-logic register scenarios
    private String type; // login type, 1 - login through verification code, 2 - regularly login with username and password
    private Date loginTime; // timestamp
    private Boolean isSuccess; // whether login is success
    private String message; // login detail message e.g. phone does not exist, verification code error and so on;
}
