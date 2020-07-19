package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getTimeNow() {
        return simpleDateFormat.format(new Date());
    }

    public static String formatDateByTimeStame(Long time) {
        return simpleDateFormat.format(new Date(time));
    }

    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }

}
