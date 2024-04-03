package com.huawei.hms.dtm.core.report;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f48557a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f48558b;

    public c(f fVar, boolean z11) {
        this.f48558b = fVar;
        this.f48557a = z11;
    }

    public void run() {
        boolean unused = this.f48558b.f48564c = this.f48557a;
        if (this.f48558b.f48564c && this.f48558b.f48563b) {
            this.f48558b.b();
        }
        this.f48558b.f48565d.removeCallbacks(this.f48558b.f48566e);
    }
}
