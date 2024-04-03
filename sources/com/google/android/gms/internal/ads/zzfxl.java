package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final class zzfxl extends TimeoutException {
    public /* synthetic */ zzfxl(String str, zzfxk zzfxk) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
