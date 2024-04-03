package com.instabug.apm.handler.session;

class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f45393b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f45394c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f45395d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j f45396e;

    public f(j jVar, String str, long j11, int i11) {
        this.f45396e = jVar;
        this.f45393b = str;
        this.f45394c = j11;
        this.f45395d = i11;
    }

    public void run() {
        this.f45396e.f45403c.a(this.f45393b, this.f45394c, this.f45395d);
    }
}
