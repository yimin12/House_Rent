package yimin.livegoods.buyaction.message.consumer.service;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:31
 *   @Description :
 *      Interface for purchasing product
 */
public interface BuyactionService {

    /**
     * purchase items
     * @param id
     * @param user
     * @return
     */
    boolean buyaction(String id, String user);

}
