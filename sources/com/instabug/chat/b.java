package com.instabug.chat;

import android.content.Context;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.reactivex.functions.Consumer;

class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f46004b;

    public b(Context context) {
        this.f46004b = context;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        e.b(this.f46004b, sDKCoreEvent);
    }
}
