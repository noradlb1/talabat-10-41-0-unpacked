package com.huawei.location.lite.common.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class LocationStatusCode {
    public static final int AGC_CHECK_FAIL = 10808;
    public static final int ARGUMENTS_EMPTY = 10100;
    private static final Map<Integer, String> CODE_MAPPING;
    public static final int CP_PERMISSION_DENIED = 10803;
    public static final int LOCATION_INTERNAL_ERROR = 10000;
    public static final int NOT_YET_SUPPORTED = 10806;
    public static final int PERMISSION_DENIED = 10102;
    public static final int SUCCESS = 0;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0, "SUCCESS");
        hashMap.put(10000, "INTERNAL_ERROR");
        hashMap.put(10100, "ARGUMENTS_EMPTY");
        hashMap.put(10806, "NOT_YET_SUPPORTED");
        hashMap.put(10808, "AGC_CHECK_FAIL");
        CODE_MAPPING = Collections.unmodifiableMap(hashMap);
    }

    public static String getStatusCodeString(int i11) {
        String str = CODE_MAPPING.get(Integer.valueOf(i11));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i11;
    }
}
