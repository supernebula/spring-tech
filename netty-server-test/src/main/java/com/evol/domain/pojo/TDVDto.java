package com.evol.domain.pojo;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 指令正文： TDV#IMEI
 */
@Getter
public class TDVDto {

    private String instructStr;

    private String instruct;

    private String imei;

    public TDVDto(String instructStr){
        this.instructStr = instructStr;
        String[] list = StringUtils.split(instructStr, "#");
        if(list == null || list.length < 2){
            return;
        }
        instruct = StringUtils.trim(list[0]);
        imei = StringUtils.trim(list[1]);
    }

    @Override
    public String toString(){
        return "instruct:" + instruct + ",imei:" + imei;
    }

}
