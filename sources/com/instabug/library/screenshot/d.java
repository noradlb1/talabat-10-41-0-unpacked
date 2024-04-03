package com.instabug.library.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class d implements ScreenshotProvider.ScreenshotCapturingListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f51737a;

    public d(e eVar) {
        this.f51737a = eVar;
    }

    public void onScreenshotCapturedSuccessfully(Bitmap bitmap) {
        BitmapUtils.maskBitmap(InstabugInternalTrackingDelegate.getInstance().getCurrentActivity(), bitmap, SettingsManager.getInstance(), (Canvas) null);
        ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener = this.f51737a.f51738b;
        if (screenshotCapturingListener != null) {
            screenshotCapturingListener.onScreenshotCapturedSuccessfully(bitmap);
        }
    }

    public void onScreenshotCapturingFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "initial screenshot capturing got error: " + th2.getMessage(), th2);
        ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener = this.f51737a.f51738b;
        if (screenshotCapturingListener != null) {
            screenshotCapturingListener.onScreenshotCapturingFailed(th2);
            SettingsManager.getInstance().setProcessingForeground(false);
        }
    }
}
