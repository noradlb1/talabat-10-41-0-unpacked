package com.instabug.chat.ui.annotation;

import android.net.Uri;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;

class e implements BitmapUtils.OnSaveBitmapCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f46185a;

    public e(f fVar, b bVar) {
        this.f46185a = bVar;
    }

    public void onError(Throwable th2) {
        this.f46185a.finish();
        InstabugSDKLogger.e("IBG-BR", "Error occurred while saving bitmap", th2);
    }

    public void onSuccess(Uri uri) {
        this.f46185a.finish();
    }
}
