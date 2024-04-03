package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.dtm.core.f  reason: case insensitive filesystem */
public class C0367f implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private Handler f48478a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f48479b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f48480c;

    public C0367f(Activity activity) {
        this.f48479b = new WeakReference<>(activity);
    }

    private void c() {
        be.b(b());
        if (C0402m.b().d()) {
            C0362e eVar = new C0362e(this);
            Runnable runnable = this.f48480c;
            if (runnable != null) {
                this.f48478a.removeCallbacks(runnable);
            }
            this.f48480c = eVar;
            this.f48478a.postDelayed(eVar, 500);
        }
    }

    public void a() {
        Handler handler = this.f48478a;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f48478a = null;
        }
        this.f48480c = null;
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.f48479b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void onGlobalLayout() {
        c();
    }

    public void onScrollChanged() {
        c();
    }
}
