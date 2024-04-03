package com.instabug.library.visualusersteps;

import android.app.Activity;
import android.net.Uri;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class w implements BitmapUtils.OnSaveBitmapCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f52195a;

    public w(x xVar) {
        this.f52195a = xVar;
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "capturing VisualUserStep failed error: " + th2.getMessage());
        this.f52195a.f52199e.n();
    }

    public void onSuccess(Uri uri) {
        c cVar = new c(uri.getLastPathSegment());
        Activity activity = this.f52195a.f52198d;
        if (activity == null || activity.getResources().getConfiguration().orientation != 2) {
            cVar.b("portrait");
        } else {
            cVar.b("landscape");
        }
        this.f52195a.f52196b.a(cVar);
        if (uri.getPath() != null) {
            InstabugCore.encrypt(uri.getPath());
        }
        this.f52195a.f52199e.n();
    }
}
