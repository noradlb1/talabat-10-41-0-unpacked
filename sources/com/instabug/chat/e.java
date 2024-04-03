package com.instabug.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.chat.cache.d;
import com.instabug.chat.cache.k;
import com.instabug.chat.settings.a;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.util.threading.PoolProvider;

abstract class e {
    private static void a() {
        a.a(0);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private static void a(Context context) {
        d.a(context);
        SynchronizationManager.getInstance().sync();
        c.f();
    }

    private static void b() {
        k.j();
    }

    public static void b(Context context, SDKCoreEvent sDKCoreEvent) {
        if (h()) {
            String type = sDKCoreEvent.getType();
            type.hashCode();
            char c11 = 65535;
            switch (type.hashCode()) {
                case -528004907:
                    if (type.equals("encryption_state")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3599307:
                    if (type.equals("user")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1738700944:
                    if (type.equals(SDKCoreEvent.Invocation.TYPE_INVOCATION)) {
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
                case 1984987798:
                    if (type.equals(SDKCoreEvent.Session.TYPE_SESSION)) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    b();
                    return;
                case 1:
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_IN)) {
                        f();
                    }
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
                        g();
                        return;
                    }
                    return;
                case 2:
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Invocation.VALUE_INVOKED)) {
                        d();
                        return;
                    }
                    return;
                case 3:
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                        c();
                        return;
                    }
                    return;
                case 4:
                    if (sDKCoreEvent.getValue().equals("started")) {
                        a(context);
                    }
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Session.VALUE_FINISHED)) {
                        e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private static void c() {
        d.b();
        i();
        SynchronizationManager.getInstance().sync();
    }

    private static void d() {
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private static void e() {
        d.b();
        i();
        SynchronizationManager.getInstance().stop();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    private static void f() {
        SynchronizationManager.getInstance().sync();
    }

    private static void g() {
        a();
    }

    private static boolean h() {
        return InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == Feature.State.ENABLED;
    }

    private static void i() {
        PoolProvider.postIOTask(new d());
    }
}
