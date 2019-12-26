package com.nikang.client.config.Interceptors;

import com.alibaba.fastjson.JSON;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(feign.RequestTemplate requestTemplate) {

        log.info("MDC："+JSON.toJSONString(MDC.getCopyOfContextMap()));
        String traceId = MDC.get("traceId");

        if(!StringUtils.isEmpty(traceId)){
            requestTemplate.header("traceId", traceId);
        }

    }
}
