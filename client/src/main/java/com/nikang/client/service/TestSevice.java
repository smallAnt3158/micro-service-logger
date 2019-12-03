package com.nikang.client.service;

import com.nikang.client.service.feign.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSevice {
    @Autowired
    private TestService testService;

    public String queryString(){
        return testService.queryString();
    }
}
