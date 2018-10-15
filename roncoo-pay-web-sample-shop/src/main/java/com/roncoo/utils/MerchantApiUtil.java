package com.roncoo.utils;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * @Author: qsy
 * @Description: 商户API工具类
 * @Date: Created in 下午 7:00 2018/10/10/010
 */
public class MerchantApiUtil {
    /**
     * 获取参数签名
     *
     * @param paramMap  签名参数
     * @param paySecret 签名秘钥
     * @return
     */
    public static String getSign(Map<String, Object> paramMap, String paySecret) {

        SortedMap<String, Object> smap = new TreeMap<>(paramMap);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Object> m : smap.entrySet()) {
            Object value = m.getValue();
            if (value != null && StringUtils.isNotBlank(String.valueOf(value))) {
                stringBuffer.append(m.getKey()).append("=").append(m.getValue()).append("&");
            }
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());

        String argPreSign = stringBuffer.append("&paySecret=").append(paySecret).toString();
        String signStr = MD5Util.encode(argPreSign).toUpperCase();
        return signStr;
    }

    /**
     * 建立请求，以表单HTML形式构造（默认）
     *
     * @param sparamMap     请求参数数组
     * @param strMethod     提交方式
     * @param strButtonName 确认按钮显示文字
     * @param actionUrl     提交表单HTML文本
     * @return
     */
    public static String buildRequest(Map<String, Object> sparamMap, String strMethod, String strButtonName, String actionUrl) {
        //待请求参数数组
        List<String> keys = new ArrayList<String>(sparamMap.keySet());
        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"rppaysubmit\" name=\"rppaysubmit\" action=\"" + actionUrl + "\" method=\"" + strMethod
                + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            Object object = sparamMap.get(name);
            String value = "";
            if (object != null) {
                value = (String) sparamMap.get(name);
            }

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['rppaysubmit'].submit();</script>");

        return sbHtml.toString();
    }
}
