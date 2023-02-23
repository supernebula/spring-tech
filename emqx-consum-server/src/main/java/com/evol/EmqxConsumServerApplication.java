package com.evol;

import com.evol.service.OnMessageCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EmqxConsumServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(EmqxConsumServerApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(EmqxConsumServerApplication.class);

    @PostConstruct
    public void run() throws Exception {

        String subTopic = "testdevtopic/2";
        String pubTopic = "testdevtopic/1";
        String content = "Hello World ,I am emqx-consumer-server";
        int qos = 2;
        String broker = "tcp://192.168.0.206:1883";
        String clientId = "emqx-consumer-server";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient client = new MqttClient(broker, clientId, persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName("serveruser1");
            connOpts.setPassword("password1".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);

            // 设置回调
            client.setCallback(new OnMessageCallback());

            // 建立连接
            logger.info("Connecting to broker: " + broker);
            client.connect(connOpts);

            logger.info("Connected");
            logger.info("Publishing message: " + content);

            // 订阅
            client.subscribe(subTopic);

            // 消息发布所需参数
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            client.publish(pubTopic, message);
            logger.info("Message published");

            //client.disconnect();
            //logger.info("Disconnected");
            //client.close();
            //System.exit(0);
        } catch (MqttException me) {
            logger.info("reason " + me.getReasonCode());
            logger.info("msg " + me.getMessage());
            logger.info("loc " + me.getLocalizedMessage());
            logger.info("cause " + me.getCause());
            logger.info("excep " + me);
            me.printStackTrace();
        }

    }
}
