package com.roncoo.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 结算发起方式
 * @Date: Created in 下午 4:07 2018/10/13/013
 */
public enum SettModeTypeEnum {
    /**
     * 手工结算
     **/
    SELFHELP_SETTLE("手工结算"),
    REGULAR_SETTLE("自动结算");
    private String desc;

    private SettModeTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SettModeTypeEnum getEnum(String enumName){
        SettModeTypeEnum resultEnum=null;
        SettModeTypeEnum[] enumAry=SettModeTypeEnum.values();
        for (int i=0;i<enumAry.length;i++){
            if (enumAry[i].name().equals(enumName)){
                resultEnum=enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String,Map<String,Object>> toMap(){
        SettModeTypeEnum[] ary=SettModeTypeEnum.values();
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
        SettModeTypeEnum[] ary=SettModeTypeEnum.values();
        List list=new ArrayList();
        for (int i=0;i<ary.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",ary[i].getDesc());
            list.add(map);
        }
        return list;
    }




}
