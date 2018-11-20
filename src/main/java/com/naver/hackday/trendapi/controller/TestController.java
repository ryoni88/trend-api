package com.naver.hackday.trendapi.controller;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.hackday.trendapi.model.Test;
import com.naver.hackday.trendapi.model.TrendKeyword;
import com.naver.hackday.trendapi.repository.TestRepository;
import com.naver.hackday.trendapi.repository.TrendKeywordRepository;

/**
 * @author SaeHan Kim
 * @since 2018-11-14
 */
@RepositoryRestController
@RequestMapping(path = "/")
public class TestController {
    private final TestRepository testRepository;
    private final TrendKeywordRepository trendKeywordRepository;

    @Autowired
    public TestController(TestRepository repository,TrendKeywordRepository trendKeywordRepository ) {
        this.testRepository = repository;
        this.trendKeywordRepository = trendKeywordRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/testlist")
    @ResponseBody
    public List<Test> getList() {
        return testRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crawlTrend")
    public void crawlTrend() throws Exception {
        Document doc = Jsoup.connect("https://datalab.naver.com/keyword/realtimeList.naver").get();
        Elements nodes = doc.select("[data-age='all']").select("span.title");
        trendKeywordRepository.save(new TrendKeyword(nodes));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTrendList")
    @ResponseBody
    public List<TrendKeyword> getTrendList()  {
        return trendKeywordRepository.findAll();
    }

}