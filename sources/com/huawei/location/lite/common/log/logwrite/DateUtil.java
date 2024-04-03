package com.huawei.location.lite.common.log.logwrite;

import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateUtil {
    private static ThreadLocal<Map<String, SimpleDateFormat>> dateFormat = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        @Nullable
        /* renamed from: a */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap(0);
        }
    };

    public static String formate(Date date, String str) {
        return getSimpleDateFormat(str).format(date);
    }

    private static SimpleDateFormat getSimpleDateFormat(String str) {
        Map map = dateFormat.get();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.getDefault());
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }
}
