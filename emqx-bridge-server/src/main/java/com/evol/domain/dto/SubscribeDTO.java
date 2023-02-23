package com.evol.domain.dto;

import java.io.Serializable;

public class SubscribeDTO implements Serializable {

    private static final long serialVersionUID = 1L;	// 序列化版本号
    private String payload;

    public void setPayload(String val){
        this.payload = val;
    }

    public String getPayload(){
        return this.payload;
    }
}
