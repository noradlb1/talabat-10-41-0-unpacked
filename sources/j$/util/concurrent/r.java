package j$.util.concurrent;

import j$.util.function.C0144b0;
import j$.util.function.ToLongFunction;
import java.util.concurrent.CountedCompleter;

final class r extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToLongFunction f28740j;

    /* renamed from: k  reason: collision with root package name */
    final C0144b0 f28741k;

    /* renamed from: l  reason: collision with root package name */
    final long f28742l;

    /* renamed from: m  reason: collision with root package name */
    long f28743m;

    /* renamed from: n  reason: collision with root package name */
    r f28744n;

    /* renamed from: o  reason: collision with root package name */
    r f28745o;

    r(C0116b bVar, int i11, int i12, int i13, E[] eArr, r rVar, ToLongFunction toLongFunction, long j11, C0144b0 b0Var) {
        super(bVar, i11, i12, i13, eArr);
        this.f28745o = rVar;
        this.f28740j = toLongFunction;
        this.f28742l = j11;
        this.f28741k = b0Var;
    }

    public final void compute() {
        C0144b0 b0Var;
        ToLongFunction toLongFunction = this.f28740j;
        if (toLongFunction != null && (b0Var = this.f28741k) != null) {
            long j11 = this.f28742l;
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
                r rVar = r0;
                r rVar2 = new r(this, i14, i13, i12, this.f28696a, this.f28744n, toLongFunction2, j11, b0Var);
                this.f28744n = rVar;
                rVar.fork();
                toLongFunction = toLongFunction3;
                i11 = i11;
            }
            ToLongFunction toLongFunction4 = toLongFunction;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                j11 = b0Var.applyAsLong(j11, toLongFunction4.applyAsLong(a11));
            }
            this.f28743m = j11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                r rVar3 = (r) firstComplete;
                r rVar4 = rVar3.f28744n;
                while (rVar4 != null) {
                    rVar3.f28743m = b0Var.applyAsLong(rVar3.f28743m, rVar4.f28743m);
                    rVar4 = rVar4.f28745o;
                    rVar3.f28744n = rVar4;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Long.valueOf(this.f28743m);
    }
}
