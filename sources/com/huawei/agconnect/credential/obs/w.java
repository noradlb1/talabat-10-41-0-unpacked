package com.huawei.agconnect.credential.obs;

import android.content.Context;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final w f47620a = new w();

    /* renamed from: b  reason: collision with root package name */
    private Context f47621b;

    private w() {
    }

    public static w a() {
        return f47620a;
    }

    public static synchronized void a(Context context) {
        synchronized (w.class) {
            Context applicationContext = context.getApplicationContext();
            w wVar = f47620a;
            if (applicationContext != null) {
                context = applicationContext;
            }
            wVar.f47621b = context;
        }
    }

    public static String c() {
        return "1C4DE4EC";
    }

    public static String d() {
        return "80fedfd8941a368fafdae46750a4d367";
    }

    public Context b() {
        return this.f47621b;
    }
}
