package com.apptimize;

import android.app.Activity;
import android.view.View;
import java.util.LinkedList;
import java.util.Queue;

public class gp {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42686a = "gp";

    /* renamed from: b  reason: collision with root package name */
    private final a f42687b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final ev f42688c = new ev(fg.f42428c);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Thread f42689d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f42690e = false;

    /* renamed from: f  reason: collision with root package name */
    private Activity f42691f = null;

    private void d() {
        final Activity a11 = this.f42687b.a();
        if (a11 == null) {
            bo.e(f42686a, "No current activity; cannot schedule tasks");
        } else {
            a11.runOnUiThread(new fi() {
                public void run() {
                    fe.a(gp.f42686a, new fi() {
                        public void run() {
                            AnonymousClass4 r02 = AnonymousClass4.this;
                            gp.this.d(a11);
                        }
                    });
                }
            });
        }
    }

    private fi e(final fi fiVar) {
        return new fi() {
            public void run() {
                fe.a(gp.f42686a, new fi() {
                    public void run() {
                        synchronized (this) {
                            Thread a11 = gp.this.f42689d;
                            Thread unused = gp.this.f42689d = Thread.currentThread();
                            try {
                                bs bsVar = bs.f41454a;
                                if (bsVar != null) {
                                    bsVar.a((Object) fiVar);
                                }
                                fiVar.run();
                            } finally {
                                bs bsVar2 = bs.f41454a;
                                if (bsVar2 != null) {
                                    bsVar2.a();
                                }
                                Thread unused2 = gp.this.f42689d = a11;
                            }
                        }
                    }
                });
            }
        };
    }

    public void b(Activity activity) {
        this.f42687b.b(activity);
    }

    public class a {

        /* renamed from: b  reason: collision with root package name */
        private Activity f42706b;

        /* renamed from: c  reason: collision with root package name */
        private final Queue<fj> f42707c;

        private a() {
            this.f42707c = new LinkedList();
        }

        public synchronized void a(Activity activity) {
            this.f42706b = activity;
        }

        public synchronized void b(Activity activity) {
            if (activity == this.f42706b) {
                this.f42706b = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized com.apptimize.fj c(android.app.Activity r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                android.app.Activity r0 = r1.f42706b     // Catch:{ all -> 0x001b }
                if (r2 != r0) goto L_0x0018
                java.util.Queue<com.apptimize.fj> r2 = r1.f42707c     // Catch:{ all -> 0x001b }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x001b }
                if (r2 == 0) goto L_0x000e
                goto L_0x0018
            L_0x000e:
                java.util.Queue<com.apptimize.fj> r2 = r1.f42707c     // Catch:{ all -> 0x001b }
                java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x001b }
                com.apptimize.fj r2 = (com.apptimize.fj) r2     // Catch:{ all -> 0x001b }
                monitor-exit(r1)
                return r2
            L_0x0018:
                monitor-exit(r1)
                r2 = 0
                return r2
            L_0x001b:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gp.a.c(android.app.Activity):com.apptimize.fj");
        }

        public synchronized void a(fj fjVar) {
            this.f42707c.add(fjVar);
        }

        public synchronized Activity a() {
            return this.f42706b;
        }
    }

    public void b(View view, fi fiVar) {
        view.post(e(fiVar));
    }

    public void c(final fi fiVar) {
        a((fj) new fj() {
            public void a(Activity activity) {
                try {
                    bs bsVar = bs.f41454a;
                    if (bsVar != null) {
                        bsVar.a((Object) fiVar);
                    }
                    fiVar.run();
                } finally {
                    bs bsVar2 = bs.f41454a;
                    if (bsVar2 != null) {
                        bsVar2.a();
                    }
                }
            }
        });
    }

    public void b(final fi fiVar) {
        d((fi) new fi() {
            public void run() {
                gp.this.c(fiVar);
            }
        });
    }

    public void c(Activity activity) {
        if (this.f42687b.a() != activity) {
            bo.g(f42686a, "verifyIsActivityRunningTasks is false!");
            throw new IllegalStateException("verifyIsActivityRunningTasks");
        }
    }

    /* access modifiers changed from: private */
    public synchronized void d(final Activity activity) {
        if (this.f42687b.a() != activity) {
            bo.a(f42686a, "Current activity is not expected.");
            return;
        }
        Thread thread = this.f42689d;
        this.f42689d = Thread.currentThread();
        boolean z11 = this.f42690e;
        this.f42690e = true;
        Activity activity2 = this.f42691f;
        this.f42691f = activity;
        try {
            final fj c11 = this.f42687b.c(activity);
            while (c11 != null) {
                fe.a(f42686a, new fi() {
                    public void run() {
                        try {
                            bs bsVar = bs.f41454a;
                            if (bsVar != null) {
                                bsVar.a(c11);
                            }
                            c11.a(activity);
                        } finally {
                            bs bsVar2 = bs.f41454a;
                            if (bsVar2 != null) {
                                bsVar2.a();
                            }
                        }
                    }
                });
                c11 = this.f42687b.c(activity);
            }
        } finally {
            this.f42689d = thread;
            this.f42690e = z11;
            this.f42691f = activity2;
        }
    }

    public void a(Activity activity) {
        this.f42687b.a(activity);
        d();
    }

    public void b() {
        a();
        if (!this.f42690e) {
            bo.g(f42686a, "verifyOnCurrentUiThread is false!");
            throw new IllegalStateException("verifyOnCurrentUiThread");
        }
    }

    public void a(View view, fi fiVar) {
        if (c.a()) {
            a(fiVar);
        } else {
            view.post(e(fiVar));
        }
    }

    public synchronized void a(fi fiVar) {
        Thread thread = this.f42689d;
        this.f42689d = Thread.currentThread();
        boolean z11 = this.f42690e;
        this.f42690e = true;
        try {
            fe.a(f42686a, fiVar);
        } finally {
            this.f42689d = thread;
            this.f42690e = z11;
        }
    }

    public void a(fj fjVar) {
        if (!this.f42690e || this.f42689d != Thread.currentThread()) {
            this.f42687b.a(fjVar);
            d();
            return;
        }
        try {
            bs bsVar = bs.f41454a;
            if (bsVar != null) {
                bsVar.a(fjVar);
            }
            fjVar.a(this.f42687b.a());
        } finally {
            bs bsVar2 = bs.f41454a;
            if (bsVar2 != null) {
                bsVar2.a();
            }
        }
    }

    public void d(fi fiVar) {
        this.f42688c.a(fiVar);
    }

    public void a() {
        if (av.f41254q && this.f42689d != Thread.currentThread()) {
            bo.g(f42686a, "verifyHasLock is false!");
            throw new IllegalStateException("verifyHasLock");
        }
    }
}
