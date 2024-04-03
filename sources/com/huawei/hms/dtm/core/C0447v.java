package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.dtm.core.util.Logger;
import java.lang.Thread;

/* renamed from: com.huawei.hms.dtm.core.v  reason: case insensitive filesystem */
public class C0447v implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th2) {
        if (thread != null && th2 != null) {
            Context a11 = J.a();
            if ((th2 instanceof StackOverflowError) && a11 != null) {
                new C0457x(a11).a();
            }
            Logger.error("DTM-Execute", "uncaughtException#" + th2.getClass().getSimpleName());
            C0381hd.a().a(th2, "uncaughtException");
        }
    }
}
