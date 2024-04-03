package com.instabug.library;

import androidx.annotation.NonNull;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.observers.DisposableCompletableObserver;

class m0 extends DisposableCompletableObserver {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r0 f50581c;

    public m0(r0 r0Var) {
        this.f50581c = r0Var;
    }

    public void onComplete() {
        this.f50581c.a(false);
    }

    public void onError(@NonNull Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Error while caching session", th2);
    }
}
