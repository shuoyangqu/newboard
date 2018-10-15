package com.roncoo.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 结算日汇总类型
 * @Date: Created in 下午 3:57 2018/10/13/013
 */
public enum SettDailyCollectTypeEnum {
    /**  **/

    ALL("存入/减少汇总"),
    TEMP("临时汇总"),
    LEAVE("遗留汇总");

    private String desc;

    private  SettDailyCollectTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SettDailyCollectTypeEnum getEnum(String enumName){
        SettDailyCollectTypeEnum resultEnum=null;
        SettDailyCollectTypeEnum[] enumAry=SettDailyCollectTypeEnum.values();
        for (int i=0;i<enumAry.length;i++){
            if (enumAry[i].name().equals(enumName)){
                resultEnum=enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String,Map<String,Object>> toMap(){
        SettDailyCollectTypeEnum[]ary=SettDailyCollectTypeEnum.values();
        Map<String,Map<String,Object>> enumMap=new HashMap<>();
        for (int num=0;num<ary.length;num++){
            Map<String,Object> map=new HashMap<>();
            String key=ary[num].name();
            map.put("desc",ary[num].getDesc());
            enumMap.put(key,map);
        }
        return enumMap;
    }

    public static List toList(){
        SettDailyCollectTypeEnum[] ary=SettDailyCollectTypeEnum.values();
        List list=new ArrayList();
        for (int i=0;i<ary.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",ary[i].getDesc());
            list.add(map);
        }
        return list;
    }





















}
