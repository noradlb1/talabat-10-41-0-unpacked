package com.instabug.library.logging.disklogs;

import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.model.h;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51460b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51461c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f51462d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f51463e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f51464f;

    public b(f fVar, String str, String str2, String str3, long j11) {
        this.f51464f = fVar;
        this.f51460b = str;
        this.f51461c = str2;
        this.f51462d = str3;
        this.f51463e = j11;
    }

    public void run() {
        h b11;
        if (InstabugStateProvider.getInstance().getState() != InstabugState.DISABLED && (b11 = this.f51464f.f51475b.b()) != null && b11.d() != 0 && this.f51464f.f51474a != null) {
            this.f51464f.f51474a.a(this.f51460b, this.f51461c, this.f51462d, this.f51463e);
        }
    }
}
