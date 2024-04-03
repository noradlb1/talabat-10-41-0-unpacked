package com.instabug.library;

import com.instabug.library.tracking.ActivityLifeCycleEvent;
import io.reactivex.functions.Consumer;

class p0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0 f50585b;

    public p0(r0 r0Var) {
        this.f50585b = r0Var;
    }

    /* renamed from: a */
    public void accept(ActivityLifeCycleEvent activityLifeCycleEvent) {
        int i11 = q0.f50587a[activityLifeCycleEvent.ordinal()];
        if (i11 == 1) {
            this.f50585b.h();
        } else if (i11 == 2) {
            this.f50585b.i();
        }
    }
}
