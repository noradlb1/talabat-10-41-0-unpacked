package com.instabug.library.visualusersteps;

import android.app.Activity;
import com.instabug.library.screenshot.ScreenshotProvider;

class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f52192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f52193c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ y f52194d;

    public v(y yVar, Activity activity, d dVar) {
        this.f52194d = yVar;
        this.f52192b = activity;
        this.f52193c = dVar;
    }

    public void run() {
        ScreenshotProvider.a(this.f52192b, (ScreenshotProvider.ScreenshotCapturingListener) new u(this));
    }
}
