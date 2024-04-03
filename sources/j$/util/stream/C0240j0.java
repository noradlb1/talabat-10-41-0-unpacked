package j$.util.stream;

import java.util.Objects;

/* renamed from: j$.util.stream.j0  reason: case insensitive filesystem */
final class C0240j0 extends C0247k2 {

    /* renamed from: b  reason: collision with root package name */
    boolean f29163b;

    /* renamed from: c  reason: collision with root package name */
    C0230h0 f29164c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0317z f29165d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0240j0(C0317z zVar, C0272p2 p2Var) {
        super(p2Var);
        this.f29165d = zVar;
        C0272p2 p2Var2 = this.f29169a;
        Objects.requireNonNull(p2Var2);
        this.f29164c = new C0230h0(p2Var2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024 A[Catch:{ all -> 0x0035, all -> 0x003a }, LOOP:0: B:7:0x0024->B:10:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(long r2) {
        /*
            r1 = this;
            j$.util.stream.z r0 = r1.f29165d
            java.lang.Object r0 = r0.f29286u
            j$.util.function.i0 r0 = (j$.util.function.C0158i0) r0
            java.lang.Object r2 = r0.apply(r2)
            j$.util.stream.LongStream r2 = (j$.util.stream.LongStream) r2
            if (r2 == 0) goto L_0x003f
            boolean r3 = r1.f29163b     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x001c
            j$.util.stream.LongStream r3 = r2.sequential()     // Catch:{ all -> 0x0035 }
            j$.util.stream.h0 r0 = r1.f29164c     // Catch:{ all -> 0x0035 }
            r3.B(r0)     // Catch:{ all -> 0x0035 }
            goto L_0x003f
        L_0x001c:
            j$.util.stream.LongStream r3 = r2.sequential()     // Catch:{ all -> 0x0035 }
            j$.util.G r3 = r3.spliterator()     // Catch:{ all -> 0x0035 }
        L_0x0024:
            j$.util.stream.p2 r0 = r1.f29169a     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.h()     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x003f
            j$.util.stream.h0 r0 = r1.f29164c     // Catch:{ all -> 0x0035 }
            boolean r0 = r3.e(r0)     // Catch:{ all -> 0x0035 }
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
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0240j0.accept(long):void");
    }

    public final void f(long j11) {
        this.f29169a.f(-1);
    }

    public final boolean h() {
        this.f29163b = true;
        return this.f29169a.h();
    }
}
