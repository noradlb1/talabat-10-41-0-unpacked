package j$.util.concurrent;

import j$.util.function.BiFunction;
import java.util.Map;
import java.util.concurrent.CountedCompleter;

final class F extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final BiFunction f28635j;

    /* renamed from: k  reason: collision with root package name */
    Map.Entry f28636k;

    /* renamed from: l  reason: collision with root package name */
    F f28637l;

    /* renamed from: m  reason: collision with root package name */
    F f28638m;

    F(C0116b bVar, int i11, int i12, int i13, E[] eArr, F f11, BiFunction biFunction) {
        super(bVar, i11, i12, i13, eArr);
        this.f28638m = f11;
        this.f28635j = biFunction;
    }

    public final void compute() {
        BiFunction biFunction = this.f28635j;
        if (biFunction != null) {
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
                F f11 = new F(this, i14, i13, i12, this.f28696a, this.f28637l, biFunction);
                this.f28637l = f11;
                f11.fork();
            }
            Map.Entry entry = null;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                entry = entry == null ? a11 : (Map.Entry) biFunction.apply(entry, a11);
            }
            this.f28636k = entry;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                F f12 = (F) firstComplete;
                F f13 = f12.f28637l;
                while (f13 != null) {
                    Map.Entry entry2 = f13.f28636k;
                    if (entry2 != null) {
                        Map.Entry entry3 = f12.f28636k;
                        if (entry3 != null) {
                            entry2 = (Map.Entry) biFunction.apply(entry3, entry2);
                        }
                        f12.f28636k = entry2;
                    }
                    f13 = f13.f28638m;
                    f12.f28637l = f13;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28636k;
    }
}
