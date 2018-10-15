package com.roncoo.pay.common.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 安全等级枚举
 * @Date: Created in 下午 2:41 2018/10/11/011
 */
public enum SecurityRatingEnum {
    /** */
    MD5("MD5"),
    MDS_IP("MD5+IP白名单");

    private String desc;

    private  SecurityRatingEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SecurityRatingEnum getEnum(String enumName){
        SecurityRatingEnum resultEnum=null;
        SecurityRatingEnum[] enumArry=SecurityRatingEnum.values();
        for (int i=0;i<enumArry.length;i++){
            if (enumArry[i].name().equals(enumName)){
                resultEnum=enumArry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String,Map<String,Object>> toMap(){
        SecurityRatingEnum[] arry=SecurityRatingEnum.values();
        Map<String ,Map<String,Object>> enumMap=new HashMap<>();
        for (int num=0;num<arry.length;num++){
            Map<String,Object> map=new HashMap<>();
            String key=arry[num].name();
            map.put("desc",arry[num].getDesc());
            enumMap.put(key,map);
        }
        return enumMap;
    }

    public static List toList(){
        SecurityRatingEnum[] arry=SecurityRatingEnum.values();
        List list=new ArrayList();
        for (int i=0;i<arry.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("name",arry[i].name());
            map.put("desc",arry[i].getDesc());
            list.add(map);
        }
        return list;
    }

    public static String getJsonStr(){
        SecurityRatingEnum[] enums=SecurityRatingEnum.values();
        StringBuffer jsonStr=new StringBuffer("[");
        for (SecurityRatingEnum senum:enums){
            if (!"[".equals(jsonStr.toString())){
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

















}
