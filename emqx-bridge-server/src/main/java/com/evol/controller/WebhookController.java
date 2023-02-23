package com.evol.controller;

import com.evol.domain.dto.EmqxSubscribeVO;
import com.evol.domain.dto.SubscribeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private Logger logger = LoggerFactory.getLogger(WebhookController.class);
    /**
     *
     */
    @PostMapping("subscribe")
    public Mono<EmqxSubscribeVO> get(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        logger.info(request.getClass().getName());
        MultiValueMap<String, String> params = request.getQueryParams();
        logger.info("----------subscribe Payload:" + params);
        //logger.info("----------subscribe Payload:" + dto.getPayload());
        // 查询用户
        EmqxSubscribeVO result = new EmqxSubscribeVO("ok", "success");
        // 返回
        return Mono.just(result);
    }
}
