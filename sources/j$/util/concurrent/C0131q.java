package j$.util.concurrent;

import j$.util.function.G;
import j$.util.function.ToIntFunction;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.q  reason: case insensitive filesystem */
final class C0131q extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToIntFunction f28734j;

    /* renamed from: k  reason: collision with root package name */
    final G f28735k;

    /* renamed from: l  reason: collision with root package name */
    final int f28736l;

    /* renamed from: m  reason: collision with root package name */
    int f28737m;

    /* renamed from: n  reason: collision with root package name */
    C0131q f28738n;

    /* renamed from: o  reason: collision with root package name */
    C0131q f28739o;

    C0131q(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0131q qVar, ToIntFunction toIntFunction, int i14, G g11) {
        super(bVar, i11, i12, i13, eArr);
        this.f28739o = qVar;
        this.f28734j = toIntFunction;
        this.f28736l = i14;
        this.f28735k = g11;
    }

    public final void compute() {
        G g11;
        ToIntFunction toIntFunction = this.f28734j;
        if (toIntFunction != null && (g11 = this.f28735k) != null) {
            int i11 = this.f28736l;
            int i12 = this.f28701f;
            while (this.f28704i > 0) {
                int i13 = this.f28702g;
                int i14 = (i13 + i12) >>> 1;
                if (i14 <= i12) {
                    break;
                }
                addToPendingCount(1);
                int i15 = this.f28704i >>> 1;
                this.f28704i = i15;
                this.f28702g = i14;
                C0131q qVar = new C0131q(this, i15, i14, i13, this.f28696a, this.f28738n, toIntFunction, i11, g11);
                this.f28738n = qVar;
                qVar.fork();
            }
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                i11 = g11.applyAsInt(i11, toIntFunction.applyAsInt(a11));
            }
            this.f28737m = i11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0131q qVar2 = (C0131q) firstComplete;
                C0131q qVar3 = qVar2.f28738n;
                while (qVar3 != null) {
                    qVar2.f28737m = g11.applyAsInt(qVar2.f28737m, qVar3.f28737m);
                    qVar3 = qVar3.f28739o;
                    qVar2.f28738n = qVar3;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Integer.valueOf(this.f28737m);
    }
}
