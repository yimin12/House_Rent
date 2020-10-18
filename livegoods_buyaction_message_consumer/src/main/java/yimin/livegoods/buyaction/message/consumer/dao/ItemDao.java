package yimin.livegoods.buyaction.message.consumer.dao;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 17:05
 *   @Description :
 *      Commodity data access interface
 */

public interface ItemDao {

    /**
     * Update the commodity's info
     * @param id
     * @param rented
     * @return
     */
    long update(String id, Boolean rented);
}
