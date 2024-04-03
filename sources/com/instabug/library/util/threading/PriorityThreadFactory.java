package com.instabug.library.util.threading;

import android.os.Process;
import androidx.annotation.NonNull;
import com.instabug.library.util.InstabugSDKLogger;
import qd.b;

public class PriorityThreadFactory extends i {
    private final int threadPriority;

    public PriorityThreadFactory(String str, int i11) {
        super(str);
        this.threadPriority = i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newThread$0(Runnable runnable) {
        try {
            Process.setThreadPriority(this.threadPriority);
            runnable.run();
        } catch (Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "new thread threw an exception" + th2);
        }
    }

    @NonNull
    public Thread newThread(Runnable runnable) {
        return super.newThread(new b(this, runnable));
    }
}
