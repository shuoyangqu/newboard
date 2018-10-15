package com.roncoo.pay.account.dao.impl;

import com.roncoo.pay.account.dao.RpAccountDao;
import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.common.core.dao.impl.BaseDaoImpl;
import com.roncoo.pay.common.core.enums.PublicStatusEnum;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 5:40 2018/10/13/013
 */
@Repository
public class IRpAccountDao extends BaseDaoImpl<RpAccount> implements RpAccountDao {

    @Override
    public RpAccount getByAccountNo(String accountNo) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("accountNo",accountNo);
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());

        return this.getBy(paramMap);
    }

    @Override
    public RpAccount getByUserNo(Map<String, Object> map) {
        return this.getSessionTemplate().selectOne(getStatement("getByUserNo"),map);
    }
}
