package com.naver.hackday.trendapi.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class TrendKeyword {
    @JsonIgnore
    @Column(name = "keyword")
    private String keyword = "";

    @Id
    @Column(name = "created_time", updatable = false)
    private LocalDateTime createdTime;

    @JsonIgnore
    @Column(insertable = false)
    private Elements keywordNode;

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
