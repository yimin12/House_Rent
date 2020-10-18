package yimin.livegoods.search.dao.impl;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;
import yimin.livegoods.search.dao.ItemDao4ES;
import yimin.livegoods.search.pojo.Item4ES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/17 23:58
 *   @Description :
 *
 */
@Repository
public class ItemDao4ESImpl implements ItemDao4ES {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Value("${livegoods.search.init.enabled}")
    private boolean initEnabled = false;

    /**
     * Paging Search, implement the highlight function
     * @param city
     * @param content
     * @param page
     * @param rows
     * @return
     */
    @Override
    public AggregatedPage<Item4ES> query4Page(String city, String content, int page, int rows) {
        // Configure the highlight
        HighlightBuilder.Field field = new HighlightBuilder.Field("title"); // highlight the title
        field.preTags("<span style='color:red'>");
        field.postTags("</span>");

        // Searching criteria
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<QueryBuilder> mustList = boolQueryBuilder.must();
        mustList.add(
                QueryBuilders.matchQuery("title", content)
        );
        List<QueryBuilder> shouldList = boolQueryBuilder.should();
        shouldList.add(
                QueryBuilders.matchQuery("title", content) // search the title
        );
        shouldList.add(
                QueryBuilders.matchQuery("houseType", content) // search the houseType
        );
        shouldList.add(
                QueryBuilders.matchQuery("rentType", content) // search the rentType
        );

        SearchQuery query = new NativeSearchQueryBuilder().withQuery(boolQueryBuilder) // search criteria config
                .withHighlightFields(field) // highlight config
                .withPageable(
                        PageRequest.of(page, rows) // paging
                ).build();

        // start to search
        AggregatedPage<Item4ES> resultPage = elasticsearchRestTemplate.queryForPage(query, Item4ES.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                // handle the result
                List<T> resultList = new ArrayList<T>();
                SearchHit[] searchHits = searchResponse.getHits().getHits();
                for(SearchHit searchHit : searchHits){
                    Map<String, Object> objectMap = searchHit.getSourceAsMap();
                    Item4ES item4ES = new Item4ES();
                    // handle the mapping way, convert the string to object class in java
                    item4ES.setId(objectMap.get("id").toString());
                    item4ES.setRentType(objectMap.get("rentType").toString());
                    item4ES.setPrice(objectMap.get("price").toString());
                    item4ES.setImgUrl(objectMap.get("img").toString());
                    item4ES.setHouseType(objectMap.get("houseType").toString());
                    item4ES.setCity(objectMap.get("city").toString());

                    // handle the highlight
                    Map<String, HighlightField> highlightFieldMap = searchHit.getHighlightFields();
                    if(highlightFieldMap.containsKey("title")){
                        // if the keyword "title" show up, highlight it
                        item4ES.setTitle(highlightFieldMap.get("title").getFragments()[0].toString());
                    } else {
                        // if there is no any keyword, directly parsing the title without any highlight
                        item4ES.setTitle(objectMap.get("title").toString());
                    }
                    resultList.add((T) item4ES);
                }
                return new AggregatedPageImpl<T>(resultList, // all results
                        pageable, // paging helper
                        searchResponse.getHits().getTotalHits(), // return total rows
                        searchResponse.getAggregations(), // aggregate object
                        searchResponse.getScrollId(), // scroll searching primary key
                        searchResponse.getHits().getMaxScore()); // search the max score(most likely match)
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                return null;
            }
        });
        return resultPage;
    }

    @Override
    public void batchIndex(List<Item4ES> items) {
        // determined whether add index and mapping
        if(initEnabled){
            this.createIndex();
            this.putMapping();
        }
        List<IndexQuery> queryList = new ArrayList<IndexQuery>();
        for(Item4ES item:items){
            queryList.add(new IndexQueryBuilder().withObject(item).build());
        }
        elasticsearchRestTemplate.bulkIndex(queryList);
    }

    @Override
    public void index(Item4ES item) {
        this.batchIndex(Arrays.asList(item));
    }

    private void createIndex(){
        elasticsearchRestTemplate.createIndex(Item4ES.class);
    }

    private void putMapping(){
        elasticsearchRestTemplate.putMapping(Item4ES.class);
    }


}
