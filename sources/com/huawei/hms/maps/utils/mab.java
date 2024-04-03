package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;

@Instrumented
public class mab extends maa {

    /* renamed from: a  reason: collision with root package name */
    private String f49623a;

    public mab(String str) {
        LogM.d("AssetBitmapDescriptor", "AssetBitmapDescriptor assetName: " + str);
        this.f49623a = str;
    }

    public Bitmap a(Context context) {
        String str;
        try {
            return BitmapFactoryInstrumentation.decodeStream(context.getAssets().open(this.f49623a));
        } catch (IOException e11) {
            str = "generateBitmap IOException: " + e11.toString();
            LogM.e("AssetBitmapDescriptor", str);
            return null;
        } catch (OutOfMemoryError unused) {
            str = "generateBitmap OutOfMemoryError: ";
            LogM.e("AssetBitmapDescriptor", str);
            return null;
        }
    }
}
