package j$.util.concurrent;

import j$.util.function.C0157i;
import j$.util.function.ToDoubleFunction;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.t  reason: case insensitive filesystem */
final class C0133t extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToDoubleFunction f28751j;

    /* renamed from: k  reason: collision with root package name */
    final C0157i f28752k;

    /* renamed from: l  reason: collision with root package name */
    final double f28753l;

    /* renamed from: m  reason: collision with root package name */
    double f28754m;

    /* renamed from: n  reason: collision with root package name */
    C0133t f28755n;

    /* renamed from: o  reason: collision with root package name */
    C0133t f28756o;

    C0133t(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0133t tVar, ToDoubleFunction toDoubleFunction, double d11, C0157i iVar) {
        super(bVar, i11, i12, i13, eArr);
        this.f28756o = tVar;
        this.f28751j = toDoubleFunction;
        this.f28753l = d11;
        this.f28752k = iVar;
    }

    public final void compute() {
        C0157i iVar;
        ToDoubleFunction toDoubleFunction = this.f28751j;
        if (toDoubleFunction != null && (iVar = this.f28752k) != null) {
            double d11 = this.f28753l;
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
                C0133t tVar = r0;
                C0133t tVar2 = new C0133t(this, i14, i13, i12, this.f28696a, this.f28755n, toDoubleFunction2, d11, iVar);
                this.f28755n = tVar;
                tVar.fork();
                toDoubleFunction = toDoubleFunction3;
                i11 = i11;
            }
            ToDoubleFunction toDoubleFunction4 = toDoubleFunction;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                d11 = iVar.applyAsDouble(d11, toDoubleFunction4.applyAsDouble(a11.f28632b));
            }
            this.f28754m = d11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0133t tVar3 = (C0133t) firstComplete;
                C0133t tVar4 = tVar3.f28755n;
                while (tVar4 != null) {
                    tVar3.f28754m = iVar.applyAsDouble(tVar3.f28754m, tVar4.f28754m);
                    tVar4 = tVar4.f28756o;
                    tVar3.f28755n = tVar4;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Double.valueOf(this.f28754m);
    }
}
