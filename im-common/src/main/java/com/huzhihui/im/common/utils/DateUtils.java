/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.im.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 * @author huzhi
 * @version $ v 0.1 2021/3/22 19:54 huzhi Exp $$
 */
public class DateUtils{

    public static final String DATE_FORMAT_YM = "yyyy-MM";

    public static final String DATE_FORMAT_YM_SLASH = "yyyy/MM";

    public static final String DATE_FORMAT_YM_SORT = "yyyyMM";

    public static final String DATE = "yyyy-MM-dd";

    public static final String DATE_FORMAT_Y = "yyyy";

    public static final String DATE_FORMAT_M = "MM";

    public static final String DATE_WITH_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_WITH_TIME_NO_SECOND = "yyyy-MM-dd HH:mm";

    public static final String DATE_WITH_TIME_NO_MINUTE = "yyyy-MM-dd HH";

    public static final String DATE_WITH_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_WITH_TIME_SLASH_NO_SECOND = "MM/dd HH:mm";

    public static final String DATE_NOSPLIT = "yyyyMMdd";

    public static final String DATE_WITH_TIME_NOSPLIT = "yyyyMMddHHmmss";

    public static final String DATE_MONTH_DAY = "M月d日";

    public static final String HOUR_MINUTE = "HH:mm";

    public static final String DATE_WITH_TIME_NO_SECOND_CN = "yyyy年MM月dd日 HH:mm";

    public static final String DATE_WITH_TIME_NO_TIME_CN = "yyyy年MM月dd日";

    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";

    public static final String DATE_WITH_TIME_MONTH_NO_SECOND = "MM-dd HH:mm";

    public static final String MONTH = "yyyy-M";

    public static String currentMonth() {
        return DateToStr(new Date(), DateUtils.DATE_FORMAT_YM_SORT);
    }

    public static String DateToM(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(MONTH);
        return sdf.format(d);
    }

    public static String DateToHHmm(Date d) {
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(HOUR_MINUTE);
        return sdf.format(d);
    }

    public static Date HHmmToDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(HOUR_MINUTE);
        return sdf.parse(d);
    }

    public static String DateToShortStr(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_MONTH_DAY);
        return sdf.format(d);
    }

    public static String DateToStr(Date d) {
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        return sdf.format(d);
    }

    public static String DateToStr(Date d, String patten) {
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        return sdf.format(d);
    }


    public static Date strToDateFormat(String Date, String format) throws ParseException {
        if (StringUtils.isBlank(Date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(Date);
    }

    public static Date strToDay(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        return sdf.parse(d);
    }

    public static Date strToDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        return sdf.parse(d);
    }

    public static Date strToYearMonthDate(String d) {
        try {
            if (StringUtils.isBlank(d)) {
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(DATE);
            return sdf.parse(d);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date strToDate(String d, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(d);
    }

    public static String DateToStr_NoSeconds(Date d) {
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_SECOND);
        return sdf.format(d);
    }

    public static String DateToStr_MonthNoSeconds(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_MONTH_NO_SECOND);
        return sdf.format(d);
    }

    public static Date strToDate_MonthNoSeconds(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_MONTH_NO_SECOND);
        try {
            return sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String DateToStr_NoMinute(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_MINUTE);
        return sdf.format(d);
    }

    public static Date strToDate_NoMinute(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_MINUTE);
        try {
            return sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String DateToStr_NoSecondSlash(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_SLASH);
        return sdf.format(d);
    }

    public static Date strToDateSlash(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_SLASH);
        return sdf.parse(d);
    }

    public static String dateSlashNoSecond(Date d) {
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_SLASH_NO_SECOND);
        return sdf.format(d);
    }

    public static String DateToStr_NoSeconds_CN(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_SECOND_CN);
        return sdf.format(d);
    }

    public static String DateToStr_NoTime_CN(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_TIME_CN);
        return sdf.format(d);
    }

    public static Date strToDate_NoTime_CN(String d) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_TIME_CN);
            return sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date strToDate_NoSeconds(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME_NO_SECOND);
        try {
            return sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String noSplitDateToDate(String d) throws ParseException {
        SimpleDateFormat sdf_no = new SimpleDateFormat(DATE_NOSPLIT);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        Date date = sdf_no.parse(d);
        return sdf.format(date);
    }

    public static String dateToNoSplitDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        SimpleDateFormat sdf_no = new SimpleDateFormat(DATE_NOSPLIT);
        Date date = sdf.parse(d);
        return sdf_no.format(date);
    }

    public static String noSplitDateToStr(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_NOSPLIT);
        return sdf.format(d);
    }

    public static Date strToNosplitDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_NOSPLIT);
        return sdf.parse(d);
    }

    public static String getDayFromDate(Date d) {
        if (d == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        return sdf.format(d);
    }

    public static String getYearFromDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_Y);
        return sdf.format(d);
    }

    public static String DateToStrNoTime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        return sdf.format(d);

    }

    public static String DateToStrHour(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(HOUR_MINUTE_SECOND);
        return sdf.format(d);
    }

    public static Date StrHourToDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(HOUR_MINUTE_SECOND);
        return sdf.parse(d);
    }

    public static String getWeekBeginDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(d);

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String imptimeBegin = sdf.format(cal.getTime());

        return imptimeBegin;
    }

    public static String getWeekEndDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(d);

        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天

        cal.add(Calendar.DATE, 8 - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

        String imptimeBegin = sdf.format(cal.getTime());

        return imptimeBegin;
    }

    public static String getMonthBeginDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE); // 设置时间格式

        Calendar cal = Calendar.getInstance();

        cal.setTime(d);

        int day = cal.get(Calendar.DAY_OF_MONTH);

        cal.add(Calendar.DATE, -day + 1);

        String imptimeBegin = sdf.format(cal.getTime());

        return imptimeBegin;
    }


    /**
     * 返回当前时间和参数时间相差的天-时-分
     * 区别(不满一分钟 会被舍弃, 如相差59秒 则为0分钟, 相差1分50秒 为1分钟)
     *
     * @param d
     * @return
     */
    public static String differTime(Date d) {
        long differMills = Math.abs(System.currentTimeMillis() - d.getTime());
        long oneDayTime = 24 * 3600 * 1000;
        long oneHourTime = 3600 * 1000;
        long oneMinuteTime = 60 * 1000;
        StringBuffer sb = new StringBuffer();

        long dayNum = differMills / oneDayTime;
        if (dayNum > 0) {
            sb.append(dayNum + "天 ");
        }
        differMills = differMills % oneDayTime;
        long hourNum = differMills / oneHourTime;
        if (hourNum > 0 || dayNum > 0) {
            sb.append(hourNum + "小时 ");
        }
        differMills = differMills % oneHourTime;
        long minuteNum = differMills / oneMinuteTime;
        if (minuteNum > 0 || dayNum > 0 || hourNum > 0) {
            sb.append(minuteNum + "分钟");
        }
        return sb.toString();
    }

    /**
     * 返回当前时间和参数时间相差的天-时-分 (向上取整)
     * 区别(不满一分钟 向上取整, 如相差59秒 则为1分钟, 相差1分50秒 为2分钟,相差59分x秒, 进位)
     *
     * @param d
     * @return
     */
    public static String differTimeCeil(Date d) {
        long differMills = Math.abs(System.currentTimeMillis() - d.getTime());
        long oneDayTime = 24 * 3600 * 1000;
        long oneHourTime = 3600 * 1000;
        long oneMinuteTime = 60 * 1000;
        long dayNum = differMills / oneDayTime;
        differMills = differMills % oneDayTime;
        long hourNum = differMills / oneHourTime;
        differMills = differMills % oneHourTime;
        long minuteNum = (long) Math.ceil(differMills / (double) oneMinuteTime);
        if (minuteNum == 60) {
            minuteNum = 0;
            hourNum++;
            if (hourNum == 24) {
                hourNum = 0;
                dayNum++;
            }
        }

        StringBuffer sb = new StringBuffer();
        if (dayNum > 0) {
            sb.append(dayNum + "天 ");
        }
        if (hourNum > 0 || dayNum > 0) {
            sb.append(hourNum + "小时 ");
        }
        if (minuteNum > 0 || dayNum > 0 || hourNum > 0) {
            sb.append(minuteNum + "分钟");
        }
        return sb.toString();
    }

    public static String differDateTime(Date start,Date end) {
        long differMills = Math.abs(end.getTime() - start.getTime());
        long oneDayTime = 24 * 3600 * 1000;
        long oneHourTime = 3600 * 1000;
        long oneMinuteTime = 60 * 1000;
        StringBuffer sb = new StringBuffer();

        long dayNum = differMills / oneDayTime;
        if (dayNum > 0) {
            sb.append(dayNum + "天 ");
        }
        differMills = differMills % oneDayTime;
        long hourNum = differMills / oneHourTime;
        if (hourNum > 0 || dayNum > 0) {
            sb.append(hourNum + "小时 ");
        }
        differMills = differMills % oneHourTime;
        long minuteNum = differMills / oneMinuteTime;
        if (minuteNum > 0 || dayNum > 0 || hourNum > 0) {
            sb.append(minuteNum + "分钟");
        }
        return sb.toString();
    }

    /**
     * 返回当前时间和参数时间相差的天数
     *
     * @param date
     * @return
     */
    public static long differDays(Date date) {
        long oneDayTime = 24 * 3600 * 1000;
        long differMills = Math.abs(System.currentTimeMillis() - date.getTime());
        return differMills / oneDayTime;
    }

    /**
     * 返回当前时间和参数时间相差的天数(不取绝对值)
     *
     * @param date
     * @return
     */
    public static long differDaysWithoutAbs(Date date) {
        long oneDayTime = 24 * 3600 * 1000;
        long differMills = System.currentTimeMillis() - date.getTime();
        return differMills / oneDayTime;
    }

    /**
     * 返回两个时间参数相差的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long differDays(Date startDate, Date endDate) {
        long oneDayTime = 24 * 3600 * 1000;
        long differMills = Math.abs(endDate.getTime() - startDate.getTime());
        return differMills / oneDayTime;
    }

    /**
     * 返回当前时间和参数时间相差的分钟数
     *
     * @param date
     * @return
     */
    public static long differMins(Date date) {
        long differMills = Math.abs(date.getTime() - System.currentTimeMillis());
        long oneMinuteTime = 60 * 1000;
        return differMills / oneMinuteTime;
    }

    /**
     * 当前时间到明天零点相差的秒数
     *
     * @return
     * @throws Exception
     */
    public static long differSeconds() throws Exception {
        Calendar myDate = Calendar.getInstance();
        myDate.add(Calendar.DAY_OF_MONTH, 1);
        Date date = myDate.getTime();

        long differMills = Math.abs(strToDate(new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date)).getTime() - System.currentTimeMillis());
        long oneMinuteTime = 1000;
        return differMills / oneMinuteTime;
    }

    /**
     * 传入的时间与加上days后日期相差的秒数
     *
     * @param currentTime
     * @param days
     * @return
     * @throws Exception
     */
    public static long differDistanceSeconds(Date currentTime, int days) throws Exception {
        Calendar myDate = Calendar.getInstance();
        myDate.setTime(currentTime);
        myDate.add(Calendar.DAY_OF_MONTH, days);
        Date date = myDate.getTime();

        long differMills = Math.abs(strToDate(new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date)).getTime() - System.currentTimeMillis());
        long oneMinuteTime = 1000;
        return differMills / oneMinuteTime;
    }

    /**
     * 返回当前时间和参数时间相差的小时数
     *
     * @param date
     * @return
     */
    public static long differHours(Date date) {
        long oneDayTime = 24 * 3600 * 1000;
        long oneHourTime = 3600 * 1000;
        long differMills = Math.abs(System.currentTimeMillis() - date.getTime());
        differMills = differMills % oneDayTime;
        return differMills / oneHourTime;
    }

    /**
     * 获取当前日期是星期几
     */
    public static int getWeekOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        // 一周第一天是否为星期天
        boolean isFirstSunday = (cal.getFirstDayOfWeek() == Calendar.SUNDAY);
        // 获取周几
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        // 若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        return weekDay;
    }

    /**
     * 获取当前日期小时
     */
    public static int getHourOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        // 获取小时
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前日期分
     *
     * @param dt
     * @return
     */
    public static int getMinuteOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        // 获取分
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * 获取所在周星期几的具体日期
     */
    public static String convertWeekByDate(Date time, int weekNum) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        // String imptimeBegin = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, weekNum);
        String imptimeEnd = sdf.format(cal.getTime());
        // System.out.println("所在周星期几的日期：" + imptimeEnd);
        return imptimeEnd;

    }

    /**
     * 日期增加天数
     *
     * @param date 日期
     * @param days 增加天数
     * @return
     */
    public static Date addDays(Date date, int days) {
        /*
         * Calendar calendar = Calendar.getInstance();
         * calendar.add(Calendar.DAY_OF_YEAR, days); Date now =
         * calendar.getTime(); return now;
         */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days);
        return calendar.getTime();

    }

    /**
     * 日期减少天数
     *
     * @param date 日期
     * @param days 减少天数
     * @return
     */
    public static Date subDays(Date date, int days) {
        /*
         * Calendar calendar = Calendar.getInstance();
         * calendar.add(Calendar.DAY_OF_YEAR, days); Date now =
         * calendar.getTime(); return now;
         */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - days);
        return calendar.getTime();

    }

    /**
     * 日期增加月数
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMonths(final Date date, final int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 日期增加秒数
     *
     * @param date   日期
     * @param amount 秒数
     * @return
     */
    public static Date addSecond(final Date date, final int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * 日期增加分钟
     *
     * @param date   日期
     * @param amount 分钟
     * @return
     */
    public static Date addMinute(final Date date, final int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * 增加日期属性值
     *
     * @param date
     * @param calendarField
     * @param amount
     * @return
     */
    public static Date add(final Date date, final int calendarField,
                           final int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        Date now = new Date();
        return now;
    }

    public static Date strToDateWithRule(String date, String rule) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(rule);
        return sdf.parse(date);
    }


    /**
     * 某个月天数
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 今天是当前月的第几天当前年的第几天
     *
     * @return
     */
    public static Map<String, Integer> getDaysOfYearAndMonth() {
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);

        int y = ca.get(Calendar.DAY_OF_YEAR);
        int m = ca.get(Calendar.DAY_OF_MONTH);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("month", m);
        map.put("year", y);

        return map;
    }

    /**
     * 返回开始时间到结束时间中间的每个小时 [08,09,10]
     *
     * @param start 2017-07-11 08
     * @param end   2017-07-11 10
     * @param list  结果集
     * @return
     * @throws Exception
     */
    public static List<String> getBetweenTime(String start, String end, List<String> list) throws Exception {
        if (start.equals(end)) return list;

        SimpleDateFormat df = new SimpleDateFormat(DATE_WITH_TIME_NO_MINUTE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(start));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
        String nextTime = df.format(calendar.getTime());

        list.add(nextTime);
        if (nextTime.equals(end))
            return list;
        else
            return getBetweenTime(nextTime, end, list);
    }

    public static String getOneHoursAgoTime(String date) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat(DATE_WITH_TIME_NO_MINUTE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        return df.format(calendar.getTime());
    }

    public static Date getMinuteAgoTime(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - amount);
        return calendar.getTime();
    }

    public static String getDayAgoTime(Date date, int amount) {
        SimpleDateFormat df = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - amount);
        return df.format(calendar.getTime());
    }

    public static Date getDayAgoTimeDate(Date date, int amount) {
        SimpleDateFormat df = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - amount);
        return calendar.getTime();
    }

    public static String getDayAddTime(Date date, int amount) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_WITH_TIME_NO_SECOND);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + amount);
        return df.format(calendar.getTime());
    }

    public static String getDayAddTimeToHHmm(String date, int amount) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(HOUR_MINUTE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strToDate(date, HOUR_MINUTE));
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + amount);
        return df.format(calendar.getTime());
    }

    /**
     * 获取当前日期的月份
     *
     * @param date
     * @return
     */
    public static String getMonthFromDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YM);
        return sdf.format(date);
    }

    public static Date getMonthFromString(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YM);
        return sdf.parse(date);
    }

    /**
     * 获取固定间隔时刻集合
     *
     * @param start    开始时间
     * @param end      结束时间
     * @param interval 时间间隔(单位：分钟)
     * @return
     */
    public static List<String> getIntervalTimeList(String start, String end, int interval) throws ParseException {
        Date startDate = HHmmToDate(start);
        Date endDate = HHmmToDate(end);
        List<String> list = new ArrayList<>();
        while (startDate.getTime() <= endDate.getTime()) {
            list.add(DateToHHmm(startDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE, interval);
            if (calendar.getTime().getTime() > endDate.getTime()) {
                if (!startDate.equals(endDate)) {
                    list.add(DateToHHmm(endDate));
                }
                startDate = calendar.getTime();
            } else {
                startDate = calendar.getTime();
            }
        }

        return list;
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        if (nowTime == null || beginTime == null || endTime == null) return false;
        return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime();
    }

    /**
     * 日期冲突
     *
     * @param intervalStart 区间开始时间
     * @param intervalEnd   区间结束时间
     * @param start
     * @param end
     * @return true冲突
     */
    public static boolean dateConflict(Date intervalStart, Date intervalEnd, Date start, Date end) {
        if (intervalStart == null || intervalEnd == null || start == null || end == null) return false;
        return end.getTime() >= intervalStart.getTime() && start.getTime() <= intervalEnd.getTime();
    }


    /**
     * 判断两个时间段是否有交集
     *
     * @param leftStartDate
     * @param leftEndDate
     * @param rightStartDate
     * @param rightEndDate
     * @return
     */
    public static boolean isOverlap(Date leftStartDate, Date leftEndDate, Date rightStartDate, Date rightEndDate) {
        return
                ((leftStartDate.getTime() >= rightStartDate.getTime())
                        && leftStartDate.getTime() < rightEndDate.getTime())
                        ||
                        ((leftStartDate.getTime() > rightStartDate.getTime())
                                && leftStartDate.getTime() <= rightEndDate.getTime())
                        ||
                        ((rightStartDate.getTime() >= leftStartDate.getTime())
                                && rightStartDate.getTime() < leftEndDate.getTime())
                        ||
                        ((rightStartDate.getTime() > leftStartDate.getTime())
                                && rightStartDate.getTime() <= leftEndDate.getTime());

    }

    /**
     * 传入的时间与当前时间间隔几分钟
     *
     * @param startTime
     * @return
     * @throws ParseException
     */
    public static long apartMin(Date startTime) throws ParseException {
        long between = (new Date().getTime() - startTime.getTime()) / 1000;
        long min = between / 60;

        return min;
    }

    /**
     * 过去一年
     *
     * @param startTime
     * @return
     * @throws ParseException
     */
    public static String getPreYearTime(String startTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(startTime));
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        return year;
    }

    /**
     * 过去一月
     *
     * @param startTime
     * @return
     * @throws ParseException
     */
    public static String getPreMonthTime(String startTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(startTime));
        c.add(Calendar.MONTH, -1);
        Date y = c.getTime();
        String month = format.format(y);
        return month;
    }

    public static long getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        return day;
    }

    /**
     * 获得该月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 获得该月最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 获得该月最后一天
     *
     * @return
     */
    public static Date getLastDayOfMonth(Date now) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            //获取某月最大天数
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            //设置日历中月份的最大天数
            cal.set(Calendar.DAY_OF_MONTH, lastDay);
            //格式化日期
            SimpleDateFormat sdf = new SimpleDateFormat(DATE);
            String lastDayOfMonth = sdf.format(cal.getTime());
            return strToDay(lastDayOfMonth);
        } catch (Exception ex) {
            throw new RuntimeException("获得该月最后一天报错");
        }
    }


    /**
     * 获得该年最后一天
     *
     * @param year
     * @return
     */
    public static String getLastDayOfYear(int year) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, 11);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        String lastDayOfYear = sdf.format(cal.getTime());
        return lastDayOfYear;
    }


    /**
     * 获得上个月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getBeforeFirstMonthDate(int year, int month) {
        SimpleDateFormat format = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        //设置年份
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(calendar.getTime());
    }

    /**
     * 获得上个月最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getBeforeEndMonthDate(int year, int month) {
        SimpleDateFormat format = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        //设置年份
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 2);
        //获取某月最大天数
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return format.format(calendar.getTime());
    }

    /**
     * 获得上个月同一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getBeforeFirstMonthSameDate(int year, int month, int day) {
        SimpleDateFormat format = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        //设置年份
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 2);
        //获取某月最大天数
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (lastDay < day) {
            day = lastDay;
        }

        calendar.set(Calendar.DAY_OF_MONTH, day);
        return format.format(calendar.getTime());
    }

    /**
     * 获得去年同一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getBeforeYearSameDate(int year, int month, int day) {
        SimpleDateFormat format = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        //设置年份
        calendar.set(Calendar.YEAR, year - 1);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return format.format(calendar.getTime());
    }

    /**
     * 获得去年同一个月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getBeforeYearMonthFirstDate(int year, int month) {
        SimpleDateFormat format = new SimpleDateFormat(DATE);
        Calendar calendar = Calendar.getInstance();
        //设置年份
        calendar.set(Calendar.YEAR, year - 1);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(calendar.getTime());
    }

    /**
     * 获得一天中的某个时间
     *
     * @param time
     * @return
     */
    public static long getTimeOfDay(int time) {
        Calendar cal = Calendar.getInstance();
        // 每天定点执行
        cal.set(Calendar.HOUR_OF_DAY, time);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime().getTime();
    }

    /**
     * 获取时间段内的每一天 左闭右开
     *
     * @param startTime 2018-09-10
     * @param endTime   2018-09-11
     * @return
     */
    public static List<String> getBetweenDates(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        try {
            Date start = DateUtils.strToDate(startTime, DATE);
            Date end = DateUtils.strToDate(endTime, DATE);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            tempStart.add(Calendar.DAY_OF_YEAR, 1);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            result.add(DateUtils.getDayFromDate(start));
            while (tempStart.before(tempEnd)) {
                result.add(DateUtils.getDayFromDate(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 获取 指定日期后 指定毫秒后的 Date
     *
     * @param date
     * @param millSecond
     * @return
     */
    public static Date getDateAddMillSecond(Date date, int millSecond) {
        Calendar cal = Calendar.getInstance();
        if (null != date) {// 没有 就取当前时间
            cal.setTime(date);
        }
        cal.add(Calendar.MILLISECOND, millSecond);
        return cal.getTime();
    }

    /**
     * 日期相减(返回秒值)
     *
     * @param date  Date
     * @param date1 Date
     * @return int
     * @author
     */
    public static Long diffDateTime(Date date, Date date1) {
        return (getMillis(date) - getMillis(date1)) / 1000;
    }

    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }


    /**
     * mongo 日期查询isodate
     *
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(String dateStr) {
        try {
            //T代表后面跟着时间，Z代表UTC统一时间
            Date date = strToDate(dateStr);
            SimpleDateFormat format =
                    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            String isoDate = format.format(date);
            try {
                return format.parse(isoDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean dateEqualsToday(Date date) {
        String dateStr = DateToStrNoTime(date);
        String today = DateToStrNoTime(new Date());

        return dateStr.equals(today);
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(long time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(sdf.parse(time).getTime());
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        } else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = String.valueOf(current_time);
        }
        return stamp;
    }


    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(Date time) {
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(time.getTime());
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        } else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = String.valueOf(current_time);
        }
        return stamp;
    }

    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return yesterday;
    }

    public static void testIterator() {
        Calendar c = Calendar.getInstance();
        int year = 2020;
        for (int i = 0; i < 12; i++) {
            c.set(year, i, 1);
            int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int x = 1; x <= lastDay; x++) {
                for (int y = 0; y < 24; y++) {
                    String startTime = year + "-" + (i + 1) + "-" + x + " " + y + ":00" + ":00";
                    String endTime = year + "-" + (i + 1) + "-" + x + " " + y + ":59" + ":59";

                    String startTimeMillis = dateToStamp(startTime);
                    String endTimeMills = dateToStamp(endTime);

                    System.out.println(startTime + "||" + startTimeMillis + ";;" + endTime + "||" + endTimeMills);
                }
            }
        }
    }

    /**
     * 是否是历史日期
     *
     * @param searchDate
     * @return
     * @throws Exception
     */
    public static boolean isHistoricalDate(String searchDate) {
        try {
            if (StringUtils.isBlank(searchDate)) {
                return false;
            }

            String nowDate = DateUtils.DateToStrNoTime(new Date());
            Date date = DateUtils.strToYearMonthDate(searchDate);
            int compare = date.compareTo(DateUtils.strToYearMonthDate(nowDate));
            return compare < 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 是否是未来日期
     *
     * @param searchDate
     * @return
     * @throws Exception
     */
    public static boolean isFutureDate(String searchDate) {
        try {
            if (StringUtils.isBlank(searchDate)) {
                return false;
            }

            String nowDate = DateUtils.DateToStrNoTime(new Date());
            Date date = DateUtils.strToYearMonthDate(searchDate);
            int compare = date.compareTo(DateUtils.strToYearMonthDate(nowDate));
            return compare > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 是否是今天
     *
     * @param searchDate
     * @return
     * @throws Exception
     */
    public static boolean isToday(String searchDate) {
        try {
            if (StringUtils.isBlank(searchDate)) {
                return false;
            }

            String nowDate = DateUtils.DateToStrNoTime(new Date());
            Date date = DateUtils.strToYearMonthDate(searchDate);
            int compare = date.compareTo(DateUtils.strToYearMonthDate(nowDate));
            return compare == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 开始时间和结束时间的日期集合
     *
     * @param start       开始时间
     * @param end         结束时间
     * @param pattern     日期格式
     * @return
     */
    public static List<String> dateList(Date start, Date end, String pattern) {
        List<String> list = new ArrayList<>();
        long s = start.getTime();
        long e = end.getTime();

        Long oneDay = 1000 * 60 * 60 * 24l;

        while (s <= e) {
            start = new Date(s);
            list.add(new SimpleDateFormat(pattern).format(start));
            s += oneDay;
        }

        return list;
    }

    // 获得当天0点时间
    public static String getDayStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return sdf.format(cal.getTime());

    }

    // 获得当天24点时间
    public static String getDayEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return sdf.format(cal.getTime());
    }


    // 获得本周一0点时间
    public static String getWeekStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return sdf.format(cal.getTime());
    }

    // 获得本周日24点时间
    public static String getWeekEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return sdf.format(cal.getTime());
    }

    // 获得上周一0点时间
    public static String getLastWeekStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(getWeekStartTime()));
            cal.add(Calendar.WEEK_OF_MONTH, -1);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 获得本月第一天0点时间
    public static String getMonthStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return sdf.format(cal.getTime());
    }

    // 获得本月最后一天24点时间
    public static String getMonthEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_WITH_TIME);
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return sdf.format(cal.getTime());
    }


    // 获得本季度第一天0点时间
    public static String getQuarterStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);

        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3) {
            c.set(Calendar.MONTH, 0);
        } else if (currentMonth >= 4 && currentMonth <= 6) {
            c.set(Calendar.MONTH, 3);
        } else if (currentMonth >= 7 && currentMonth <= 9) {
            c.set(Calendar.MONTH, 6);
        } else if (currentMonth >= 10 && currentMonth <= 12) {
            c.set(Calendar.MONTH, 9);
        }

        c.set(Calendar.DATE, 1);
        return sdf.format(c.getTime()) + " 00:00:00";
    }

    // 获得本季度最后一天24点时间
    public static String getQuarterEndTime() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE);
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(getQuarterStartTime()));
            c.add(Calendar.MONTH, 3);
            c.add(Calendar.DAY_OF_MONTH, -1);
            return sdf.format(c.getTime()) + " 23:59:59";
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 判断日期属于当年的第几周
    public static int getWeekNumOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
