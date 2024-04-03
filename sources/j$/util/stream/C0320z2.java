package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* renamed from: j$.util.stream.z2  reason: case insensitive filesystem */
final class C0320z2 extends C0209d {

    /* renamed from: j  reason: collision with root package name */
    private final C0204c f29290j;

    /* renamed from: k  reason: collision with root package name */
    private final IntFunction f29291k;

    /* renamed from: l  reason: collision with root package name */
    private final long f29292l;

    /* renamed from: m  reason: collision with root package name */
    private final long f29293m;

    /* renamed from: n  reason: collision with root package name */
    private long f29294n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f29295o;

    C0320z2(C0204c cVar, C0204c cVar2, Spliterator spliterator, IntFunction intFunction, long j11, long j12) {
        super((C0314y0) cVar2, spliterator);
        this.f29290j = cVar;
        this.f29291k = intFunction;
        this.f29292l = j11;
        this.f29293m = j12;
    }

    C0320z2(C0320z2 z2Var, Spliterator spliterator) {
        super((C0209d) z2Var, spliterator);
        this.f29290j = z2Var.f29290j;
        this.f29291k = z2Var.f29291k;
        this.f29292l = z2Var.f29292l;
        this.f29293m = z2Var.f29293m;
    }

    private long k(long j11) {
        if (this.f29295o) {
            return this.f29294n;
        }
        C0320z2 z2Var = (C0320z2) this.f29140d;
        C0320z2 z2Var2 = (C0320z2) this.f29141e;
        if (z2Var == null || z2Var2 == null) {
            return this.f29294n;
        }
        long k11 = z2Var.k(j11);
        return k11 >= j11 ? k11 : k11 + z2Var2.k(j11);
    }

    /* access modifiers changed from: protected */
    public final Object a() {
        long j11 = -1;
        if (d() == null) {
            if (C0213d3.SIZED.s(this.f29290j.f29090j)) {
                j11 = this.f29290j.N0(this.f29138b);
            }
            C0 c12 = this.f29290j.c1(j11, this.f29291k);
            C0272p2 v12 = this.f29290j.v1(this.f29137a.T0(), c12);
            C0314y0 y0Var = this.f29137a;
            y0Var.K0(this.f29138b, y0Var.h1(v12));
            return c12.build();
        }
        C0 c13 = this.f29290j.c1(-1, this.f29291k);
        if (this.f29292l == 0) {
            C0272p2 v13 = this.f29290j.v1(this.f29137a.T0(), c13);
            C0314y0 y0Var2 = this.f29137a;
            y0Var2.K0(this.f29138b, y0Var2.h1(v13));
        } else {
            this.f29137a.g1(this.f29138b, c13);
        }
        H0 build = c13.build();
        this.f29294n = build.count();
        this.f29295o = true;
        this.f29138b = null;
        return build;
    }

    /* access modifiers changed from: protected */
    public final C0219f e(Spliterator spliterator) {
        return new C0320z2(this, spliterator);
    }

    /* access modifiers changed from: protected */
    public final void h() {
        this.f29104i = true;
        if (this.f29295o) {
            f(j());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final C0201b1 j() {
        return C0314y0.M0(this.f29290j.n1());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCompletion(java.util.concurrent.CountedCompleter r15) {
        /*
            r14 = this;
            j$.util.stream.f r0 = r14.f29140d
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            r4 = 0
            if (r3 != 0) goto L_0x0090
            j$.util.stream.z2 r0 = (j$.util.stream.C0320z2) r0
            long r6 = r0.f29294n
            j$.util.stream.f r0 = r14.f29141e
            j$.util.stream.z2 r0 = (j$.util.stream.C0320z2) r0
            long r8 = r0.f29294n
            long r6 = r6 + r8
            r14.f29294n = r6
            boolean r0 = r14.f29104i
            if (r0 == 0) goto L_0x0021
            r14.f29294n = r4
            goto L_0x0027
        L_0x0021:
            long r6 = r14.f29294n
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
        L_0x0027:
            j$.util.stream.b1 r0 = r14.j()
        L_0x002b:
            r6 = r0
            goto L_0x0061
        L_0x002d:
            j$.util.stream.f r0 = r14.f29140d
            j$.util.stream.z2 r0 = (j$.util.stream.C0320z2) r0
            long r6 = r0.f29294n
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0042
            j$.util.stream.f r0 = r14.f29141e
            j$.util.stream.z2 r0 = (j$.util.stream.C0320z2) r0
            java.lang.Object r0 = r0.c()
            j$.util.stream.H0 r0 = (j$.util.stream.H0) r0
            goto L_0x002b
        L_0x0042:
            j$.util.stream.c r0 = r14.f29290j
            j$.util.stream.e3 r0 = r0.n1()
            j$.util.stream.f r3 = r14.f29140d
            j$.util.stream.z2 r3 = (j$.util.stream.C0320z2) r3
            java.lang.Object r3 = r3.c()
            j$.util.stream.H0 r3 = (j$.util.stream.H0) r3
            j$.util.stream.f r6 = r14.f29141e
            j$.util.stream.z2 r6 = (j$.util.stream.C0320z2) r6
            java.lang.Object r6 = r6.c()
            j$.util.stream.H0 r6 = (j$.util.stream.H0) r6
            j$.util.stream.J0 r0 = j$.util.stream.C0314y0.I0(r0, r3, r6)
            goto L_0x002b
        L_0x0061:
            j$.util.stream.f r0 = r14.d()
            if (r0 != 0) goto L_0x0069
            r0 = r1
            goto L_0x006a
        L_0x0069:
            r0 = r2
        L_0x006a:
            if (r0 == 0) goto L_0x008b
            long r7 = r14.f29293m
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0080
            long r7 = r6.count()
            long r9 = r14.f29292l
            long r11 = r14.f29293m
            long r9 = r9 + r11
            long r7 = java.lang.Math.min(r7, r9)
            goto L_0x0082
        L_0x0080:
            long r7 = r14.f29294n
        L_0x0082:
            r9 = r7
            long r7 = r14.f29292l
            j$.util.function.IntFunction r11 = r14.f29291k
            j$.util.stream.H0 r6 = r6.q(r7, r9, r11)
        L_0x008b:
            r14.f(r6)
            r14.f29295o = r1
        L_0x0090:
            long r6 = r14.f29293m
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x00e8
            j$.util.stream.f r0 = r14.d()
            if (r0 != 0) goto L_0x009e
            r0 = r1
            goto L_0x009f
        L_0x009e:
            r0 = r2
        L_0x009f:
            if (r0 != 0) goto L_0x00e8
            long r3 = r14.f29292l
            long r5 = r14.f29293m
            long r3 = r3 + r5
            boolean r0 = r14.f29295o
            if (r0 == 0) goto L_0x00ad
            long r5 = r14.f29294n
            goto L_0x00b1
        L_0x00ad:
            long r5 = r14.k(r3)
        L_0x00b1:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x00b6
            goto L_0x00e3
        L_0x00b6:
            j$.util.stream.f r0 = r14.d()
            j$.util.stream.z2 r0 = (j$.util.stream.C0320z2) r0
            r7 = r14
        L_0x00bd:
            if (r0 == 0) goto L_0x00dd
            j$.util.stream.f r8 = r0.f29141e
            if (r7 != r8) goto L_0x00d3
            j$.util.stream.f r7 = r0.f29140d
            j$.util.stream.z2 r7 = (j$.util.stream.C0320z2) r7
            if (r7 == 0) goto L_0x00d3
            long r7 = r7.k(r3)
            long r5 = r5 + r7
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x00d3
            goto L_0x00e3
        L_0x00d3:
            j$.util.stream.f r7 = r0.d()
            j$.util.stream.z2 r7 = (j$.util.stream.C0320z2) r7
            r13 = r7
            r7 = r0
            r0 = r13
            goto L_0x00bd
        L_0x00dd:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x00e2
            goto L_0x00e3
        L_0x00e2:
            r1 = r2
        L_0x00e3:
            if (r1 == 0) goto L_0x00e8
            r14.i()
        L_0x00e8:
            super.onCompletion(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0320z2.onCompletion(java.util.concurrent.CountedCompleter):void");
    }
}
