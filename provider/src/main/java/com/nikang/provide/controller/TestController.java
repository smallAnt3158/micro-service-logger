package com.nikang.provide.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.HeaderParam;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/queryStrByProvider")
    public String getString(@RequestHeader("traceId") String traceId){
        log.info("into Controller For Provider ....");
        log.info("MDC tracId For Provider = {}",traceId);
        MDC.put("traceId",traceId);
        return "hello world";
    }
}
