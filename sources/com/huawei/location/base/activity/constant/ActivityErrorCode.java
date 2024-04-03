package com.huawei.location.base.activity.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ActivityErrorCode {
    public static final int ACTIVITY_IDENTIFICATION_NOT_AVAILABLE = 10301;
    public static final int ARGUMENTS_INVALID = 10101;
    private static final Map<Integer, String> CODE_MAPPING;
    public static final int CP_PERMISSION_DENIED = 10803;
    public static final int ENABLE_CONVERSION_EVENT_FAILED = 10300;
    public static final int INTERNAL_ERROR = 10000;
    public static final int NO_MATCHED_INTENT = 10108;
    public static final int PARAM_ERROR_INVALID = 10802;
    public static final int PERMISSION_DENIED = 10102;
    public static final int SUCCESS = 0;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0, "SUCCESS");
        hashMap.put(10000, "INTERNAL_ERROR");
        hashMap.put(10101, "ARGUMENTS_INVALID");
        hashMap.put(10102, "PERMISSION_DENIED");
        hashMap.put(Integer.valueOf(NO_MATCHED_INTENT), "NO_MATCHED_INTENT");
        hashMap.put(10300, "ENABLE_CONVERSION_EVENT_FAILED");
        hashMap.put(10301, "ACTIVITY_IDENTIFICATION_NOT_AVAILABLE");
        hashMap.put(10802, "PARAM_ERROR_INVALID");
        hashMap.put(10803, "CP_PERMISSION_DENIED");
        CODE_MAPPING = Collections.unmodifiableMap(hashMap);
    }

    public static String getErrorCodeMessage(int i11) {
        String str = CODE_MAPPING.get(Integer.valueOf(i11));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i11;
    }
}
