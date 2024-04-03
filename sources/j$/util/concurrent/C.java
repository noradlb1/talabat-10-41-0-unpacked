package j$.util.concurrent;

import j$.util.function.G;
import j$.util.function.ToIntFunction;
import java.util.concurrent.CountedCompleter;

final class C extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final ToIntFunction f28618j;

    /* renamed from: k  reason: collision with root package name */
    final G f28619k;

    /* renamed from: l  reason: collision with root package name */
    final int f28620l;

    /* renamed from: m  reason: collision with root package name */
    int f28621m;

    /* renamed from: n  reason: collision with root package name */
    C f28622n;

    /* renamed from: o  reason: collision with root package name */
    C f28623o;

    C(C0116b bVar, int i11, int i12, int i13, E[] eArr, C c11, ToIntFunction toIntFunction, int i14, G g11) {
        super(bVar, i11, i12, i13, eArr);
        this.f28623o = c11;
        this.f28618j = toIntFunction;
        this.f28620l = i14;
        this.f28619k = g11;
    }

    public final void compute() {
        G g11;
        ToIntFunction toIntFunction = this.f28618j;
        if (toIntFunction != null && (g11 = this.f28619k) != null) {
            int i11 = this.f28620l;
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
                C c11 = new C(this, i15, i14, i13, this.f28696a, this.f28622n, toIntFunction, i11, g11);
                this.f28622n = c11;
                c11.fork();
            }
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                i11 = g11.applyAsInt(i11, toIntFunction.applyAsInt(a11.f28633c));
            }
            this.f28621m = i11;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C c12 = (C) firstComplete;
                C c13 = c12.f28622n;
                while (c13 != null) {
                    c12.f28621m = g11.applyAsInt(c12.f28621m, c13.f28621m);
                    c13 = c13.f28623o;
                    c12.f28622n = c13;
                }
            }
        }
    }

    public final Object getRawResult() {
        return Integer.valueOf(this.f28621m);
    }
}
