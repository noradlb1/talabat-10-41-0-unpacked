package j$.util.concurrent;

import j$.util.function.C0157i;
import j$.util.function.ToDoubleFunction;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.p  reason: case insensitive filesystem */
final class C0130p extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToDoubleFunction f28728j;

    /* renamed from: k  reason: collision with root package name */
    final C0157i f28729k;

    /* renamed from: l  reason: collision with root package name */
    final double f28730l;

    /* renamed from: m  reason: collision with root package name */
    double f28731m;

    /* renamed from: n  reason: collision with root package name */
    C0130p f28732n;

    /* renamed from: o  reason: collision with root package name */
    C0130p f28733o;

    C0130p(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0130p pVar, ToDoubleFunction toDoubleFunction, double d11, C0157i iVar) {
        super(bVar, i11, i12, i13, eArr);
        this.f28733o = pVar;
        this.f28728j = toDoubleFunction;
        this.f28730l = d11;
        this.f28729k = iVar;
    }

    public final void compute() {
        C0157i iVar;
        ToDoubleFunction toDoubleFunction = this.f28728j;
        if (toDoubleFunction != null && (iVar = this.f28729k) != null) {
            double d11 = this.f28730l;
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
                C0130p pVar = r0;
                C0130p pVar2 = new C0130p(this, i14, i13, i12, this.f28696a, this.f28732n, toDoubleFunction2, d11, iVar);
                this.f28732n = pVar;
                pVar.fork();
                toDoubleFunction = toDoubleFunction3;
                i11 = i11;
            }
            ToDoubleFunction toDoubleFunction4 = toDoubleFunction;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                d11 = iVar.applyAsDouble(d11, toDoubleFunction4.applyAsDouble(a11));
            }
            this.f28731m = d11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0130p pVar3 = (C0130p) firstComplete;
                C0130p pVar4 = pVar3.f28732n;
                while (pVar4 != null) {
                    pVar3.f28731m = iVar.applyAsDouble(pVar3.f28731m, pVar4.f28731m);
                    pVar4 = pVar4.f28733o;
                    pVar3.f28732n = pVar4;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Double.valueOf(this.f28731m);
    }
}
