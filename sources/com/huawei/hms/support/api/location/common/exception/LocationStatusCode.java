package com.huawei.hms.support.api.location.common.exception;

import com.huawei.hms.common.api.CommonStatusCodes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LocationStatusCode extends CommonStatusCodes {
    public static final int AGC_CHECK_FAIL = 10808;
    public static final int ARGUMENTS_EMPTY = 10100;
    public static final int ARGUMENTS_INVALID = 10101;
    private static final Map<Integer, String> CODE_MAPPING;
    public static final int GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION = 10204;
    public static final int GEOFENCE_NOT_AVAILABLE = 10200;
    public static final int GEOFENCE_REQUEST_TOO_FREQUENT = 10205;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 10201;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 10202;
    public static final int LOCATION_ENABLE_OFF = 10106;
    public static final int LOCATION_INTERNAL_ERROR = 10000;
    public static final int METHOD_INVOKE_ERROR = 10807;
    public static final int NAVIGATION_EMPTY_RESULT = 10110;
    public static final int NAVIGATION_NOT_AVAILABLE = 10109;
    public static final int NETWORK_LOCATION_SERVICES_DISABLED = 10105;
    public static final int NOT_IN_WHITELIST = 10111;
    public static final int NOT_SUPPORT_WATCH = 10601;
    public static final int NOT_YET_SUPPORTED = 10806;
    public static final int NO_MATCHED_CALLBACK = 10804;
    public static final int NO_MATCHED_INTENT = 10805;
    public static final int NO_PRECISE_LOCATION_PERMISSION = 10809;
    public static final int OFFLINE_LOCATION_MODE_OFF = 10112;
    public static final int PARAM_ERROR_EMPTY = 10801;
    public static final int PARAM_ERROR_INVALID = 10802;
    public static final int PERMISSION_DENIED = 10803;
    public static final int SUCCESS = 0;

    static {
        HashMap hashMap = new HashMap(0);
        hashMap.put(0, "SUCCESS");
        hashMap.put(Integer.valueOf(LOCATION_ENABLE_OFF), "LOCATION_ENABLE_OFF");
        hashMap.put(8, "INTERNAL_ERROR");
        hashMap.put(10100, "ARGUMENTS_EMPTY");
        hashMap.put(10101, "ARGUMENTS_INVALID");
        hashMap.put(10802, "PARAM_ERROR_INVALID");
        hashMap.put(10803, "PERMISSION_DENIED");
        hashMap.put(Integer.valueOf(NO_MATCHED_CALLBACK), "NO_MATCHED_CALLBACK");
        hashMap.put(10806, "NOT_YET_SUPPORTED");
        hashMap.put(Integer.valueOf(NETWORK_LOCATION_SERVICES_DISABLED), "NETWORK_LOCATION_SERVICES_DISABLED");
        hashMap.put(Integer.valueOf(NO_MATCHED_INTENT), "NO_MATCHED_INTENT");
        hashMap.put(Integer.valueOf(PARAM_ERROR_EMPTY), "PARAM_ERROR_EMPTY");
        hashMap.put(Integer.valueOf(METHOD_INVOKE_ERROR), "METHOD_INVOKE_ERROR");
        hashMap.put(10808, "AGC_CHECK_FAIL");
        hashMap.put(Integer.valueOf(NO_PRECISE_LOCATION_PERMISSION), "NO_PRECISE_LOCATION_PERMISSION");
        hashMap.put(10200, "GEOFENCE_NOT_AVAILABLE");
        hashMap.put(10201, "GEOFENCE_TOO_MANY_GEOFENCES");
        hashMap.put(10202, "GEOFENCE_TOO_MANY_PENDING_INTENTS");
        hashMap.put(10204, "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION");
        hashMap.put(10205, "GEOFENCE_REQUEST_TOO_FREQUENT");
        hashMap.put(Integer.valueOf(NOT_SUPPORT_WATCH), "NOT_SUPPORT_WATCH");
        hashMap.put(Integer.valueOf(NOT_IN_WHITELIST), "NOT_IN_WHITELIST");
        hashMap.put(Integer.valueOf(NAVIGATION_NOT_AVAILABLE), "NAVIGATION_NOT_AVAILABLE");
        hashMap.put(Integer.valueOf(NAVIGATION_EMPTY_RESULT), "NAVIGATION_EMPTY_RESULT");
        hashMap.put(Integer.valueOf(OFFLINE_LOCATION_MODE_OFF), "OFFLINE_LOCATION_MODE_OFF");
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
