package com.nikang.client.controller;

import com.nikang.client.service.TestSevice;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestSevice testService;
    @RequestMapping(value = "/getStrByClient")
    public String getString(){
        log.info("into Controller For Client ...");
        log.info("MDC tracId For Client = {}", MDC.get("traceId"));
        String str = restTemplate.getForObject( "http://provider/test/queryStrByProvider" , String.class);
        return str;
    }

    @RequestMapping(value = "/queryStrByClient")
    public String queryString(){
        log.info("into Controller For Client ...");
        log.info("MDC tracId For Client = {}", MDC.get("traceId"));
        return testService.queryString();
    }
}
