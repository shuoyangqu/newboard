package com.roncoo.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qsy
 * @Description: 结算记录，状态
 * @Date: Created in 下午 4:18 2018/10/13/013
 */
public enum SettRecordStatusEnum {
/****/
    WAIT_CONFIRM("等待审核"),
    CONFIRMED("已审核"),
    CANCEL("审核不通过"),
    REMITTING("打款中"),
    REMIT_SUCCESS("打款成功"),
    REMIT_FAIL("打款失败");

    private String desc;

    private    SettRecordStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SettRecordStatusEnum getEnum(String enumName){
        SettRecordStatusEnum resultEnum=null;
        SettRecordStatusEnum[] enumAry=SettRecordStatusEnum.values();
        for (int i=0;i<enumAry.length;i++){
            if (enumAry[i].name().equals(enumName)){
                resultEnum=enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String,Map<String,Object>> toMap(){
        SettRecordStatusEnum[] ary=SettRecordStatusEnum.values();
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
        SettRecordStatusEnum[] ary=SettRecordStatusEnum.values();
        List list=new ArrayList();
        for (int i=0;i<ary.length;i++){
            Map<String,String> map=new HashMap<>();
            map.put("desc",ary[i].getDesc());
            list.add(map);
        }
        return list;
    }

    /**
     * 判断填入审核状态
     * @param enumName
     * @return
     */
    public static boolean checkConfirm(String enumName){
        SettRecordStatusEnum[] enumAry={SettRecordStatusEnum.CANCEL,SettRecordStatusEnum.CONFIRMED};

        for (int i=0;i<enumAry.length;i++){
            if (enumAry[i].name().equals(enumName)){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断填入打款状态
     * @param enumName
     * @return
     */
    public static boolean checkRemit(String enumName){
        SettRecordStatusEnum[] enumAry={SettRecordStatusEnum.REMIT_FAIL,SettRecordStatusEnum.REMIT_SUCCESS};
        for (int i=0;i<enumAry.length;i++){
            if (enumAry[i].name().equals(enumName)){
                return true;
            }
        }
        return false;
    }










}
