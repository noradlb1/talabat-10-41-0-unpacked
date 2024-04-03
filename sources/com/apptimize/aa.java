package com.apptimize;

import android.app.Activity;
import com.apptimize.y;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class aa implements y {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41026a = "aa";

    /* renamed from: b  reason: collision with root package name */
    private List<a> f41027b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Set<Activity> f41028c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d  reason: collision with root package name */
    private fo f41029d;

    /* renamed from: e  reason: collision with root package name */
    private c f41030e;

    /* renamed from: f  reason: collision with root package name */
    private final g f41031f;

    /* renamed from: com.apptimize.aa$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41033a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.apptimize.aa$c[] r0 = com.apptimize.aa.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41033a = r0
                com.apptimize.aa$c r1 = com.apptimize.aa.c.Foreground     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41033a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.aa$c r1 = com.apptimize.aa.c.BackgroundPending     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41033a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apptimize.aa$c r1 = com.apptimize.aa.c.Background     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.aa.AnonymousClass2.<clinit>():void");
        }
    }

    public static class a implements y.a {

        /* renamed from: a  reason: collision with root package name */
        private final g f41034a;

        /* renamed from: b  reason: collision with root package name */
        private final y.a f41035b;

        public a(g gVar, y.a aVar) {
            this.f41034a = gVar;
            this.f41035b = aVar;
        }

        public void a(Activity activity) {
            g gVar = this.f41034a;
            if (gVar == null || !gVar.b()) {
                this.f41035b.a(activity);
                g gVar2 = this.f41034a;
                if (gVar2 != null && gVar2.b()) {
                    e.a();
                }
            }
        }

        public void a_() {
            g gVar = this.f41034a;
            if (gVar == null || !gVar.b()) {
                this.f41035b.a_();
                g gVar2 = this.f41034a;
                if (gVar2 != null && gVar2.b()) {
                    e.a();
                }
            }
        }
    }

    public class b implements w {
        private b() {
        }

        public void a(Activity activity) {
            aa.this.b(activity);
        }

        public void b(Activity activity) {
            aa.this.c(activity);
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }

        public void f(Activity activity) {
        }

        public void g(Activity activity) {
        }
    }

    public enum c {
        Foreground,
        BackgroundPending,
        Background
    }

    public aa(x xVar, au auVar, g gVar) {
        this.f41029d = auVar.b().a((fi) new fi() {
            public void run() {
                aa.this.b();
            }
        });
        this.f41030e = c.Background;
        this.f41031f = gVar;
        if (xVar != null) {
            xVar.a((w) new b());
        }
    }

    private synchronized void c() {
        c cVar = this.f41030e;
        c cVar2 = c.BackgroundPending;
        if (cVar != cVar2) {
            if (cVar != c.Background) {
                this.f41030e = cVar2;
                this.f41029d.b(600);
                return;
            }
        }
        bo.j(f41026a, "Detected consecutive application backgrounds without detecting application foreground");
    }

    /* access modifiers changed from: private */
    public void b() {
        boolean z11;
        synchronized (this) {
            if (this.f41030e == c.BackgroundPending) {
                this.f41030e = c.Background;
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (z11) {
            for (a a_ : this.f41027b) {
                a_.a_();
            }
        }
    }

    public void a(y.a aVar) {
        this.f41027b.add(new a(this.f41031f, aVar));
    }

    public synchronized boolean a() {
        return this.f41030e == c.Background;
    }

    private void a(Activity activity) {
        boolean z11;
        synchronized (this) {
            int i11 = AnonymousClass2.f41033a[this.f41030e.ordinal()];
            z11 = true;
            if (i11 == 1) {
                bo.j(f41026a, "Detected application foreground without detecting application background");
            } else if (i11 == 2) {
                this.f41030e = c.Foreground;
            } else if (i11 == 3) {
                this.f41030e = c.Foreground;
            }
            z11 = false;
        }
        if (z11) {
            for (a a11 : this.f41027b) {
                a11.a(activity);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.app.Activity r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Set<android.app.Activity> r0 = r1.f41028c     // Catch:{ all -> 0x001d }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            return
        L_0x000b:
            java.util.Set<android.app.Activity> r0 = r1.f41028c     // Catch:{ all -> 0x001d }
            r0.remove(r2)     // Catch:{ all -> 0x001d }
            java.util.Set<android.app.Activity> r2 = r1.f41028c     // Catch:{ all -> 0x001d }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            if (r2 == 0) goto L_0x001c
            r1.c()
        L_0x001c:
            return
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.aa.c(android.app.Activity):void");
    }

    /* access modifiers changed from: private */
    public void b(Activity activity) {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.f41028c.isEmpty();
            this.f41028c.add(activity);
        }
        if (isEmpty) {
            a(activity);
        }
    }
}
