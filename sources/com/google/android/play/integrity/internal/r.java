package com.google.android.play.integrity.internal;

import android.os.IBinder;

final class r extends l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f44585a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u f44586b;

    public r(u uVar, IBinder iBinder) {
        this.f44586b = uVar;
        this.f44585a = iBinder;
    }

    public final void b() {
        this.f44586b.f44588a.f44602n = g.b(this.f44585a);
        v.n(this.f44586b.f44588a);
        this.f44586b.f44588a.f44596h = false;
        for (Runnable run : this.f44586b.f44588a.f44593e) {
            run.run();
        }
        this.f44586b.f44588a.f44593e.clear();
    }
}
