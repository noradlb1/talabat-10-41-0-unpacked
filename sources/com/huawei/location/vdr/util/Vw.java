package com.huawei.location.vdr.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vw {

    /* renamed from: yn  reason: collision with root package name */
    private static final Map<Integer, String> f50298yn;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(29, "Android10");
        hashMap.put(30, "Android11");
        hashMap.put(28, "Android9");
        hashMap.put(26, "Android8");
        hashMap.put(27, "Android8");
        hashMap.put(24, "Android7");
        hashMap.put(25, "Android7");
        f50298yn = Collections.unmodifiableMap(hashMap);
    }

    public static String yn(int i11) {
        return f50298yn.get(Integer.valueOf(i11));
    }
}
