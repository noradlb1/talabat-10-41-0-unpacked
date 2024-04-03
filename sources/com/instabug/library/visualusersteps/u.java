package com.instabug.library.visualusersteps;

import android.graphics.Bitmap;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.util.InstabugSDKLogger;

class u implements ScreenshotProvider.ScreenshotCapturingListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f52191a;

    public u(v vVar) {
        this.f52191a = vVar;
    }

    public void onScreenshotCapturedSuccessfully(Bitmap bitmap) {
        this.f52191a.f52193c.a(false);
        v vVar = this.f52191a;
        vVar.f52194d.f(vVar.f52192b, bitmap, vVar.f52193c);
    }

    public void onScreenshotCapturingFailed(Throwable th2) {
        this.f52191a.f52193c.a(false);
        InstabugSDKLogger.e("IBG-Core", "capturing VisualUserStep failed error: " + th2.getMessage());
        this.f52191a.f52194d.n();
    }
}
