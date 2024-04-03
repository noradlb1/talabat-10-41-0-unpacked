package com.instabug.bug;

import android.content.Context;
import com.instabug.bug.di.a;
import com.instabug.bug.settings.b;
import com.instabug.bug.view.actionList.service.d;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class i {
    private static void a() {
        b.f().a(0);
        b.f().c((String) null);
    }

    private static void a(Context context) {
        a.b().a(context);
    }

    public static void a(Context context, SDKCoreEvent sDKCoreEvent) {
        InstabugSDKLogger.v("IBG-BR", "receive new core event: " + sDKCoreEvent.toString());
        String type = sDKCoreEvent.getType();
        type.hashCode();
        char c11 = 65535;
        switch (type.hashCode()) {
            case -376724013:
                if (type.equals("sdk_version")) {
                    c11 = 0;
                    break;
                }
                break;
            case -296668708:
                if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
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
            case 1710713462:
                if (type.equals("db_encryption_state")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1738700944:
                if (type.equals(SDKCoreEvent.Invocation.TYPE_INVOCATION)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1843485230:
                if (type.equals(SDKCoreEvent.Network.TYPE_NETWORK)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1984987798:
                if (type.equals(SDKCoreEvent.Session.TYPE_SESSION)) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (sDKCoreEvent.getValue().equals("sdk_version_changed")) {
                    a(context);
                    return;
                }
                return;
            case 1:
                a(sDKCoreEvent.getValue());
                return;
            case 2:
                if (sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
                    d();
                    return;
                }
                return;
            case 3:
                a.b().a(context, sDKCoreEvent.getValue());
                return;
            case 4:
                if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Invocation.VALUE_INVOKED)) {
                    b();
                    return;
                }
                return;
            case 5:
                if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                    g();
                    return;
                }
                return;
            case 6:
                if (sDKCoreEvent.getValue().equals("started")) {
                    d.c().start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void a(String str) {
        a.d().a(str);
    }

    private static void b() {
    }

    public static void c() {
        InstabugSDKLogger.d("IBG-BR", "SDK dismissed Handle sdk dismissing");
        f();
        e();
    }

    private static void d() {
        a();
    }

    private static void e() {
        n.e().i();
    }

    private static void f() {
        if (b.f().h() != null && n.e().c() != null && n.e().d() != null) {
            b.f().h().call(t.a(n.e().d()), t.a(n.e().c().i()));
        }
    }

    private static void g() {
        com.instabug.bug.network.i.b().start();
    }
}
