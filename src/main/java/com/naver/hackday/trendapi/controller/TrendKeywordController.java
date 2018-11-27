package com.naver.hackday.trendapi.controller;

import com.naver.hackday.trendapi.model.TrendKeyword;
import com.naver.hackday.trendapi.repository.TestRepository;
import com.naver.hackday.trendapi.repository.TrendKeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author SaeHan Kim
 * @since 2018-11-14
 */
@RepositoryRestController
@RequestMapping(path = "/")
public class TrendKeywordController {
    private final TrendKeywordRepository trendKeywordRepository;

    @Autowired
    public TrendKeywordController(TrendKeywordRepository trendKeywordRepository) {
        this.trendKeywordRepository = trendKeywordRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getTrendList")
    @ResponseBody
    public List<TrendKeyword> getTrendList() {
        return trendKeywordRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTrendLatest")
    @ResponseBody
    public TrendKeyword getTrend() {
        return trendKeywordRepository.findTopByOrderByCreatedTimeDesc();
    }

}