package com.instabug.library.logging.disklogs;

import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.model.h;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f51472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f51473c;

    public e(f fVar, long j11) {
        this.f51473c = fVar;
        this.f51472b = j11;
    }

    public void run() {
        h b11;
        if (InstabugStateProvider.getInstance().getState() != InstabugState.DISABLED && (b11 = this.f51473c.f51475b.b()) != null && b11.d() != 0 && this.f51473c.f51474a != null) {
            this.f51473c.f51474a.a(this.f51472b);
        }
    }
}
