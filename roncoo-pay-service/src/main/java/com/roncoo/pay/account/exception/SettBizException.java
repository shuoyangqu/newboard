package com.roncoo.pay.account.exception;

import com.roncoo.pay.common.core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: qsy
 * @Description: 结算服务业务异常类，异常代码8位数字组成，前4位固定1001打头，后4位自定义
 * @Date: Created in 下午 5:25 2018/10/13/013
 */
public class SettBizException extends BizException {
    private static final long serialVersionUID = 191569701478753175L;
    private static final Logger logger= LoggerFactory.getLogger(SettBizException.class);

    public static final SettBizException SETT_STATUS_ERROR=new SettBizException(10010001,"结算状态错误");

    public SettBizException(){}
    public SettBizException(int code,String msgFormat,Object... args){
        super(code,msgFormat,args);
    }

    public SettBizException(int code, String msgFormat) {
        super(code,msgFormat);
    }

    /**
     * 实例化异常
     * @param msgFormat
     * @param args
     * @return
     */
    @Override
    public SettBizException newInstance(String msgFormat,Object... args){
        return new SettBizException(this.code,msgFormat,args);
    }

    public SettBizException print(){
        logger.info("==>BizException,code:"+this.code+",msg:"+this.msgFormat);
        return this;
    }

}
