package com.roncoo.pay.common.core.utils;


import com.alibaba.druid.sql.dialect.oracle.ast.OracleDataTypeIntervalYear;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: qsy
 * @Description: 日期工具类
 * @Date: Created in 下午 5:44 2018/10/11/011
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
    public static final String TIME_WITH_MINUTE_PATTERN = "HH:mm";

    //一天的MilliSecond
    public static final long DAY_MILLI = 24 * 60 * 60 * 1000;

    public final static int LEFT_OPEN_RIGHT_OPEN = 1;
    public final static int LEFT_CLOSE_RIGHT_OPEN = 2;
    public final static int LEFT_OPEN_RIGHT_CLOSE = 3;
    public final static int LEFT_CLOSE_RIGHT_CLOSE = 4;

    /**
     * 比较日期的模式 --只比较日期，不比较时间
     */
    public final static int COMP_MODEL_DATE = 1;
    /**
     * 比较日期的模式 --只比较时间，不比较日期
     */
    public final static int COMP_MODEL_TIME = 2;
    /**
     * 比较日期的模式 --比较日期，也比较时间
     */
    public final static int COMP_MODEL_DATETIME = 3;

    private static Logger logger = Logger.getLogger(DateUtils.class);

    /**
     * 要用到的DATE Format的定义
     */
    public static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd";
    public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static SimpleDateFormat sdfDateTime = new SimpleDateFormat(DateUtils.DATE_FORMAT_DATETIME);

    public static SimpleDateFormat sdfDateOnly = new SimpleDateFormat(DateUtils.DATE_FORMAT_DATEONLY);
    public static final SimpleDateFormat SHORTDATEFORMAT = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat LONG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat HMS_FORMAT = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat formatTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 根据日期格式字符串解析日期字符串
     *
     * @param str           日期字符串
     * @param parsePatterns 日期格式字符串
     * @return 解析后日期
     */
    public static Date parseDate(String str, String parsePatterns) {
        try {
            return parseDate(str, new String[]{parsePatterns});
        } catch (ParseException e) {
            logger.error(e);
            return null;
        }
    }

    /**
     * 根据单位字段比较两个日期
     *
     * @param date      日期1
     * @param otherDate 日期2
     * @param withUnit  单位字段，从Calendar field取值
     * @return 等于返回0值，大于返回大于0的值 小于返回小于0的值
     */
    public static int compareDate(Date date, Date otherDate, int withUnit) {
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        Calendar otherDateCal = Calendar.getInstance();
        otherDateCal.setTime(otherDate);

        switch (withUnit) {
            case Calendar.YEAR:
                dateCal.clear(Calendar.MONTH);
                otherDateCal.clear(Calendar.MONTH);
                break;
            case Calendar.MONTH:
                dateCal.set(Calendar.DATE, 1);
                otherDateCal.set(Calendar.DATE, 1);
                break;
            case Calendar.DATE:
                dateCal.set(Calendar.HOUR_OF_DAY, 0);
                otherDateCal.set(Calendar.HOUR_OF_DAY, 0);
                break;
            case Calendar.HOUR:
                dateCal.clear(Calendar.MINUTE);
                otherDateCal.clear(Calendar.MINUTE);
                break;
            case Calendar.MINUTE:
                dateCal.clear(Calendar.SECOND);
                otherDateCal.clear(Calendar.SECOND);
                break;
            case Calendar.SECOND:
                dateCal.clear(Calendar.MILLISECOND);
                otherDateCal.clear(Calendar.MILLISECOND);
                break;
            case Calendar.MILLISECOND:
                break;

            default:
                throw new IllegalArgumentException("withUnit 单位字段 " + withUnit + " 不合法！");
        }
        return dateCal.compareTo(otherDateCal);
    }

    /**
     * 根据单位字段比较两个时间
     *
     * @param date      时间1
     * @param otherDate 时间2
     * @param withUnit  单位字段，从Calendar field取值
     * @return 等于返回0值，大于返回大于0的值，小于返回小于0的值
     */
    public static int compareTime(Date date, Date otherDate, int withUnit) {
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        Calendar otherDateCal = Calendar.getInstance();
        otherDateCal.setTime(otherDate);

        dateCal.clear(Calendar.YEAR);
        dateCal.clear(Calendar.MONTH);
        dateCal.set(Calendar.DATE, 1);
        otherDateCal.clear(Calendar.YEAR);
        otherDateCal.clear(Calendar.MONTH);
        otherDateCal.set(Calendar.DATE, 1);

        switch (withUnit) {
            case Calendar.HOUR:
                dateCal.clear(Calendar.MINUTE);
                otherDateCal.clear(Calendar.MINUTE);
                break;
            case Calendar.MINUTE:
                dateCal.clear(Calendar.SECOND);
                otherDateCal.clear(Calendar.SECOND);
                break;
            case Calendar.SECOND:
                dateCal.clear(Calendar.MILLISECOND);
                otherDateCal.clear(Calendar.MILLISECOND);
                break;
            case Calendar.MILLISECOND:
                break;
            default:
                throw new IllegalArgumentException("withUnit  单位字段 " + withUnit + "不合法！");
        }
        return dateCal.compareTo(otherDateCal);
    }

    /**
     * 获得当前的日期毫秒
     *
     * @return
     */
    public static long nowTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获得当前的时间戳
     *
     * @return
     */
    public static Timestamp nowTimeStamp() {
        return new Timestamp(nowTimeMillis());
    }

    /**
     * yyyy-MM-dd 当前日期
     *
     * @return
     */
    public static String getReqDate() {
        return SHORTDATEFORMAT.format(new Date());
    }

    /**
     * yyyy-MM-dd 传入日期
     *
     * @param date
     * @return
     */
    public static String getReqDate(Date date) {
        return SHORT_DATE_FORMAT.format(date);
    }

    /**
     * yyyy-MM-dd 传入的时间戳
     *
     * @param tmp
     * @return
     */
    public static String TimeStampToDateStr(Timestamp tmp) {
        return SHORT_DATE_FORMAT.format(tmp);
    }

    /**
     * HH:mm:ss当前时间
     *
     * @return
     */
    public static String getReqTime() {
        return HMS_FORMAT.format(new Date());
    }

    /**
     * 得到时间戳格式字符串
     *
     * @param date
     * @return
     */
    public static String getTimeStampStr(Date date) {
        return LONG_DATE_FORMAT.format(date);
    }

    /**
     * 得到长日期格式字符串
     *
     * @return
     */
    public static String getLongDateStr() {
        return LONG_DATE_FORMAT.format(new Date());
    }

    /**
     * 得到短日期格式字符串
     *
     * @param date
     * @return
     */
    public static String getShortDateStr(Date date) {
        return SHORT_DATE_FORMAT.format(date);
    }

    public static String getShortDateStr() {
        return SHORT_DATE_FORMAT.format(new Date());
    }

    /**
     * 计算second秒后的时间
     *
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 计算minute分钟后的时间
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 计算hour小时后的时间
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date addHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    /**
     * 得到day的起始时间点
     *
     * @param date
     * @return
     */
    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到day的终止时间点
     *
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 1);
        calendar.set(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 计算day天后的时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 得到month的终止时间点
     *
     * @param date
     * @return
     */
    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 365 * year);
        return calendar.getTime();
    }

    public static Timestamp strToTimeStamp(String dateStr) {
        return Timestamp.valueOf(dateStr);
    }

    public static Timestamp strToTimeStamp(Date date) {
        return Timestamp.valueOf(formatTimeStamp.format(date));
    }

    public static Timestamp getCurTimeStamp() {
        return Timestamp.valueOf(formatTimeStamp.format(new Date()));
    }

    /**
     * 取得两个日期之间的日数
     *
     * @param t1
     * @param t2
     * @return t1到t2间的日数，如果t2在t1之后，返回正数，否则返回负数
     */
    public static long daysBetween(Timestamp t1, Timestamp t2) {
        return (t2.getTime() - t1.getTime()) / DAY_MILLI;
    }

    /**
     * 返回Timestamp型的SYSDATE
     *
     * @return
     */
    public static Timestamp getSysDateTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 利用缺省的Date格式(YYYY/MM/DD)转换String到java.sql.Timestamp
     *
     * @param sDate
     * @return
     */
    public static Timestamp toSqlTimestamp(String sDate) {
        if (sDate == null) {
            return null;
        }
        if (sDate.length() != DateUtils.DATE_FORMAT_DATEONLY.length()
                && sDate.length() != DateUtils.DATE_FORMAT_DATETIME.length()) {
            return null;
        }
        return toSqlTimestamp(sDate,
                sDate.length() == DateUtils.DATE_FORMAT_DATEONLY.length() ?
                        DateUtils.DATE_FORMAT_DATEONLY : DateUtils.DATE_FORMAT_DATETIME);
    }

    /**
     * 利用缺省的Date格式(YYYY/MM/DD hh:mm:ss)转化String到Timestamp
     *
     * @param sDate
     * @param sFmt
     * @return
     */
    private static Timestamp toSqlTimestamp(String sDate, String sFmt) {
        String temp = null;
        if (sDate == null || sFmt == null) {
            return null;
        }
        if (sDate.length() != sFmt.length()) {
            return null;
        }
        if (sFmt.equals(DateUtils.DATE_FORMAT_DATETIME)) {
            temp = sDate.replace('/', '-');
            temp = temp + ".000000000";
        } else if (sFmt.equals(DateUtils.DATE_FORMAT_DATEONLY)) {
            temp = sDate.replace('/', '-');
            temp = temp + " 00:00:00.000000000";
        } else {
            return null;
        }
        return Timestamp.valueOf(temp);
    }

    /**
     * 以YYYY/MM/DD HH24:MI:SS格式返回系统日期时间
     *
     * @return
     */
    public static String getSysDateTimeString() {
        return toString(new Date(System.currentTimeMillis()), DateUtils.sdfDateTime);
    }

    /**
     * 根据指定的Format转化java.util.Date到String
     *
     * @param date
     * @param sFmt
     * @return
     */
    public static String toString(Date date, String sFmt) {
        if (date == null || sFmt == null || "".equals(sFmt)) {
            return "";
        }
        return toString(date, new SimpleDateFormat(sFmt));
    }

    /**
     * 利用指定SimpleDateFormat instance转换java.util.Date到String
     *
     * @param date
     * @param formatter
     * @return
     */
    private static String toString(Date date, SimpleDateFormat formatter) {
        String sRet = null;
        try {
            sRet = formatter.format(date).toString();
        } catch (Exception e) {
            logger.error(e);
            sRet = null;
        }
        return sRet;
    }

    /**
     * 转换java.sql.Timestamp到String，格式为YYYY/MM/DD HH24:MI
     *
     * @param dt
     * @return
     */
    public static String toSqlTimestampString2(Timestamp dt) {
        if (dt == null) {
            return null;
        }
        String temp = toSqlTimestampString(dt, DateUtils.DATE_FORMAT_DATETIME);
        return temp.substring(0, 16);
    }

    public static String toString(Timestamp dt) {
        return dt == null ? "" : toSqlTimestampString2(dt);
    }

    /**
     * 根据指定的格式转换java.sql.Timestamp到String
     *
     * @param dt
     * @param sFmt
     * @return
     */
    public static String toSqlTimestampString(Timestamp dt, String sFmt) {
        String temp = null;
        String out = null;
        if (dt == null || sFmt == null) {
            return null;
        }
        temp = dt.toString();
        if (sFmt.equals(DateUtils.DATE_FORMAT_DATETIME) || sFmt.equals(DateUtils.DATE_FORMAT_DATEONLY)) {
            temp = temp.substring(0, sFmt.length());
            out = temp.replace('/', '-');
        }
        return out;
    }

    /**
     * 得到当前日期的星期
     *
     * @return
     */
    public static int getWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK);
        return w;
    }

    /**
     * Timestamp格式转换成yyyy-MM-dd
     *
     * @param timestamp
     * @return
     */
    public static String timeStampToStringYMD(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_FORMAT_DATEONLY);
        String createTimeStr = sdf.format(timestamp);
        return createTimeStr;
    }

    /**
     * 判断一个时间是否在某个时间区间内
     *
     * @param now   目标时间
     * @param start 时间区间开始
     * @param end   时间区间结束
     * @param model 区间模式
     * @return 是否在区间内
     */
    public static boolean isBetween(Date now, Date start, Date end, int model) {
        return isBetween(now, start, end, model, LEFT_OPEN_RIGHT_OPEN);
    }

    /**
     * 判断时间是否在指定的时间段之内
     *
     * @param date       需要判断的时间
     * @param start      时间段的起始时间
     * @param end        时间段的截止时间
     * @param interModel 区间的模式
     * @param compModel  比较的模式
     *                   取值：
     *                   COMP_MODEL_DATE 只比较日期，不比较时间
     *                   COMP_MODEL_TIME 只比较时间，不比较日期
     *                   COMP_MODEL_DATE 比较日期，也比较时间
     * @return
     */
    public static boolean isBetween(Date date, Date start, Date end, int interModel, int compModel) {
        if (date == null || start == null || end == null) {
            throw new IllegalArgumentException("日期不能为空");
        }
        SimpleDateFormat format = null;
        switch (compModel) {
            case COMP_MODEL_DATE: {
                format = new SimpleDateFormat("yyyyMMdd");
                break;
            }
            case COMP_MODEL_TIME: {
                format = new SimpleDateFormat("HHmmss");
                break;
            }
            case COMP_MODEL_DATETIME: {
                format = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
            }
            default:
                throw new IllegalArgumentException(String.format("日期的比较模式[%d]有误", compModel));
        }
        long dateNumber = Long.parseLong(format.format(date));
        long startNumber = Long.parseLong(format.format(start));
        long endNumber = Long.parseLong(format.format(end));
        switch (interModel) {
            case LEFT_OPEN_RIGHT_OPEN: {
                if (dateNumber <= startNumber || dateNumber >= endNumber) {
                    return false;
                } else {
                    return true;
                }
            }
            case LEFT_OPEN_RIGHT_CLOSE: {
                if (dateNumber < startNumber || dateNumber >= endNumber) {
                    return false;
                } else {
                    return true;
                }
            }
            case LEFT_CLOSE_RIGHT_OPEN: {
                if (dateNumber <= startNumber || dateNumber > endNumber) {
                    return false;
                } else {
                    return true;
                }
            }
            case LEFT_CLOSE_RIGHT_CLOSE: {
                if (dateNumber < startNumber || dateNumber > endNumber) {
                    return false;
                } else {
                    return true;
                }
            }
            default:
                //使用指定的详细消息和原因构造一个新的异常。
                throw new IllegalArgumentException(String.format("日期的区间模式[%d]有误", interModel));
        }
    }

    /**
     * 得到当前周起始时间
     *
     * @param date
     * @return
     */
    public static Date getWeekStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(Calendar.WEEK_OF_YEAR);
        int firstDay = calendar.getFirstDayOfWeek();
        calendar.set(Calendar.DAY_OF_WEEK, firstDay);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到当前周截止时间
     *
     * @param date
     * @return
     */
    public static Date getWeekEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(Calendar.WEEK_OF_YEAR);
        int firstDay = calendar.getFirstDayOfWeek();
        calendar.set(Calendar.DAY_OF_WEEK, 8 - firstDay);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 取得月第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 取得月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 取得季度月
     *
     * @param date
     * @return
     */
    public static Date[] getSeasonDate(Date date) {
        Date[] season = new Date[3];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int nSeason = getSeason(date);
        //第一季度
        if (nSeason == 1) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            season[0] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
            season[1] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.MARCH);
            season[2] = calendar.getTime();
        } else if (nSeason == 2) {
            calendar.set(Calendar.MONTH, Calendar.APRIL);
            season[0] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.MAY);
            season[1] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.JUNE);
            season[2] = calendar.getTime();
        } else if (nSeason == 3) {
            calendar.set(Calendar.MONTH, Calendar.JULY);
            season[0] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.AUGUST);
            season[1] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
            season[2] = calendar.getTime();
        } else if (nSeason == 4) {
            calendar.set(Calendar.MONTH, Calendar.OCTOBER);
            season[0] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
            season[1] = calendar.getTime();
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            season[2] = calendar.getTime();
        }
        return season;
    }

    /**
     * 第一季度、第二季度、第三季度、第四季度
     *
     * @param date
     * @return
     */
    public static int getSeason(Date date) {
        int season = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;

            default:
                break;
        }
        return season;
    }

    /**
     * 判断开始时间和结束时间，是否超出了当前时间的一定的间隔数限制，时间单位默认为天数
     * 如：开始时间和结束时间，不能超出距离当前时间90天
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param interval  间隔数
     * @return
     */
    public static boolean isOverIntervalLimit(Date startDate, Date endDate, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, interval * (-1));
        Date curDate = getDayStart(calendar.getTime());
        if (getDayStart(startDate).compareTo(curDate) < 0 || getDayStart(endDate).compareTo(curDate) < 0) {
            return true;
        }
        return false;
    }

    /**
     * 传入时间字符串及时间格式，返回对应的Date对象
     *
     * @param src     时间字符串
     * @param pattern 时间格式
     * @return
     */
    public static Date getDateFromString(String src, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(src);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 取得通用日期时间格式字符串
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 获取当前时间格式串
     * @return
     */
    public static String today(){
        return formatDate(new Date(),"yyyy-MM-dd");
    }

    /**
     * 取得指定日期格式的字符串
     * @param date
     * @param format
     * @return
     */
    private static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat=new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 获取当前时间格式串
     * @return
     */
    public static String currentTime(){return formatDate(new Date(),"yyyyMMddHHmmssSSS");}

    public static Date getDateByStr(String dateStr){
        SimpleDateFormat formatter=null;
        if (dateStr==null){
            return null;
        }else if (dateStr.length()==10){
            formatter=new SimpleDateFormat("yyyy-MM-dd");
        }else if (dateStr.length()==16){
            formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }else if (dateStr.length()==19){
            formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }else if (dateStr.length()>19){
            dateStr=dateStr.substring(0,19);
            formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }else {
            return null;
        }

        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            logger.error(e);
            return null;
        }
    }

    /**
     * 根据传入的数字，输出相比现在days天的数据
     * @param days
     * @return
     */
    public static Date getDate(int days){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,days);
        return calendar.getTime();
    }

    /**
     * 日期最小时间
     * @param dt
     * @return
     */
    public static Date getMinTime(Date dt){
        Date dt1=null;
        dt1=DateUtils.getDateByStr(DateUtils.formatDate(dt,"yyyy-MM-dd"));
        return dt1;
    }

    public static Date dateFormat(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date value=new Date();
        try {
            value=sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean isSameDayWithToday(Date date){
        if (date==null){
            return false;
        }
        Calendar todayCal=Calendar.getInstance();
        Calendar dateCal=Calendar.getInstance();

        todayCal.setTime(new Date());
        dateCal.setTime(date);
        int subYear=todayCal.get(Calendar.YEAR)-dateCal.get(Calendar.YEAR);
        int subMonth=todayCal.get(Calendar.MONTH)-dateCal.get(Calendar.MONTH);
        int subDay=todayCal.get(Calendar.DAY_OF_MONTH)-dateCal.get(Calendar.DAY_OF_MONTH);
        if (subYear==0&&subMonth==0&&subDay==0){
            return true;
        }
        return false;
    }

















}
