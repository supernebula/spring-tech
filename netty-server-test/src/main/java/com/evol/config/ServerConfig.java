package com.evol.config;

import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author admin
 */
@Getter
public class ServerConfig {



    private int nettyPort;

    private String excelPath;

    public ServerConfig() {
        Properties properties = getProperties();
        if(properties != null){
            nettyPort = NumberUtils.toInt(properties.getProperty("netty.port"), 9090);
            excelPath = properties.getProperty("excel.path");
        }

    }

    private static Properties getProperties(){
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ServerConfig.class.getClassLoader().getResourceAsStream("application.properties");
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        try {
            properties.load(in);
            return properties;
        }catch (Exception ex){
            System.out.print(ex);
        }
        return null;
    }


}
