package yimin.livegoods.search.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/11 18:11
 *   @Description :
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Banner {

    /**
     * Banner real entity
     * The optional properties should be numerous.
     *  1、 轮播图生效时间， 当系统时间大于等于生效时间的时候，轮播图生效，可被查询。
     *  2、 有效时长|失效时间。当系统时间大于等于失效时间的时候，轮播图不可查询。
     *  3、 优先级。 根据具体情况，排序查询。
     *  4、 随机算法。 代码逻辑实现
     */
    // We query the data form mongo db
    private String id; // logical primary key
    private String url; // url of the picture
    private Date createTime; // create timestamp

}
