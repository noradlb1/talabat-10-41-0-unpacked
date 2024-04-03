package com.instabug.apm.logger;

import androidx.annotation.NonNull;
import com.instabug.apm.di.a;

public final class APMLogger {
    private APMLogger() {
    }

    public static void d(String str) {
        a.f().a(str);
    }

    public static void e(String str) {
        a.f().b(str);
    }

    public static void i(String str) {
        a.f().c(str);
    }

    public static void logSDKDebug(@NonNull String str) {
        a.f().d(str);
    }

    public static void logSDKError(@NonNull String str) {
        a.f().e(str);
    }

    public static void logSDKError(@NonNull String str, @NonNull Throwable th2) {
        a.f().a(str, th2);
    }

    public static void logSDKInfo(@NonNull String str) {
        a.f().f(str);
    }

    public static void logSDKProtected(@NonNull String str) {
        a.f().g(str);
    }

    public static void logSDKVerbose(@NonNull String str) {
        a.f().h(str);
    }

    public static void logSDKWarning(@NonNull String str) {
        a.f().i(str);
    }

    public static void v(String str) {
        a.f().j(str);
    }

    public static void w(String str) {
        a.f().k(str);
    }
}
