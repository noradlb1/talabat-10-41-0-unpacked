package com.instabug.library.internal.video.customencoding;

class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f51157b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f51158c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f51159d;

    public h(k kVar, g gVar, Exception exc) {
        this.f51159d = kVar;
        this.f51157b = gVar;
        this.f51158c = exc;
    }

    public void run() {
        if (this.f51159d.f51167a != null) {
            this.f51159d.f51167a.a(this.f51157b, this.f51158c);
        }
    }
}
