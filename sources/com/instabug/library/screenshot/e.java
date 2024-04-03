package com.instabug.library.screenshot;

import com.instabug.library.screenshot.ScreenshotProvider;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenshotProvider.ScreenshotCapturingListener f51738b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f51739c;

    public e(f fVar, ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener) {
        this.f51739c = fVar;
        this.f51738b = screenshotCapturingListener;
    }

    public void run() {
        this.f51739c.b(new d(this));
    }
}
