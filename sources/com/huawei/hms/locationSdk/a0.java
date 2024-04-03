package com.huawei.hms.locationSdk;

public class a0 extends c0 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a0 f49152b;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f49153c = new byte[0];

    public static a0 b() {
        if (f49152b == null) {
            synchronized (f49153c) {
                if (f49152b == null) {
                    f49152b = new a0();
                }
            }
        }
        return f49152b;
    }
}
