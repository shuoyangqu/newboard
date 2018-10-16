package com.roncoo.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易类型枚举类
 */
public enum TrxTypeEnum {

    ERRORHANKLE("差错处理"),
    REMIT("打款"),
    EXPENSE("消费");

    private String desc;

    private TrxTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        TrxTypeEnum[] ary = TrxTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<>();
            String key = ary[num].name();
            map.put("desc", ary[num].getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList(){
        TrxTypeEnum[] ary=TrxTypeEnum.values();
        List list=new ArrayList();
        for (int i=0;i<ary.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",ary[i].getDesc());
            list.add(map);
        }
        return list;
    }

    public static TrxTypeEnum getEnum(String name){
        TrxTypeEnum[] ary=TrxTypeEnum.values();
        for (int i=0;i<ary.length;i++){
            if (ary[i].name().equalsIgnoreCase(name)){
                return ary[i];
            }

        }
        return null;
    }
}
