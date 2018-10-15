package com.roncoo.pay.common.core.entity;

import com.roncoo.pay.common.core.utils.StringUtil;

import java.util.Date;

/**
 * @Author: qsy
 * @Description: 基类
 * @Date: Created in 上午 10:09 2018/10/11/011
 */
public class BaseEntity {
    /**主键ID*/
    private String id= StringUtil.get32UUID();
    /**版本号默认为0*/
    private Integer version=0;
    /** 状态PublicStatusEnum*/
    private String status;
    /**创建人*/
    private String creater;
    /**创建时间*/
    private Date createTime=new Date();
    /**修改人*/
    private String editor;
    /**修改时间*/
    private Date editTime;
    /**描述*/
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
