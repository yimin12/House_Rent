package yimin.livegoods.commons.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/11 17:59
 *   @Description :
 *    This is the return type for the front page
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LivegoodsResult {

    // Response code, 200-success; 500-failure
    private int status;
    // Use for Banner, store the the urls of picture
    private Object results;
    // Response message, Use for banner, return error message if query fail
    private String msg;
    // Use for top sales product, Use for recommendation
    private Object data;
    // Use for paging, whether it has more
    private boolean hasMore;
    // Timestamp
    private long time;

    public static LivegoodsResult ok(){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(200);
        return result;
    }

    public static LivegoodsResult ok(Object data){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(200);
        result.setData(data);
        return result;
    }

    public static LivegoodsResult error(){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(500);
        return result;
    }

    public static LivegoodsResult error(String msg){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(500);
        result.setMsg(msg);
        return result;
    }
}
