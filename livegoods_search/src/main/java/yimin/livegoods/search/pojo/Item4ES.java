package yimin.livegoods.search.pojo;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:46
 *   @Description :
 *      Real entity for elastic search
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * We create this real entity only for elastic search.
 * Spring Data Elastic search should use @Document to declare the indexName
 */
@Document(indexName = "livegoods-item", type = "item")
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Item4ES {

    @Id
    private String id; // primary key
    @Field(type = FieldType.Keyword)
    private String rentType; // not use analyzer
    @Field(type = FieldType.Keyword)
    private String price; // not use analyzer
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String houseType; // we might search based on the house type
    @Field(type = FieldType.Keyword)
    private String imgUrl; // url of the picture
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Keyword)
    private String city;

}
