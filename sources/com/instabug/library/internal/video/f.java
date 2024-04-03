package com.instabug.library.internal.video;

import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f51224b;

    public f(h hVar) {
        this.f51224b = hVar;
    }

    public void run() {
        File file = new File(this.f51224b.f51231e);
        if (!file.exists()) {
            InstabugSDKLogger.e("IBG-Core", "Screen recording file doesn't exist - couldn't be deleted");
            return;
        }
        if (!file.delete()) {
            InstabugSDKLogger.e("IBG-Core", "Screen recording file couldn't be deleted");
        }
        this.f51224b.f51228b.b();
    }
}
