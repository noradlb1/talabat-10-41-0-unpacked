package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f34018a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f34018a.post(runnable);
        }
    }
}
