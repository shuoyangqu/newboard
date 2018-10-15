package com.roncoo.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.KeyGenerator;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: qsy
 * @Description: 龙果支付属性配置工具类
 * @Date: Created in 下午 6:47 2018/10/10/010
 */
public class PayConfigUtil {

    private static final Log LOG = LogFactory.getLog(PayConfigUtil.class);

    /**
     * 通过静态代码块读取上传文件的验证格式配置文件，静态代码块只执行一次（单例）
     */
    private static Properties properties = new Properties();

    private PayConfigUtil() {
    }

    //通过类装载器装载进来
    static {
        try {
            //从类路径下读取属性文件
            properties.load(PayConfigUtil.class.getClassLoader().getResourceAsStream("pay_config.properties"));
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    /**
     * 函数功能说明：读取配置项
     *
     * @param key
     * @return
     */
    public static String readConfig(String key) {
        return (String) properties.get(key);
    }
}
