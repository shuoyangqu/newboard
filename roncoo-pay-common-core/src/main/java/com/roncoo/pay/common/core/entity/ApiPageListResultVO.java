package com.roncoo.pay.common.core.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @Author: qsy
 * @Description: API请求，返回分页数据时，统一实体类，将返回的数据统一封装到该实体中，返回给客户端
 * @Date: Created in 上午 9:56 2018/10/11/011
 */
public class ApiPageListResultVO {
    private int code;
    private String msg="";
    private PageListVO data=new PageListVO((long) 0,0,0,new ArrayList<rpObject>());

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageListVO getData() {
        return data;
    }

    public void setData(PageListVO data) {
        this.data = data;
    }

    public static void main(String[] args) {
        ApiPageListResultVO apiPageListResultVO=new ApiPageListResultVO();
        apiPageListResultVO.setCode(-1);
        apiPageListResultVO.setMsg("测试数据");

        PageListVO pageListVO=new PageListVO((long) 0,2,33,new ArrayList<Object>());

        apiPageListResultVO.setData(pageListVO);
        System.out.println(JSONObject.toJSONString(apiPageListResultVO));

    }
}
