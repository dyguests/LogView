package com.fanhl.logview.util;

import java.util.List;

/**
 * Created by fanhl on 16/5/4.
 */
public class ListUtil {
    public static  <T> void filter(List<T> fromList, List<T> toList, Filter<T> filter) {
        if (fromList == null) return;
        if (filter == null || fromList.isEmpty()) toList.addAll(fromList);
        else for (T t : fromList) if (filter.filter(t)) toList.add(t);
    }

    public interface Filter<T> {
        boolean filter(T t);
    }
}
