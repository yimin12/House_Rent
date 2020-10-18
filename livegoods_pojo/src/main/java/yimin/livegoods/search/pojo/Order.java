package yimin.livegoods.search.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 13:41
 *   @Description :
 *
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Order {

    private String id;
    // user's phone
    private String username;
    // item's primary key
    private String itemId;
    // item's title
    private String title;
    // item's houseType
    private String houseType;
    // item's rentType
    private String rentType;
    // item's price
    private String price;
    // picture's url of item
    private String imgUrl;
    // whether has been comment already, 0 - not comment yet, 2 - already comment
    private int commentState;
}
