package com.iab.omid.library.deliveryhero3.internal;

import android.annotation.SuppressLint;
import android.view.View;
import com.iab.omid.library.deliveryhero3.adsession.a;

public class b extends d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static b f44953d = new b();

    private b() {
    }

    public static b g() {
        return f44953d;
    }

    public void b(boolean z11) {
        for (a adSessionStatePublisher : c.c().b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(z11);
        }
    }

    public boolean d() {
        for (a c11 : c.c().a()) {
            View c12 = c11.c();
            if (c12 != null && c12.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
