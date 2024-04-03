package com.instabug.bug;

import com.instabug.bug.BugReporting;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugReporting.b f45622b;

    public c(BugReporting.b bVar) {
        this.f45622b = bVar;
    }

    public void run() {
        if (Instabug.isBuilding()) {
            SDKCoreEventSubscriber.subscribe(new b(this));
        } else {
            h.b(this.f45622b.f45596a);
        }
    }
}
