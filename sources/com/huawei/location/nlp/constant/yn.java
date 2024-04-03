package com.huawei.location.nlp.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private static final Map<Integer, String> f50182yn;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0, "SUCCESS");
        hashMap.put(10000, "INTERNAL_ERROR");
        hashMap.put(10100, "SCAN_RESULT_ERROR");
        hashMap.put(11000, "LOCATION_CLOUD_ERROR");
        f50182yn = Collections.unmodifiableMap(hashMap);
    }

    public static String yn(int i11) {
        String str = f50182yn.get(Integer.valueOf(i11));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i11;
    }
}
