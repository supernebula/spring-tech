package com.evol.util;

import com.evol.domain.MonitorErrOrder;
import com.evol.domain.PageResult;
import com.evol.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
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


    @Test
    public void queryErrOrderRateTest() {
        Date date = this.addDate(-1);
        Query query = new Query();

        Date minDate1 = this.convertDateToMin(date);
        Date maxDate1 = this.convertDateToMax(date);

        //转时区加8小时
        LocalDateTime minDate =  minDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusHours(8L);
        LocalDateTime maxDate =  maxDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusHours(8L);

        log.info("minDate:" + minDate + " , maxDate:" + maxDate);
        Criteria criteria = Criteria.where("createTime").gte(minDate).lt(maxDate);
        query.addCriteria(criteria);
        query.limit(5);
        query.with(Sort.by(Sort.Order.desc("errOrderRate"), Sort.Order.desc("errOrderNumber")));
        List<MonitorErrOrder> monitorErrOrders = mongoUtil.query(query, MonitorErrOrder.class);
        for (MonitorErrOrder item: monitorErrOrders) {
            log.info(item.toString());
        }
    }

    private Date addDate(int day) {
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(5, date.get(5) + day);
        return date.getTime();
    }

    /** 日期转日期零点*/
    private Date convertDateToMin(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    /** 日期转日期最大*/
    private Date convertDateToMax(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }


}
