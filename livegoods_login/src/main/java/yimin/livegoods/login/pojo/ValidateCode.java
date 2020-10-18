package yimin.livegoods.login.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:37
 *   @Description :
 *
 */
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ValidateCode {

    private String phone; // phone number
    private String validateCode; // verification code

}
