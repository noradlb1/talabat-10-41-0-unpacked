package com.instabug.library.networkv2.service.userattributes;

import com.instabug.library.networkv2.request.Request;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Request f51696b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51697c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f51698d;

    public c(e eVar, Request request, Request.Callbacks callbacks) {
        this.f51698d = eVar;
        this.f51696b = request;
        this.f51697c = callbacks;
    }

    public void run() {
        this.f51698d.c(this.f51696b, this.f51697c);
    }
}
