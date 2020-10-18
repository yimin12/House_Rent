package yimin.livegoods.buyaction.redisdao;

import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 14:37
 *   @Description :
 *
 */
public interface ItemDao {

    /**
     * query redis based on the key. value is cache value
     * @param key
     * @return
     */
    Item get(String key);

}
