package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.ne;
import okhttp3.WebSocket;

public class ie implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebSocket f48495a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ne.a f48496b;

    public ie(ne.a aVar, WebSocket webSocket) {
        this.f48496b = aVar;
        this.f48495a = webSocket;
    }

    public void run() {
        WebSocket unused = ne.this.f48532c = this.f48495a;
        String unused2 = ne.this.f48534e = null;
        ne.this.f48530a.onConnected();
    }
}
