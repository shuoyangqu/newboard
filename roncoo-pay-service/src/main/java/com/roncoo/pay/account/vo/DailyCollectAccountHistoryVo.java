package com.roncoo.pay.account.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: qsy
 * @Description: 结算日汇总vo
 * @Date: Created in 下午 3:27 2018/10/13/013
 */
public class DailyCollectAccountHistoryVo implements Serializable {
    private static final long serialVersionUID = -4466216022234653879L;

    /** 账户编号 **/
    private String accountNo;
    /** 汇总日期 **/
    private Date collectDate;
    /** 总金额 **/
    private BigDecimal totalAmount=BigDecimal.ZERO;
    /** 总笔数 **/
    private Integer totalNum=0;
    /** 最后ID **/
    private  Long lastId=0L;
    /** 风险预存期 **/
    private Integer riskDay;
    /** 账户编号 **/
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    public Integer getRiskDay() {
        return riskDay;
    }

    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }
}
