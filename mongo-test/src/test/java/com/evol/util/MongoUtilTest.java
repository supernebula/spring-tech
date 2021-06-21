package com.evol.util;

import com.evol.domain.PageResult;
import com.evol.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MongoUtilTest {

    //private Logger logger = LoggerFactory.getLogger(MongoUtilTest.class);

    @Autowired
    private MongoUtil mongoUtil;

    @Test
    public void insertTest(){
        User user = new User();
        user.setUsername("test-user8");
        user.setPoint(55);
        user.setCreateTime(new Date());
        User result = mongoUtil.insert(user);
        //System.out.println(result.toString());
        log.info("======" + result.toString());
    }

    @Test
    public void upsertTest(){

        Update update = new Update()
                .set("username", "test-user002")
                .set("point", 2100)
                .set("createTime", new Date());
        long count = mongoUtil.upsert("60cc33f7a39a8e6667a0c42e", update, User.class);
        log.info("====== upsertTest count:" + count);
        //logger.info(() -> {return "upsertTest count:" + count;});

    }

    @Test
    public void updateByIdTest(){

        Update update = new Update()
                .set("username", "test-user002222")
                .set("point", 2500)
                .set("createTime", new Date());
        long count = mongoUtil.updateById("60cc33f7a39a8e6667a0c42e", update, User.class);
        log.info("====== updateById count:" + count);

    }

    @Test
    public void findByIdTest(){
        User user = mongoUtil.findById("60cc33842bc66f2462d73ec9", User.class);
        log.info("====== findByIdTest user:" + user.toString());
    }

    @Test
    public void deleteByIdTest(){
        long count = mongoUtil.deleteById("60cc33842bc66f2462d73ec9", User.class);
        log.info("====== deleteByIdTest count:" + count);
    }

    @Test
    public void queryTest(){
        Query query = new Query(Criteria.where("username").regex("test-user"));
        List<User> list = mongoUtil.query(query, User.class);
        for (User item : list) {
            log.info("======  " + item.toString());
        }
    }

    @Test
    public void queryByPageTest(){

        Query query = new Query(Criteria.where("username").regex("test"));
        PageResult result = mongoUtil.queryByPage(query, 4, 2, User.class);
        log.info("======" + result.toString());
    }


}
