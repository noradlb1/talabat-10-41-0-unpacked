package j$.util.concurrent;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.s  reason: case insensitive filesystem */
final class C0132s extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final Function f28746j;

    /* renamed from: k  reason: collision with root package name */
    final BiFunction f28747k;

    /* renamed from: l  reason: collision with root package name */
    Object f28748l;

    /* renamed from: m  reason: collision with root package name */
    C0132s f28749m;

    /* renamed from: n  reason: collision with root package name */
    C0132s f28750n;

    C0132s(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0132s sVar, Function function, BiFunction biFunction) {
        super(bVar, i11, i12, i13, eArr);
        this.f28750n = sVar;
        this.f28746j = function;
        this.f28747k = biFunction;
    }

    public final void compute() {
        BiFunction biFunction;
        Function function = this.f28746j;
        if (function != null && (biFunction = this.f28747k) != null) {
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
                C0132s sVar = new C0132s(this, i14, i13, i12, this.f28696a, this.f28749m, function, biFunction);
                this.f28749m = sVar;
                sVar.fork();
            }
            Object obj = null;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                Object apply = function.apply(a11.f28632b);
                if (apply != null) {
                    if (obj != null) {
                        apply = biFunction.apply(obj, apply);
                    }
                    obj = apply;
                }
            }
            this.f28748l = obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0132s sVar2 = (C0132s) firstComplete;
                C0132s sVar3 = sVar2.f28749m;
                while (sVar3 != null) {
                    Object obj2 = sVar3.f28748l;
                    if (obj2 != null) {
                        Object obj3 = sVar2.f28748l;
                        if (obj3 != null) {
                            obj2 = biFunction.apply(obj3, obj2);
                        }
                        sVar2.f28748l = obj2;
                    }
                    sVar3 = sVar3.f28750n;
                    sVar2.f28749m = sVar3;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28748l;
    }
}
