package com.instabug.library.networkv2.service;

import com.instabug.library.networkv2.request.Request;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f51677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51678c;

    public /* synthetic */ h(a aVar, Request.Callbacks callbacks) {
        this.f51677b = aVar;
        this.f51678c = callbacks;
    }

    public final void run() {
        this.f51677b.a(this.f51678c);
    }
}
