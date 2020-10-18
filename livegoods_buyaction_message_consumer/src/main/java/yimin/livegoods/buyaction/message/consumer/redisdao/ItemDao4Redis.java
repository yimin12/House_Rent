package yimin.livegoods.buyaction.message.consumer.redisdao;

import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:15
 *   @Description :
 *
 */
public interface ItemDao4Redis {

    /**
     * store the key to cache
     * @param key
     * @return
     */
    Item get(String key);

    /**
     * update the key and its mapping value to redis. If key already exist, overwrite it
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, Object value);

}
