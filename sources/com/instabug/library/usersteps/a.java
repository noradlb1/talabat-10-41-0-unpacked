package com.instabug.library.usersteps;

import com.instabug.library.tracking.ActivityLifeCycleEvent;
import io.reactivex.functions.Consumer;

class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f51998b;

    public a(g gVar) {
        this.f51998b = gVar;
    }

    /* renamed from: a */
    public void accept(ActivityLifeCycleEvent activityLifeCycleEvent) {
        if (activityLifeCycleEvent == ActivityLifeCycleEvent.RESUMED) {
            this.f51998b.c();
        } else if (activityLifeCycleEvent == ActivityLifeCycleEvent.DESTROYED) {
            this.f51998b.a();
        }
    }
}
