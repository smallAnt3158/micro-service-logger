package com.nikang.client.service;

import com.nikang.client.service.feign.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSevice {
    @Autowired
    private TestFeignService testFeignService;

    public String query2String(){
        return testFeignService.query2String();
    }
    public String queryString(){
        return testFeignService.queryString();
    }
}
