package com.roncoo.pay.common.core.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: qsy
 * @Description: 加密工具类
 * @Date: Created in 上午 10:22 2018/10/12/012
 */
public class EncryptUtil {
    private static final Log LOG = LogFactory.getLog(EncryptUtil.class);

    //密码盐
    public static final String PWDSALT = "PAY";

    /**
     * 私有构造方法，将加密工具类设为单例模式
     */
    private EncryptUtil() {
    }

    /**
     * 用MD5算法进行加密
     * @param str 需要加密的字符串
     * @return MD5加密后的结果
     */
    public static String encodeMD5String(String str) {
        return encode(str, "MD5");
    }

    /**
     * 用SHA算法进行加密
     * @param str 需要加密的字符串
     * @return SHA加密后的结果
     */
    public static String encodeSHAString(String str){
        return encode(str,"SHA");
    }

    /**
     * 用base64算法进行加密
     * @param str 需要加密的字符串
     * @return base64加密后的结果
     */
    public static String encodeBase64String(String str){
        BASE64Encoder encoder=new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    private static String encode(String str, String method) {

        MessageDigest mdInst=null;
        //把密文转换成十六进制的字符串形式
        //单线程用StringBuilder，速度快，多线程用StringBuffer，安全
        StringBuilder dstr=new StringBuilder();
        try {
            //获得MD5摘要算法的MessageDigest对象
            mdInst=MessageDigest.getInstance(method);
            //使用指定的字节更新摘要
            mdInst.update(str.getBytes());
            //获得密文
            byte[] md=mdInst.digest();
            for (int i=0;i<md.length;i++){
                int tmp=md[i];
                if (tmp<0){
                    tmp+=256;
                }
                if (tmp<16){
                    dstr.append("0");
                }
                dstr.append(Integer.toHexString(tmp));
            }
        } catch (NoSuchAlgorithmException e) {
            LOG.error(e);
        }
        return dstr.toString();
    }



}
