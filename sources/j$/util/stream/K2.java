package j$.util.stream;

import j$.util.Comparator;
import j$.util.Spliterator;
import j$.util.function.IntFunction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

final class K2 extends C0222f2 {

    /* renamed from: t  reason: collision with root package name */
    private final boolean f28963t;

    /* renamed from: u  reason: collision with root package name */
    private final Comparator f28964u;

    K2(C0204c cVar) {
        super(cVar, C0213d3.f29120q | C0213d3.f29118o);
        this.f28963t = true;
        this.f28964u = Comparator.CC.naturalOrder();
    }

    K2(C0204c cVar, java.util.Comparator comparator) {
        super(cVar, C0213d3.f29120q | C0213d3.f29119p);
        this.f28963t = false;
        Objects.requireNonNull(comparator);
        this.f28964u = comparator;
    }

    public final H0 s1(Spliterator spliterator, IntFunction intFunction, C0204c cVar) {
        if (C0213d3.SORTED.k(cVar.T0()) && this.f28963t) {
            return cVar.i1(spliterator, false, intFunction);
        }
        Object[] o11 = cVar.i1(spliterator, true, intFunction).o(intFunction);
        Arrays.sort(o11, this.f28964u);
        return new K0(o11);
    }

    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        if (C0213d3.SORTED.k(i11) && this.f28963t) {
            return p2Var;
        }
        boolean k11 = C0213d3.SIZED.k(i11);
        java.util.Comparator comparator = this.f28964u;
        return k11 ? new P2(p2Var, comparator) : new L2(p2Var, comparator);
    }
}
