package com.instabug.library.tracking;

import android.os.SystemClock;
import com.instabug.library.PresentationManager;
import com.instabug.library._InstabugActivity;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f51921b;

    public d(e eVar) {
        this.f51921b = eVar;
    }

    public void run() {
        InstabugInternalTrackingDelegate.getInstance().d(this.f51921b.f51922b);
        if (SystemClock.elapsedRealtime() - this.f51921b.f51923c.f51925b >= 300) {
            if (PresentationManager.getInstance().getCurrentActivityName().equalsIgnoreCase(this.f51921b.f51922b.getLocalClassName()) && this.f51921b.f51923c.f51924a) {
                long unused = this.f51921b.f51923c.f51925b = SystemClock.elapsedRealtime();
            }
            PresentationManager.getInstance().setCurrentActivity(this.f51921b.f51922b);
            if (this.f51921b.f51923c.f51924a) {
                boolean unused2 = this.f51921b.f51923c.f51924a = false;
            } else if (!(this.f51921b.f51922b instanceof _InstabugActivity)) {
                PresentationManager.getInstance().notifyActivityChanged();
            }
        }
    }
}
