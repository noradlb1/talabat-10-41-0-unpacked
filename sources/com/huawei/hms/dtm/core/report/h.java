package com.huawei.hms.dtm.core.report;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.dtm.core.util.Logger;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static Application f48572a;

    /* renamed from: b  reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f48573b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f48574c;

    public static class a implements Application.ActivityLifecycleCallbacks {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f48575a = true;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f48576b = false;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f48577c = new Handler(Looper.getMainLooper());

        /* renamed from: d  reason: collision with root package name */
        private Runnable f48578d;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            Logger.debug("DTM-Execute", "onActivityPaused called.");
            this.f48576b = true;
            Runnable runnable = this.f48578d;
            if (runnable != null) {
                this.f48577c.removeCallbacks(runnable);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f48577c;
            g gVar = new g(this, currentTimeMillis);
            this.f48578d = gVar;
            handler.postDelayed(gVar, 200);
        }

        public void onActivityResumed(Activity activity) {
            String str;
            Logger.debug("DTM-Execute", "onActivityResumed called.");
            this.f48576b = false;
            boolean z11 = !this.f48575a;
            this.f48575a = true;
            Runnable runnable = this.f48578d;
            if (runnable != null) {
                this.f48577c.removeCallbacks(runnable);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z11) {
                str = "foreground. Resume time: " + currentTimeMillis;
            } else {
                str = "still foreground.";
            }
            Logger.debug("DTM-Execute", str);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (h.class) {
            if (f48572a == null || f48573b == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    f48574c = aVar;
                    f48572a = (Application) applicationContext;
                    a aVar2 = new a();
                    f48573b = aVar2;
                    f48572a.registerActivityLifecycleCallbacks(aVar2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b() {
        /*
            java.lang.Class<com.huawei.hms.dtm.core.report.h> r0 = com.huawei.hms.dtm.core.report.h.class
            monitor-enter(r0)
            android.app.Application r1 = f48572a     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0016
            android.app.Application$ActivityLifecycleCallbacks r2 = f48573b     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x000c
            goto L_0x0016
        L_0x000c:
            r1.unregisterActivityLifecycleCallbacks(r2)     // Catch:{ all -> 0x0018 }
            r1 = 0
            f48573b = r1     // Catch:{ all -> 0x0018 }
            f48572a = r1     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            return
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.report.h.b():void");
    }
}
