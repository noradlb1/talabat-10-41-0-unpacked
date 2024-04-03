package com.instabug.bug.view.visualusersteps.visitedscreens;

import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import com.instabug.library.util.InstabugSDKLogger;

class h implements DiskOperationCallback {
    public h(i iVar) {
    }

    /* renamed from: a */
    public void onSuccess(Boolean bool) {
        InstabugSDKLogger.v("IBG-BR", "Deleting visual user steps operation succeeded");
    }

    public void onFailure(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "Deleting visual user steps operation failed due to: " + th2.getMessage());
    }
}
