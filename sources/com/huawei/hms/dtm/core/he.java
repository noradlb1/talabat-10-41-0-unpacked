package com.huawei.hms.dtm.core;

public class he implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ne f48491a;

    public he(ne neVar) {
        this.f48491a = neVar;
    }

    public void run() {
        if (this.f48491a.f48532c != null) {
            this.f48491a.f48532c.close(4000, "disconnect WebSocket");
        }
    }
}
