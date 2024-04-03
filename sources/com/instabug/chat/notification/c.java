package com.instabug.chat.notification;

import com.instabug.library.tracking.ActivityLifeCycleEvent;
import io.reactivex.functions.Consumer;

class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f46107b;

    public c(s sVar) {
        this.f46107b = sVar;
    }

    /* renamed from: a */
    public void accept(ActivityLifeCycleEvent activityLifeCycleEvent) {
        int i11 = d.f46108a[activityLifeCycleEvent.ordinal()];
        if (i11 == 1) {
            this.f46107b.d();
        } else if (i11 == 2) {
            this.f46107b.c();
        }
    }
}
