package com.roncoo.pay.account.service.impl;

import com.roncoo.pay.account.dao.RpAccountHistoryDao;
import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.account.service.RpAccountHistoryService;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 账户历史service实现类
 * @Date: Created in 下午 4:53 2018/10/14/014
 */
@Service("rpAccountHistoryService")
public class IRpAccountHistoryService implements RpAccountHistoryService {
    @Autowired
    private RpAccountHistoryDao rpAccountHistoryDao;

    @Override
    public void saveData(RpAccountHistory rpAccountHistory) {
        rpAccountHistoryDao.insert(rpAccountHistory);
    }

    @Override
    public void updateData(RpAccountHistory rpAccountHistory) {
        rpAccountHistoryDao.update(rpAccountHistory);
    }

    @Override
    public RpAccountHistory getDataById(String id) {
        return rpAccountHistoryDao.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, RpAccountHistory rpAccountHistory) {
        Map<String, Object> paramMap=new HashMap<>();
        paramMap.put("accountNo",rpAccountHistory.getAccountNo());
        return rpAccountHistoryDao.listPage(pageParam,paramMap);
    }
}
