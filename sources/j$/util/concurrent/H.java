package j$.util.concurrent;

import j$.util.function.BiFunction;
import java.util.concurrent.CountedCompleter;

final class H extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final BiFunction f28643j;

    /* renamed from: k  reason: collision with root package name */
    Object f28644k;

    /* renamed from: l  reason: collision with root package name */
    H f28645l;

    /* renamed from: m  reason: collision with root package name */
    H f28646m;

    H(C0116b bVar, int i11, int i12, int i13, E[] eArr, H h11, BiFunction biFunction) {
        super(bVar, i11, i12, i13, eArr);
        this.f28646m = h11;
        this.f28643j = biFunction;
    }

    public final void compute() {
        BiFunction biFunction = this.f28643j;
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
                H h11 = new H(this, i14, i13, i12, this.f28696a, this.f28645l, biFunction);
                this.f28645l = h11;
                h11.fork();
            }
            Object obj = null;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                Object obj2 = a11.f28633c;
                obj = obj == null ? obj2 : biFunction.apply(obj, obj2);
            }
            this.f28644k = obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                H h12 = (H) firstComplete;
                H h13 = h12.f28645l;
                while (h13 != null) {
                    Object obj3 = h13.f28644k;
                    if (obj3 != null) {
                        Object obj4 = h12.f28644k;
                        if (obj4 != null) {
                            obj3 = biFunction.apply(obj4, obj3);
                        }
                        h12.f28644k = obj3;
                    }
                    h13 = h13.f28646m;
                    h12.f28645l = h13;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28644k;
    }
}
