package com.fanhl.logview.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fanhl on 16/5/1.
 */
public class DateUtil {
    public static final String FORMAT_msS = "mm:ss.SSS";

    private static SimpleDateFormat simpleDateFormat;

    static {
        simpleDateFormat = new SimpleDateFormat(FORMAT_msS, Locale.getDefault());
    }

    public static String long2mmssSSS(long millisecond) {
        return simpleDateFormat.format(new Date(millisecond));
    }
}
