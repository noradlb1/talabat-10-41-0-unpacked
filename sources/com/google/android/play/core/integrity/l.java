package com.google.android.play.core.integrity;

import android.content.Context;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private static j f44550a;

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (l.class) {
            if (f44550a == null) {
                h hVar = new h((g) null);
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                hVar.a(context);
                f44550a = hVar.b();
            }
            jVar = f44550a;
        }
        return jVar;
    }
}
