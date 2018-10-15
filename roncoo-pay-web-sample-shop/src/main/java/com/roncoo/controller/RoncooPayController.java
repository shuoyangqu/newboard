package com.roncoo.controller;

import com.roncoo.utils.MerchantApiUtil;
import com.roncoo.utils.PayConfigUtil;
import jdk.internal.org.objectweb.asm.commons.Method;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 3:21 2018/10/10/010
 */
@Controller
@RequestMapping(value = "/roncooPay")
public class RoncooPayController extends BaseController {

    /**
     * 模拟商户F2F条码支付
     *
     * @param httpServletRequest
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/f2fPay")
    public String f2fPay(HttpServletRequest httpServletRequest, HttpServletResponse response, Model model) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        //订单金额，单位：元
        String orderPriceStr = getString_UrlDecode_UTF8("orderPrice");
        paramMap.put("orderPrice", orderPriceStr);

        //支付方式编码 支付宝：ALIPAY 微信：WEIXIN
        String payWayCode = getString_UrlDecode_UTF8("payWayCode");
        paramMap.put("payWayCode", payWayCode);

        //订单编号
        String orderNo = String.valueOf(System.currentTimeMillis());
        paramMap.put("orderNo", orderNo);

        //订单日期
        Date orderDate = new Date();
        //订单日期
        String orderDateStr = new SimpleDateFormat("yyyyMMdd").format(orderDate);
        paramMap.put("orderDate", orderDateStr);

        //订单时间
        Date orderTime = new Date();
        //订单时间
        String orderTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(orderTime);
        paramMap.put("orderTime", orderTimeStr);

        paramMap.put("payKey", PayConfigUtil.readConfig("payKey"));
        //商品名称
        String productName = getString_UrlDecode_UTF8("productName");
        paramMap.put("productName", productName);

        //商品名称
        String authCode = getString_UrlDecode_UTF8("authCode");
        paramMap.put("authCode", authCode);

        //下单Ip
        String orderIp = PayConfigUtil.readConfig("orderIp");
        paramMap.put("orderIp", orderIp);

        //支付备注
        String remark = getString_UrlDecode_UTF8("remark");
        paramMap.put("remark", remark);

        //扩展字段，选填，原值返回
        // 扩展字段1
        String field1 = "扩展字段1";
        paramMap.put("field1", field1);
        // 扩展字段2
        String field2 = "扩展字段2";
        paramMap.put("field2", field2);
        // 扩展字段3
        String field3 = "扩展字段3";
        paramMap.put("field3", field3);
        // 扩展字段4
        String field4 = "扩展字段4";
        paramMap.put("field4", field4);
        // 扩展字段5
        String field5 = "扩展字段5";
        paramMap.put("field5", field5);

        //签名及生成请求API的方法
        String sign = MerchantApiUtil.getSign(paramMap, PayConfigUtil.readConfig("paySecret"));
        paramMap.put("sign", sign);

        String buildRequest = MerchantApiUtil.buildRequest(paramMap, "get",
                "确定", PayConfigUtil.readConfig("f2fPayUrl"));
        model.addAttribute("payMessage", buildRequest);

        return "toPay";
    }
}
