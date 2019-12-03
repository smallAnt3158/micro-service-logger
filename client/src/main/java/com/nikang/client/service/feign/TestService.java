package com.nikang.client.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("provider")
@Component
public interface TestService {
        @GetMapping(value = "/test/queryStrByProvider")
        public String queryString();
}
