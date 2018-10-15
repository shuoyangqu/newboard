package com.roncoo.pay.common.core.dao.impl;

import com.roncoo.pay.common.core.dao.BaseDao;
import com.roncoo.pay.common.core.entity.BaseEntity;
import com.roncoo.pay.common.core.exception.BizException;
import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 访问层基础支撑类
 * @Date: Created in 下午 2:53 2018/10/12/012
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    protected static final Log LOG = LogFactory.getLog(BaseDaoImpl.class);

    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "batchInsert";
    public static final String SQL_UPDATE_BY_ID = "updateByPrimaryKey";
    public static final String SQL_BATCH_UPDATE_BY_IDS = "batchUpdateByIds";
    public static final String SQL_BATCH_UPDATE_BY_COLUMN = "batchUpdateByColumn";
    public static final String SQL_SELECT_BY_ID = "selectByPrimaryKey";
    public static final String SQL_LIST_BY_COLUMN = "listByColumn";
    public static final String SQL_COUNT_BY_COLUMN = "getCountByColumn";
    public static final String SQL_DELETE_BY_ID = "deleteByPrimaryKey";
    public static final String SQL_BATCH_DELETE_BY_IDS = "batchDeleteByIds";
    public static final String SQL_BATCH_DELETE_BY_COLUMN = "batchDeleteByColumn";
    public static final String SQL_LIST_PAGE = "listPage";
    public static final String SQL_LIST_BY = "listBy";
    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    //根据当前分页参数进行统计
    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam";
    /**
     * 注入SQLSessionTemplate实例
     * 可以调用sessionTemplate完成数据库操作
     */
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @Override
    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    /**
     * 单条插入数据
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(T entity) {
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作，insert返回0.{%s}", getStatement(SQL_INSERT));
        }
        return result;
    }

    /**
     * 获取Mapper命名空间
     *
     * @param sqlId
     * @return
     */
    public String getStatement(String sqlId) {
        String name = this.getClass().getName();
        //单线程用StringBuilder，确保速度，多线程用StringBuffer，确保安全
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(".").append(sqlId);
        return sb.toString();
    }

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
    @Override
    public int insert(List<T> list) {
        if (list.isEmpty() || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作，batchInsert返回0.{%s}", getStatement(SQL_BATCH_INSERT));
        }
        return result;
    }

    /**
     * 根据id单条更新数据
     *
     * @param entity
     * @return
     */
    @Override
    public int update(T entity) {
        entity.setEditTime(new Date());
        int result = sessionTemplate.update(getStatement(SQL_UPDATE_BY_ID), entity);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作，batchInsert返回0.{%s}", getStatement(SQL_BATCH_INSERT));
        }
        return result;

    }

    /**
     * 根据id批量更新数据
     *
     * @param list
     * @return
     */
    @Override
    public int update(List<T> list) {
        if (list.isEmpty() || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.update(getStatement(SQL_BATCH_DELETE_BY_IDS), list);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作，batchInsert返回0.{%s}", getStatement(SQL_BATCH_INSERT));
        }
        return result;
    }

    /**
     * 根据column批量更新数据
     *
     * @param paramMap
     * @return
     */
    @Override
    public int update(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return 0;
        }
        int result=sessionTemplate.update(getStatement(SQL_BATCH_DELETE_BY_COLUMN),paramMap);
        if (result<=0){
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作，batchInsert返回0.{%s}",getStatement(SQL_BATCH_INSERT));
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public T getById(String id) {
        return sessionTemplate.selectOne(getStatement(SQL_SELECT_BY_ID),id);
    }

    /**
     * 根据column查询数据
     * @param paramMap
     * @return
     */
    @Override
    public T getByColumn(Map<String, Object> paramMap) {
        if (paramMap==null) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_LIST_BY_COLUMN),paramMap);
    }

    /**
     * 根据条件查询getBy:selectOne
     * @param paramMap
     * @return
     */
    @Override
    public T getBy(Map<String, Object> paramMap) {
        if (paramMap==null) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_LIST_BY),paramMap);
    }

    /**
     * 根据条件查询列表数据
     * @param paramMap
     * @return
     */
    @Override
    public List<T> listBy(Map<String, Object> paramMap) {
        if (paramMap==null) {
            return null;
        }
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY),paramMap);
    }

    /**
     * 根据column查询列表数据
     * @param paramMap
     * @return
     */
    @Override
    public List<T> listByColumn(Map<String, Object> paramMap) {
        if (paramMap==null) {
            return null;
        }
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY_COLUMN),paramMap);
    }

    /**
     * 根据column查询记录数
     * @param paramMap
     * @return
     */
    @Override
    public Long getCountByColumn(Map<String, Object> paramMap) {
        if (paramMap==null) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_LIST_BY_COLUMN),paramMap);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        return (int) sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID),id);
    }

    /**
     * 根据id批量删除数据
     * @param list
     * @return
     */
    @Override
    public int delete(List<T> list) {
        if (list.isEmpty()||list.size()<=0) {
            return 0;
        }else {
            return (int)sessionTemplate.delete(getStatement(SQL_BATCH_DELETE_BY_IDS),list);
        }
    }

    @Override
    public int delete(Map<String, Object> paramMap) {
        if (paramMap==null) {
            return 0;
        }else {
            return (int)sessionTemplate.delete(getStatement(SQL_BATCH_DELETE_BY_COLUMN),paramMap);
        }
    }

    /**
     * 分页查询数据
     * @param pageParam
     * @param paramMap
     * @return
     */
    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap==null){
            paramMap=new HashMap<String,Object>();
        }
        //统计总记录数
        Long totalCount=sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT),paramMap);
        //校验当前页数
        int currentPage=PageBean.checkCurrentPage(totalCount.intValue(),pageParam.getNumPerPage(),pageParam.getPageNum());
        //为当前页重新设置
        pageParam.setPageNum(currentPage);
        //校验页面输入的每页记录数numPerPage是否合法
        //校验每页记录数
        int numPerPage=PageBean.checkNumPerPage(pageParam.getNumPerPage());
        //重新设值
        pageParam.setNumPerPage(numPerPage);

        //根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst",(pageParam.getPageNum()-1)*pageParam.getNumPerPage());
        paramMap.put("pageSize",pageParam.getNumPerPage());
        paramMap.put("startRowNum",(pageParam.getPageNum()-1)*pageParam.getNumPerPage());
        paramMap.put("endRowNum",pageParam.getPageNum()*pageParam.getNumPerPage());

        //获取分页数据集
        List<Object> list=sessionTemplate.selectList(getStatement(SQL_LIST_PAGE),pageParam);
        //是否统计当前分页条件下的数据：1、是，其他为否
        Object isCount=paramMap.get("isCount");
        if (isCount!=null&&"1".equals(isCount.toString())){
            Map<String,Object> countResultMap=sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM),paramMap);
            return new PageBean(pageParam.getPageNum(),pageParam.getNumPerPage(),totalCount.intValue(),list,countResultMap);
        }else {
            //构造分页对象
            return new PageBean(pageParam.getPageNum(),pageParam.getNumPerPage(),totalCount.intValue(),list);
        }






    }

}
