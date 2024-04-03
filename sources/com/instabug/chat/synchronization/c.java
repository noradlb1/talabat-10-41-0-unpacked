package com.instabug.chat.synchronization;

import android.content.Context;
import com.instabug.chat.settings.a;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SynchronizationManager.d f46176b;

    public c(SynchronizationManager.d dVar) {
        this.f46176b = dVar;
    }

    public void run() {
        WeakReference weakReference = this.f46176b.f46172b;
        if (weakReference == null || weakReference.get() == null) {
            try {
                SynchronizationManager.this.syncAction.accept(Long.valueOf(a.g()));
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-BR", "Exception was occurred," + e11.getMessage());
            }
        } else {
            SynchronizationManager.d dVar = this.f46176b;
            SynchronizationManager.this.syncMessages((Context) dVar.f46172b.get(), SynchronizationManager.this.syncAction);
        }
    }
}
