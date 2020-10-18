package yimin.livegoods.search.pojo;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 13:06
 *   @Description :
 *      Real entity for items
 *      Lombok is not very popular in many industrial scenarios, because lombok is not
 *      flexible enough. Sometimes, you need to add self-defined getter and setter
 */
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Item {

    /**
     * item fields, use for data in mongodb
     * { "title" : " 北京高档公寓", "sales" : NumberLong(100), "recommendation" : true, "recoSort" : 9,
     * "city" : "北京", "price" : NumberLong(12000), "rentType" : "整租", "houseType" : "150 ㎡", "info" :
     * { "orientation" : "南北通透", "level" : "10/18 层", "style" : "精装修", "type" : "3 室2 厅", "years" :
     * "2010" }, "imgs" : [ "group1/M00/00/01/wKhZjF6_UkuAGCsJABLGy04UWBI573.png",
     * "group1/M00/00/01/wKhZjF6_UlyANqRfAAjIoXS-cuE984.png",
     * "group1/M00/00/01/wKhZjF6_UmmAQsntAAro96E3Lio262.png" ], "_class" :
     * "com.bjsxt.livegoods.pojo.Item" }
     * all required fields are listed above
     */
    private String id;
    private String title;
    private Long sales;
    private Boolean recommendation;
    private Byte recoSort;
    private String city;
    private Long price;
    private String rentType;
    private String houseType;
    private Map<String, String> info;
    private List<String> imgs;
    private Date buytime;
    private Boolean isRented;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * self-define getter and setter
     */
    public String getImg(){
        return imgs.get(0);
    }

    public void setImg(String img){

    }

    public String getLink(){
        return "/details/" + id;
    }

    public void setLink(){

    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Boolean getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Boolean recommendation) {
        this.recommendation = recommendation;
    }

    public Byte getRecoSort() {
        return recoSort;
    }

    public void setRecoSort(Byte recoSort) {
        this.recoSort = recoSort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseType4Searcyh(){
        return info.get("level") + " | " + info.get("type") + " - " + houseType;
    }

    public void setHouseType4Search(String houseType4Search){}

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }
}
