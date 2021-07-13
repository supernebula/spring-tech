package com.evol.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author: xc
 * @ClassName: MonitorErrOrder
 * @Date: 2021-06-22 17:02
 * @Description:
 */
@Data
@Document(collection = "monitor_err_order")
@ToString
public class MonitorErrOrder {
    @Id
    private String id;

    private Integer deviceId;

    private String deviceNumber;

    private Integer errOrderNumber;

    private Integer errOrderRate;

    private Integer totalOrderNumber;

    @Indexed(direction = IndexDirection.DESCENDING, expireAfterSeconds = 604800)
    private Date createTime;
}
