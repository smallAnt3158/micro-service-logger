package com.nikang.client.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("provider")
public interface TestFeignService {
        @GetMapping(value = "/test/queryStrByProvider")
        public String queryString();
}
