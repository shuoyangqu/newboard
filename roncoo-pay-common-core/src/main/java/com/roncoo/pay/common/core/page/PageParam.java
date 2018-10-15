package com.roncoo.pay.common.core.page;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;

/**
 * @Author: qsy
 * @Description: 分页参数传递工具类
 * @Date: Created in 下午 3:44 2018/10/11/011
 */
public class PageParam implements Serializable{

    private static final long serialVersionUID = -2114465125587576019L;

    /**默认为第一页*/
    public static final int DEFAULT_PAGE_NUM=1;
    /**默认每页记录数（15）*/
    public static final int DEFAULT_NUM_PER_PAGE=15;
    /**最大每页记录数（100）*/
    public static final int MAX_PAGE_SIZE=100;
    /**当前页数*/
    private int pageNum=DEFAULT_PAGE_NUM;
    /**每页记录数*/
    private int numPerPage;

    public PageParam() {
    }

    public PageParam(int pageNum, int numPerPage) {
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage>0?numPerPage:DEFAULT_NUM_PER_PAGE;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }
}
