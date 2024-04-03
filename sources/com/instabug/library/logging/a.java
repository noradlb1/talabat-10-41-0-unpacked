package com.instabug.library.logging;

import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

class a extends DisposableObserver {
    /* renamed from: a */
    public void onNext(List list) {
        try {
            b.f51448c.clear();
            b.b(list);
        } catch (IllegalStateException e11) {
            InstabugSDKLogger.e("IBG-Core", "couldn't insert the latest logs due to " + e11.getMessage());
            IBGDiagnostics.reportNonFatal(e11, "couldn't insert the latest SDK logs due to " + e11.getMessage());
        }
    }

    public void onComplete() {
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "couldn't insert the latest SDK logs");
        IBGDiagnostics.reportNonFatal(th2, "couldn't insert the latest SDK logs due to " + th2.getMessage());
    }
}
