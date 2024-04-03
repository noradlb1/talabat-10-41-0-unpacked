package com.instabug.library;

import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.util.InstabugSDKLogger;

class b implements VoidRunnable {
    public b(Instabug.a aVar) {
    }

    public void run() {
        if (Instabug.getInstance() != null) {
            Instabug.getInstance().delegate.c0(Feature.State.ENABLED);
        }
        if (Instabug.getInstance() != null) {
            Instabug.getInstance().delegate.t();
        }
        InstabugSDKLogger.d("IBG-Core", "enable");
    }
}
