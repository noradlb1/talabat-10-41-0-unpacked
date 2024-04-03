package com.instabug.library.customizations;

import android.os.Handler;
import android.os.Looper;

public abstract class b {
    public static void a() {
        new Handler(Looper.getMainLooper()).post(new a());
    }
}
