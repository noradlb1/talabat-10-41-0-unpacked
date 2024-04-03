package com.instabug.library.sessionprofiler;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class c implements Consumer {
    public c(e eVar) {
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Error while starting session profiler", th2);
    }
}
