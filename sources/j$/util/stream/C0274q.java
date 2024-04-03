package j$.util.stream;

import java.util.Objects;

/* renamed from: j$.util.stream.q  reason: case insensitive filesystem */
final class C0274q extends C0252l2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29196b = 0;

    /* renamed from: c  reason: collision with root package name */
    boolean f29197c;

    /* renamed from: d  reason: collision with root package name */
    Object f29198d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C0204c f29199e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0274q(C0283s sVar, C0272p2 p2Var) {
        super(p2Var);
        this.f29199e = sVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0274q(C0308x xVar, C0272p2 p2Var) {
        super(p2Var);
        this.f29199e = xVar;
        C0272p2 p2Var2 = this.f29177a;
        Objects.requireNonNull(p2Var2);
        this.f29198d = new C0293u(p2Var2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0274q(C0313y yVar, C0272p2 p2Var) {
        super(p2Var);
        this.f29199e = yVar;
        C0272p2 p2Var2 = this.f29177a;
        Objects.requireNonNull(p2Var2);
        this.f29198d = new Y(p2Var2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0274q(C0317z zVar, C0272p2 p2Var) {
        super(p2Var);
        this.f29199e = zVar;
        C0272p2 p2Var2 = this.f29177a;
        Objects.requireNonNull(p2Var2);
        this.f29198d = new C0230h0(p2Var2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[Catch:{ all -> 0x0089, all -> 0x008e }, LOOP:1: B:28:0x0078->B:31:0x0086, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da A[Catch:{ all -> 0x00eb, all -> 0x00f0 }, LOOP:2: B:56:0x00da->B:59:0x00e8, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031 A[Catch:{ all -> 0x0042, all -> 0x0047 }, LOOP:0: B:9:0x0031->B:12:0x003f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f29196b
            j$.util.stream.c r1 = r3.f29199e
            j$.util.stream.p2 r2 = r3.f29177a
            switch(r0) {
                case 0: goto L_0x0099;
                case 1: goto L_0x0052;
                case 2: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00b4
        L_0x000b:
            j$.util.stream.y r1 = (j$.util.stream.C0313y) r1
            java.lang.Object r0 = r1.f29273u
            j$.util.function.Function r0 = (j$.util.function.Function) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.IntStream r4 = (j$.util.stream.IntStream) r4
            if (r4 == 0) goto L_0x004c
            boolean r0 = r3.f29197c     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0029
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x0042 }
            java.lang.Object r1 = r3.f29198d     // Catch:{ all -> 0x0042 }
            j$.util.function.K r1 = (j$.util.function.K) r1     // Catch:{ all -> 0x0042 }
            r0.Q(r1)     // Catch:{ all -> 0x0042 }
            goto L_0x004c
        L_0x0029:
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x0042 }
            j$.util.D r0 = r0.spliterator()     // Catch:{ all -> 0x0042 }
        L_0x0031:
            boolean r1 = r2.h()     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x004c
            java.lang.Object r1 = r3.f29198d     // Catch:{ all -> 0x0042 }
            j$.util.function.K r1 = (j$.util.function.K) r1     // Catch:{ all -> 0x0042 }
            boolean r1 = r0.j(r1)     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0031
            goto L_0x004c
        L_0x0042:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x004b:
            throw r0
        L_0x004c:
            if (r4 == 0) goto L_0x0051
            r4.close()
        L_0x0051:
            return
        L_0x0052:
            j$.util.stream.z r1 = (j$.util.stream.C0317z) r1
            java.lang.Object r0 = r1.f29286u
            j$.util.function.Function r0 = (j$.util.function.Function) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.LongStream r4 = (j$.util.stream.LongStream) r4
            if (r4 == 0) goto L_0x0093
            boolean r0 = r3.f29197c     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0070
            j$.util.stream.LongStream r0 = r4.sequential()     // Catch:{ all -> 0x0089 }
            java.lang.Object r1 = r3.f29198d     // Catch:{ all -> 0x0089 }
            j$.util.function.f0 r1 = (j$.util.function.C0152f0) r1     // Catch:{ all -> 0x0089 }
            r0.B(r1)     // Catch:{ all -> 0x0089 }
            goto L_0x0093
        L_0x0070:
            j$.util.stream.LongStream r0 = r4.sequential()     // Catch:{ all -> 0x0089 }
            j$.util.G r0 = r0.spliterator()     // Catch:{ all -> 0x0089 }
        L_0x0078:
            boolean r1 = r2.h()     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0093
            java.lang.Object r1 = r3.f29198d     // Catch:{ all -> 0x0089 }
            j$.util.function.f0 r1 = (j$.util.function.C0152f0) r1     // Catch:{ all -> 0x0089 }
            boolean r1 = r0.e(r1)     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0078
            goto L_0x0093
        L_0x0089:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x0092:
            throw r0
        L_0x0093:
            if (r4 == 0) goto L_0x0098
            r4.close()
        L_0x0098:
            return
        L_0x0099:
            if (r4 != 0) goto L_0x00a4
            boolean r4 = r3.f29197c
            if (r4 != 0) goto L_0x00b3
            r4 = 1
            r3.f29197c = r4
            r4 = 0
            goto L_0x00ae
        L_0x00a4:
            java.lang.Object r0 = r3.f29198d
            if (r0 == 0) goto L_0x00ae
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x00b3
        L_0x00ae:
            r3.f29198d = r4
            r2.accept(r4)
        L_0x00b3:
            return
        L_0x00b4:
            j$.util.stream.x r1 = (j$.util.stream.C0308x) r1
            java.lang.Object r0 = r1.f29266u
            j$.util.function.Function r0 = (j$.util.function.Function) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.DoubleStream r4 = (j$.util.stream.DoubleStream) r4
            if (r4 == 0) goto L_0x00f5
            boolean r0 = r3.f29197c     // Catch:{ all -> 0x00eb }
            if (r0 != 0) goto L_0x00d2
            j$.util.stream.DoubleStream r0 = r4.sequential()     // Catch:{ all -> 0x00eb }
            java.lang.Object r1 = r3.f29198d     // Catch:{ all -> 0x00eb }
            j$.util.function.m r1 = (j$.util.function.C0165m) r1     // Catch:{ all -> 0x00eb }
            r0.D(r1)     // Catch:{ all -> 0x00eb }
            goto L_0x00f5
        L_0x00d2:
            j$.util.stream.DoubleStream r0 = r4.sequential()     // Catch:{ all -> 0x00eb }
            j$.util.A r0 = r0.spliterator()     // Catch:{ all -> 0x00eb }
        L_0x00da:
            boolean r1 = r2.h()     // Catch:{ all -> 0x00eb }
            if (r1 != 0) goto L_0x00f5
            java.lang.Object r1 = r3.f29198d     // Catch:{ all -> 0x00eb }
            j$.util.function.m r1 = (j$.util.function.C0165m) r1     // Catch:{ all -> 0x00eb }
            boolean r1 = r0.o(r1)     // Catch:{ all -> 0x00eb }
            if (r1 != 0) goto L_0x00da
            goto L_0x00f5
        L_0x00eb:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x00f4:
            throw r0
        L_0x00f5:
            if (r4 == 0) goto L_0x00fa
            r4.close()
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0274q.accept(java.lang.Object):void");
    }

    public final void end() {
        switch (this.f29196b) {
            case 0:
                this.f29197c = false;
                this.f29198d = null;
                this.f29177a.end();
                return;
            default:
                super.end();
                return;
        }
    }

    public final void f(long j11) {
        int i11 = this.f29196b;
        C0272p2 p2Var = this.f29177a;
        switch (i11) {
            case 0:
                this.f29197c = false;
                this.f29198d = null;
                p2Var.f(-1);
                return;
            case 1:
                p2Var.f(-1);
                return;
            case 2:
                p2Var.f(-1);
                return;
            default:
                p2Var.f(-1);
                return;
        }
    }

    public final boolean h() {
        int i11 = this.f29196b;
        C0272p2 p2Var = this.f29177a;
        switch (i11) {
            case 1:
                this.f29197c = true;
                return p2Var.h();
            case 2:
                this.f29197c = true;
                return p2Var.h();
            case 3:
                this.f29197c = true;
                return p2Var.h();
            default:
                return super.h();
        }
    }
}
