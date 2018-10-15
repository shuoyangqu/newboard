package com.roncoo.pay.common.core.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qsy
 * @Description: 返回的分页实体
 * @Date: Created in 上午 9:58 2018/10/11/011
 */
public class PageListVO {
    /**
     * 总数量
     */
    private Long total;
    /**
     * 页码
     */
    private int page;
    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 分页数据
     */
    private List pageData=new ArrayList();
    /**
     * 汇总数据
     */
    private Object summary;

    public PageListVO(Long total, int page, int pageSize, List pageData) {
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;

        if (pageData!=null) {
            this.pageData = pageData;
        }
    }

    public PageListVO(Long total, int page, int pageSize, List pageData, Object summary) {
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
        if (pageData!=null) {
            this.pageData = pageData;
        }
        this.summary = summary;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getPageData() {
        return pageData;
    }

    public void setPageData(List pageData) {
        this.pageData = pageData;
    }

    public Object getSummary() {
        return summary;
    }

    public void setSummary(Object summary) {
        this.summary = summary;
    }
}
