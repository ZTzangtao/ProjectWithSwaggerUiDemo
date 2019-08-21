package com.bbd.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author lisu
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    /**
     * 计算当前日期与{@code endDate}的间隔天数
     *
     * @param time
     * @return 间隔分钟
     */
    public static long until(LocalDateTime time) {
        logger.info("当前时间---，{}", LocalDateTime.now());
        return Math.abs(LocalDateTime.now().until(time, ChronoUnit.MINUTES));
    }

    /**
     * 时间戳转localDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeOfTimestamp(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 获取明天的凌晨12点时间戳（秒）
     *
     * @return
     */
    public static long getTomorrowBegin() {
        long now = System.currentTimeMillis() / 1000L;
        long daySecond = 60 * 60 * 24;
        long dayTime = now - (now + 8 * 3600) % daySecond + 1 * daySecond;
        return dayTime;
    }

    /**
     * 获取当前时间 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String localDateTimeToLongString() {
        return localDateTimeToString("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前时间 yyyy-MM-dd
     *
     * @return
     */
    public static String localDateTimeToSimpleString() {
        return localDateTimeToString("yyyy-MM-dd");
    }

    public static String localDateTimeToString(String dateFormat) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        return localTime;
    }

    /**
     * 获取几个月前的短时间
     *
     * @param month
     * @return
     */
    public static String getStringTime(long month) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        date = date.minusMonths(month);
        return df.format(date);
    }

    public static String getNewTime(String str1, String str2) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if (StringUtils.isEmpty(str2)) {
                return str1;
            }

            if (StringUtils.isEmpty(str1)) {
                return str2;
            }

            if (dateFormat.parse(str1).getTime() < dateFormat.parse(str2).getTime()) {
                return str2;
            } else {
                return str1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
