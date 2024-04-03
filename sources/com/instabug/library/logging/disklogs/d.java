package com.instabug.library.logging.disklogs;

import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.model.g;
import com.instabug.library.model.h;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f51470b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f51471c;

    public d(f fVar, g gVar) {
        this.f51471c = fVar;
        this.f51470b = gVar;
    }

    public void run() {
        h b11;
        if (InstabugStateProvider.getInstance().getState() != InstabugState.DISABLED && (b11 = this.f51471c.f51475b.b()) != null && b11.d() != 0 && this.f51471c.f51474a != null) {
            this.f51471c.f51474a.a(this.f51470b);
        }
    }
}
