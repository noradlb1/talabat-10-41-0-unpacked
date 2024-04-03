package com.huawei.hms.dtm.core.report;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f48559a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f48560b;

    public d(f fVar, boolean z11) {
        this.f48560b = fVar;
        this.f48559a = z11;
    }

    public void run() {
        boolean unused = this.f48560b.f48563b = !this.f48559a;
        if (this.f48559a) {
            this.f48560b.f48565d.removeCallbacks(this.f48560b.f48566e);
        } else if (!this.f48560b.f48565d.hasCallbacks(this.f48560b.f48566e) && this.f48560b.f48564c) {
            this.f48560b.f48565d.postDelayed(this.f48560b.f48566e, 60000);
        }
    }
}
