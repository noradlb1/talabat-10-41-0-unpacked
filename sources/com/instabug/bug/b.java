package com.instabug.bug;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.reactivex.functions.Consumer;

class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f45621b;

    public b(c cVar) {
        this.f45621b = cVar;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals("sdk_state") && sDKCoreEvent.getValue().equals("built")) {
            h.b(this.f45621b.f45622b.f45596a);
        }
    }
}
