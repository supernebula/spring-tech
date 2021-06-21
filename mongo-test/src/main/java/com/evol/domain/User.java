package com.evol.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@ToString
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String username;

    private Integer point;

    private Date createTime;

}
