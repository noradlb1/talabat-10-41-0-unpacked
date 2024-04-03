package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class mag extends maa {

    /* renamed from: a  reason: collision with root package name */
    private String f49633a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f49634b;

    public mag(String str) {
        this.f49633a = str;
    }

    private Bitmap a(String str) {
        LogM.d("PathBitmapDescriptor", "getBitmapFromPath: ");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = 5;
        try {
            return BitmapFactoryInstrumentation.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            LogM.e("PathBitmapDescriptor", "generateBitmap OutOfMemoryError: ");
            return null;
        }
    }

    public Bitmap a(Context context) {
        Bitmap a11 = a(this.f49633a);
        this.f49634b = a11;
        return a11;
    }
}
