package yimin.livegoods.commons.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 12:19
 *   @Description :
 *
 */
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class LivegoodsBuyMessage extends LivegoodsMessage{

    // primary key for purchasing items
    private String itemId;
    // front-end user
    private String username;
}
