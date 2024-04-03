package com.instabug.library.screenshot;

import android.net.Uri;
import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class c implements BitmapUtils.OnSaveBitmapCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtraScreenshotHelper.b f51736a;

    public c(ExtraScreenshotHelper.b bVar) {
        this.f51736a = bVar;
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Error while saving screenshot" + th2.getMessage());
    }

    public void onSuccess(Uri uri) {
        ExtraScreenshotHelper.OnCaptureListener onCaptureListener = this.f51736a.f51716b;
        if (onCaptureListener != null) {
            onCaptureListener.onExtraScreenshotCaptured(uri);
        }
    }
}
