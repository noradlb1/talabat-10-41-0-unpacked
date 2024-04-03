package com.huawei.hms.hatool;

import android.content.Context;

public final class m {

    /* renamed from: b  reason: collision with root package name */
    private static m f49075b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f49076c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f49077a;

    private m() {
    }

    public static m a() {
        if (f49075b == null) {
            b();
        }
        return f49075b;
    }

    private static synchronized void b() {
        synchronized (m.class) {
            if (f49075b == null) {
                f49075b = new m();
            }
        }
    }

    public void a(Context context) {
        synchronized (f49076c) {
            if (this.f49077a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f49077a = context;
            s.c().b().a(this.f49077a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f49077a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
            return;
        }
        s.c().b().i(e1.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
