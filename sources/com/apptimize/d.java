package com.apptimize;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.apptimize.y;
import i.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class d implements y.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41726a = "d";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f41727b = new HashSet() {
        {
            add(a.class.getName());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static au f41728d;

    /* renamed from: c  reason: collision with root package name */
    private AtomicReference<a> f41729c = new AtomicReference<>((Object) null);

    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f41731b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f41732c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f41733d;

        /* renamed from: e  reason: collision with root package name */
        private final int f41734e;

        /* renamed from: f  reason: collision with root package name */
        private final AtomicBoolean f41735f;

        /* renamed from: g  reason: collision with root package name */
        private final fi f41736g;

        /* renamed from: h  reason: collision with root package name */
        private final fi f41737h;

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0192 A[EDGE_INSN: B:51:0x0192->B:48:0x0192 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0016 A[Catch:{ InterruptedException -> 0x0189 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                android.os.Handler r0 = r8.f41731b
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.String r0 = com.apptimize.d.f41726a
                java.lang.String r1 = "enter AnrWatchdog thread"
                com.apptimize.bo.k(r0, r1)
            L_0x000e:
                java.util.concurrent.atomic.AtomicBoolean r0 = r8.f41735f     // Catch:{ InterruptedException -> 0x0189 }
                boolean r0 = r0.get()     // Catch:{ InterruptedException -> 0x0189 }
                if (r0 != 0) goto L_0x0192
                java.util.concurrent.atomic.AtomicInteger r0 = r8.f41732c     // Catch:{ InterruptedException -> 0x0189 }
                int r0 = r0.get()     // Catch:{ InterruptedException -> 0x0189 }
                java.util.concurrent.atomic.AtomicInteger r1 = r8.f41733d     // Catch:{ InterruptedException -> 0x0189 }
                int r1 = r1.get()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r2 = com.apptimize.d.f41726a     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r3 = "post uiTicker and bgTicker"
                com.apptimize.bo.k(r2, r3)     // Catch:{ InterruptedException -> 0x0189 }
                android.os.Handler r2 = r8.f41731b     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.fi r3 = r8.f41736g     // Catch:{ InterruptedException -> 0x0189 }
                r2.post(r3)     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.au r2 = com.apptimize.d.f41728d     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.h r2 = r2.c()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.fi r3 = r8.f41737h     // Catch:{ InterruptedException -> 0x0189 }
                r2.b((com.apptimize.fi) r3)     // Catch:{ InterruptedException -> 0x0189 }
                int r2 = r8.f41734e     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bs r3 = com.apptimize.bs.f41454a     // Catch:{ InterruptedException -> 0x0189 }
                if (r3 == 0) goto L_0x004a
                int r3 = com.apptimize.bs.f41455b     // Catch:{ InterruptedException -> 0x0189 }
                if (r3 <= 0) goto L_0x004a
                goto L_0x004b
            L_0x004a:
                r3 = r2
            L_0x004b:
                java.util.concurrent.atomic.AtomicBoolean r4 = r8.f41735f     // Catch:{ InterruptedException -> 0x0189 }
                boolean r4 = r4.get()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r5 = ";"
                if (r4 != 0) goto L_0x008b
                if (r2 <= 0) goto L_0x008b
                long r6 = (long) r3
                java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bs r4 = com.apptimize.bs.f41454a     // Catch:{ InterruptedException -> 0x0189 }
                if (r4 == 0) goto L_0x0089
                int r4 = com.apptimize.bs.f41455b     // Catch:{ InterruptedException -> 0x0189 }
                if (r4 <= 0) goto L_0x0089
                com.apptimize.d$a$3 r4 = new com.apptimize.d$a$3     // Catch:{ InterruptedException -> 0x0189 }
                r4.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.util.Set r6 = com.apptimize.d.f41727b     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.fr$a r4 = com.apptimize.fr.a((java.util.Set<java.lang.Long>) r4, (java.util.Set<java.lang.String>) r6)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0189 }
                r6.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r7 = r4.f42467c     // Catch:{ InterruptedException -> 0x0189 }
                r6.append(r7)     // Catch:{ InterruptedException -> 0x0189 }
                r6.append(r5)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = r4.f42465a     // Catch:{ InterruptedException -> 0x0189 }
                r6.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = r6.toString()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bs.b((java.lang.String) r4)     // Catch:{ InterruptedException -> 0x0189 }
            L_0x0089:
                int r2 = r2 - r3
                goto L_0x004b
            L_0x008b:
                java.util.concurrent.atomic.AtomicBoolean r2 = r8.f41735f     // Catch:{ InterruptedException -> 0x0189 }
                boolean r2 = r2.get()     // Catch:{ InterruptedException -> 0x0189 }
                if (r2 != 0) goto L_0x0192
                boolean r2 = android.os.Debug.isDebuggerConnected()     // Catch:{ InterruptedException -> 0x0189 }
                if (r2 == 0) goto L_0x009b
                goto L_0x0192
            L_0x009b:
                java.lang.String r2 = com.apptimize.d.f41726a     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0189 }
                r3.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = "ANR check uiTick:"
                r3.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                java.util.concurrent.atomic.AtomicInteger r4 = r8.f41732c     // Catch:{ InterruptedException -> 0x0189 }
                int r4 = r4.get()     // Catch:{ InterruptedException -> 0x0189 }
                r3.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = " lastUiTick:"
                r3.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                r3.append(r0)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r3 = r3.toString()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bo.k(r2, r3)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r2 = com.apptimize.d.f41726a     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0189 }
                r3.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = "ANR check bgTick:"
                r3.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                java.util.concurrent.atomic.AtomicInteger r4 = r8.f41733d     // Catch:{ InterruptedException -> 0x0189 }
                int r4 = r4.get()     // Catch:{ InterruptedException -> 0x0189 }
                r3.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = " lastBgTick:"
                r3.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                r3.append(r1)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r3 = r3.toString()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bo.k(r2, r3)     // Catch:{ InterruptedException -> 0x0189 }
                java.util.concurrent.atomic.AtomicInteger r2 = r8.f41732c     // Catch:{ InterruptedException -> 0x0189 }
                int r2 = r2.get()     // Catch:{ InterruptedException -> 0x0189 }
                if (r2 == r0) goto L_0x00f7
                java.util.concurrent.atomic.AtomicInteger r0 = r8.f41733d     // Catch:{ InterruptedException -> 0x0189 }
                int r0 = r0.get()     // Catch:{ InterruptedException -> 0x0189 }
                if (r0 != r1) goto L_0x000e
            L_0x00f7:
                com.apptimize.d$a$4 r0 = new com.apptimize.d$a$4     // Catch:{ InterruptedException -> 0x0189 }
                r0.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.util.Set r2 = com.apptimize.d.f41727b     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.fr$a r0 = com.apptimize.fr.a((java.util.Set<java.lang.Long>) r0, (java.util.Set<java.lang.String>) r2)     // Catch:{ InterruptedException -> 0x0189 }
                java.util.concurrent.atomic.AtomicInteger r2 = r8.f41733d     // Catch:{ InterruptedException -> 0x0189 }
                int r2 = r2.get()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r3 = "AN1019"
                if (r2 != r1) goto L_0x010f
                goto L_0x011d
            L_0x010f:
                java.lang.String r1 = r0.f42467c     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r2 = "com.apptimize"
                boolean r1 = r1.contains(r2)     // Catch:{ InterruptedException -> 0x0189 }
                if (r1 == 0) goto L_0x011a
                goto L_0x011d
            L_0x011a:
                java.lang.String r1 = "AN1020"
                r3 = r1
            L_0x011d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0189 }
                r1.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r2 = r0.f42467c     // Catch:{ InterruptedException -> 0x0189 }
                r1.append(r2)     // Catch:{ InterruptedException -> 0x0189 }
                r1.append(r5)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r0 = r0.f42465a     // Catch:{ InterruptedException -> 0x0189 }
                r1.append(r0)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r0 = r1.toString()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.au r1 = com.apptimize.d.f41728d     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bq r1 = r1.a()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bq$b r2 = com.apptimize.bq.b.A     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.d$a$5 r4 = new com.apptimize.d$a$5     // Catch:{ InterruptedException -> 0x0189 }
                r4.<init>(r3, r0)     // Catch:{ InterruptedException -> 0x0189 }
                r1.a((com.apptimize.bq.b) r2, (java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r1 = com.apptimize.d.f41726a     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0189 }
                r2.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = "ANR code: "
                r2.append(r4)     // Catch:{ InterruptedException -> 0x0189 }
                r2.append(r3)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bo.k(r1, r2)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r1 = com.apptimize.d.f41726a     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0189 }
                r2.<init>()     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r3 = "ANR stack: "
                r2.append(r3)     // Catch:{ InterruptedException -> 0x0189 }
                r2.append(r0)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bo.k(r1, r2)     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String[] r0 = r0.split(r5)     // Catch:{ InterruptedException -> 0x0189 }
                int r1 = r0.length     // Catch:{ InterruptedException -> 0x0189 }
                r2 = 0
            L_0x017b:
                if (r2 >= r1) goto L_0x0192
                r3 = r0[r2]     // Catch:{ InterruptedException -> 0x0189 }
                java.lang.String r4 = com.apptimize.d.f41726a     // Catch:{ InterruptedException -> 0x0189 }
                com.apptimize.bo.k(r4, r3)     // Catch:{ InterruptedException -> 0x0189 }
                int r2 = r2 + 1
                goto L_0x017b
            L_0x0189:
                java.lang.String r0 = com.apptimize.d.f41726a
                java.lang.String r1 = "interrupted"
                com.apptimize.bo.k(r0, r1)
            L_0x0192:
                java.lang.String r0 = com.apptimize.d.f41726a
                java.lang.String r1 = "exit AnrWatchdog thread"
                com.apptimize.bo.k(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.d.a.run():void");
        }

        private a(int i11) {
            this.f41731b = Looper.getMainLooper() != null ? new Handler(Looper.getMainLooper()) : null;
            this.f41732c = new AtomicInteger(0);
            this.f41733d = new AtomicInteger(0);
            this.f41735f = new AtomicBoolean(false);
            this.f41736g = new fi() {
                public void run() {
                    int i11;
                    int i12 = a.this.f41732c.get();
                    if (i12 == Integer.MAX_VALUE) {
                        i11 = 0;
                    } else {
                        i11 = i12 + 1;
                    }
                    a.this.f41732c.compareAndSet(i12, i11);
                    String c11 = d.f41726a;
                    bo.k(c11, "uiTicker " + a.this.f41732c.get());
                }
            };
            this.f41737h = new fi() {
                public void run() {
                    int i11;
                    int i12 = a.this.f41733d.get();
                    if (i12 == Integer.MAX_VALUE) {
                        i11 = 0;
                    } else {
                        i11 = i12 + 1;
                    }
                    a.this.f41733d.compareAndSet(i12, i11);
                    String c11 = d.f41726a;
                    bo.k(c11, "bgTicker " + a.this.f41733d.get());
                }
            };
            this.f41734e = i11;
        }

        public void a() {
            this.f41735f.set(true);
        }
    }

    public d(au auVar, y yVar) {
        bo.k(f41726a, "start AnrWatchdog");
        f41728d = auVar;
        if (yVar == null) {
            e();
            return;
        }
        yVar.a(this);
        if (!yVar.a()) {
            e();
        }
    }

    private void e() {
        a aVar = new a(5000);
        if (b.a(this.f41729c, (Object) null, aVar)) {
            bo.k(f41726a, "start AnrWatchdogThread");
            aVar.setName("ApptimizeAnrWatchdog");
            aVar.start();
        }
    }

    private void f() {
        a andSet = this.f41729c.getAndSet((Object) null);
        if (andSet != null) {
            bo.k(f41726a, "interrupt AnrWatchdogThread");
            andSet.a();
            andSet.interrupt();
        }
    }

    public void a(Activity activity) {
        e();
    }

    public void a_() {
        f();
    }
}
