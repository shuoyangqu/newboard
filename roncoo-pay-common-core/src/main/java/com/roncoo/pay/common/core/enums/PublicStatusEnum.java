package com.roncoo.pay.common.core.enums;

import sun.awt.image.OffScreenImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 公共状态枚举，只有（冻结）于（激活）两种状态
 * @Date: Created in 下午 2:13 2018/10/11/011
 */
public enum PublicStatusEnum {
    /** */
    ACTIVE("激活"),
    UNACTIVE("冻结");

    private String desc;

    private PublicStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String,Map<String,Object>> toMap(){
        PublicStatusEnum[] arry=PublicStatusEnum.values();
        Map<String,Map<String,Object>> enumMap=new HashMap<>();
        for (int num=0;num<arry.length;num++){
            Map<String,Object> map=new HashMap<>();
            String key=arry[num].name();
            map.put("value",arry[num].name());
            map.put("desc",arry[num].getDesc());
        }
        return enumMap;
    }

    public static List toList(){
        PublicStatusEnum[] arry=PublicStatusEnum.values();
        List list=new ArrayList();
        for (int i=0;i<arry.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",arry[i].getDesc());
            map.put("name",arry[i].name());
            list.add(map);
        }
        return list;
    }

    public static PublicStatusEnum getEnum(String name){
        PublicStatusEnum[] arry=PublicStatusEnum.values();
        for (int i=0;i<arry.length;i++){
            if (arry[i].name().equalsIgnoreCase(name)){
                return arry[i];
            }
        }
        return null;
    }

    public static String getJsonStr(){
        PublicStatusEnum[] enums=PublicStatusEnum.values();
        StringBuffer jsonStr=new StringBuffer("[");
        for (PublicStatusEnum senum:enums){
            if (!"[".equals(jsonStr.toString())){
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }









}
