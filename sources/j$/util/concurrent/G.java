package j$.util.concurrent;

import j$.util.function.BiFunction;
import java.util.concurrent.CountedCompleter;

final class G extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final BiFunction f28639j;

    /* renamed from: k  reason: collision with root package name */
    Object f28640k;

    /* renamed from: l  reason: collision with root package name */
    G f28641l;

    /* renamed from: m  reason: collision with root package name */
    G f28642m;

    G(C0116b bVar, int i11, int i12, int i13, E[] eArr, G g11, BiFunction biFunction) {
        super(bVar, i11, i12, i13, eArr);
        this.f28642m = g11;
        this.f28639j = biFunction;
    }

    public final void compute() {
        BiFunction biFunction = this.f28639j;
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
                G g11 = new G(this, i14, i13, i12, this.f28696a, this.f28641l, biFunction);
                this.f28641l = g11;
                g11.fork();
            }
            Object obj = null;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                Object obj2 = a11.f28632b;
                if (obj == null) {
                    obj = obj2;
                } else if (obj2 != null) {
                    obj = biFunction.apply(obj, obj2);
                }
            }
            this.f28640k = obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                G g12 = (G) firstComplete;
                G g13 = g12.f28641l;
                while (g13 != null) {
                    Object obj3 = g13.f28640k;
                    if (obj3 != null) {
                        Object obj4 = g12.f28640k;
                        if (obj4 != null) {
                            obj3 = biFunction.apply(obj4, obj3);
                        }
                        g12.f28640k = obj3;
                    }
                    g13 = g13.f28642m;
                    g12.f28641l = g13;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28640k;
    }
}
