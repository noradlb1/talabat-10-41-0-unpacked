package j$.util.concurrent;

import j$.util.function.BiFunction;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.w  reason: case insensitive filesystem */
final class C0136w extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final BiFunction f28769j;

    /* renamed from: k  reason: collision with root package name */
    final BiFunction f28770k;

    /* renamed from: l  reason: collision with root package name */
    Object f28771l;

    /* renamed from: m  reason: collision with root package name */
    C0136w f28772m;

    /* renamed from: n  reason: collision with root package name */
    C0136w f28773n;

    C0136w(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0136w wVar, BiFunction biFunction, BiFunction biFunction2) {
        super(bVar, i11, i12, i13, eArr);
        this.f28773n = wVar;
        this.f28769j = biFunction;
        this.f28770k = biFunction2;
    }

    public final void compute() {
        BiFunction biFunction;
        BiFunction biFunction2 = this.f28769j;
        if (biFunction2 != null && (biFunction = this.f28770k) != null) {
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
                C0136w wVar = new C0136w(this, i14, i13, i12, this.f28696a, this.f28772m, biFunction2, biFunction);
                this.f28772m = wVar;
                wVar.fork();
            }
            Object obj = null;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                Object apply = biFunction2.apply(a11.f28632b, a11.f28633c);
                if (apply != null) {
                    if (obj != null) {
                        apply = biFunction.apply(obj, apply);
                    }
                    obj = apply;
                }
            }
            this.f28771l = obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0136w wVar2 = (C0136w) firstComplete;
                C0136w wVar3 = wVar2.f28772m;
                while (wVar3 != null) {
                    Object obj2 = wVar3.f28771l;
                    if (obj2 != null) {
                        Object obj3 = wVar2.f28771l;
                        if (obj3 != null) {
                            obj2 = biFunction.apply(obj3, obj2);
                        }
                        wVar2.f28771l = obj2;
                    }
                    wVar3 = wVar3.f28773n;
                    wVar2.f28772m = wVar3;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28771l;
    }
}
