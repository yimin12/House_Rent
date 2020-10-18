package yimin.livegoods.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 11:53
 *   @Description :
 *
 */
@SpringBootApplication
@EnableCaching
public class DetailsApp {

    public static void main(String[] args) {
        SpringApplication.run(DetailsApp.class, args);
    }
}
