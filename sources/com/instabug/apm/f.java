package com.instabug.apm;

import android.app.Activity;
import android.os.Looper;
import com.instabug.apm.configuration.c;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f45303b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Looper f45304c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h f45305d;

    public f(h hVar, String str, Looper looper) {
        this.f45305d = hVar;
        this.f45303b = str;
        this.f45304c = looper;
    }

    public void run() {
        a a11;
        String str;
        String str2;
        String str3 = this.f45303b;
        if (str3 == null || str3.trim().isEmpty()) {
            this.f45305d.f45358a.e("Custom UI Trace wasn't created. Trace name can't be empty or null.");
        } else if (this.f45304c != Looper.getMainLooper()) {
            this.f45305d.f45358a.b("Custom UI Trace \"$name\" wasn't started as it was called from a non-main thread. Please make sure to start Custom UI Traces from the main thread.".replace("$name", this.f45303b));
        } else {
            c c11 = com.instabug.apm.di.a.c();
            if (!c11.H()) {
                a11 = this.f45305d.f45358a;
                str = this.f45303b;
                str2 = "Custom UI Trace \"$s\" wasn't started. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
            } else if (!c11.C()) {
                a11 = this.f45305d.f45358a;
                str = this.f45303b;
                str2 = "Custom UI Trace \"$s\" wasn't started as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
            } else {
                String trim = this.f45303b.trim();
                if (trim.length() > 150) {
                    trim = trim.substring(0, 150);
                    this.f45305d.f45358a.i("Custom UI Trace \"$s\" was truncated as it was too long. Please limit trace names to 150 characters.".replace("$s", this.f45303b));
                }
                Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
                if (currentActivity != null) {
                    com.instabug.apm.di.a.s().a(trim, currentActivity, this.f45304c);
                    return;
                }
                return;
            }
            a11.b(str2.replace("$s", str));
        }
    }
}
