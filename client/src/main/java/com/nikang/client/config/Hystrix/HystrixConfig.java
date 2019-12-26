package com.nikang.client.config.Hystrix;

import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HystrixConfig {
    @Bean
    public HystrixCallableWrapper requestAttributeAwareCallableWrapper() {
        return new RequestAttributeAwareCallableWrapper();
    }

    @Bean
    public HystrixCallableWrapper mdcAwareCallableWrapper(){
        return new MdcAwareCallableWrapper();
    }

    @Autowired(required = false)
    private List<HystrixCallableWrapper> wrappers = new ArrayList<>();

    @PostConstruct
    public void init() {
        HystrixPlugins.reset();
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new RequestContextHystrixConcurrencyStrategy(wrappers));
    }
}
