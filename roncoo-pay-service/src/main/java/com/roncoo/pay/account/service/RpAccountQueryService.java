package com.roncoo.pay.account.service;

import com.roncoo.pay.account.entity.RpAccount;
import com.roncoo.pay.account.entity.RpAccountHistory;
import com.roncoo.pay.account.vo.DailyCollectAccountHistoryVo;
import com.roncoo.pay.common.core.exception.BizException;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;

import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 账户查询service接口
 * @Date: Created in 下午 4:56 2018/10/14/014
 */
public interface RpAccountQueryService {
    /**
     * 根据账户编号获取账户信息
     * @param accountNo 账户编号
     * @return
     * @throws BizException
     */
    RpAccount getAccountByAccountNo(String accountNo) throws BizException;

    /**
     * 根据用户编号获取账户信息
     * @param userNo 用户编号
     * @return
     * @throws BizException
     */
    RpAccount getAccountByUserNo(String userNo)throws BizException;

    //////账户历史/////////

    /**
     * 根据账户编号分页查询账户历史单商户
     * @param pageParam 分页参数
     * @param accountNo 账户编号
     * @return
     * @throws BizException
     */
    PageBean queryAccountHistoryListPage(PageParam pageParam,String accountNo)throws BizException;

    /**
     * 根据账户编号分页查询账户历史单角色
     * @param pageParam 分页参数
     * @param params 参数
     * @return
     * @throws BizException
     */
    PageBean queryAccountHistoryListPageByRole(PageParam pageParam, Map<String,Object> params) throws BizException;

    /**
     * 获取账户历史（参数没有可以传null）
     * @param accountNo 账户编号
     * @param requestNo 请求号
     * @param trxType 业务类型
     * @return
     * @throws BizException
     */
    RpAccountHistory getAccountHistoryByAccountNo_requestNo_trxType(String accountNo,String requestNo,
                                                                    Integer trxType)throws BizException;

    /**
     * 日汇总账户待结算金额
     * @param accountNo 账户金额
     * @param statDate 统计日期
     * @param riskDay 风险预测期
     * @param fundDirection 资金流向
     * @return
     * @throws BizException
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo,
                                                                        String statDate,Integer riskDay,
                                                                        Integer fundDirection)throws BizException;

    /**
     * 根据参数分页查询账户
     * @param pageParam
     * @param params
     * @return
     * @throws BizException
     */
    PageBean queryAccountListPage(PageParam pageParam,Map<String,Object> params)throws BizException;

    /**
     * 根据参数分页查询账户历史
     * @param pageParam 分页参数
     * @param params 查询参数，可以为null
     * @return
     * @throws BizException
     */
    PageBean queryAccountHistoryListPage(PageParam pageParam,Map<String,Object> params)throws BizException;

    /**
     * 获取所有账户
     * @return
     * @throws BizException
     */
    List<RpAccount> listAll()throws BizException;





}
