package com.instabug.library.screenshot;

import android.graphics.Bitmap;
import com.instabug.library.instacapture.listener.b;
import com.instabug.library.screenshot.ScreenshotProvider;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class g extends b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenshotProvider.ScreenshotCapturingListener f51743a;

    public g(ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener) {
        this.f51743a = screenshotCapturingListener;
    }

    public void a(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.f51743a.onScreenshotCapturedSuccessfully(bitmap);
    }

    public void a(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        this.f51743a.onScreenshotCapturingFailed(th2);
    }
}
