package com.instabug.library.invocation.invoker;

import android.os.Handler;
import android.os.Looper;

class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f51351a;

    /* renamed from: b  reason: collision with root package name */
    private float f51352b;

    /* renamed from: c  reason: collision with root package name */
    private float f51353c;

    /* renamed from: d  reason: collision with root package name */
    private long f51354d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f51355e;

    private m(n nVar) {
        this.f51355e = nVar;
        this.f51351a = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void a(float f11, float f12) {
        this.f51352b = f11;
        this.f51353c = f12;
        this.f51354d = System.currentTimeMillis();
        this.f51351a.post(this);
    }

    public void run() {
        if (this.f51355e.getParent() != null) {
            float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f51354d)) / 400.0f);
            n nVar = this.f51355e;
            nVar.m((int) (((float) nVar.B.f51364c) + ((this.f51352b - ((float) this.f51355e.B.f51364c)) * min)), (int) (((float) this.f51355e.B.f51365d) + ((this.f51353c - ((float) this.f51355e.B.f51365d)) * min)));
            if (min < 1.0f) {
                this.f51351a.post(this);
            }
        }
    }

    public /* synthetic */ m(n nVar, d dVar) {
        this(nVar);
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f51351a.removeCallbacks(this);
    }
}
