package com.instabug.library.user;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.observers.DisposableCompletableObserver;

class b extends DisposableCompletableObserver {
    public b(d dVar) {
    }

    public void onComplete() {
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Error while updating UUID in db" + th2.getMessage());
    }
}
