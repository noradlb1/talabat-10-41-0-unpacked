package com.instabug.apm;

import android.app.Activity;
import android.os.Looper;
import com.instabug.apm.handler.uitrace.customuitraces.a;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Looper f45356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f45357c;

    public g(h hVar, Looper looper) {
        this.f45357c = hVar;
        this.f45356b = looper;
    }

    public void run() {
        a s11 = com.instabug.apm.di.a.s();
        if (s11.a() != null) {
            Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                s11.a(currentActivity, this.f45356b);
                return;
            }
            return;
        }
        this.f45357c.f45358a.e("Custom UI Trace wasn't ended. Please make sure to start a UI Trace first by following the instructions at this link: https://docs.instabug.com/reference#start-ui-trace");
    }
}
