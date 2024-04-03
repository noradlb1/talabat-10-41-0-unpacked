package com.instabug.bug;

import android.content.Context;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.reactivex.functions.Consumer;

class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f45710b;

    public q(Context context) {
        this.f45710b = context;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        i.a(this.f45710b, sDKCoreEvent);
    }
}
