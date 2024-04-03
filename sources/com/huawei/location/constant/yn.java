package com.huawei.location.constant;

import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private static final Map<Integer, String> f50018yn;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0, "SUCCESS");
        hashMap.put(10000, "INTERNAL_ERROR");
        hashMap.put(10100, "ARGUMENTS_EMPTY");
        hashMap.put(10101, "ARGUMENTS_INVALID");
        hashMap.put(10102, "PERMISSION_DENIED");
        hashMap.put(10104, "NO_MATCHED_CALLBACK");
        hashMap.put(Integer.valueOf(LocationStatusCode.NETWORK_LOCATION_SERVICES_DISABLED), "NETWORK_LOCATION_SERVICES_DISABLED");
        hashMap.put(10803, "PERMISSION_DENIED");
        f50018yn = Collections.unmodifiableMap(hashMap);
    }

    public static String yn(int i11) {
        String str = f50018yn.get(Integer.valueOf(i11));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i11;
    }
}
