package com.instabug.library.screenshot;

import android.net.Uri;
import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class b implements BitmapUtils.OnSaveBitmapCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtraScreenshotHelper.a f51735a;

    public b(ExtraScreenshotHelper.a aVar) {
        this.f51735a = aVar;
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Error while saving screenshot" + th2);
    }

    public void onSuccess(Uri uri) {
        ExtraScreenshotHelper.OnCaptureListener onCaptureListener = this.f51735a.f51713b;
        if (onCaptureListener != null) {
            onCaptureListener.onExtraScreenshotCaptured(uri);
        }
    }
}
