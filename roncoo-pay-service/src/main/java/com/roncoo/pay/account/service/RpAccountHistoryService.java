package com.roncoo.pay.account.service;

import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;

/**
 * @Author: qsy
 * @Description: 账户历史service接口
 * @Date: Created in 下午 4:50 2018/10/14/014
 */
public interface RpAccountHistoryService  {
    /**
     * 保存
     * @param rpAccountHistory
     */
    void saveData(RpAccountHistory rpAccountHistory);

    /**
     * 更新
     * @param rpAccountHistory
     */
    void updateData(RpAccountHistory rpAccountHistory);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    RpAccountHistory getDataById(String id);

    /**
     * 获取分页数据
     * @param pageParam
     * @param rpAccountHistory
     * @return
     */
    PageBean listPage(PageParam pageParam,RpAccountHistory rpAccountHistory);




}
