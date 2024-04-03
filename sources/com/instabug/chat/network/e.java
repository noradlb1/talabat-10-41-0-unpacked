package com.instabug.chat.network;

import androidx.annotation.Nullable;
import com.instabug.chat.cache.k;
import com.instabug.chat.model.b;
import com.instabug.chat.model.d;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f46089a;

    public e(d dVar) {
        this.f46089a = dVar;
    }

    /* renamed from: a */
    public void onFailed(d dVar) {
        InstabugSDKLogger.d("IBG-BR", "Something went wrong while uploading chat logs");
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-BR", "chat logs uploaded successfully, changing its state");
        this.f46089a.a(b.SENT);
        k.k();
    }
}
