package com.instabug.library;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50567b;

    public h(c0 c0Var) {
        this.f50567b = c0Var;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        InstabugSDKLogger.d("IBG-Core", "stopSdk Subscriber received sdkCoreEvent " + sDKCoreEvent.getValue());
        if (sDKCoreEvent.getType().equals("sdk_state") && sDKCoreEvent.getValue().equals("built")) {
            this.f50567b.K();
        }
    }
}
