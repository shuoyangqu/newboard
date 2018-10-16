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

    /**
     * 加款：有银行流水
     **/
    RpAccount creditToAccount(String userNo, BigDecimal amount, String requestNo, String bankTrxNo,
                              String trxType, String remark) throws BizException;

    /**
     * 减款：有银行流水
     **/
    RpAccount debitToAccount(String userNo, BigDecimal amount, String requestNo, String bankTrxNo,
                             String trxType, String remark) throws BizException;

    /**
     * 加款
     **/
    RpAccount creditToAccount(String userNo, BigDecimal amount, String requestNo, String trxType, String remark) throws BizException;

    /**
     * 减款
     **/
    RpAccount debitToAccount(String userNo, BigDecimal freezeAmount) throws BizException;

    /**
     * 冻结
     **/
    RpAccount freezeAmount(String userNo, BigDecimal freezeAmount) throws BizException;

    /**
     * 结算成功：解冻+减款
     **/
    RpAccount unFreezeAmount(String userNo, BigDecimal amout, String requestNo, String trxType, String remark) throws BizException;

    /** 结算失败：解冻 **/
    RpAccount unFreezeSettAmount(String userNo,BigDecimal amount)throws BizException;

    /** 更新账户历史中的结算状态，并且累加可结算金额 **/
    void settCollectSuccess(String accountNo,String collectData,int riskDay,BigDecimal totoalAmount)throws BizException;

}
