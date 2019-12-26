package com.nikang.client.service.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TestFeignServiceException implements FallbackFactory<TestFeignService> {
    @Override
    public TestFeignService create(Throwable throwable) {
        return new TestFeignService() {
            @Override
            public String query2String() {
                return "2进入熔断...";
            }

            @Override
            public String queryString() {
                return  "进入熔断...";
            }
        };
    }
}
