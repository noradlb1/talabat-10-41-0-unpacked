package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.c;
import com.huawei.hms.dtm.core.util.f;
import com.huawei.hms.dtm.core.util.g;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public class Rd implements Bd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Handler f48403a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Runnable f48404b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final de f48405c;

    public static class a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f48406a;

        private a() {
            this.f48406a = null;
        }

        public /* synthetic */ a(Nd nd2) {
            this();
        }

        private String a(Activity activity) {
            Window window = activity.getWindow();
            if (window == null) {
                return "";
            }
            a(window.getDecorView());
            return g.a(this.f48406a);
        }

        private void a(View view) {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            try {
                Ed.d().a(4);
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache != null) {
                    this.f48406a = Rd.b(drawingCache);
                    Ed.d().a(0);
                    if (!isDrawingCacheEnabled) {
                        view.setDrawingCacheEnabled(false);
                    }
                }
            } finally {
                Ed.d().a(0);
                if (!isDrawingCacheEnabled) {
                    view.setDrawingCacheEnabled(false);
                }
            }
        }

        public String call() {
            Logger.debug("DTM-AutoTrace", "screenShot in Thread:" + Thread.currentThread().getName());
            Activity b11 = c.a().b();
            if (b11 == null || b11.isFinishing()) {
                return null;
            }
            return a(b11);
        }
    }

    @Instrumented
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Kd f48407a;

        private b() {
        }

        public /* synthetic */ b(Rd rd2, Nd nd2) {
            this();
        }

        private String a() {
            FutureTask futureTask = new FutureTask(new a((Nd) null));
            if (Rd.this.f48403a == null) {
                Handler unused = Rd.this.f48403a = new Handler(Looper.getMainLooper());
            }
            Rd.this.f48403a.post(futureTask);
            try {
                return (String) futureTask.get(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e11) {
                Logger.warn("DTM-AutoTrace", "Exception in getScreenShot#" + e11.getClass().getSimpleName());
                return null;
            }
        }

        private void a(Activity activity, Kd kd2) {
            View rootView;
            Window window = activity.getWindow();
            if (window != null && (rootView = window.getDecorView().getRootView()) != null) {
                Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
                if (Build.VERSION.SDK_INT >= 26) {
                    PixelCopy.request(window, createBitmap, new Sd(this, createBitmap, kd2), new Handler());
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(String str, Kd kd2) {
            if (!TextUtils.isEmpty(str)) {
                kd2.a("data:image/png;base64," + str);
                if (!kd2.equals(this.f48407a)) {
                    de a11 = Rd.this.f48405c;
                    JSONObject a12 = kd2.a();
                    a11.send(!(a12 instanceof JSONObject) ? a12.toString() : JSONObjectInstrumentation.toString(a12));
                    this.f48407a = kd2;
                }
            }
        }

        public void run() {
            try {
                Activity b11 = c.a().b();
                if (b11 != null) {
                    if (!b11.isFinishing()) {
                        if (!f.c(b11)) {
                            Cd.a().a(b11);
                            Kd a11 = Jd.a(b11);
                            if (a11 != null) {
                                if (!f.b(b11) || Build.VERSION.SDK_INT < 26) {
                                    a(a(), a11);
                                } else {
                                    a(b11, a11);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                Cd.a().b();
                throw th2;
            }
            Cd.a().b();
        }
    }

    public Rd(de deVar) {
        this.f48405c = deVar;
    }

    /* access modifiers changed from: private */
    public static Bitmap b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float f11 = 1.0f / Resources.getSystem().getDisplayMetrics().density;
        Bitmap createBitmap = Bitmap.createBitmap((int) (((float) bitmap.getWidth()) * f11), (int) (((float) bitmap.getHeight()) * f11), bitmap.getConfig());
        Matrix matrix = new Matrix();
        matrix.setScale(f11, f11);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint(2));
        return createBitmap;
    }

    private void d() {
        if (this.f48404b == null) {
            this.f48404b = new b(this, (Nd) null);
        }
        this.f48404b.run();
    }

    public void a() {
        Logger.warn("DTM-AutoTrace", "ConnectedState#onFailure");
        c();
    }

    public void b() {
        d();
    }

    public void c() {
        Logger.warn("DTM-AutoTrace", "ConnectedState#onDisconnected");
        Ed.d().b(false);
        Activity b11 = c.a().b();
        if (b11 != null) {
            b11.runOnUiThread(new Pd(this, b11));
        }
    }

    public void onActivityPaused(Activity activity) {
        activity.runOnUiThread(new Od(this));
    }

    public void onActivityResumed(Activity activity) {
        activity.runOnUiThread(new Nd(this, activity));
    }

    public void onConnected() {
        Logger.warn("DTM-AutoTrace", "ConnectedState#onConnected");
        Ed.d().b(true);
        C0352c.a(J.a());
        Activity b11 = c.a().b();
        if (b11 != null) {
            b11.runOnUiThread(new Qd(this, b11));
        }
    }
}
