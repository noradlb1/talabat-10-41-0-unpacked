package com.instabug.featuresrequest.settings;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f46588a;

    private a() {
    }

    public static a a() {
        if (f46588a == null) {
            f46588a = new a();
        }
        return f46588a;
    }

    public static void a(int i11) {
        if (c.a() != null) {
            c.a().a(i11);
        }
    }

    public static int c() {
        if (c.a() == null) {
            return 0;
        }
        return c.a().c();
    }

    public static boolean g() {
        return c.a() == null || c.a().c() == 0;
    }

    public void a(long j11) {
        if (c.a() != null) {
            c.a().a(j11);
        }
    }

    public void a(boolean z11) {
        b.a().a(z11);
    }

    public long b() {
        if (c.a() == null) {
            return 0;
        }
        return c.a().b();
    }

    public void b(boolean z11) {
        b.a().b(z11);
    }

    public boolean d() {
        return b.a().b();
    }

    public boolean e() {
        Feature feature = Feature.FEATURE_REQUESTS;
        return InstabugCore.isFeatureAvailable(feature) && InstabugCore.isExperimentalFeatureAvailable(feature) && InstabugCore.isFeatureEnabled(feature);
    }

    public boolean f() {
        return b.a().c();
    }
}
