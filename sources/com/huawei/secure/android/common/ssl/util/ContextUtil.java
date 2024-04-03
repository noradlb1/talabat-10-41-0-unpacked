package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

public class ContextUtil {

    /* renamed from: a  reason: collision with root package name */
    private static Context f33956a;

    public static Context getInstance() {
        return f33956a;
    }

    public static void setContext(Context context) {
        if (context != null && f33956a == null) {
            f33956a = context.getApplicationContext();
        }
    }
}
