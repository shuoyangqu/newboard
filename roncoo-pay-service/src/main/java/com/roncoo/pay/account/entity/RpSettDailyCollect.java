package com.roncoo.pay.account.entity;

import com.roncoo.pay.common.core.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: qsy
 * @Description: 每日待结算汇总实体
 * @Date: Created in 下午 2:59 2018/10/13/013
 */
public class RpSettDailyCollect extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4565540974222718378L;
    /**
     * 账户编号
     */
    private String accountNo;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 汇总日期
     */
    private Date collectDate;
    /**
     * 汇总类型
     */
    private String collectType;
    /**
     * 结算批次号（结算之后再回写过来）
     */
    private String batchNo;
    /**
     * 交易总金额
     */
    private BigDecimal totalAmount = BigDecimal.ZERO;
    /**
     * 交易总笔数
     */
    private Integer totalCount = 0;
    /**
     * 结算状态
     */
    private String settStatus;
    /**
     * 风险预存期
     */
    private Integer riskDay;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getSettStatus() {
        return settStatus;
    }

    public void setSettStatus(String settStatus) {
        this.settStatus = settStatus;
    }

    public Integer getRiskDay() {
        return riskDay;
    }

    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }
}
