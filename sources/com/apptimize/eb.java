package com.apptimize;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.apptimize.ap;

public class eb implements ao {

    /* renamed from: a  reason: collision with root package name */
    public static Long f42212a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f42213b = "eb";

    /* renamed from: g  reason: collision with root package name */
    private static boolean f42214g;

    /* renamed from: c  reason: collision with root package name */
    private au f42215c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f42216d;

    /* renamed from: e  reason: collision with root package name */
    private ap f42217e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f42218f = false;

    public eb(Context context, Boolean bool, au auVar) {
        this.f42216d = context.getApplicationContext();
        this.f42215c = auVar;
        try {
            this.f42217e = new ap.a(this).a("updateOfflineRequestedStatusTransient", eb.class.getDeclaredMethod("b", new Class[]{Boolean.TYPE})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42213b, "Error binding", e11);
        }
        this.f42218f = i.a().a(context, "offline", false);
        if (bool != null) {
            a(bool.booleanValue());
        }
    }

    private synchronized void b(boolean z11) {
        this.f42218f = z11;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public synchronized boolean e() {
        if (this.f42218f) {
            bo.o(f42213b, "Offline Mode enabled");
            return true;
        }
        return a(this.f42216d, this.f42215c.e());
    }

    public synchronized boolean f() {
        return this.f42218f;
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return Long.valueOf(eb.this.f42218f ? 1 : 0);
            }
        };
    }

    public static synchronized boolean a(Context context, eu euVar) {
        boolean z11;
        synchronized (eb.class) {
            long c11 = euVar.c();
            Long l11 = f42212a;
            if (l11 == null || c11 >= l11.longValue() + 1000) {
                if (context.getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        if (activeNetworkInfo.isConnectedOrConnecting()) {
                            f42214g = false;
                        }
                    }
                    bo.o(f42213b, "No internet connection detected");
                    f42214g = true;
                } else {
                    f42214g = false;
                }
                f42212a = Long.valueOf(c11);
            }
            z11 = f42214g;
        }
        return z11;
    }

    public synchronized void a(boolean z11) {
        b(z11);
        this.f42217e.b("updateOfflineRequestedStatusTransient", a(), Boolean.valueOf(z11));
        i.a().b(this.f42216d, "offline", z11);
    }
}
