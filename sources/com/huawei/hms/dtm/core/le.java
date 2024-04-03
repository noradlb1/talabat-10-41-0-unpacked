package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.ne;
import okhttp3.WebSocket;

public class le implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ne.a f48514a;

    public le(ne.a aVar) {
        this.f48514a = aVar;
    }

    public void run() {
        WebSocket unused = ne.this.f48532c = null;
        ne.this.f48530a.a();
    }
}
