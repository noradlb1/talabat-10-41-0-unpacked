package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.c;
import com.huawei.hms.dtm.core.util.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.dtm.core.c  reason: case insensitive filesystem */
public final class C0352c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f48452a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static b f48453b;

    /* renamed from: com.huawei.hms.dtm.core.c$a */
    public static class a implements ComponentCallbacks2 {
        private a() {
        }

        public /* synthetic */ a(C0347b bVar) {
            this();
        }

        public void onConfigurationChanged(Configuration configuration) {
            C0402m.b().e();
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i11) {
        }
    }

    /* renamed from: com.huawei.hms.dtm.core.c$b */
    public static class b implements Application.ActivityLifecycleCallbacks {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final AtomicBoolean f48454a;

        private b() {
            this.f48454a = new AtomicBoolean(false);
        }

        public /* synthetic */ b(C0347b bVar) {
            this();
        }

        private void a() {
            C0402m.b().e();
            C0392k.c().a((C0397l) new C0357d(this));
        }

        /* access modifiers changed from: private */
        public void a(Activity activity) {
            View findViewById;
            ViewTreeObserver viewTreeObserver;
            C0367f b11;
            if (activity != null && (findViewById = activity.findViewById(16908290)) != null && (viewTreeObserver = findViewById.getViewTreeObserver()) != null && viewTreeObserver.isAlive() && (b11 = C0382i.a().b(activity.getClass().getCanonicalName())) != null) {
                b11.a();
                viewTreeObserver.removeOnGlobalLayoutListener(b11);
                viewTreeObserver.removeOnScrollChangedListener(b11);
            }
        }

        private void a(Activity activity, View view) {
            a(activity);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                C0367f fVar = new C0367f(activity);
                C0382i.a().a(activity.getClass().getCanonicalName(), fVar);
                viewTreeObserver.addOnGlobalLayoutListener(fVar);
                viewTreeObserver.addOnScrollChangedListener(fVar);
                fVar.onGlobalLayout();
            }
        }

        /* access modifiers changed from: private */
        public void a(WeakReference<Activity> weakReference) {
            a(weakReference, "$DTM_AT_ENTER");
        }

        private void a(WeakReference<Activity> weakReference, String str) {
            Bundle bundle = new Bundle();
            Activity activity = weakReference.get();
            if (activity != null) {
                bundle.putString("$DTM_AT_TARGET", activity.getClass().getName());
                bundle.putLong("$DTM_AT_TIME", System.currentTimeMillis());
                bundle.putString("$DTM_AT_TYPE", str);
                C0417p.a(weakReference, bundle, activity.getClass().getName(), str);
            }
        }

        private boolean a(View view) {
            return DynamicTagManager.getInstance().getWebPages().size() > 0 && f.h(view);
        }

        private void b(View view) {
            for (WebView b11 : f.g(view)) {
                _d.b().b(b11);
            }
        }

        private void b(WeakReference<Activity> weakReference) {
            a(weakReference, "$DTM_AT_EXIT");
        }

        private boolean b(Activity activity) {
            if (DynamicTagManager.getInstance().isVisualPage(activity.getClass().getName()) || Ed.d().f()) {
                return true;
            }
            Logger.info("DTM-AutoTrace", "no visual point");
            return false;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            c.a().a(activity, true);
        }

        public void onActivityDestroyed(Activity activity) {
            c.a().a(activity);
        }

        public void onActivityPaused(Activity activity) {
            try {
                c.a().b(activity, false);
                this.f48454a.set(false);
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    boolean a11 = a(findViewById);
                    if (a11) {
                        b(findViewById);
                    }
                    _d.b().c();
                    be.a(activity);
                    if (b(activity) || a11) {
                        b((WeakReference<Activity>) new WeakReference(activity));
                        Ed.d().b(activity);
                        C0392k.c().a();
                        a(activity);
                    }
                }
            } catch (Throwable th2) {
                Logger.error("DTM-AutoTrace", "onActivityPaused#" + th2.getClass().getSimpleName());
                C0381hd.a().a(th2, "onActivityPaused");
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                c.a().b(activity, true);
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    if (b(activity) || a(findViewById)) {
                        C0412o.a(activity, findViewById);
                        _d.b().a(findViewById, activity);
                        a();
                        a(activity, findViewById);
                        Ed.d().c(activity);
                    }
                }
            } catch (Throwable th2) {
                Logger.error("DTM-AutoTrace", "onActivityResumed#" + th2.getClass().getSimpleName());
                C0381hd.a().a(th2, "onActivityResumed");
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Activity activity) {
        b bVar;
        Logger.info("DTM-AutoTrace", "AutoTraceProxy#activityConnected:" + activity.getClass().getName());
        if (f48452a && (bVar = f48453b) != null) {
            bVar.onActivityResumed(activity);
        }
    }

    public static synchronized void a(Context context) {
        synchronized (C0352c.class) {
            if (f48452a) {
                Logger.info("DTM-AutoTrace", "AutoTraceProxy#already initialized");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                Application application = (Application) applicationContext;
                b bVar = new b((C0347b) null);
                f48453b = bVar;
                application.registerActivityLifecycleCallbacks(bVar);
                application.registerComponentCallbacks(new a((C0347b) null));
                Activity b11 = c.a().b();
                if (b11 != null) {
                    b11.runOnUiThread(new C0347b(b11));
                }
                f48452a = true;
                Logger.info("DTM-AutoTrace", "AutoTraceProxy#init success");
            }
        }
    }

    public static void b(Activity activity) {
        b bVar;
        Logger.info("DTM-AutoTrace", "AutoTraceProxy#activityDisConnected:" + activity.getClass().getName());
        if (f48452a && (bVar = f48453b) != null) {
            bVar.a(activity);
        }
    }
}
