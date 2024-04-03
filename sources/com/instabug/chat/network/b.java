package com.instabug.chat.network;

import androidx.annotation.Nullable;
import com.instabug.chat.cache.k;
import com.instabug.chat.eventbus.c;
import com.instabug.chat.model.d;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f46086a;

    public b(d dVar) {
        this.f46086a = dVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        if (str != null) {
            String id2 = this.f46086a.getId();
            com.instabug.chat.eventbus.b.a().post(new c(id2, str));
            InstabugSDKLogger.v("IBG-BR", "Updating local chat with id: " + id2 + ", with synced chat with id: " + str);
            this.f46086a.setId(str);
            this.f46086a.a(com.instabug.chat.model.b.LOGS_READY_TO_BE_UPLOADED);
            InMemoryCache b11 = k.b();
            if (b11 != null) {
                b11.delete(id2);
                b11.put(this.f46086a.getId(), this.f46086a);
            }
            k.k();
            f.b(this.f46086a);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "Something went wrong while triggering offline chat with id: " + this.f46086a.getId(), th2);
    }
}
