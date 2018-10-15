package com.roncoo.pay.account.dao;

import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.account.vo.DailyCollectAccountHistoryVo;
import com.roncoo.pay.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 账户历史dao
 * @Date: Created in 下午 5:45 2018/10/13/013
 */
public interface RpAccountHistoryDao extends BaseDao<RpAccountHistory> {
    List<RpAccountHistory> listPageByParams(Map<String,Object> params);

    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(Map<String,Object> params);

    /** 更新账户风险预存期外的账户历史记录记为结算完成*/
    void updateCompleteSettTo100(Map<String,Object> params);
}
