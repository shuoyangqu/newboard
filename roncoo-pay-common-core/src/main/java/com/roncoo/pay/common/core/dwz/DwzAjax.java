package com.roncoo.pay.common.core.dwz;

/**
 * @Author: qsy
 * @Description: 封装DWZ框架ajax请求及响应的参数
 * @Date: Created in 下午 2:20 2018/10/12/012
 */
public class DwzAjax {

    /**
     * Ajax请求的执行状态码
     * statusCode:{ok:200,error:300,timeout:301}
     */
    private String statusCode;
    /** Ajax提示消息*/
    private String message;
    /**
     * navTabId。服务器传回navTabId可以把那个navTab标记为reloadFlag=1
     * 下次切换到那个navTab时会重新载入内容
     * */
    private String navTabId;
    /**
     *callbackType ajax请求回调类型
     * callbackType如果是closeCurrent就会关闭当前tab选项
     * 只有callbackType="forward"时需要forwardURl值，以重定向到另一个URL
     */
    private String callbackType;
    /**重定向URL*/
    private String forwardUrl;

    public final String getStatusCode() {
        return statusCode;
    }

    public final void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public final String getMessage() {
        return message;
    }

    public final void setMessage(String message) {
        this.message = message;
    }

    public final String getNavTabId() {
        return navTabId;
    }

    public final  void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public final String getCallbackType() {
        return callbackType;
    }

    public final void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public final String getForwardUrl() {
        return forwardUrl;
    }

    public final void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }
}
