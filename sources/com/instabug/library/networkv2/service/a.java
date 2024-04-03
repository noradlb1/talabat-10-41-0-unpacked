package com.instabug.library.networkv2.service;

import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.threading.PoolProvider;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f51662c;

    public a(c cVar, Request.Callbacks callbacks) {
        this.f51662c = cVar;
        this.f51661b = callbacks;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Request.Callbacks callbacks) {
        this.f51662c.a(callbacks);
    }

    public void run() {
        PoolProvider.postIOTask(new h(this, this.f51661b));
    }
}
