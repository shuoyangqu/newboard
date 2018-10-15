package com.roncoo.pay.account.dao;

import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.common.core.dao.BaseDao;

import java.util.Map;

/**
 * @Author: qsy
 * @Description: 账户dao
 * @Date: Created in 下午 5:38 2018/10/13/013
 */
public interface RpAccountDao extends BaseDao<RpAccount> {
    RpAccount getByAccountNo(String accountNo);

    RpAccount getByUserNo(Map<String,Object> map);

}
