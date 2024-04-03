package com.huawei.wearengine;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f35177c;

    public e(d dVar, int i11) {
        this.f35177c = dVar;
        this.f35176b = i11;
    }

    public void run() {
        int i11 = this.f35176b;
        if (i11 == 1) {
            this.f35177c.f35144d.onServiceConnect();
        } else if (i11 == 2) {
            this.f35177c.f35144d.onServiceDisconnect();
        }
    }
}
