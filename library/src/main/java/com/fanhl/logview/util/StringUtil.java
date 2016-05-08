package com.fanhl.logview.util;

/**
 * Created by fanhl on 16/5/4.
 */
public class StringUtil {
    public static boolean equals(String s1, String s2) {
        if (s1 == null) return s2 == null;
        return s1.equals(s2);
    }
}
