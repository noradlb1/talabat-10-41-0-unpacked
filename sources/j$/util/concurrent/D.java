package j$.util.concurrent;

import j$.util.function.C0144b0;
import j$.util.function.ToLongFunction;
import java.util.concurrent.CountedCompleter;

final class D extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToLongFunction f28625j;

    /* renamed from: k  reason: collision with root package name */
    final C0144b0 f28626k;

    /* renamed from: l  reason: collision with root package name */
    final long f28627l;

    /* renamed from: m  reason: collision with root package name */
    long f28628m;

    /* renamed from: n  reason: collision with root package name */
    D f28629n;

    /* renamed from: o  reason: collision with root package name */
    D f28630o;

    D(C0116b bVar, int i11, int i12, int i13, E[] eArr, D d11, ToLongFunction toLongFunction, long j11, C0144b0 b0Var) {
        super(bVar, i11, i12, i13, eArr);
        this.f28630o = d11;
        this.f28625j = toLongFunction;
        this.f28627l = j11;
        this.f28626k = b0Var;
    }

    public final void compute() {
        C0144b0 b0Var;
        ToLongFunction toLongFunction = this.f28625j;
        if (toLongFunction != null && (b0Var = this.f28626k) != null) {
            long j11 = this.f28627l;
            int i11 = this.f28701f;
            while (this.f28704i > 0) {
                int i12 = this.f28702g;
                int i13 = (i12 + i11) >>> 1;
                if (i13 <= i11) {
                    break;
                }
                addToPendingCount(1);
                int i14 = this.f28704i >>> 1;
                this.f28704i = i14;
                this.f28702g = i13;
                ToLongFunction toLongFunction2 = toLongFunction;
                ToLongFunction toLongFunction3 = toLongFunction;
                D d11 = r0;
                D d12 = new D(this, i14, i13, i12, this.f28696a, this.f28629n, toLongFunction2, j11, b0Var);
                this.f28629n = d11;
                d11.fork();
                toLongFunction = toLongFunction3;
                i11 = i11;
            }
            ToLongFunction toLongFunction4 = toLongFunction;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                j11 = b0Var.applyAsLong(j11, toLongFunction4.applyAsLong(a11.f28633c));
            }
            this.f28628m = j11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                D d13 = (D) firstComplete;
                D d14 = d13.f28629n;
                while (d14 != null) {
                    d13.f28628m = b0Var.applyAsLong(d13.f28628m, d14.f28628m);
                    d14 = d14.f28630o;
                    d13.f28629n = d14;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Long.valueOf(this.f28628m);
    }
}
