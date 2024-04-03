package com.instabug.library.instacapture;

import com.instabug.library.instacapture.listener.a;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f34374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f34375c;

    public c(d dVar, a aVar) {
        this.f34375c = dVar;
        this.f34374b = aVar;
    }

    /* renamed from: a */
    public void accept(Throwable th2) throws Exception {
        InstabugSDKLogger.e("IBG-Core", "Screenshot capture failed", th2);
        a aVar = this.f34374b;
        if (aVar != null) {
            aVar.a(th2);
        }
        this.f34375c.a(this.f34374b);
        this.f34375c.b();
    }
}
