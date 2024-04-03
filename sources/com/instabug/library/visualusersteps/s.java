package com.instabug.library.visualusersteps;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.functions.Consumer;

class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ y f52184b;

    public s(y yVar) {
        this.f52184b = yVar;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals(SDKCoreEvent.Session.TYPE_SESSION)) {
            String value = sDKCoreEvent.getValue();
            value.hashCode();
            if (value.equals("started")) {
                this.f52184b.i();
            } else if (value.equals(SDKCoreEvent.Session.VALUE_FINISHED) && !SettingsManager.getInstance().isCrashedSession()) {
                this.f52184b.h();
                PoolProvider.getSingleThreadExecutor("steps-executor").execute(new a0(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f52184b.p();
    }
}
