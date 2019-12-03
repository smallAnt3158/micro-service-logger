package com.nikang.client.config.Interceptors;

import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(feign.RequestTemplate requestTemplate) {
        String traceId = MDC.get("traceId");

        if(!StringUtils.isEmpty(traceId)){
            requestTemplate.header("traceId", traceId);
        }

    }
}
