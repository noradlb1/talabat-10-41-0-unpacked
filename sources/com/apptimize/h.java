package com.apptimize;

import android.os.Handler;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static a f42873a = a.NON_BLOCKING_THREAD;

    /* renamed from: b  reason: collision with root package name */
    private static final String f42874b = "h";

    /* renamed from: c  reason: collision with root package name */
    private boolean f42875c = false;

    /* renamed from: d  reason: collision with root package name */
    private Looper f42876d;

    /* renamed from: e  reason: collision with root package name */
    private long f42877e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f42878f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private Long f42879g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f42880h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Thread f42881i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public long f42882j = 0;

    /* renamed from: k  reason: collision with root package name */
    private CountDownLatch f42883k = null;

    /* renamed from: l  reason: collision with root package name */
    private Long f42884l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f42885m = 0;

    /* renamed from: n  reason: collision with root package name */
    private final Queue<c> f42886n = new ConcurrentLinkedQueue();

    /* renamed from: o  reason: collision with root package name */
    private final Queue<fi> f42887o = new ConcurrentLinkedQueue();

    /* renamed from: p  reason: collision with root package name */
    private final Queue<b> f42888p = new ConcurrentLinkedQueue();

    /* renamed from: q  reason: collision with root package name */
    private b f42889q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f42890r = true;

    /* renamed from: s  reason: collision with root package name */
    private fi f42891s = new fi() {
        public void run() {
            int unused = h.this.f();
        }
    };

    public enum a {
        CURRENT_THREAD,
        NON_BLOCKING_THREAD,
        MIXED_THREADS
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        fi f42899a;

        /* renamed from: b  reason: collision with root package name */
        boolean f42900b = false;

        public b(fi fiVar) {
            this.f42899a = fiVar;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public fi f42902a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f42903b = false;

        public c(fi fiVar) {
            this.f42902a = fiVar;
        }
    }

    public h() {
        Looper mainLooper = Looper.getMainLooper();
        this.f42876d = mainLooper;
        if (mainLooper != null) {
            this.f42877e = mainLooper.getThread().getId();
            c();
        }
    }

    private void h(fi fiVar) {
        if (c.a()) {
            try {
                bs bsVar = bs.f41454a;
                if (bsVar != null) {
                    bsVar.c((Object) fiVar);
                }
                fiVar.run();
            } finally {
                bs bsVar2 = bs.f41454a;
                if (bsVar2 != null) {
                    bsVar2.a();
                }
            }
        } else {
            c cVar = new c(fiVar);
            synchronized (this.f42878f) {
                this.f42886n.add(cVar);
                this.f42878f.notifyAll();
            }
            new Handler(this.f42876d).post(this.f42891s);
            synchronized (cVar) {
                try {
                    if (!cVar.f42903b) {
                        cVar.wait();
                    }
                } catch (InterruptedException e11) {
                    bo.i(f42874b, "runOnMainThreadSynchronous interrupted", e11);
                }
            }
        }
    }

    private void i(fi fiVar) {
        synchronized (this.f42878f) {
            this.f42887o.add(fiVar);
            this.f42878f.notifyAll();
        }
    }

    public void d(fi fiVar) {
        a(fiVar, false);
    }

    public void e(fi fiVar) {
        a(fiVar, true);
    }

    public void f(fi fiVar) {
        h(fiVar);
    }

    public void g(fi fiVar) {
        i(fiVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f42878f
            monitor-enter(r0)
            boolean r1 = r5.f42890r     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x004f
            java.lang.Thread r1 = r5.f42881i     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x004f
            boolean r1 = r1.isAlive()     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x004f
            java.lang.Thread r1 = r5.f42881i     // Catch:{ all -> 0x0051 }
            long r1 = r1.getId()     // Catch:{ all -> 0x0051 }
            long r3 = r5.f42882j     // Catch:{ all -> 0x0051 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x004f
            com.apptimize.h$b r1 = r5.f42889q     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = f42874b     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r2.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "Background thread lost while processing "
            r2.append(r3)     // Catch:{ all -> 0x0051 }
            com.apptimize.h$b r3 = r5.f42889q     // Catch:{ all -> 0x0051 }
            r2.append(r3)     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0051 }
            com.apptimize.bo.g(r1, r2)     // Catch:{ all -> 0x0051 }
            r1 = 0
            r5.f42890r = r1     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x003e:
            java.lang.String r1 = f42874b     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Restarting background thread"
            com.apptimize.bo.g(r1, r2)     // Catch:{ all -> 0x0051 }
            r1 = 0
            r5.f42881i = r1     // Catch:{ all -> 0x0051 }
            r1 = 0
            r5.f42882j = r1     // Catch:{ all -> 0x0051 }
            r5.c()     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.h.d():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r3 == null) goto L_0x0008;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        com.apptimize.fe.a(f42874b, r3.f42899a);
        r2 = r10.f42878f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r10.f42889q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r3.f42900b = true;
        g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r10 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            long r0 = r0.getId()
        L_0x0008:
            java.lang.Object r2 = r10.f42878f     // Catch:{ Exception -> 0x009f }
            monitor-enter(r2)     // Catch:{ Exception -> 0x009f }
            long r3 = r10.f42882j     // Catch:{ all -> 0x009c }
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r4 = 0
            if (r3 != 0) goto L_0x0083
            java.util.concurrent.CountDownLatch r3 = r10.f42883k     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0017
            goto L_0x0083
        L_0x0017:
            java.util.Queue<com.apptimize.h$b> r3 = r10.f42888p     // Catch:{ all -> 0x009c }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x009c }
            r5 = 1
            if (r3 != 0) goto L_0x0043
            java.lang.Long r3 = r10.f42879g     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x002e
            long r6 = r3.longValue()     // Catch:{ all -> 0x009c }
            long r8 = r10.f42882j     // Catch:{ all -> 0x009c }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0043
        L_0x002e:
            long r6 = r10.f42882j     // Catch:{ all -> 0x009c }
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x009c }
            r10.f42879g = r3     // Catch:{ all -> 0x009c }
            r10.f42880h = r5     // Catch:{ all -> 0x009c }
            java.util.Queue<com.apptimize.h$b> r3 = r10.f42888p     // Catch:{ all -> 0x009c }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x009c }
            com.apptimize.h$b r3 = (com.apptimize.h.b) r3     // Catch:{ all -> 0x009c }
            r10.f42889q = r3     // Catch:{ all -> 0x009c }
            goto L_0x006a
        L_0x0043:
            java.util.Queue<com.apptimize.h$b> r3 = r10.f42888p     // Catch:{ all -> 0x009c }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0064
            java.lang.Long r3 = r10.f42879g     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0064
            long r6 = r3.longValue()     // Catch:{ all -> 0x009c }
            long r8 = r10.f42882j     // Catch:{ all -> 0x009c }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0064
            r10.f42879g = r4     // Catch:{ all -> 0x009c }
            r3 = 0
            r10.f42880h = r3     // Catch:{ all -> 0x009c }
            java.lang.Object r3 = r10.f42878f     // Catch:{ all -> 0x009c }
            r3.notifyAll()     // Catch:{ all -> 0x009c }
            goto L_0x0069
        L_0x0064:
            java.lang.Object r3 = r10.f42878f     // Catch:{ all -> 0x009c }
            r3.wait()     // Catch:{ all -> 0x009c }
        L_0x0069:
            r3 = r4
        L_0x006a:
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0008
            java.lang.String r2 = f42874b     // Catch:{ Exception -> 0x009f }
            com.apptimize.fi r6 = r3.f42899a     // Catch:{ Exception -> 0x009f }
            com.apptimize.fe.a(r2, r6)     // Catch:{ Exception -> 0x009f }
            java.lang.Object r2 = r10.f42878f     // Catch:{ Exception -> 0x009f }
            monitor-enter(r2)     // Catch:{ Exception -> 0x009f }
            r10.f42889q = r4     // Catch:{ all -> 0x0080 }
            monitor-exit(r2)     // Catch:{ all -> 0x0080 }
            r3.f42900b = r5     // Catch:{ Exception -> 0x009f }
            r10.g()     // Catch:{ Exception -> 0x009f }
            goto L_0x0008
        L_0x0080:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0080 }
            throw r3     // Catch:{ Exception -> 0x009f }
        L_0x0083:
            java.lang.Long r3 = r10.f42879g     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0091
            long r5 = r3.longValue()     // Catch:{ all -> 0x009c }
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x0091
            r10.f42879g = r4     // Catch:{ all -> 0x009c }
        L_0x0091:
            java.util.concurrent.CountDownLatch r3 = r10.f42883k     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x009a
            r10.f42883k = r4     // Catch:{ all -> 0x009c }
            r3.countDown()     // Catch:{ all -> 0x009c }
        L_0x009a:
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            return
        L_0x009c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            throw r3     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            r2 = move-exception
            java.lang.String r3 = f42874b
            java.lang.String r4 = "Error processing request "
            com.apptimize.bo.e(r3, r4, r2)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.h.e():void");
    }

    /* access modifiers changed from: private */
    public int f() {
        c poll;
        int i11 = 0;
        do {
            synchronized (this.f42878f) {
                poll = !this.f42886n.isEmpty() ? this.f42886n.poll() : null;
            }
            if (poll != null) {
                i11++;
                try {
                    fe.a(f42874b, poll.f42902a);
                    synchronized (poll) {
                        poll.f42903b = true;
                        poll.notify();
                    }
                    continue;
                } catch (Throwable th2) {
                    synchronized (poll) {
                        poll.f42903b = true;
                        poll.notify();
                        throw th2;
                    }
                }
            }
        } while (poll != null);
        return i11;
    }

    private void g() {
        fi poll;
        do {
            synchronized (this.f42878f) {
                poll = this.f42887o.poll();
            }
            if (poll != null) {
                h(poll);
                continue;
            }
        } while (poll != null);
    }

    public void b(fi fiVar) {
        b(fiVar, 0);
    }

    public void c(fi fiVar) {
        Looper myLooper = Looper.myLooper();
        if (Thread.currentThread().getId() == a() || myLooper == null) {
            b(fiVar);
        } else {
            new Handler().post(fiVar);
        }
    }

    private long b() {
        long j11;
        synchronized (this.f42878f) {
            j11 = this.f42882j;
        }
        return j11;
    }

    public void a(boolean z11) {
        String str = f42874b;
        bo.k(str, "setupInBackground:" + z11);
        f42873a = z11 ? a.NON_BLOCKING_THREAD : a.CURRENT_THREAD;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(2:18|19)|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.apptimize.fi r6, int r7) {
        /*
            r5 = this;
            com.apptimize.h$b r0 = new com.apptimize.h$b
            r0.<init>(r6)
            java.lang.Object r6 = r5.f42878f
            monitor-enter(r6)
            java.util.Queue<com.apptimize.h$b> r1 = r5.f42888p     // Catch:{ all -> 0x0050 }
            r1.add(r0)     // Catch:{ all -> 0x0050 }
            r5.d()     // Catch:{ all -> 0x0050 }
            java.lang.Object r1 = r5.f42878f     // Catch:{ all -> 0x0050 }
            r1.notifyAll()     // Catch:{ all -> 0x0050 }
            monitor-exit(r6)     // Catch:{ all -> 0x0050 }
            if (r7 <= 0) goto L_0x004f
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            long r1 = r6.getId()
            long r3 = r5.f42877e
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x004f
        L_0x0026:
            if (r7 <= 0) goto L_0x004f
            boolean r6 = r0.f42900b
            if (r6 != 0) goto L_0x004f
            java.lang.Object r6 = r5.f42878f
            monitor-enter(r6)
            boolean r1 = r0.f42900b     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0045
            java.util.Queue<com.apptimize.h$c> r1 = r5.f42886n     // Catch:{ all -> 0x004c }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r5.f42878f     // Catch:{ InterruptedException -> 0x0045 }
            r2 = 1
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x0045 }
            r5.d()     // Catch:{ InterruptedException -> 0x0045 }
        L_0x0045:
            monitor-exit(r6)     // Catch:{ all -> 0x004c }
            int r6 = r5.f()
            int r7 = r7 - r6
            goto L_0x0026
        L_0x004c:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004c }
            throw r7
        L_0x004f:
            return
        L_0x0050:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0050 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.h.b(com.apptimize.fi, int):void");
    }

    public void a(fi fiVar) {
        if (f42873a != a.MIXED_THREADS) {
            d(fiVar);
        } else {
            f(fiVar);
        }
    }

    private void c() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(new fi() {
            public void run() {
                Thread unused = h.this.f42881i = Thread.currentThread();
                h hVar = h.this;
                long unused2 = hVar.f42882j = hVar.f42881i.getId();
                countDownLatch.countDown();
                h.this.e();
            }
        });
        thread.setName(f42874b);
        thread.setPriority(9);
        thread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e11) {
            String str = f42874b;
            bo.g(str, "Error starting thread " + fx.a((Exception) e11));
        }
    }

    public long a() {
        return b();
    }

    public void a(fi fiVar, int i11) {
        b(fiVar, i11);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:106|107|(2:115|116)|117|118) */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0135, code lost:
        if (r7 == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x013b, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x013c, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x013e, code lost:
        if (r7 == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0140, code lost:
        r6 = r10.f42878f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0142, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
        r10.f42879g = null;
        r10.f42878f.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x014a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x004e, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (r5 == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
        r11.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00e0, code lost:
        r4 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x0124 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.apptimize.fi r11, boolean r12) {
        /*
            r10 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            long r0 = r0.getId()
            r2 = 0
            r3 = 1
            if (r12 == 0) goto L_0x004d
            long r4 = r10.f42882j
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x001a
            java.lang.String r11 = f42874b
            java.lang.String r12 = "The non-blocking thread cannot wait"
            com.apptimize.bo.l(r11, r12)
            return
        L_0x001a:
            java.lang.Object r4 = r10.f42878f
            monitor-enter(r4)
            java.lang.Long r5 = r10.f42884l     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x0033
            long r5 = r5.longValue()     // Catch:{ all -> 0x004a }
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0033
            java.lang.String r11 = f42874b     // Catch:{ all -> 0x004a }
            java.lang.String r12 = "wait calls cannot be nested"
            com.apptimize.bo.l(r11, r12)     // Catch:{ all -> 0x004a }
            monitor-exit(r4)     // Catch:{ all -> 0x004a }
            return
        L_0x0033:
            java.lang.Long r5 = r10.f42879g     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x0042
            long r5 = r5.longValue()     // Catch:{ all -> 0x004a }
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r5 = r2
            goto L_0x0043
        L_0x0042:
            r5 = r3
        L_0x0043:
            monitor-exit(r4)     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x004d
            r11.run()
            return
        L_0x004a:
            r11 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004a }
            throw r11
        L_0x004d:
            r4 = r2
        L_0x004e:
            if (r11 != 0) goto L_0x0060
            if (r12 == 0) goto L_0x005f
            java.lang.Long r5 = r10.f42884l
            if (r5 == 0) goto L_0x005f
            long r5 = r5.longValue()
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            return
        L_0x0060:
            r5 = 0
            java.lang.Object r6 = r10.f42878f     // Catch:{ all -> 0x016f }
            monitor-enter(r6)     // Catch:{ all -> 0x016f }
            java.lang.Long r7 = r10.f42884l     // Catch:{ all -> 0x016c }
            if (r7 == 0) goto L_0x0070
            long r7 = r7.longValue()     // Catch:{ all -> 0x016c }
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x00b7
        L_0x0070:
            long r7 = r10.f42882j     // Catch:{ all -> 0x016c }
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x00a1
            java.lang.Long r7 = r10.f42879g     // Catch:{ all -> 0x016c }
            if (r7 != 0) goto L_0x0082
            java.util.Queue<com.apptimize.h$b> r7 = r10.f42888p     // Catch:{ all -> 0x016c }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x016c }
            if (r7 != 0) goto L_0x00a1
        L_0x0082:
            java.lang.Long r7 = r10.f42879g     // Catch:{ all -> 0x016c }
            if (r7 == 0) goto L_0x008f
            long r7 = r7.longValue()     // Catch:{ all -> 0x016c }
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x008f
            goto L_0x00a1
        L_0x008f:
            java.lang.Long r7 = r10.f42879g     // Catch:{ all -> 0x016c }
            if (r7 != 0) goto L_0x00b7
            java.util.Queue<com.apptimize.h$b> r7 = r10.f42888p     // Catch:{ all -> 0x016c }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x016c }
            if (r7 != 0) goto L_0x00b7
            java.lang.Object r7 = r10.f42878f     // Catch:{ all -> 0x016c }
            r7.notifyAll()     // Catch:{ all -> 0x016c }
            goto L_0x00b7
        L_0x00a1:
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x016c }
            r10.f42879g = r7     // Catch:{ all -> 0x016c }
            int r7 = r10.f42880h     // Catch:{ all -> 0x016c }
            int r7 = r7 + r3
            r10.f42880h = r7     // Catch:{ all -> 0x016c }
            java.lang.Long r7 = r10.f42884l     // Catch:{ all -> 0x016c }
            if (r7 == 0) goto L_0x00b6
            r10.f42884l = r5     // Catch:{ all -> 0x016c }
            int r7 = r10.f42885m     // Catch:{ all -> 0x016c }
            r10.f42880h = r7     // Catch:{ all -> 0x016c }
        L_0x00b6:
            r4 = r3
        L_0x00b7:
            monitor-exit(r6)     // Catch:{ all -> 0x016c }
            long r6 = r10.f42877e     // Catch:{ all -> 0x016f }
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x00c1
            r10.f()     // Catch:{ all -> 0x016f }
        L_0x00c1:
            if (r4 == 0) goto L_0x00fd
            if (r11 == 0) goto L_0x00fd
            com.apptimize.bs r6 = com.apptimize.bs.f41454a     // Catch:{ all -> 0x00f4 }
            if (r6 == 0) goto L_0x00cc
            r6.b((java.lang.Object) r11)     // Catch:{ all -> 0x00f4 }
        L_0x00cc:
            if (r12 == 0) goto L_0x00e8
            java.lang.Object r6 = r10.f42878f     // Catch:{ all -> 0x00f4 }
            monitor-enter(r6)     // Catch:{ all -> 0x00f4 }
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00e5 }
            r10.f42884l = r7     // Catch:{ all -> 0x00e5 }
            int r7 = r10.f42880h     // Catch:{ all -> 0x00e5 }
            r10.f42885m = r7     // Catch:{ all -> 0x00e5 }
            r10.f42879g = r5     // Catch:{ all -> 0x00e5 }
            r10.f42880h = r2     // Catch:{ all -> 0x00e5 }
            monitor-exit(r6)     // Catch:{ all -> 0x00e2 }
            r4 = r2
            goto L_0x00e8
        L_0x00e2:
            r11 = move-exception
            r4 = r2
            goto L_0x00e6
        L_0x00e5:
            r11 = move-exception
        L_0x00e6:
            monitor-exit(r6)     // Catch:{ all -> 0x00e5 }
            throw r11     // Catch:{ all -> 0x00f4 }
        L_0x00e8:
            r11.run()     // Catch:{ all -> 0x00f4 }
            com.apptimize.bs r11 = com.apptimize.bs.f41454a     // Catch:{ all -> 0x016f }
            if (r11 == 0) goto L_0x00f2
            r11.a()     // Catch:{ all -> 0x016f }
        L_0x00f2:
            r11 = r5
            goto L_0x0125
        L_0x00f4:
            r11 = move-exception
            com.apptimize.bs r12 = com.apptimize.bs.f41454a     // Catch:{ all -> 0x016f }
            if (r12 == 0) goto L_0x00fc
            r12.a()     // Catch:{ all -> 0x016f }
        L_0x00fc:
            throw r11     // Catch:{ all -> 0x016f }
        L_0x00fd:
            java.lang.Object r6 = r10.f42878f     // Catch:{ all -> 0x016f }
            monitor-enter(r6)     // Catch:{ all -> 0x016f }
            java.lang.Long r7 = r10.f42879g     // Catch:{ all -> 0x0169 }
            if (r7 == 0) goto L_0x0124
            long r7 = r7.longValue()     // Catch:{ all -> 0x0169 }
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0124
            long r7 = r10.f42877e     // Catch:{ all -> 0x0169 }
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x011a
            java.util.Queue<com.apptimize.h$c> r7 = r10.f42886n     // Catch:{ all -> 0x0169 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0169 }
            if (r7 == 0) goto L_0x0124
        L_0x011a:
            java.lang.Object r7 = r10.f42878f     // Catch:{ InterruptedException -> 0x0124 }
            r8 = 1
            r7.wait(r8)     // Catch:{ InterruptedException -> 0x0124 }
            r10.d()     // Catch:{ InterruptedException -> 0x0124 }
        L_0x0124:
            monitor-exit(r6)     // Catch:{ all -> 0x0169 }
        L_0x0125:
            if (r4 == 0) goto L_0x004e
            java.lang.Object r6 = r10.f42878f     // Catch:{ all -> 0x0156 }
            monitor-enter(r6)     // Catch:{ all -> 0x0156 }
            int r7 = r10.f42880h     // Catch:{ all -> 0x0153 }
            int r7 = r7 - r3
            r10.f42880h = r7     // Catch:{ all -> 0x0153 }
            if (r7 != 0) goto L_0x0133
            r7 = r3
            goto L_0x0134
        L_0x0133:
            r7 = r2
        L_0x0134:
            monitor-exit(r6)     // Catch:{ all -> 0x0150 }
            if (r7 == 0) goto L_0x013e
            r10.g()     // Catch:{ all -> 0x013b }
            goto L_0x013e
        L_0x013b:
            r11 = move-exception
            r2 = r7
            goto L_0x0157
        L_0x013e:
            if (r7 == 0) goto L_0x004e
            java.lang.Object r6 = r10.f42878f
            monitor-enter(r6)
            r10.f42879g = r5     // Catch:{ all -> 0x014d }
            java.lang.Object r5 = r10.f42878f     // Catch:{ all -> 0x014d }
            r5.notifyAll()     // Catch:{ all -> 0x014d }
            monitor-exit(r6)     // Catch:{ all -> 0x014d }
            goto L_0x004e
        L_0x014d:
            r11 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x014d }
            throw r11
        L_0x0150:
            r11 = move-exception
            r2 = r7
            goto L_0x0154
        L_0x0153:
            r11 = move-exception
        L_0x0154:
            monitor-exit(r6)     // Catch:{ all -> 0x0153 }
            throw r11     // Catch:{ all -> 0x0156 }
        L_0x0156:
            r11 = move-exception
        L_0x0157:
            if (r2 == 0) goto L_0x0168
            java.lang.Object r12 = r10.f42878f
            monitor-enter(r12)
            r10.f42879g = r5     // Catch:{ all -> 0x0165 }
            java.lang.Object r0 = r10.f42878f     // Catch:{ all -> 0x0165 }
            r0.notifyAll()     // Catch:{ all -> 0x0165 }
            monitor-exit(r12)     // Catch:{ all -> 0x0165 }
            goto L_0x0168
        L_0x0165:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0165 }
            throw r11
        L_0x0168:
            throw r11
        L_0x0169:
            r11 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0169 }
            throw r11     // Catch:{ all -> 0x016f }
        L_0x016c:
            r11 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x016c }
            throw r11     // Catch:{ all -> 0x016f }
        L_0x016f:
            r11 = move-exception
            if (r4 == 0) goto L_0x01aa
            java.lang.Object r12 = r10.f42878f     // Catch:{ all -> 0x0197 }
            monitor-enter(r12)     // Catch:{ all -> 0x0197 }
            int r0 = r10.f42880h     // Catch:{ all -> 0x0194 }
            int r0 = r0 - r3
            r10.f42880h = r0     // Catch:{ all -> 0x0194 }
            if (r0 != 0) goto L_0x017d
            r2 = r3
        L_0x017d:
            monitor-exit(r12)     // Catch:{ all -> 0x0194 }
            if (r2 == 0) goto L_0x0183
            r10.g()     // Catch:{ all -> 0x0197 }
        L_0x0183:
            if (r2 == 0) goto L_0x01aa
            java.lang.Object r12 = r10.f42878f
            monitor-enter(r12)
            r10.f42879g = r5     // Catch:{ all -> 0x0191 }
            java.lang.Object r0 = r10.f42878f     // Catch:{ all -> 0x0191 }
            r0.notifyAll()     // Catch:{ all -> 0x0191 }
            monitor-exit(r12)     // Catch:{ all -> 0x0191 }
            goto L_0x01aa
        L_0x0191:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0191 }
            throw r11
        L_0x0194:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0194 }
            throw r11     // Catch:{ all -> 0x0197 }
        L_0x0197:
            r11 = move-exception
            if (r2 == 0) goto L_0x01a9
            java.lang.Object r12 = r10.f42878f
            monitor-enter(r12)
            r10.f42879g = r5     // Catch:{ all -> 0x01a6 }
            java.lang.Object r0 = r10.f42878f     // Catch:{ all -> 0x01a6 }
            r0.notifyAll()     // Catch:{ all -> 0x01a6 }
            monitor-exit(r12)     // Catch:{ all -> 0x01a6 }
            goto L_0x01a9
        L_0x01a6:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x01a6 }
            throw r11
        L_0x01a9:
            throw r11
        L_0x01aa:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.h.a(com.apptimize.fi, boolean):void");
    }
}
