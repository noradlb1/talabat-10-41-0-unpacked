package com.instabug.library.visualusersteps;

import android.app.Activity;
import android.graphics.Bitmap;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f52196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f52197c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f52198d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ y f52199e;

    public x(y yVar, d dVar, Bitmap bitmap, Activity activity) {
        this.f52199e = yVar;
        this.f52196b = dVar;
        this.f52197c = bitmap;
        this.f52198d = activity;
    }

    public void run() {
        InstabugSDKLogger.d("IBG-Core", "Saving bitmap for user step step" + this.f52196b.a());
        Bitmap bitmap = this.f52197c;
        File visualUserStepsDirectory = VisualUserStepsHelper.getVisualUserStepsDirectory(this.f52198d);
        BitmapUtils.saveBitmapAsPNG(bitmap, 70, visualUserStepsDirectory, "step" + this.f52196b.a(), new w(this));
    }
}
