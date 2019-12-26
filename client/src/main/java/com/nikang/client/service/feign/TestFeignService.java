package com.nikang.client.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider",fallbackFactory = TestFeignServiceException.class)
public interface TestFeignService {
        @GetMapping(value = "/test/queryStrByProvider2")
        public String query2String();
        @GetMapping(value = "/test/queryStrByProvider")
        public String queryString();
}
