package com.instabug.library.logging.disklogs;

import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.model.h;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51466c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f51467d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f51468e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f51469f;

    public c(f fVar, String str, String str2, String str3, long j11) {
        this.f51469f = fVar;
        this.f51465b = str;
        this.f51466c = str2;
        this.f51467d = str3;
        this.f51468e = j11;
    }

    public void run() {
        h b11;
        if (InstabugStateProvider.getInstance().getState() != InstabugState.DISABLED && (b11 = this.f51469f.f51475b.b()) != null && b11.d() == 2 && this.f51469f.f51474a != null) {
            this.f51469f.f51474a.a(this.f51465b, this.f51466c, this.f51467d, this.f51468e);
        }
    }
}
