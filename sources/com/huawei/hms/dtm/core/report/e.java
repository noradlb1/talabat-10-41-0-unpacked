package com.huawei.hms.dtm.core.report;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f48561a;

    public e(f fVar) {
        this.f48561a = fVar;
    }

    public void run() {
        if (this.f48561a.f48564c) {
            this.f48561a.b();
        }
        this.f48561a.f48565d.removeCallbacks(this.f48561a.f48566e);
    }
}
