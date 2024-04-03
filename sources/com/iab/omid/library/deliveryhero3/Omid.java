package com.iab.omid.library.deliveryhero3;

import android.content.Context;

public final class Omid {
    private static b INSTANCE = new b();

    private Omid() {
    }

    public static void activate(Context context) {
        INSTANCE.c(context.getApplicationContext());
    }

    public static String getVersion() {
        return INSTANCE.a();
    }

    public static boolean isActive() {
        return INSTANCE.e();
    }

    public static void updateLastActivity() {
        INSTANCE.f();
    }
}
