package com.naver.hackday.trendapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.select.Elements;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author SaeHan Kim
 * @since 2018-11-14
 */

@Entity
@Table(name = "TrendKeyword")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class TrendKeyword {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @Column(name = "keyword")
    private String keyword = "";

    @Column(name = "created_time", updatable = false)
    private LocalDateTime createdTime;

    @JsonIgnore
    @Column(insertable = false)
    private Elements keywordNode;


    public TrendKeyword() {
    }


    public TrendKeyword(Elements keywordNode) {
        List<String> tempKeywordList = new ArrayList();
        keywordNode.stream().forEach(n -> tempKeywordList.add(n.text()));

        this.keyword = StringUtils.join(tempKeywordList, "|||");
        this.createdTime = LocalDateTime.now();
    }

    public List<String> getKeywordList() {
        return Arrays.asList(StringUtils.split(keyword, "|||"));
    }
}
