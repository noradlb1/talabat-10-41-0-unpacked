package com.iab.omid.library.deliveryhero3.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

public class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44957a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44958b;

    /* renamed from: c  reason: collision with root package name */
    private a f44959c;

    public interface a {
        void a(boolean z11);
    }

    private void a(boolean z11) {
        if (this.f44958b != z11) {
            this.f44958b = z11;
            if (this.f44957a) {
                b(z11);
                a aVar = this.f44959c;
                if (aVar != null) {
                    aVar.a(z11);
                }
            }
        }
    }

    private boolean a() {
        return (b().importance == 100) || d();
    }

    public void a(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void a(a aVar) {
        this.f44959c = aVar;
    }

    @VisibleForTesting
    public ActivityManager.RunningAppProcessInfo b() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public void b(boolean z11) {
    }

    public boolean c() {
        return this.f44958b;
    }

    public boolean d() {
        return false;
    }

    public void e() {
        this.f44957a = true;
        boolean a11 = a();
        this.f44958b = a11;
        b(a11);
    }

    public void f() {
        this.f44957a = false;
        this.f44959c = null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        a(true);
    }

    public void onActivityStopped(Activity activity) {
        a(a());
    }
}
