package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.ne;
import okhttp3.WebSocket;

public class me implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ne.a f48521a;

    public me(ne.a aVar) {
        this.f48521a = aVar;
    }

    public void run() {
        if (ne.this.f48532c != null) {
            WebSocket unused = ne.this.f48532c = null;
            ne.this.f48530a.c();
        }
    }
}
