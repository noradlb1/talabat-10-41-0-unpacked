package com.huawei.hms.locationSdk;

public class y extends c0 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile y f49217b;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f49218c = new byte[0];

    public static y b() {
        if (f49217b == null) {
            synchronized (f49218c) {
                if (f49217b == null) {
                    f49217b = new y();
                }
            }
        }
        return f49217b;
    }
}
