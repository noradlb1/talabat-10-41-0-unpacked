package com.instabug.library.invocation.invoker;

import com.instabug.library.tracking.ActivityLifeCycleEvent;
import io.reactivex.functions.Consumer;

class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f51348b;

    public k(p pVar) {
        this.f51348b = pVar;
    }

    /* renamed from: a */
    public void accept(ActivityLifeCycleEvent activityLifeCycleEvent) {
        int i11 = c.f51338b[activityLifeCycleEvent.ordinal()];
        if (i11 == 1) {
            this.f51348b.f();
        } else if (i11 == 2) {
            this.f51348b.e();
        }
    }
}
