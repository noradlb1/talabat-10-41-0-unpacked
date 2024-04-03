package com.instabug.survey.settings;

import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.survey.callbacks.OnDismissCallback;
import com.instabug.survey.callbacks.OnFinishCallback;
import com.instabug.survey.callbacks.OnShowCallback;
import java.util.concurrent.TimeUnit;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final long f52433a = TimeUnit.DAYS.toMillis(7);

    public static void a() {
        a.b().a();
    }

    public static void a(long j11) {
        if (b.c() != null) {
            b.c().a(j11);
        }
    }

    public static void a(OnDismissCallback onDismissCallback) {
        a.b().a(onDismissCallback);
    }

    public static void a(OnFinishCallback onFinishCallback) {
        a.b().a(onFinishCallback);
    }

    public static void a(OnShowCallback onShowCallback) {
        a.b().a(onShowCallback);
    }

    public static void a(String str) {
        if (b.c() != null) {
            b.c().a(str);
        }
    }

    public static void a(boolean z11) {
        a.b().e(z11);
    }

    @Nullable
    public static String b() {
        if (b.c() == null) {
            return null;
        }
        return b.c().a();
    }

    public static void b(long j11) {
        if (b.c() != null) {
            b.c().b(j11);
        }
    }

    public static void b(String str) {
        if (b.c() != null) {
            a.b().a(str);
        }
    }

    public static void b(boolean z11) {
        a.b().b(z11);
    }

    public static long c() {
        if (b.c() == null) {
            return -1;
        }
        return b.c().b();
    }

    public static void c(boolean z11) {
        a.b().c(z11);
    }

    public static long d() {
        return InstabugCore.getFirstSeen();
    }

    public static void d(boolean z11) {
        a.b().d(z11);
    }

    public static long e() {
        if (b.c() == null) {
            return -1;
        }
        return b.c().d();
    }

    @Nullable
    public static String f() {
        if (b.c() == null) {
            return null;
        }
        return a.b().c();
    }

    @Nullable
    public static OnDismissCallback g() {
        return a.b().d();
    }

    @Nullable
    public static OnFinishCallback h() {
        return a.b().e();
    }

    @Nullable
    public static OnShowCallback i() {
        return a.b().f();
    }

    public static int j() {
        return 4;
    }

    public static boolean k() {
        if (b.c() == null) {
            return false;
        }
        return b.c().f();
    }

    public static boolean l() {
        return a.b().h() && a.b().k();
    }

    @Nullable
    public static Boolean m() {
        return a.b().i();
    }

    public static boolean n() {
        return a.b().j() && InstabugCore.isFeatureAvailable(Feature.VZ_MESSAGES_CUSTOM_APPRATING_UI);
    }

    public static boolean o() {
        return a.b().l();
    }

    public static void p() {
        if (b.c() != null) {
            b.c().g();
        }
    }

    public static void q() {
        a.b().n();
    }

    public static Boolean r() {
        return Boolean.valueOf(a.b().o());
    }
}
