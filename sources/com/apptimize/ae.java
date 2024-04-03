package com.apptimize;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ae implements x {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41080a = "ae";

    /* renamed from: b  reason: collision with root package name */
    private ab f41081b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<w> f41082c;

    public class a implements Application.ActivityLifecycleCallbacks {
        private a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            for (w c11 : ae.this.f41082c) {
                c11.c(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            for (w d11 : ae.this.f41082c) {
                d11.d(activity);
            }
        }

        public void onActivityPaused(Activity activity) {
            for (w b11 : ae.this.f41082c) {
                b11.b(activity);
            }
        }

        public void onActivityResumed(Activity activity) {
            for (w a11 : ae.this.f41082c) {
                a11.a(activity);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            for (w e11 : ae.this.f41082c) {
                e11.e(activity);
            }
        }

        public void onActivityStarted(Activity activity) {
            for (w f11 : ae.this.f41082c) {
                f11.f(activity);
            }
        }

        public void onActivityStopped(Activity activity) {
            for (w g11 : ae.this.f41082c) {
                g11.g(activity);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
        r3 = com.apptimize.c.c(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ae(android.app.Application r3, java.lang.ClassLoader r4, com.apptimize.h r5) {
        /*
            r2 = this;
            r2.<init>()
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r2.f41082c = r0
            com.apptimize.ae$a r0 = new com.apptimize.ae$a
            r1 = 0
            r0.<init>()
            r3.registerActivityLifecycleCallbacks(r0)
            com.apptimize.gn$b r1 = com.apptimize.gn.b.f42668f
            boolean r1 = com.apptimize.gn.a((com.apptimize.gn.b) r1)
            if (r1 != 0) goto L_0x002a
            java.lang.String r3 = f41080a
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "Unable to monitor application lifecycle events"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.apptimize.bo.e(r3, r4)
            return
        L_0x002a:
            com.apptimize.ab r1 = new com.apptimize.ab
            r1.<init>(r4)
            r2.f41081b = r1
            boolean r4 = com.apptimize.c.b(r3)
            if (r4 == 0) goto L_0x0045
            android.app.Activity r3 = com.apptimize.c.c(r3)
            if (r3 == 0) goto L_0x0045
            com.apptimize.ae$1 r4 = new com.apptimize.ae$1
            r4.<init>(r0, r3)
            r5.g(r4)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ae.<init>(android.app.Application, java.lang.ClassLoader, com.apptimize.h):void");
    }

    public static ae a(final Context context, final h hVar) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            final AtomicReference atomicReference = new AtomicReference();
            hVar.a((fi) new fi() {
                public void run() {
                    atomicReference.set(new ae((Application) applicationContext, context.getClassLoader(), hVar));
                }
            });
            return (ae) atomicReference.get();
        }
        bo.j(f41080a, "Application context is not an Application. Will not be able to detect foreground/background or sleep events");
        return null;
    }

    public synchronized void a(w wVar) {
        this.f41082c.add(wVar);
    }

    public void a(af afVar) {
        ab abVar = this.f41081b;
        if (abVar != null) {
            abVar.a(afVar);
        }
    }
}
