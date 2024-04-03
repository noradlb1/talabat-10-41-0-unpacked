package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.IntFunction;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j$.util.stream.s  reason: case insensitive filesystem */
final class C0283s extends C0222f2 {
    C0283s(C0204c cVar, int i11) {
        super(cVar, i11);
    }

    static L0 A1(C0204c cVar, Spliterator spliterator) {
        N0 n02 = new N0(17);
        N0 n03 = new N0(18);
        return new L0((Collection) new C1(C0218e3.REFERENCE, new N0(19), n03, n02, 3).v(cVar, spliterator));
    }

    /* access modifiers changed from: package-private */
    public final H0 s1(Spliterator spliterator, IntFunction intFunction, C0204c cVar) {
        if (C0213d3.DISTINCT.k(cVar.T0())) {
            return cVar.i1(spliterator, false, intFunction);
        }
        if (C0213d3.ORDERED.k(cVar.T0())) {
            return A1(cVar, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new T(new C0269p(0, atomicBoolean, concurrentHashMap), false).v(cVar, spliterator);
        Set keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add((Object) null);
            keySet = hashSet;
        }
        return new L0(keySet);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator t1(C0204c cVar, Spliterator spliterator) {
        return C0213d3.DISTINCT.k(cVar.T0()) ? cVar.z1(spliterator) : C0213d3.ORDERED.k(cVar.T0()) ? A1(cVar, spliterator).spliterator() : new C0282r3(cVar.z1(spliterator));
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        return C0213d3.DISTINCT.k(i11) ? p2Var : C0213d3.SORTED.k(i11) ? new C0274q(this, p2Var) : new r(p2Var);
    }
}
