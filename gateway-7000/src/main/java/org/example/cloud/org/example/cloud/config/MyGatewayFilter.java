package org.example.cloud.org.example.cloud.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("------------ come in MyLogGateWayFilter: " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (StringUtils.isEmpty(uname)) {
            log.info("------------ 用户名 [{}] 非法 o(╥﹏╥)o", uname);
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            中断
            return exchange.getResponse().setComplete();
        }
        //按顺序执行
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("提交之后----");
        }));


    }

    @Override
    public int getOrder() {
        return 4;
    }


    

}

