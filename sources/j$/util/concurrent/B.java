package j$.util.concurrent;

import j$.util.function.C0157i;
import j$.util.function.ToDoubleFunction;
import java.util.concurrent.CountedCompleter;

final class B extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToDoubleFunction f28612j;

    /* renamed from: k  reason: collision with root package name */
    final C0157i f28613k;

    /* renamed from: l  reason: collision with root package name */
    final double f28614l;

    /* renamed from: m  reason: collision with root package name */
    double f28615m;

    /* renamed from: n  reason: collision with root package name */
    B f28616n;

    /* renamed from: o  reason: collision with root package name */
    B f28617o;

    B(C0116b bVar, int i11, int i12, int i13, E[] eArr, B b11, ToDoubleFunction toDoubleFunction, double d11, C0157i iVar) {
        super(bVar, i11, i12, i13, eArr);
        this.f28617o = b11;
        this.f28612j = toDoubleFunction;
        this.f28614l = d11;
        this.f28613k = iVar;
    }

    public final void compute() {
        C0157i iVar;
        ToDoubleFunction toDoubleFunction = this.f28612j;
        if (toDoubleFunction != null && (iVar = this.f28613k) != null) {
            double d11 = this.f28614l;
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
                ToDoubleFunction toDoubleFunction2 = toDoubleFunction;
                ToDoubleFunction toDoubleFunction3 = toDoubleFunction;
                B b11 = r0;
                B b12 = new B(this, i14, i13, i12, this.f28696a, this.f28616n, toDoubleFunction2, d11, iVar);
                this.f28616n = b11;
                b11.fork();
                toDoubleFunction = toDoubleFunction3;
                i11 = i11;
            }
            ToDoubleFunction toDoubleFunction4 = toDoubleFunction;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                d11 = iVar.applyAsDouble(d11, toDoubleFunction4.applyAsDouble(a11.f28633c));
            }
            this.f28615m = d11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                B b13 = (B) firstComplete;
                B b14 = b13.f28616n;
                while (b14 != null) {
                    b13.f28615m = iVar.applyAsDouble(b13.f28615m, b14.f28615m);
                    b14 = b14.f28617o;
                    b13.f28616n = b14;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Double.valueOf(this.f28615m);
    }
}
