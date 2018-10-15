package com.roncoo.pay.account.service.impl;

import com.roncoo.pay.account.dao.RpAccountDao;
import com.roncoo.pay.account.dao.RpAccountHistoryDao;
import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.account.exception.AccountBizException;
import com.roncoo.pay.account.service.RpAccountQueryService;
import com.roncoo.pay.account.vo.DailyCollectAccountHistoryVo;
import com.roncoo.pay.common.core.enums.PublicStatusEnum;
import com.roncoo.pay.common.core.exception.BizException;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;
import com.roncoo.pay.common.core.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 账户查询service实现类
 * @Date: Created in 下午 5:08 2018/10/14/014
 */
@Service("rpAccountQueryService")
public class IRpAccountQueryService implements RpAccountQueryService {
    @Autowired
    private RpAccountDao rpAccountDao;
    @Autowired
    private RpAccountHistoryDao rpAccountHistoryDao;

    private static final Logger logger = LoggerFactory.getLogger(IRpAccountQueryService.class);

    /**
     * 根据账户编号获取账户信息
     *
     * @param accountNo 账户编号
     * @return
     * @throws BizException
     */
    @Override
    public RpAccount getAccountByAccountNo(String accountNo) throws BizException {
        logger.info("根据账户编号查询账户信息");
        RpAccount account = this.rpAccountDao.getByAccountNo(accountNo);
        //不是同一天直接清0
        if (!DateUtils.isSameDayWithToday(account.getEditTime())) {
            account.setTodayExpend(BigDecimal.ZERO);
            account.setTotalIncome(BigDecimal.ZERO);
            account.setEditTime(new Date());
            rpAccountDao.update(account);
        }
        return account;
    }

    /**
     * 根据用户编号获取账户信息
     *
     * @param userNo 用户编号
     * @return
     * @throws BizException
     */
    @Override
    public RpAccount getAccountByUserNo(String userNo) throws BizException {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        logger.info("根据用户编号查询账户信息");
        RpAccount account = this.rpAccountDao.getBy(map);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT;
        }
        //不是同一天直接清0
        if (!DateUtils.isSameDayWithToday(account.getEditTime())) {
            account.setTodayExpend(BigDecimal.ZERO);
            account.setTodayIncome(BigDecimal.ZERO);
            account.setEditTime(new Date());
            rpAccountDao.update(account);
        }
        return account;
    }

    /**
     * 分页查询账户历史单用户
     *
     * @param pageParam 分页参数
     * @param accountNo 账户编号
     * @return
     * @throws BizException
     */
    @Override
    public PageBean queryAccountHistoryListPage(PageParam pageParam, String accountNo) throws BizException {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        return rpAccountDao.listPage(pageParam, params);
    }

    /**
     * 分页查询账户历史单角色
     * @param pageParam 分页参数
     * @param params 参数
     * @return
     * @throws BizException
     */
    @Override
    public PageBean queryAccountHistoryListPageByRole(PageParam pageParam, Map<String, Object> params) throws BizException {
        String accountType= (String) params.get("accountType");
        if (StringUtils.isBlank(accountType)){
            throw AccountBizException.ACCOUNT_TYPE_IS_NULL;
        }
        return rpAccountDao.listPage(pageParam,params);
    }

    /**
     * 获取账户历史单角色
     * @param accountNo 账户编号
     * @param requestNo 请求号
     * @param trxType 业务类型
     * @return
     * @throws BizException
     */
    @Override
    public RpAccountHistory getAccountHistoryByAccountNo_requestNo_trxType(String accountNo, String requestNo, Integer trxType) throws BizException {
        Map<String,Object> map=new HashMap<>();
        map.put("accountNo",accountNo);
        map.put("requestNo",requestNo);
        map.put("trxType",trxType);
        return rpAccountHistoryDao.getBy(map);
    }

    /**
     * 日汇总账户待结算金额
     * @param accountNo 账户金额
     * @param statDate 统计日期
     * @param riskDay 风险预测期
     * @param fundDirection 资金流向
     * @return
     * @throws BizException
     */
    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskDay, Integer fundDirection) throws BizException {
        Map<String,Object> params=new HashMap<>();
        params.put("accountNo",accountNo);
        params.put("statDate",statDate);
        params.put("riskDay",riskDay);
        params.put("fundDirection",fundDirection);
        return rpAccountHistoryDao.listDailyCollectAccountHistoryVo(params);
    }

    /**
     * 根据参数分页查询账户
     * @param pageParam
     * @param params
     * @return
     * @throws BizException
     */
    @Override
    public PageBean queryAccountListPage(PageParam pageParam, Map<String, Object> params) throws BizException {
        return rpAccountDao.listPage(pageParam,params);
    }

    /**
     * 根据参数分页查询账户历史
     * @param pageParam 分页参数
     * @param params 查询参数，可以为null
     * @return
     * @throws BizException
     */
    @Override
    public PageBean queryAccountHistoryListPage(PageParam pageParam, Map<String, Object> params) throws BizException {
        return rpAccountHistoryDao.listPage(pageParam,params);
    }

    /**
     * 获取所有账户
     * @return
     * @throws BizException
     */
    @Override
    public List<RpAccount> listAll() throws BizException {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        return rpAccountDao.listBy(paramMap);
    }
}
