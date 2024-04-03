package j$.util.concurrent;

import j$.util.function.G;
import j$.util.function.ToIntFunction;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.u  reason: case insensitive filesystem */
final class C0134u extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToIntFunction f28757j;

    /* renamed from: k  reason: collision with root package name */
    final G f28758k;

    /* renamed from: l  reason: collision with root package name */
    final int f28759l;

    /* renamed from: m  reason: collision with root package name */
    int f28760m;

    /* renamed from: n  reason: collision with root package name */
    C0134u f28761n;

    /* renamed from: o  reason: collision with root package name */
    C0134u f28762o;

    C0134u(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0134u uVar, ToIntFunction toIntFunction, int i14, G g11) {
        super(bVar, i11, i12, i13, eArr);
        this.f28762o = uVar;
        this.f28757j = toIntFunction;
        this.f28759l = i14;
        this.f28758k = g11;
    }

    public final void compute() {
        G g11;
        ToIntFunction toIntFunction = this.f28757j;
        if (toIntFunction != null && (g11 = this.f28758k) != null) {
            int i11 = this.f28759l;
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
                C0134u uVar = new C0134u(this, i15, i14, i13, this.f28696a, this.f28761n, toIntFunction, i11, g11);
                this.f28761n = uVar;
                uVar.fork();
            }
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                i11 = g11.applyAsInt(i11, toIntFunction.applyAsInt(a11.f28632b));
            }
            this.f28760m = i11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0134u uVar2 = (C0134u) firstComplete;
                C0134u uVar3 = uVar2.f28761n;
                while (uVar3 != null) {
                    uVar2.f28760m = g11.applyAsInt(uVar2.f28760m, uVar3.f28760m);
                    uVar3 = uVar3.f28762o;
                    uVar2.f28761n = uVar3;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Integer.valueOf(this.f28760m);
    }
}
