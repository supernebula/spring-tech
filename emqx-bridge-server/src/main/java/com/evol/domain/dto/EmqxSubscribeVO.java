package com.evol.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder
public class EmqxSubscribeVO implements Serializable {

    private static final long serialVersionUID = 1L;	// 序列化版本号

    @JsonProperty("result")
    private String result;

    @JsonProperty("message")
    private String message;

    public EmqxSubscribeVO(String result, String message){
        this.result = result;
        this.message = message;
    }

}
