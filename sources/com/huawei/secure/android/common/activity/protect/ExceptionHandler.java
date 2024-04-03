package com.huawei.secure.android.common.activity.protect;

import com.huawei.secure.android.common.activity.a;

public abstract class ExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33690a = "ExceptionHandler";

    public final void a(Throwable th2) {
        a.b(f33690a, "bandageExceptionHappened ");
        try {
            b(th2);
        } catch (Throwable unused) {
            a.a(f33690a, "bandageExceptionHappened");
        }
    }

    public abstract void b(Throwable th2);

    public abstract void c(Thread thread, Throwable th2);

    public final void uncaughtExceptionHappened(Thread thread, Throwable th2) {
        a.b(f33690a, "uncaughtExceptionHappened ");
        try {
            c(thread, th2);
        } catch (Throwable unused) {
            a.a(f33690a, "uncaughtExceptionHappened");
        }
    }
}
