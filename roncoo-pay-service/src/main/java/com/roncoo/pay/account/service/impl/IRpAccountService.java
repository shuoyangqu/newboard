package com.roncoo.pay.account.service.impl;

import com.roncoo.pay.account.dao.RpAccountDao;
import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.account.service.RpAccountService;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 账户service实现
 * @Date: Created in 下午 4:44 2018/10/14/014
 */
@Service("rpAccountService")
public class IRpAccountService implements RpAccountService {
    @Autowired
    private RpAccountDao rpAccountDao;

    @Override
    public void saveData(RpAccount rpAccount) {
        rpAccountDao.insert(rpAccount);
    }

    @Override
    public void updateData(RpAccount rpAccount) {
        rpAccountDao.update(rpAccount);
    }

    @Override
    public RpAccount getDataById(String id) {
        return rpAccountDao.getById(id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, RpAccount rpAccount) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("accountNo",rpAccount.getAccountNo());
        return rpAccountDao.listPage(pageParam,paramMap);
    }

    @Override
    public RpAccount getDataByUserNo(String userNo) {
        Map<String, Object> paramMap=new HashMap<>();
        paramMap.put("userNo",userNo);
        return rpAccountDao.getByUserNo(paramMap);
    }
}
