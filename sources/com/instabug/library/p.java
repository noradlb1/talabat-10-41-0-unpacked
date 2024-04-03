package com.instabug.library;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.diagnostics.nonfatals.di.a;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.sessionV3.di.c;
import com.instabug.library.sessionV3.sync.SessionBatchingFilterKt;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.functions.Consumer;

class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50584b;

    public p(c0 c0Var) {
        this.f50584b = c0Var;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f50584b.f50535c.d().a().g();
        c.u().a(SessionBatchingFilterKt.getDataReadinessFilter());
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        e g11;
        String type = sDKCoreEvent.getType();
        type.hashCode();
        boolean z11 = true;
        char c11 = 65535;
        switch (type.hashCode()) {
            case -376724013:
                if (type.equals("sdk_version")) {
                    c11 = 0;
                    break;
                }
                break;
            case -290659267:
                if (type.equals("features")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3599307:
                if (type.equals("user")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1843485230:
                if (type.equals(SDKCoreEvent.Network.TYPE_NETWORK)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (sDKCoreEvent.getValue().equals("sdk_version_changed") && (g11 = a.g()) != null) {
                    g11.clearCache();
                    break;
                }
            case 1:
                if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Feature.VALUE_FETCHED) && InstabugCore.getRunningSession() != null) {
                    this.f50584b.L();
                    if (!this.f50584b.f50547o) {
                        this.f50584b.f50546n.a();
                        boolean unused = this.f50584b.f50547o = true;
                    }
                }
                if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Feature.VALUE_FETCHED) || sDKCoreEvent.getValue().equals(SDKCoreEvent.Feature.VALUE_UPDATED)) {
                    e g12 = a.g();
                    if (SettingsManager.getInstance().getFeatureState(Feature.NON_FATAL_ERRORS, false) != Feature.State.ENABLED) {
                        z11 = false;
                    }
                    if (!z11 && g12 != null) {
                        g12.clearCache();
                        break;
                    }
                }
            case 2:
                break;
            case 3:
                if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                    this.f50584b.C();
                    if (InstabugCore.getRunningSession() != null) {
                        PoolProvider.postIOTask(new t0(this));
                        break;
                    }
                }
                break;
        }
        if (sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
            PoolProvider.postIOTask(new u0(this));
        }
        this.f50584b.f50548p.a(sDKCoreEvent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f50584b.f50546n.a();
    }
}
