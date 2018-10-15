package com.roncoo.pay.account.dao.impl;

import com.roncoo.pay.account.dao.RpAccountHistoryDao;
import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.account.vo.DailyCollectAccountHistoryVo;
import com.roncoo.pay.common.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 5:49 2018/10/13/013
 */
@Repository
public class IRpAccountHistoryDao extends BaseDaoImpl<RpAccountHistory> implements RpAccountHistoryDao {
    @Override
    public List<RpAccountHistory> listPageByParams(Map<String, Object> params) {

        return this.listBy(params);
    }

    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(Map<String, Object> params) {

        return this.getSessionTemplate().selectList(getStatement("listDailyCollectAccountHistoryVo"),params);
    }

    /**
     * 更新账户风险预存期外的账户历史记录记为结算完成
     * @param params
     */
    @Override
    public void updateCompleteSettTo100(Map<String, Object> params) {
        this.getSessionTemplate().update(getStatement("updateCompleteSettTo100"),params);
    }
}
