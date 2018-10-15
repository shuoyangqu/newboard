package com.roncoo.pay.common.core.dao;

import com.roncoo.pay.common.core.page.PageBean;
import com.roncoo.pay.common.core.page.PageParam;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 数据访问层基础支撑接口
 * @Date: Created in 下午 2:54 2018/10/12/012
 */
public interface BaseDao<T> {
    /**
     * 单条插入数据
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 批量插入数据
     * @param list
     * @return
     */
    int insert(List<T> list);

    /**
     * 根据id单条更新数据
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 根据id批量更新数据
     * @param list
     * @return
     */
    int update(List<T> list);

    /**
     * 根据column批量更新数据
     * @param paramMap
     * @return
     */
    int update(Map<String,Object> paramMap);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    T getById(String id);

    /**
     * 根据column查询数据
     * @param paramMap
     * @return
     */
    T getByColumn(Map<String,Object> paramMap);

    /**
     * 根据条件查询listBy
     * @param paramMap
     * @return
     */
    T getBy(Map<String,Object> paramMap);

    /**
     * 根据条件查询列表数据
     * @param paramMap
     * @return
     */
    List<T> listBy(Map<String,Object> paramMap);

    /**
     * 根据column查询列表数据
     * @param paramMap
     * @return
     */
    List<T> listByColumn(Map<String,Object> paramMap);

    /**
     * 根据column查询记录数
     * @param paramMap
     * @return
     */
    Long getCountByColumn(Map<String,Object> paramMap);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据id批量删除数据
     * @param list
     * @return
     */
    int delete(List<T> list);

    /**
     * 根据column批量删除数据
     * @param paramMap
     * @return
     */
    int delete(Map<String,Object> paramMap);

    /**
     * 分页查询数据
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean listPage(PageParam pageParam,Map<String,Object> paramMap);

    SqlSessionTemplate getSessionTemplate();

    SqlSession getSqlSession();

}
