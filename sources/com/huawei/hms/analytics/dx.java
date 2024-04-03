package com.huawei.hms.analytics;

import java.util.concurrent.CountDownLatch;

public final class dx {
    private static boolean ikl = false;
    private static final CountDownLatch klm = new CountDownLatch(1);
    private static final Object lmn = new Object();

    public static void ikl() {
        synchronized (lmn) {
            ikl = true;
        }
    }

    public static boolean klm() {
        boolean z11;
        synchronized (lmn) {
            z11 = ikl;
        }
        return z11;
    }

    public static CountDownLatch lmn() {
        return klm;
    }
}
