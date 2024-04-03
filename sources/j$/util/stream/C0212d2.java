package j$.util.stream;

/* renamed from: j$.util.stream.d2  reason: case insensitive filesystem */
final class C0212d2 extends C0252l2 {

    /* renamed from: b  reason: collision with root package name */
    boolean f29107b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0207c2 f29108c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0212d2(C0207c2 c2Var, C0272p2 p2Var) {
        super(p2Var);
        this.f29108c = c2Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026 A[Catch:{ all -> 0x0033, all -> 0x0038 }, LOOP:0: B:9:0x0026->B:12:0x0030, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4) {
        /*
            r3 = this;
            j$.util.stream.c2 r0 = r3.f29108c
            j$.util.function.Function r0 = r0.f29101u
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.Stream r4 = (j$.util.stream.Stream) r4
            if (r4 == 0) goto L_0x003d
            boolean r0 = r3.f29107b     // Catch:{ all -> 0x0033 }
            j$.util.stream.p2 r1 = r3.f29177a
            if (r0 != 0) goto L_0x001c
            j$.util.stream.BaseStream r0 = r4.sequential()     // Catch:{ all -> 0x0033 }
            j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x0033 }
            r0.forEach(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x003d
        L_0x001c:
            j$.util.stream.BaseStream r0 = r4.sequential()     // Catch:{ all -> 0x0033 }
            j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x0033 }
            j$.util.Spliterator r0 = r0.spliterator()     // Catch:{ all -> 0x0033 }
        L_0x0026:
            boolean r2 = r1.h()     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x003d
            boolean r2 = r0.a(r1)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0026
            goto L_0x003d
        L_0x0033:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x003c:
            throw r0
        L_0x003d:
            if (r4 == 0) goto L_0x0042
            r4.close()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0212d2.accept(java.lang.Object):void");
    }

    public final void f(long j11) {
        this.f29177a.f(-1);
    }

    public final boolean h() {
        this.f29107b = true;
        return this.f29177a.h();
    }
}
