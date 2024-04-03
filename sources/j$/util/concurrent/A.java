package j$.util.concurrent;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.CountedCompleter;

final class A extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final Function f28607j;

    /* renamed from: k  reason: collision with root package name */
    final BiFunction f28608k;

    /* renamed from: l  reason: collision with root package name */
    Object f28609l;

    /* renamed from: m  reason: collision with root package name */
    A f28610m;

    /* renamed from: n  reason: collision with root package name */
    A f28611n;

    A(C0116b bVar, int i11, int i12, int i13, E[] eArr, A a11, Function function, BiFunction biFunction) {
        super(bVar, i11, i12, i13, eArr);
        this.f28611n = a11;
        this.f28607j = function;
        this.f28608k = biFunction;
    }

    public final void compute() {
        BiFunction biFunction;
        Function function = this.f28607j;
        if (function != null && (biFunction = this.f28608k) != null) {
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
                A a11 = new A(this, i14, i13, i12, this.f28696a, this.f28610m, function, biFunction);
                this.f28610m = a11;
                a11.fork();
            }
            Object obj = null;
            while (true) {
                E a12 = a();
                if (a12 == null) {
                    break;
                }
                Object apply = function.apply(a12.f28633c);
                if (apply != null) {
                    if (obj != null) {
                        apply = biFunction.apply(obj, apply);
                    }
                    obj = apply;
                }
            }
            this.f28609l = obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                A a13 = (A) firstComplete;
                A a14 = a13.f28610m;
                while (a14 != null) {
                    Object obj2 = a14.f28609l;
                    if (obj2 != null) {
                        Object obj3 = a13.f28609l;
                        if (obj3 != null) {
                            obj2 = biFunction.apply(obj3, obj2);
                        }
                        a13.f28609l = obj2;
                    }
                    a14 = a14.f28611n;
                    a13.f28610m = a14;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28609l;
    }
}
