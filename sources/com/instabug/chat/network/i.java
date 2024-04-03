package com.instabug.chat.network;

import com.instabug.chat.network.service.g;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.request.Request;

public class i extends InstabugNetworkJob {

    /* renamed from: a  reason: collision with root package name */
    private static i f46092a;

    private i() {
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f46092a == null) {
                f46092a = new i();
            }
            iVar = f46092a;
        }
        return iVar;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!InstabugCore.isPushNotificationTokenSent()) {
            g.a().a(InstabugCore.getPushNotificationToken(), (Request.Callbacks) new h(this));
        }
    }

    public synchronized void start() {
        b("InstabugPushNotificationTokenService", new g(this));
    }
}
