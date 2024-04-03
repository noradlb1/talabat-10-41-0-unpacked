package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class J {

    /* renamed from: a  reason: collision with root package name */
    private static CountDownLatch f48322a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private static Context f48323b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f48324c;

    public static Context a() {
        try {
            f48322a.await(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Logger.error("Before initialize");
        }
        return f48323b;
    }

    public static String a(int i11) {
        try {
            f48322a.await(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Logger.error("Before initialize");
        }
        Context context = f48324c;
        return context == null ? "error:not initialized" : context.getString(i11);
    }

    public static void a(Context context, Context context2) {
        if (context != null) {
            f48323b = context.getApplicationContext();
        }
        if (context2 != null) {
            f48324c = context2.getApplicationContext();
        }
        f48322a.countDown();
    }

    public static Context b() {
        try {
            f48322a.await(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Logger.error("Before initialize");
        }
        return f48324c;
    }
}
