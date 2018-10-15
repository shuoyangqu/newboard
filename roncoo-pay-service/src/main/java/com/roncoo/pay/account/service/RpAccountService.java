package com.roncoo.pay.account.service;

import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;

/**
 * @Author: qsy
 * @Description: 账户service接口
 * @Date: Created in 下午 4:40 2018/10/14/014
 */
public interface RpAccountService {
    /**
     * 保存
     * @param rpAccount
     */
    void saveData(RpAccount rpAccount);

    /**
     * 更新
     * @param rpAccount
     */
    void updateData(RpAccount rpAccount);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    RpAccount getDataById(String id);

    /**
     * 获取分页数据
     * @param pageParam
     * @param rpAccount
     * @return
     */
    PageBean listPage(PageParam pageParam,RpAccount rpAccount);

    /**
     * 根据userNo获取数据
     * @param userNo
     * @return
     */
    RpAccount getDataByUserNo(String userNo);

}
