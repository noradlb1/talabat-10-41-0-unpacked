package j$.util.concurrent;

import j$.util.function.C0144b0;
import j$.util.function.ToLongFunction;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.v  reason: case insensitive filesystem */
final class C0135v extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToLongFunction f28763j;

    /* renamed from: k  reason: collision with root package name */
    final C0144b0 f28764k;

    /* renamed from: l  reason: collision with root package name */
    final long f28765l;

    /* renamed from: m  reason: collision with root package name */
    long f28766m;

    /* renamed from: n  reason: collision with root package name */
    C0135v f28767n;

    /* renamed from: o  reason: collision with root package name */
    C0135v f28768o;

    C0135v(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0135v vVar, ToLongFunction toLongFunction, long j11, C0144b0 b0Var) {
        super(bVar, i11, i12, i13, eArr);
        this.f28768o = vVar;
        this.f28763j = toLongFunction;
        this.f28765l = j11;
        this.f28764k = b0Var;
    }

    public final void compute() {
        C0144b0 b0Var;
        ToLongFunction toLongFunction = this.f28763j;
        if (toLongFunction != null && (b0Var = this.f28764k) != null) {
            long j11 = this.f28765l;
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
                C0135v vVar = r0;
                C0135v vVar2 = new C0135v(this, i14, i13, i12, this.f28696a, this.f28767n, toLongFunction2, j11, b0Var);
                this.f28767n = vVar;
                vVar.fork();
                toLongFunction = toLongFunction3;
                i11 = i11;
            }
            ToLongFunction toLongFunction4 = toLongFunction;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                j11 = b0Var.applyAsLong(j11, toLongFunction4.applyAsLong(a11.f28632b));
            }
            this.f28766m = j11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0135v vVar3 = (C0135v) firstComplete;
                C0135v vVar4 = vVar3.f28767n;
                while (vVar4 != null) {
                    vVar3.f28766m = b0Var.applyAsLong(vVar3.f28766m, vVar4.f28766m);
                    vVar4 = vVar4.f28768o;
                    vVar3.f28767n = vVar4;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Long.valueOf(this.f28766m);
    }
}
