package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import java.util.Arrays;
import java.util.Objects;

final class I2 extends C0215e0 {
    I2(C0204c cVar) {
        super(cVar, C0213d3.f29120q | C0213d3.f29118o);
    }

    public final H0 s1(Spliterator spliterator, IntFunction intFunction, C0204c cVar) {
        if (C0213d3.SORTED.k(cVar.T0())) {
            return cVar.i1(spliterator, false, intFunction);
        }
        int[] iArr = (int[]) ((E0) cVar.i1(spliterator, true, intFunction)).b();
        Arrays.sort(iArr);
        return new C0211d1(iArr);
    }

    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        return C0213d3.SORTED.k(i11) ? p2Var : C0213d3.SIZED.k(i11) ? new N2(p2Var) : new F2(p2Var);
    }
}
