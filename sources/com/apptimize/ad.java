package com.apptimize;

import android.app.Activity;
import com.apptimize.z;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ad implements z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41052a = "ad";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<a> f41053b = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Set<Activity> f41054c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    private Set<Activity> f41055d = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: e  reason: collision with root package name */
    private final g f41056e;

    /* renamed from: f  reason: collision with root package name */
    private final au f41057f;

    /* renamed from: g  reason: collision with root package name */
    private fo f41058g;

    /* renamed from: h  reason: collision with root package name */
    private d f41059h;

    /* renamed from: i  reason: collision with root package name */
    private b f41060i = b.f41069a;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<Activity> f41061j = new WeakReference<>((Object) null);

    /* renamed from: com.apptimize.ad$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41065a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f41066b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            /*
                com.apptimize.ad$d[] r0 = com.apptimize.ad.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41066b = r0
                r1 = 1
                com.apptimize.ad$d r2 = com.apptimize.ad.d.ApplicationRunning     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f41066b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.ad$d r3 = com.apptimize.ad.d.SleepPending     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f41066b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apptimize.ad$d r4 = com.apptimize.ad.d.ApplicationStart     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f41066b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.apptimize.ad$d r4 = com.apptimize.ad.d.Sleeping     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.apptimize.ad$b[] r3 = com.apptimize.ad.b.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f41065a = r3
                com.apptimize.ad$b r4 = com.apptimize.ad.b.FIRST_SCREEN     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f41065a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.apptimize.ad$b r3 = com.apptimize.ad.b.SLEEPING     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f41065a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.apptimize.ad$b r1 = com.apptimize.ad.b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ad.AnonymousClass3.<clinit>():void");
        }
    }

    public enum b {
        f41069a,
        SLEEPING,
        RESUMED,
        FIRST_SCREEN
    }

    public class c implements w {
        private c() {
        }

        public void a(Activity activity) {
            ad.this.d(activity);
            ad.this.b(activity);
        }

        public void b(Activity activity) {
            ad.this.c(activity);
        }

        public void c(Activity activity) {
            ad.this.b(activity);
        }

        public void d(Activity activity) {
            g(activity);
        }

        public void e(Activity activity) {
        }

        public void f(Activity activity) {
            a(activity);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
            r3 = r2.f41074a;
            com.apptimize.ad.a(r3, !com.apptimize.ad.d(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
            if (r3 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(android.app.Activity r3) {
            /*
                r2 = this;
                com.apptimize.ad r0 = com.apptimize.ad.this
                monitor-enter(r0)
                com.apptimize.ad r1 = com.apptimize.ad.this     // Catch:{ all -> 0x0033 }
                java.util.Set r1 = r1.f41054c     // Catch:{ all -> 0x0033 }
                boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x0033 }
                return
            L_0x0011:
                com.apptimize.ad r1 = com.apptimize.ad.this     // Catch:{ all -> 0x0033 }
                java.util.Set r1 = r1.f41054c     // Catch:{ all -> 0x0033 }
                r1.remove(r3)     // Catch:{ all -> 0x0033 }
                com.apptimize.ad r3 = com.apptimize.ad.this     // Catch:{ all -> 0x0033 }
                java.util.Set r3 = r3.f41054c     // Catch:{ all -> 0x0033 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0033 }
                monitor-exit(r0)     // Catch:{ all -> 0x0033 }
                if (r3 == 0) goto L_0x0032
                com.apptimize.ad r3 = com.apptimize.ad.this
                boolean r0 = r3.b()
                r0 = r0 ^ 1
                r3.a((boolean) r0)
            L_0x0032:
                return
            L_0x0033:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0033 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ad.c.g(android.app.Activity):void");
        }
    }

    public enum d {
        ApplicationStart,
        ApplicationRunning,
        SleepPending,
        Sleeping
    }

    public ad(x xVar, au auVar, g gVar) {
        this.f41056e = gVar;
        this.f41057f = auVar;
        this.f41058g = auVar.b().a((fi) new fi() {
            public void run() {
                ad.this.a();
            }
        });
        this.f41059h = d.ApplicationStart;
        if (xVar != null) {
            xVar.a((w) new c());
        }
    }

    /* access modifiers changed from: private */
    public synchronized void d(Activity activity) {
        this.f41055d.remove(activity);
    }

    private void b(z.a aVar) {
        Activity activity = this.f41061j.get();
        if (activity != null) {
            int i11 = AnonymousClass3.f41065a[this.f41060i.ordinal()];
            if (i11 == 1) {
                aVar.b(activity);
            } else if (i11 == 2) {
                aVar.a();
            } else if (i11 == 3) {
                aVar.a(activity);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void c(Activity activity) {
        this.f41055d.add(activity);
    }

    public static class a implements z.a {

        /* renamed from: a  reason: collision with root package name */
        private final g f41067a;

        /* renamed from: b  reason: collision with root package name */
        private final z.a f41068b;

        public a(g gVar, z.a aVar) {
            this.f41067a = gVar;
            this.f41068b = aVar;
        }

        public void a() {
            g gVar = this.f41067a;
            if (gVar == null || !gVar.b()) {
                this.f41068b.a();
                g gVar2 = this.f41067a;
                if (gVar2 != null && gVar2.b()) {
                    e.a();
                }
            }
        }

        public void b(Activity activity) {
            g gVar = this.f41067a;
            if (gVar == null || !gVar.b()) {
                this.f41068b.b(activity);
                g gVar2 = this.f41067a;
                if (gVar2 != null && gVar2.b()) {
                    e.a();
                }
            }
        }

        public void a(Activity activity) {
            g gVar = this.f41067a;
            if (gVar == null || !gVar.b()) {
                this.f41068b.a(activity);
                g gVar2 = this.f41067a;
                if (gVar2 != null && gVar2.b()) {
                    e.a();
                }
            }
        }
    }

    public at a(z.a aVar) {
        b(aVar);
        final a aVar2 = new a(this.f41056e, aVar);
        this.f41053b.add(aVar2);
        return new at() {
            public void a() {
                ad.this.f41053b.remove(aVar2);
            }
        };
    }

    /* access modifiers changed from: private */
    public void a() {
        boolean z11;
        synchronized (this) {
            if (this.f41059h == d.SleepPending) {
                this.f41059h = d.Sleeping;
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (z11) {
            this.f41060i = b.SLEEPING;
            for (a a11 : this.f41053b) {
                a11.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals("android.app.ActivityThread") && stackTraceElement.getMethodName().equals("handleRelaunchActivity")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b(Activity activity) {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.f41054c.isEmpty();
            this.f41054c.add(activity);
        }
        if (isEmpty) {
            a(activity);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.apptimize.ad$d r0 = r3.f41059h     // Catch:{ all -> 0x0028 }
            com.apptimize.ad$d r1 = com.apptimize.ad.d.SleepPending     // Catch:{ all -> 0x0028 }
            if (r0 == r1) goto L_0x001f
            com.apptimize.ad$d r2 = com.apptimize.ad.d.Sleeping     // Catch:{ all -> 0x0028 }
            if (r0 != r2) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            r3.f41059h = r1     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x0016
            com.apptimize.fo r4 = r3.f41058g     // Catch:{ all -> 0x0028 }
            r4.a()     // Catch:{ all -> 0x0028 }
            goto L_0x001d
        L_0x0016:
            com.apptimize.fo r4 = r3.f41058g     // Catch:{ all -> 0x0028 }
            r0 = 600(0x258, double:2.964E-321)
            r4.b((long) r0)     // Catch:{ all -> 0x0028 }
        L_0x001d:
            monitor-exit(r3)
            return
        L_0x001f:
            java.lang.String r4 = f41052a     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = "Detected consecutive application sleeps without detecting application wake"
            com.apptimize.bo.j(r4, r0)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return
        L_0x0028:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ad.a(boolean):void");
    }

    private void a(Activity activity) {
        boolean z11;
        boolean z12;
        synchronized (this) {
            int i11 = AnonymousClass3.f41066b[this.f41059h.ordinal()];
            z11 = true;
            z12 = false;
            if (i11 == 1) {
                bo.n(f41052a, "Detected application wake without detecting application sleep");
            } else if (i11 == 2) {
                this.f41059h = d.ApplicationRunning;
            } else if (i11 == 3) {
                this.f41059h = d.ApplicationRunning;
                z12 = true;
            } else if (i11 == 4) {
                this.f41059h = d.ApplicationRunning;
            }
            z11 = false;
        }
        if (z11) {
            this.f41060i = z12 ? b.FIRST_SCREEN : b.RESUMED;
            this.f41061j = new WeakReference<>(activity);
            for (z.a next : this.f41053b) {
                if (z12) {
                    next.b(activity);
                } else {
                    next.a(activity);
                }
            }
        }
    }
}
