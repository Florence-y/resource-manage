package com.florence.resources.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyanzhen
 */
@ToString
public class Page<T> implements IPage<T> {
    private List<T> data;
    private Long curPage;
    private Long pageSize;
    private Long total;
    private Long pageCount;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Page(Long curPage, Long pageSize) {
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public Page() {

    }

    @Override
    public List<OrderItem> orders() {
        return orderItems;
    }

    @Override
    public List<T> getRecords() {
        return data;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        data = records;
        return this;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public IPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return pageSize;
    }

    @Override
    public IPage<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return curPage;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        this.curPage = current;
        return this;
    }
}
