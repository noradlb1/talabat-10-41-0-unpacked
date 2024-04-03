package com.instabug.library;

import android.content.Context;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.util.InstabugSDKLogger;

class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50594b;

    public u(c0 c0Var) {
        this.f50594b = c0Var;
    }

    public void run() {
        Context context;
        InstabugSDKLogger.v("IBG-Core", "Dumping caches");
        if (this.f50594b.f50537e != null && (context = (Context) this.f50594b.f50537e.get()) != null) {
            AssetsCacheManager.cleanUpCache(context);
            SDKCoreEventPublisher.post(new SDKCoreEvent("cache_dump", "cache_dumped_successfully"));
        }
    }
}
