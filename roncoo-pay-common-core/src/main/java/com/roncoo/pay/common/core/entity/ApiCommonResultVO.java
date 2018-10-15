package com.roncoo.pay.common.core.entity;


import com.alibaba.fastjson.JSONObject;

/**
 * @Author: qsy
 * @Description: api请求正常返回结果，该实体作为API请求时，按照规范返回的实体，code为返回码，
 * msg为返回描述，data为返回的具体结果 created
 * @Date: Created in 上午 9:42 2018/10/11/011
 */
public class ApiCommonResultVO {

    public ApiCommonResultVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        if (data!=null) {
            this.data = data;
        }
    }

    public ApiCommonResultVO(Object data) {
        this.code = code;
        this.msg = msg;
        if (data!=null) {
            this.data = data;
        }
    }

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回描述
     */
    private String msg="";
    /**
     * 返回数据
     */
    private Object data=new Object();

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new ApiCommonResultVO(-1,"",null)));
    }
}
