package yimin.livegoods.search.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 13:27
 *   @Description :
 *      comment for items
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Comment {

    private String id;
    // username and phone
    private String username;
    // comments details
    private String comment;
    // scores range from 0 - 5 stars
    private int star;
    // item's primary key
    private String itemId;

}
