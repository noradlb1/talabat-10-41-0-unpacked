package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class maa {

    /* renamed from: a  reason: collision with root package name */
    private volatile Bitmap f49622a;

    public abstract Bitmap a(Context context);

    public Bitmap b(Context context) {
        if (this.f49622a == null) {
            synchronized (this) {
                if (this.f49622a == null) {
                    this.f49622a = a(context);
                }
            }
        }
        return this.f49622a;
    }
}
