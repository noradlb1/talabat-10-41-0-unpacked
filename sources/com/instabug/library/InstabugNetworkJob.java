package com.instabug.library;

import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import qc.k;

public abstract class InstabugNetworkJob {
    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$enqueueJob$0(String str, Runnable runnable) {
        if (Instabug.getApplicationContext() != null) {
            InstabugSDKLogger.v("IBG-Core", str + " Started");
            runnable.run();
            return;
        }
        InstabugSDKLogger.d("IBG-Core", "Context was null while trying to start job: " + str);
    }

    public void b(String str, Runnable runnable) {
        PoolProvider.getNetworkingSingleThreadExecutor(str).execute(new k(str, runnable));
    }

    public abstract void start();
}
