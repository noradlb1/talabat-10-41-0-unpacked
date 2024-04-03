package com.instabug.apm.logger.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.apm.configuration.c;
import com.instabug.library.util.InstabugSDKLogger;

public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final c f45477a;

    public a(@NonNull c cVar) {
        this.f45477a = cVar;
    }

    public void a(String str) {
        b(4);
    }

    public void a(@NonNull String str, @NonNull Throwable th2) {
        b(str + ". " + th2.toString());
        g(str + ". " + th2.toString());
    }

    public void b(String str) {
        if (b(1)) {
            Log.e("IBG-APM", str);
        }
    }

    @VisibleForTesting
    public boolean b(int i11) {
        int h11 = this.f45477a.h();
        return h11 != 0 && i11 <= h11;
    }

    public void c(String str) {
        if (b(3)) {
            Log.i("IBG-APM", str);
        }
    }

    public void d(@NonNull String str) {
        a(str);
        g(str);
    }

    public void e(@NonNull String str) {
        b(str);
        g(str);
    }

    public void f(@NonNull String str) {
        c(str);
        g(str);
    }

    public void g(@NonNull String str) {
        InstabugSDKLogger.p("IBG-APM", str);
    }

    public void h(@NonNull String str) {
        j(str);
        g(str);
    }

    public void i(@NonNull String str) {
        k(str);
        g(str);
    }

    public void j(String str) {
        b(5);
    }

    public void k(String str) {
        if (b(2)) {
            Log.w("IBG-APM", str);
        }
    }
}
