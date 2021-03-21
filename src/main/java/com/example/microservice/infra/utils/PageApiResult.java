package com.example.microservice.infra.utils;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 钟玖林
 * @Date 2020/12/16 22:18
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class PageApiResult<T> extends ApiResult<T> implements Serializable {
    /**
     * 总记录数
     */
    private long totalRecord;
    /**
     * 总页数
     */
    private long pageCount;
    /**
     * 当前页码
     */
    private long pageNo;
    /**
     * 当前页的记录数量
     */
    private long pageSize;

    public PageApiResult(Page<T> page) {
        this.setData((T) page.getRecords());
        this.setPageNo(page.getCurrent())
                .setPageSize(page.getSize())
                .setPageCount(page.getPages())
                .setTotalRecord(page.getTotal());
    }
}
