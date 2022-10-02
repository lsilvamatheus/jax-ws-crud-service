package com.lsilva.matheus.jaxwscrudservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    private DataUtils() {}

    private static final String PATTERN_DATA_PT_BR = "yyyy-MM-dd HH:mm:ss";

    public static String formatarData(Date date) {
        return new SimpleDateFormat(PATTERN_DATA_PT_BR).format(date);
    }

    public static Date converterDateResultSetTime(Long time) {
        return new Date(time);
    }

    public static java.sql.Date converterDateParaSqlDate(Long time) {
        return new java.sql.Date(time);
    }
}
