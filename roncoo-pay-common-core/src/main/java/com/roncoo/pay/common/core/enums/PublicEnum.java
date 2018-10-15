package com.roncoo.pay.common.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 公共枚举，针对只有"是"，“否”两种状态
 * @Date: Created in 下午 2:00 2018/10/11/011
 */
public enum PublicEnum {
    /** */
    YES("是"),
    NO("否");

    private String desc;

    PublicEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String,Map<String,Object>> toMap(){
        PublicEnum[] arry=PublicEnum.values();
        Map<String,Map<String,Object>> enumMap=new HashMap<>();
        for (int num=0;num<arry.length;num++){
            Map<String,Object> map=new HashMap<>();
            String key=arry[num].name();
            map.put("desc",arry[num].getDesc());
            enumMap.put(key,map);
        }
        return enumMap;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public static List toList(){
        PublicEnum[] arry=PublicEnum.values();
        List list=new ArrayList();
        for (int i=0;i<arry.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",arry[i].getDesc());
            list.add(map);
        }
        return list;
    }

    public static PublicEnum  getEnum(String name){
        PublicEnum[] arry=PublicEnum.values();
        for (int i=0;i<arry.length;i++){
            if (arry[i].name().equalsIgnoreCase(name)){
                return arry[i];
            }
        }
        return null;
    }

    /**
     * 获取枚举json字符串
     * @return
     */
    public static String getJsonStr(){
        PublicEnum[] enums=PublicEnum.values();
        StringBuffer jsonStr=new StringBuffer("[");
        for (PublicEnum senum:enums){
            if (!"[".equals(jsonStr.toString())){
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }













}
