package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class Lc {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f48337a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Application f48338b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f48339c;

    public static class a implements Application.ActivityLifecycleCallbacks {
        private a() {
        }

        public /* synthetic */ a(Kc kc2) {
            this();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            Jc.b().a();
        }

        public void onActivityResumed(Activity activity) {
            Jc.b().a(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r2) {
        /*
            java.lang.Class<com.huawei.hms.dtm.core.Lc> r0 = com.huawei.hms.dtm.core.Lc.class
            monitor-enter(r0)
            boolean r1 = f48337a     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x003b }
            boolean r1 = r2 instanceof android.app.Application     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)
            return
        L_0x0013:
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x003b }
            f48338b = r2     // Catch:{ all -> 0x003b }
            com.huawei.hms.dtm.core.Lc$a r2 = new com.huawei.hms.dtm.core.Lc$a     // Catch:{ all -> 0x003b }
            r1 = 0
            r2.<init>(r1)     // Catch:{ all -> 0x003b }
            f48339c = r2     // Catch:{ all -> 0x003b }
            android.app.Application r1 = f48338b     // Catch:{ all -> 0x003b }
            r1.registerActivityLifecycleCallbacks(r2)     // Catch:{ all -> 0x003b }
            r2 = 1
            f48337a = r2     // Catch:{ all -> 0x003b }
            com.huawei.hms.dtm.core.util.c r2 = com.huawei.hms.dtm.core.util.c.a()     // Catch:{ all -> 0x003b }
            android.app.Activity r2 = r2.b()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0039
            com.huawei.hms.dtm.core.Kc r1 = new com.huawei.hms.dtm.core.Kc     // Catch:{ all -> 0x003b }
            r1.<init>(r2)     // Catch:{ all -> 0x003b }
            r2.runOnUiThread(r1)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0)
            return
        L_0x003b:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Lc.a(android.content.Context):void");
    }

    public static synchronized void b() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        synchronized (Lc.class) {
            if (f48337a) {
                Application application = f48338b;
                if (!(application == null || (activityLifecycleCallbacks = f48339c) == null)) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                Jc.b().a();
                f48337a = false;
            }
        }
    }

    public static synchronized boolean c() {
        boolean z11;
        synchronized (Lc.class) {
            z11 = f48337a;
        }
        return z11;
    }
}
