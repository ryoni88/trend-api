package com.naver.hackday.trendapi.controller;

import com.naver.hackday.trendapi.model.Test;
import com.naver.hackday.trendapi.repository.TestRepository;
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
public class TestController {
    private final TestRepository testRepository;

    @Autowired
    public TestController(TestRepository repository) {
        this.testRepository = repository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/testlist")
    @ResponseBody
    public List<Test> getList() {
        return testRepository.findAll();
    }

}