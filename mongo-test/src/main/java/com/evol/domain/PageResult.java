
package com.evol.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -4843054288180603924L;

    /**
     * 总页数
     */
    private Long pageTotal;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页号
     */
    private Integer page;

    /**
     * 总记录数
     */
    private Long total=0L;

    /**
     * 数据
     */
    private List records;

    public static <T> PageResult<T> create(Long pageTotal, Integer pageSize, Integer page, Long total,List<T> records) {
        PageResult pageInfo = new PageResult();
        pageInfo.pageTotal = pageTotal;
        pageInfo.pageSize = pageSize;
        pageInfo.page = page;
        pageInfo.setTotal(total);
        pageInfo.setRecords(records);
        return pageInfo;
    }
}
