package com.evol.util;

import com.evol.domain.PageResult;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class MongoUtil {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入
     * @param t
     * @param <T>
     * @return
     */
    public <T> T insert(T t){
        T result = mongoTemplate.insert(t);
        return result;
    }

//    /**
//     * 插入
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public <T> List<T> insert(List<T> list){
//        List<T> result = mongoTemplate.insertAll(list);
//        return result;
//    }

    /**
     * 插入，如果存在则更新
     * @param id
     * @param update
     * @param entityClazz
     * @param <T>
     * @return
     */
    public <T> long upsert(String id, Update update, Class<T> entityClazz){
        if(StringUtils.isEmpty(id)){
            return 0;
        }

        Query query = new Query(Criteria.where("_id").is(id));
        UpdateResult result = mongoTemplate.upsert(query, update, entityClazz);
        long count = result.getModifiedCount();
        return count;
    }

    /**
     * 更新
     * @param id
     * @param update
     * @param entityClazz
     * @param <T>
     * @return
     */
    public <T> long updateById(String id, Update update, Class<T> entityClazz){
        if(StringUtils.isEmpty(id)){
            return 0;
        }
        Query query = new Query(Criteria.where("_id").is(id));
        UpdateResult result = mongoTemplate.updateFirst(query, update, entityClazz);
        long count = result.getModifiedCount();
        return count;
    }

    /**
     * 查找
     * @param id
     * @param entityClazz
     * @param <T>
     * @return
     */
    public <T> T findById(String id, Class<T> entityClazz){
        Query query = new Query(Criteria.where("_id").is(id));
        T result = mongoTemplate.findOne(query, entityClazz);
        return result;
    }

    /**
     * 删除
     * @param id
     * @param <T>
     * @return
     */
    public <T> long deleteById(String id, Class<T> clazz){
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query, clazz);
        long count = result.getDeletedCount();
        return count;
    }


    /**
     *
     * @param query
     * @param entityClazz
     * @param <T>
     * @return
     */
    public <T> List<T> query(Query query, Class<T> entityClazz){
        if(query == null){
            return null;
        }
        List<T> list = mongoTemplate.find(query, entityClazz);
        return list;
    }


    /**
     * 分页查询
     * @param query
     * @param pageSize
     * @param page
     * @param entityClazz
     * @param <T>
     * @return
     */
    public <T> PageResult<T> queryByPage(Query query, int pageSize, int page, Class<T> entityClazz){
        if(query == null){
            return null;
        }

        long total = mongoTemplate.count(query, entityClazz);
        long pageTotal = (int)Math.ceil(total / pageSize);
        if(page <= 0 || page > pageTotal){
            page = 1;
        }
        int skip = pageSize * (page - 1);
        query = query.skip(skip).limit(pageSize);
        List<T> list = mongoTemplate.find(query, entityClazz);
        PageResult pageResult = PageResult.create(pageTotal, pageSize, page, total, list);
        return pageResult;
    }
}
