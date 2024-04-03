package com.instabug.library.visualusersteps;

import android.net.Uri;
import android.view.View;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class h implements BitmapUtils.OnSaveBitmapCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f52157a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f52158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f52159c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f52160d;

    public h(k kVar, j jVar, d dVar, View view) {
        this.f52160d = kVar;
        this.f52157a = jVar;
        this.f52158b = dVar;
        this.f52159c = view;
    }

    public void onError(Throwable th2) {
        if (!(th2 == null || th2.getMessage() == null)) {
            InstabugSDKLogger.e("IBG-Core", "Error saving button icon bitmap: " + th2.getMessage());
        }
        if (this.f52160d.a(this.f52159c)) {
            this.f52160d.f52174f.c(String.format("the button \"%s\"", new Object[]{this.f52159c.getContentDescription()}));
            this.f52157a.a(this.f52158b, this.f52160d.f52174f);
            return;
        }
        this.f52160d.f52174f.c("a button");
        this.f52160d.f52174f.b((String) null);
        this.f52160d.f52174f.a((String) null);
        this.f52157a.a(this.f52158b, this.f52160d.f52174f);
    }

    public void onSuccess(Uri uri) {
        this.f52160d.f52174f.c("the button ");
        this.f52160d.f52174f.b(uri.toString());
        this.f52160d.f52174f.a(uri.getLastPathSegment());
        if (uri.getPath() != null) {
            InstabugCore.encrypt(uri.getPath());
        }
        this.f52157a.a(this.f52158b, this.f52160d.f52174f);
    }
}
