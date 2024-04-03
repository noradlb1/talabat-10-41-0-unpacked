package com.instabug.library.visualusersteps;

import android.net.Uri;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class i implements BitmapUtils.OnSaveBitmapCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f52161a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f52162b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f52163c;

    public i(k kVar, j jVar, d dVar) {
        this.f52163c = kVar;
        this.f52161a = jVar;
        this.f52162b = dVar;
    }

    public void onError(Throwable th2) {
        if (th2.getMessage() != null) {
            InstabugSDKLogger.e("IBG-Core", "Error while saving tab icon: " + th2.getMessage());
        }
        this.f52163c.f52174f.c("a button");
        this.f52163c.f52174f.b((String) null);
        this.f52163c.f52174f.a((String) null);
        this.f52161a.a(this.f52162b, this.f52163c.f52174f);
    }

    public void onSuccess(Uri uri) {
        this.f52163c.f52174f.c("the button ");
        this.f52163c.f52174f.b(uri.toString());
        this.f52163c.f52174f.a(uri.getLastPathSegment());
        if (uri.getPath() != null) {
            InstabugCore.encrypt(uri.getPath());
        }
        this.f52161a.a(this.f52162b, this.f52163c.f52174f);
    }
}
