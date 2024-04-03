package com.instabug.chat.cache;

import android.content.Context;
import com.instabug.chat.model.d;
import com.instabug.chat.model.o;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.OnDiskCache;
import com.instabug.library.util.InstabugSDKLogger;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f46005b;

    public a(Context context) {
        this.f46005b = context;
    }

    public void run() {
        try {
            CacheManager.getInstance().addCache(new OnDiskCache(this.f46005b, "chats_disk_cache", "/chats.cache", d.class));
            CacheManager.getInstance().addCache(new OnDiskCache(this.f46005b, "read_queue_disk_cache_key", "/read_queue.cache", o.class));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "failed to prepare chat cache due to " + e11.getMessage());
        }
    }
}
