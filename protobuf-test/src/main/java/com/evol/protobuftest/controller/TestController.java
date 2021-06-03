package com.evol.protobuftest.controller;

import com.evol.protobuftest.domain.SearchRequest;
import com.evol.protobuftest.domain.SearchResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://www.dazhuanlan.com/2019/11/28/5ddf8dc4b0cfb/
 * https://cloud.tencent.com/developer/article/1504965
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @PostMapping(value = "getUser", produces = "application/x-protobuf;charset=UTF-8")
    public SearchResponse.MessageSearchResponse getUser(@RequestBody SearchRequest.MessageSearchRequest request) {
        SearchResponse.MessageSearchResponse.Builder builder =  SearchResponse.MessageSearchResponse.newBuilder();
        builder.setCode(1);
        builder.setMsg("ok");
        builder.setUsername(request.getUsername());
        builder.setNick("张三");
        builder.setSubCode(1);
        builder.setSubMsg("data ok");
        SearchResponse.MessageSearchResponse response = builder.build();
        return response;
    }



}
