# micro-service-logger
跟踪微服务日志

整个服务调用是依赖Eureka注册中心的

消息消费者是Client

消息生产者是Provider

由Client服务中生成一个UUID随即的数设置到MDC中的属性traceId
而后续Provider服务中可以根据前置消费者调用的同一个服务链获取Client服务生成的traceId，从而建立微服务之间请求链。
