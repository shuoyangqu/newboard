package com.roncoo.pay.account.entity;

import com.roncoo.pay.common.core.entity.BaseEntity;
import com.roncoo.pay.common.core.enums.PublicEnum;

import java.io.Serializable;

/**
 * @Author: qsy
 * @Description: 结算附件表
 * @Date: Created in 下午 3:23 2018/10/13/013
 */
public class RpSettRecordAnnex extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6492740824540830465L;
/** 是否删除 **/
    private String isDelete= PublicEnum.NO.name();
    /** 附件名称 **/
    private String annexName;
    /** 附件地址 **/
    private String annexAddress;
    /** 结算id **/
    private String settlementId;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete== null ? null : isDelete.trim();
    }

    public String getAnnexName() {
        return annexName;
    }

    public void setAnnexName(String annexName) {
        this.annexName = annexName== null ? null : annexName.trim();
    }

    public String getAnnexAddress() {
        return annexAddress;
    }

    public void setAnnexAddress(String annexAddress) {
        this.annexAddress = annexAddress== null ? null : annexAddress.trim();
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }
}
