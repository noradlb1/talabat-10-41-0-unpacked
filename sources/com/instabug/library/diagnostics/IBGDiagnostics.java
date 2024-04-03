package com.instabug.library.diagnostics;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import com.instabug.library.diagnostics.nonfatals.c;
import com.instabug.library.diagnostics.sdkEvents.di.a;

public class IBGDiagnostics {
    public static void logEvent(String str, int i11) {
        a.i().a(str, i11, Thread.currentThread().getStackTrace());
    }

    public static void logEventImmediately(String str, int i11) {
        a.i().b(str, i11, Thread.currentThread().getStackTrace());
    }

    @WorkerThread
    public static void logTrace(String str, long j11, long j12) {
        com.instabug.library.diagnostics.customtraces.di.a.d().a(str, j11, j12);
    }

    public static void reportNonFatal(Throwable th2, String str) {
        c.a(th2, str, 0);
    }

    public static void reportNonFatalAndLog(Throwable th2, String str, String str2) {
        c.a(th2, str, 0, str2);
    }

    @WorkerThread
    @Nullable
    public static IBGCustomTrace startTrace(String str) {
        return com.instabug.library.diagnostics.customtraces.di.a.d().a(str, System.currentTimeMillis() * 1000);
    }

    public static void logEvent(String str) {
        a.i().a(str, 1, Thread.currentThread().getStackTrace());
    }

    public static void logEventImmediately(String str) {
        a.i().b(str, 1, Thread.currentThread().getStackTrace());
    }

    public static void reportNonFatal(Throwable th2, String str, int i11) {
        c.a(th2, str, i11);
    }

    public static void reportNonFatalAndLog(Throwable th2, String str, String str2, int i11) {
        c.a(th2, str, i11, str2);
    }

    @WorkerThread
    @Nullable
    public static IBGCustomTrace startTrace(String str, long j11) {
        return com.instabug.library.diagnostics.customtraces.di.a.d().a(str, j11);
    }
}
