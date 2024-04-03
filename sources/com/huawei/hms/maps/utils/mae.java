package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.FileInputStream;
import java.io.IOException;

@Instrumented
public class mae extends maa {

    /* renamed from: a  reason: collision with root package name */
    private String f49627a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f49628b;

    public mae(String str) {
        this.f49627a = str;
    }

    public Bitmap a(Context context) {
        StringBuilder sb2;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(this.f49627a);
            this.f49628b = BitmapFactoryInstrumentation.decodeStream(fileInputStream);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                    e = e11;
                    sb2 = new StringBuilder();
                }
            }
        } catch (IOException e12) {
            LogM.e("FileBitmapDescriptor", "generateBitmap IOException : " + e12.toString());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e13) {
                    e = e13;
                    sb2 = new StringBuilder();
                }
            }
        } catch (OutOfMemoryError unused) {
            LogM.e("FileBitmapDescriptor", "generateBitmap OutOfMemoryError: ");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e14) {
                    e = e14;
                    sb2 = new StringBuilder();
                }
            }
        } catch (Throwable th2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e15) {
                    LogM.d("FileBitmapDescriptor", "generateBitmap close fileInputStream IOException : " + e15.toString());
                }
            }
            throw th2;
        }
        return this.f49628b;
        sb2.append("generateBitmap close fileInputStream IOException : ");
        sb2.append(e.toString());
        LogM.d("FileBitmapDescriptor", sb2.toString());
        return this.f49628b;
    }
}
