package com.roncoo.pay.account.service;

import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.common.core.exception.BizException;

import java.math.BigDecimal;

/**
 * @Author: qsy
 * @Description: 账户操作service接口
 * @Date: Created in 上午 8:30 2018/10/15/015
 */
public interface RpAccountTransactionService {

    /** 加款：有银行流水 **/
    RpAccount creditToAccount(String userNo, BigDecimal amount,String requestNo,String bankTrxNo,
                              String trxType,String remark)throws BizException;

    /** 减款：有银行流水 **/
    RpAccount debitToAccount(String userNo,BigDecimal amount,String requestNo,String bankTrxNo,
                             String trxType,String remark)throws BizException;






}
