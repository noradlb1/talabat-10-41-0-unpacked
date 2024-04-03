package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.dtm.core.util.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.dtm.core.k  reason: case insensitive filesystem */
public class C0392k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f48501a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f48502b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f48503c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<Activity> f48504d;

    /* renamed from: e  reason: collision with root package name */
    private C0397l f48505e;

    /* renamed from: com.huawei.hms.dtm.core.k$a */
    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final C0392k f48506a = new C0392k();
    }

    private C0392k() {
        this.f48501a = new AtomicInteger(3);
    }

    public static C0392k c() {
        return a.f48506a;
    }

    private void d() {
        Activity activity;
        if (this.f48505e != null && (activity = this.f48504d.get()) != null && !activity.isFinishing()) {
            this.f48505e.a(this.f48504d);
        }
    }

    private void e() {
        Activity activity;
        View findViewById;
        WeakReference<Activity> weakReference = this.f48504d;
        if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing() && (findViewById = activity.findViewById(16908290)) != null) {
            Logger.debug("DTM-AutoTrace", "setClickListener in Thread:" + Thread.currentThread().getName());
            C0412o.a(activity, findViewById);
        }
    }

    public C0392k a(int i11) {
        if (this.f48501a == null) {
            this.f48501a = new AtomicInteger();
        }
        this.f48501a.set(i11);
        return this;
    }

    public C0392k a(Activity activity) {
        this.f48504d = new WeakReference<>(activity);
        return this;
    }

    public void a() {
        this.f48501a.set(0);
        Handler handler = this.f48503c;
        if (handler != null) {
            handler.removeCallbacks(this);
            this.f48503c = null;
        }
        HandlerThread handlerThread = this.f48502b;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f48502b = null;
        }
    }

    public void a(C0397l lVar) {
        this.f48505e = lVar;
    }

    public void b() {
        if (this.f48502b == null) {
            HandlerThread handlerThread = new HandlerThread("DTM-XPath");
            this.f48502b = handlerThread;
            handlerThread.start();
        }
        if (this.f48503c == null) {
            this.f48503c = new Handler(this.f48502b.getLooper());
        }
        this.f48503c.removeCallbacks(this);
        this.f48503c.postDelayed(this, 100);
    }

    public void run() {
        try {
            if (this.f48501a.decrementAndGet() >= 0) {
                e();
                Ed.d().c();
                d();
                Handler handler = this.f48503c;
                if (handler != null) {
                    handler.postDelayed(this, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
            }
        } catch (Throwable th2) {
            Logger.warn("DTM-AutoTrace", "Exception in ViewTreeTask#" + th2.getClass().getSimpleName());
            C0381hd.a().a(th2, "ViewTreeTask");
        }
    }
}
