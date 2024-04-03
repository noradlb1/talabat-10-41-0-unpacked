package com.instabug.library.invocation;

import android.net.Uri;
import com.instabug.library.core.InitialScreenshotHelper;

class b implements InitialScreenshotHelper.InitialScreenshotCapturingListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f51285a;

    public b(d dVar) {
        this.f51285a = dVar;
    }

    public void onScreenshotCapturedSuccessfully(Uri uri) {
        this.f51285a.j(uri);
    }

    public void onScreenshotCapturingFailed(Throwable th2) {
        this.f51285a.j((Uri) null);
    }
}
