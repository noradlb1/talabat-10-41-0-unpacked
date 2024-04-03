package j$.util.stream;

import java.util.Objects;

/* renamed from: j$.util.stream.b0  reason: case insensitive filesystem */
final class C0200b0 extends C0242j2 {

    /* renamed from: b  reason: collision with root package name */
    boolean f29084b;

    /* renamed from: c  reason: collision with root package name */
    Y f29085c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0313y f29086d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0200b0(C0313y yVar, C0272p2 p2Var) {
        super(p2Var);
        this.f29086d = yVar;
        C0272p2 p2Var2 = this.f29166a;
        Objects.requireNonNull(p2Var2);
        this.f29085c = new Y(p2Var2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024 A[Catch:{ all -> 0x0035, all -> 0x003a }, LOOP:0: B:7:0x0024->B:10:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(int r3) {
        /*
            r2 = this;
            j$.util.stream.y r0 = r2.f29086d
            java.lang.Object r0 = r0.f29273u
            j$.util.function.IntFunction r0 = (j$.util.function.IntFunction) r0
            java.lang.Object r3 = r0.apply(r3)
            j$.util.stream.IntStream r3 = (j$.util.stream.IntStream) r3
            if (r3 == 0) goto L_0x003f
            boolean r0 = r2.f29084b     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x001c
            j$.util.stream.IntStream r0 = r3.sequential()     // Catch:{ all -> 0x0035 }
            j$.util.stream.Y r1 = r2.f29085c     // Catch:{ all -> 0x0035 }
            r0.Q(r1)     // Catch:{ all -> 0x0035 }
            goto L_0x003f
        L_0x001c:
            j$.util.stream.IntStream r0 = r3.sequential()     // Catch:{ all -> 0x0035 }
            j$.util.D r0 = r0.spliterator()     // Catch:{ all -> 0x0035 }
        L_0x0024:
            j$.util.stream.p2 r1 = r2.f29166a     // Catch:{ all -> 0x0035 }
            boolean r1 = r1.h()     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x003f
            j$.util.stream.Y r1 = r2.f29085c     // Catch:{ all -> 0x0035 }
            boolean r1 = r0.j(r1)     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0024
            goto L_0x003f
        L_0x0035:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r3 = move-exception
            r0.addSuppressed(r3)
        L_0x003e:
            throw r0
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            r3.close()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0200b0.accept(int):void");
    }

    public final void f(long j11) {
        this.f29166a.f(-1);
    }

    public final boolean h() {
        this.f29084b = true;
        return this.f29166a.h();
    }
}
