package com.roncoo.pay.account.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.roncoo.pay.account.dao.RpAccountDao;
import com.roncoo.pay.account.dao.RpAccountHistoryDao;
import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.account.enums.AccountFundDirectionEnum;
import com.roncoo.pay.account.enums.TrxTypeEnum;
import com.roncoo.pay.account.exception.AccountBizException;
import com.roncoo.pay.account.service.RpAccountTransactionService;
import com.roncoo.pay.common.core.enums.PublicEnum;
import com.roncoo.pay.common.core.exception.BizException;
import com.roncoo.pay.common.core.utils.DateUtils;
import com.roncoo.pay.common.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("rpAccountTransactionService")
public class IRpAccountTransactionService implements RpAccountTransactionService {

    private static final Log LOG= LogFactory.getLog(IRpAccountTransactionService.class);

    @Autowired
    private RpAccountDao rpAccountDao;
    @Autowired
    private RpAccountHistoryDao rpAccountHistoryDao;

    /**
     * 根据用户编号获取账户信息
     * @param userNo 用户编号
     * @param isPessimist 是否加行锁
     * @return
     */
    private RpAccount getByUserNo_IsPessimist(String userNo,boolean isPessimist){
        Map<String,Object> map=new HashMap<>();
        map.put("userNo",userNo);
        map.put("isPessimist",isPessimist);
        return rpAccountDao.getByUserNo(map);
    }

    /**
     * 加款：有银行流水
     * @param userNo 用户编号
     * @param amount 加款金额
     * @param requestNo  请求号
     * @param bankTrxNo  业务编号
     * @param trxType 业务类型
     * @param remark 备注
     * @return
     * @throws BizException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RpAccount creditToAccount(String userNo, BigDecimal amount,
                                     String requestNo, String bankTrxNo, String trxType, String remark) throws BizException {
        RpAccount account=this.getByUserNo_IsPessimist(userNo,true);
        if (account==null){
            throw AccountBizException.ACCOUNT_NOT_EXIT;
        }
        Date lastModifyDate=account.getEditTime();
        //不是同一天直接清0
        if (!DateUtils.isSameDayWithToday(lastModifyDate)){
            account.setTodayExpend(BigDecimal.ZERO);
            account.setTodayIncome(BigDecimal.ZERO);
        }
        //总收益累加和今日收益
        if (TrxTypeEnum.EXPENSE.name().equals(trxType)){//业务类型是交易
            account.setTotalIncome(account.getTotalIncome().add(amount));
            /*** 根据上次修改时间，统计今日收益 **/
            if (DateUtils.isSameDayWithToday(lastModifyDate)){
                //如果是同一天
                account.setTodayIncome(account.getTodayIncome().add(amount));
            }else {
                //不是同一天
                account.setTodayIncome(amount);
            }
        }
        String completeSett= PublicEnum.NO.name();
        String isAllowSett=PublicEnum.YES.name();

        /**设置余额的值*/
        account.setBalance(account.getBalance().add(amount));
        account.setEditTime(new Date());

        //记录账户历史
        RpAccountHistory accountHistory=new RpAccountHistory();
        accountHistory.setCreateTime(new Date());
        accountHistory.setEditTime(new Date());
        accountHistory.setIsAllowSett(isAllowSett);
        accountHistory.setAmount(amount);
        accountHistory.setBalance(account.getBalance());
        accountHistory.setRequestNo(requestNo);
        accountHistory.setBankTrxNo(bankTrxNo);
        accountHistory.setIsCompleteSett(completeSett);
        accountHistory.setRemark(remark);
        accountHistory.setFundDirection(AccountFundDirectionEnum.ADD.name());
        accountHistory.setAccountNo(account.getAccountNo());
        accountHistory.setTrxType(trxType);
        accountHistory.setId(StringUtil.get32UUID());
        accountHistory.setUserNo(userNo);

        this.rpAccountHistoryDao.insert(accountHistory);
        this.rpAccountDao.update(account);
        LOG.info("账户加款成功，并记录了账户历史");
        return account;
    }

    /**
     * 加款
     * @param userNo 用户编号
     * @param amount 加款金额
     * @param requestNo 请求号
     * @param trxType 业务类型
     * @param remark 备注
     * @return
     * @throws BizException
     */
    @Override
    public RpAccount creditToAccount(String userNo, BigDecimal amount,
                                     String requestNo, String trxType, String remark) throws BizException {
        return null;
    }

    @Override
    public RpAccount debitToAccount(String userNo, BigDecimal amount, String requestNo, String bankTrxNo, String trxType, String remark) throws BizException {
        return this.creditToAccount(userNo,amount,requestNo,null,trxType,remark);
    }

    @Override
    public RpAccount debitToAccount(String userNo, BigDecimal freezeAmount) throws BizException {
        return null;
    }

    @Override
    public RpAccount freezeAmount(String userNo, BigDecimal freezeAmount) throws BizException {
        return null;
    }

    @Override
    public RpAccount unFreezeAmount(String userNo, BigDecimal amout, String requestNo, String trxType, String remark) throws BizException {
        return null;
    }

    @Override
    public RpAccount unFreezeSettAmount(String userNo, BigDecimal amount) throws BizException {
        return null;
    }

    @Override
    public void settCollectSuccess(String accountNo, String collectData, int riskDay, BigDecimal totoalAmount) throws BizException {

    }
}
