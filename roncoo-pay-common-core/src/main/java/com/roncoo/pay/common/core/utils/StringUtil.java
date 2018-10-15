package com.roncoo.pay.common.core.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.channels.Pipe;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: qsy
 * @Description: String字符串工具类
 * @Date: Created in 上午 10:12 2018/10/11/011
 */
public class StringUtil {

    private static final Log LOG= LogFactory.getLog(StringUtil.class);

    /**
     * 私有构造方法，将该工具类设为单例模式
     */
    private StringUtil() {
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return null==str||"".equals(str);
    }

    /**
     * 判断对象数组是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object[] obj){
        return null==obj||obj.length==0;
    }

    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if (null==obj){
            return true;
        }
        if (obj instanceof String){
            return ((String) obj).trim().isEmpty();
        }
        return !(obj instanceof Number)?false:true;
    }

    /**
     * 判断集合是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(List<?> obj){
        return null==obj||obj.isEmpty();
    }

    /**
     * 判断map集合是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Map<?,?> obj){
        return null==obj||obj.isEmpty();
    }


    /**
     * 获取去掉横线的长度为32的UUID串
     * @return
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 验证一个字符串是否完全由纯数字组成的字符串，当字符串为空时也返回false
     * @param str 要判断的字符串
     * @return
     */
    public static boolean isNumeric(String str){
        if (StringUtils.isBlank(str)){
            return false;
        }else {
            return str.matches("\\d*");
        }
    }




















}
