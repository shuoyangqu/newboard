package com.roncoo.pay.account.entity;

import com.roncoo.pay.common.core.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: qsy
 * @Description: 结算记录
 * @Date: Created in 下午 3:06 2018/10/13/013
 */
public class RpSettRecord extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -7724451888432974342L;
    /** 结算发起方式 */
    private String settMode;
    /** 账户编号 */
    private String accountNo;
    /** 用户编号 */
    private String userNo;
    /** 用户类型 */
    private String userType;
    /** 用户姓名 */
    private String userName;
    /** 结算日期 */
    private Date settDate;
    /** 银行编码 */
    private String bankCode;
    /** 银行名称 */
    private String bankName;
    /** 开户名 */
    private String bankAccountName;
    /** 开户账户 */
    private String bankAccountNo;
    /** 开户银行卡类型 */
    private String bankAccountType;
    /** 开户行所在国家 */
    private String country;
    /** 开户行所在省份 */
    private String province;
    /** 开户行所在城市 */
    private String city;
    /** 开户行所在区域 */
    private String areas;
    /** 开户行全称 */
    private String bankAccountAddress;
    /** 收款人手机号 */
    private String mobileNo;
    /** 结算金额 */
    private BigDecimal settAmount=BigDecimal.ZERO;
    /** 结算手续费 */
    private BigDecimal settFee=BigDecimal.ZERO;
    /** 结算打款金额 */
    private BigDecimal remitAmount=BigDecimal.ZERO;
    /** 结算状态 */
    private String settStatus;
    /** 打款发送时间 */
    private Date remitRequestTime;
    /**打款确认时间*/
    private Date remitConfirmTime;
    /** 打款备注 */
    private String remitRemark;
    /** 操作员登录名 */
    private String operatorLoginname;
    /** 操作员姓名 */
    private String operatorRealname;


    public String getSettMode() {
        return settMode;
    }

    public void setSettMode(String settMode) {
        this.settMode = settMode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo==null?null:accountNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo==null?null:userNo.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName==null?null:userName.trim();
    }

    public Date getSettDate() {
        return settDate;
    }

    public void setSettDate(Date settDate) {
        this.settDate = settDate;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode==null?null:bankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName==null?null:bankAccountName.trim();
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo==null?null:bankAccountNo.trim();
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country==null?null:country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province==null?null:province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city==null?null:city.trim();
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas==null?null:areas.trim();
    }

    public String getBankAccountAddress() {
        return bankAccountAddress;
    }

    public void setBankAccountAddress(String bankAccountAddress) {
        this.bankAccountAddress = bankAccountAddress==null?null:bankAccountAddress.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public BigDecimal getSettAmount() {
        return settAmount;
    }

    public void setSettAmount(BigDecimal settAmount) {
        this.settAmount = settAmount;
    }

    public BigDecimal getSettFee() {
        return settFee;
    }

    public void setSettFee(BigDecimal settFee) {
        this.settFee = settFee;
    }

    public BigDecimal getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(BigDecimal remitAmount) {
        this.remitAmount = remitAmount;
    }

    public String getSettStatus() {
        return settStatus;
    }

    public void setSettStatus(String settStatus) {
        this.settStatus = settStatus;
    }

    public Date getRemitRequestTime() {
        return remitRequestTime;
    }

    public void setRemitRequestTime(Date remitRequestTime) {
        this.remitRequestTime = remitRequestTime;
    }

    public Date getRemitConfirmTime() {
        return remitConfirmTime;
    }

    public void setRemitConfirmTime(Date remitConfirmTime) {
        this.remitConfirmTime = remitConfirmTime;
    }

    public String getRemitRemark() {
        return remitRemark;
    }

    public void setRemitRemark(String remitRemark) {
        this.remitRemark = remitRemark==null?null:remitRemark.trim();
    }

    public String getOperatorLoginname() {
        return operatorLoginname;
    }

    public void setOperatorLoginname(String operatorLoginname) {
        this.operatorLoginname = operatorLoginname==null?null:operatorLoginname.trim();
    }

    public String getOperatorRealname() {
        return operatorRealname;
    }

    public void setOperatorRealname(String operatorRealname) {
        this.operatorRealname = operatorRealname==null?null:operatorRealname.trim();
    }
}
