package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.PixelCopy;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.HashMap;

class c implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f34398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f34399b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f34400c;

    public c(d dVar, Bitmap bitmap, HashMap hashMap) {
        this.f34400c = dVar;
        this.f34398a = bitmap;
        this.f34399b = hashMap;
    }

    public void onPixelCopyFinished(int i11) {
        if (i11 == 0) {
            h.b(this.f34400c.f34401b, i11, this.f34398a);
            if (!this.f34398a.isRecycled()) {
                BitmapUtils.maskBitmap(this.f34400c.f34401b, this.f34398a, SettingsManager.getInstance(), (Canvas) null);
            }
        } else {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while capturing ");
            this.f34398a.recycle();
        }
        h.b(this.f34399b);
    }
}
