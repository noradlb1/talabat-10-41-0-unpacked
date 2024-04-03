package j$.util.concurrent;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.concurrent.o  reason: case insensitive filesystem */
final class C0129o extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    final Function f28723j;

    /* renamed from: k  reason: collision with root package name */
    final BiFunction f28724k;

    /* renamed from: l  reason: collision with root package name */
    Object f28725l;

    /* renamed from: m  reason: collision with root package name */
    C0129o f28726m;

    /* renamed from: n  reason: collision with root package name */
    C0129o f28727n;

    C0129o(C0116b bVar, int i11, int i12, int i13, E[] eArr, C0129o oVar, Function function, BiFunction biFunction) {
        super(bVar, i11, i12, i13, eArr);
        this.f28727n = oVar;
        this.f28723j = function;
        this.f28724k = biFunction;
    }

    public final void compute() {
        BiFunction biFunction;
        Function function = this.f28723j;
        if (function != null && (biFunction = this.f28724k) != null) {
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
                C0129o oVar = new C0129o(this, i14, i13, i12, this.f28696a, this.f28726m, function, biFunction);
                this.f28726m = oVar;
                oVar.fork();
            }
            Object obj = null;
            while (true) {
                E a11 = a();
                if (a11 == null) {
                    break;
                }
                Object apply = function.apply(a11);
                if (apply != null) {
                    if (obj != null) {
                        apply = biFunction.apply(obj, apply);
                    }
                    obj = apply;
                }
            }
            this.f28725l = obj;
            for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                C0129o oVar2 = (C0129o) firstComplete;
                C0129o oVar3 = oVar2.f28726m;
                while (oVar3 != null) {
                    Object obj2 = oVar3.f28725l;
                    if (obj2 != null) {
                        Object obj3 = oVar2.f28725l;
                        if (obj3 != null) {
                            obj2 = biFunction.apply(obj3, obj2);
                        }
                        oVar2.f28725l = obj2;
                    }
                    oVar3 = oVar3.f28727n;
                    oVar2.f28726m = oVar3;
                }
            }
        }
    }

    public final Object getRawResult() {
        return this.f28725l;
    }
}
