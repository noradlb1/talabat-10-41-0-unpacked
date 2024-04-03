package j$.util.stream;

import java.util.Objects;

final class A extends C0237i2 {

    /* renamed from: b  reason: collision with root package name */
    boolean f28889b;

    /* renamed from: c  reason: collision with root package name */
    C0293u f28890c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0308x f28891d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    A(C0308x xVar, C0272p2 p2Var) {
        super(p2Var);
        this.f28891d = xVar;
        C0272p2 p2Var2 = this.f29160a;
        Objects.requireNonNull(p2Var2);
        this.f28890c = new C0293u(p2Var2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024 A[Catch:{ all -> 0x0035, all -> 0x003a }, LOOP:0: B:7:0x0024->B:10:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(double r2) {
        /*
            r1 = this;
            j$.util.stream.x r0 = r1.f28891d
            java.lang.Object r0 = r0.f29266u
            j$.util.function.p r0 = (j$.util.function.C0171p) r0
            java.lang.Object r2 = r0.apply(r2)
            j$.util.stream.DoubleStream r2 = (j$.util.stream.DoubleStream) r2
            if (r2 == 0) goto L_0x003f
            boolean r3 = r1.f28889b     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x001c
            j$.util.stream.DoubleStream r3 = r2.sequential()     // Catch:{ all -> 0x0035 }
            j$.util.stream.u r0 = r1.f28890c     // Catch:{ all -> 0x0035 }
            r3.D(r0)     // Catch:{ all -> 0x0035 }
            goto L_0x003f
        L_0x001c:
            j$.util.stream.DoubleStream r3 = r2.sequential()     // Catch:{ all -> 0x0035 }
            j$.util.A r3 = r3.spliterator()     // Catch:{ all -> 0x0035 }
        L_0x0024:
            j$.util.stream.p2 r0 = r1.f29160a     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.h()     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x003f
            j$.util.stream.u r0 = r1.f28890c     // Catch:{ all -> 0x0035 }
            boolean r0 = r3.o(r0)     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0024
            goto L_0x003f
        L_0x0035:
            r3 = move-exception
            r2.close()     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x003e:
            throw r3
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.close()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.A.accept(double):void");
    }

    public final void f(long j11) {
        this.f29160a.f(-1);
    }

    public final boolean h() {
        this.f28889b = true;
        return this.f29160a.h();
    }
}
