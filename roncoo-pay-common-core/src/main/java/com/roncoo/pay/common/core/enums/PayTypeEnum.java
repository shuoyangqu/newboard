package com.roncoo.pay.common.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 支付类型枚举类
 * @Date: Created in 上午 10:23 2018/10/11/011
 */
public enum PayTypeEnum {
    /**扫码支付 */
    SCANPAY("WEIXIN","扫码支付"),
    /**H5支付*/
    H5PAY("WEIXIN","H5支付"),
    DIRECT_PAY("ALIPAY","即时到账"),
    MICRO_PAY("WEIXIN","刷卡支付"),
    WX_PROGRAM_PAY("WEIXIN","微信小程序"),
    F2F_PAY("ALIPAY","条码支付"),
    ALI_TEST("ALIPAY","支付宝测试");


    /**所属支付方式 */
    private  String way;
    /**描述 */
    private  String desc;

    /**构造方法*/
    private  PayTypeEnum(String way, String desc) {
        this.way=way;
        this.desc=desc;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String,Map<String,Object>> toMap(){
        PayTypeEnum[] ary=PayTypeEnum.values();
        Map<String,Map<String,Object>> enumMap=new HashMap<>();
        for (int num=0;num<ary.length;num++){
            Map<String,Object> map=new HashMap<>();
            String key=ary[num].name();
            map.put("desc",ary[num].getDesc());
            enumMap.put(key,map);
        }
        return enumMap;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public static List toList(){
        PayTypeEnum[] ary=PayTypeEnum.values();
        List list=new ArrayList();
        for (int i=0;i<ary.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",ary[i].getDesc());
            map.put("name",ary[i].name());
            list.add(map);
        }
        return list;
    }

    public static PayTypeEnum getEnum(String name){
        PayTypeEnum[] arry=PayTypeEnum.values();
        for (int i=0; i<arry.length;i++){
            if (arry[i].name().equalsIgnoreCase(name)){
                return arry[i];
            }
        }
        return null;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public static List getWayList(String way){
        PayTypeEnum[] arry=PayTypeEnum.values();
        List list=new ArrayList();
        for (int i=0;i<arry.length;i++){
            if (arry[i].way.equals(way)){
                Map<String,String> map=new HashMap<>();
                map.put("desc",arry[i].getDesc());
                map.put("name",arry[i].name());
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr(){
        PayTypeEnum[] enums=PayTypeEnum.values();
        StringBuffer jsonStr=new StringBuffer("[");
        for (PayTypeEnum senum:enums){
            if (!"[".equals(jsonStr.toString())){
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
