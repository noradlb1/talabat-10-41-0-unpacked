package j$.util.stream;

import j$.util.C0182g;
import j$.util.C0185j;
import j$.util.C0186k;
import j$.util.D;
import j$.util.PrimitiveIterator$OfInt;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.A0;
import j$.util.function.BiConsumer;
import j$.util.function.G;
import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.K;
import j$.util.function.S;
import j$.util.function.Supplier;
import j$.util.function.V;
import j$.util.function.Y;
import java.util.Objects;

/* renamed from: j$.util.stream.g0  reason: case insensitive filesystem */
abstract class C0225g0 extends C0204c implements IntStream {
    C0225g0(Spliterator spliterator, int i11) {
        super(spliterator, i11, false);
    }

    C0225g0(C0204c cVar, int i11) {
        super(cVar, i11);
    }

    /* access modifiers changed from: private */
    public static D B1(Spliterator spliterator) {
        if (spliterator instanceof D) {
            return (D) spliterator;
        }
        if (X3.f29067a) {
            X3.a(C0204c.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    public void J(K k11) {
        Objects.requireNonNull(k11);
        j1(new Q(k11, true));
    }

    public final IntStream M(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new C0313y(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, intFunction, 3);
    }

    public void Q(K k11) {
        Objects.requireNonNull(k11);
        j1(new Q(k11, false));
    }

    public final DoubleStream R(S s11) {
        Objects.requireNonNull(s11);
        return new C0308x(this, C0213d3.f29119p | C0213d3.f29117n, s11, 4);
    }

    public final IntStream T(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        return new C0313y(this, C0213d3.f29123t, intPredicate, 4);
    }

    public final C0186k U(G g11) {
        Objects.requireNonNull(g11);
        return (C0186k) j1(new A1(C0218e3.INT_VALUE, g11, 3));
    }

    public final IntStream V(K k11) {
        Objects.requireNonNull(k11);
        return new C0313y(this, 0, k11, 1);
    }

    public final boolean allMatch(IntPredicate intPredicate) {
        return ((Boolean) j1(C0314y0.Z0(intPredicate, C0299v0.ALL))).booleanValue();
    }

    public final boolean anyMatch(IntPredicate intPredicate) {
        return ((Boolean) j1(C0314y0.Z0(intPredicate, C0299v0.ANY))).booleanValue();
    }

    public final DoubleStream asDoubleStream() {
        return new B(this, 0, 1);
    }

    public final LongStream asLongStream() {
        return new C0195a0(this, 0, 0);
    }

    public final C0185j average() {
        long[] jArr = (long[]) z(new C0199b(18), new C0199b(19), new C0199b(20));
        long j11 = jArr[0];
        return j11 > 0 ? C0185j.d(((double) jArr[1]) / ((double) j11)) : C0185j.a();
    }

    public final Stream boxed() {
        return new C0303w(this, 0, new X(3), 1);
    }

    /* access modifiers changed from: package-private */
    public final C0 c1(long j11, IntFunction intFunction) {
        return C0314y0.U0(j11);
    }

    public final long count() {
        return ((Long) j1(new E1(C0218e3.INT_VALUE, 3))).longValue();
    }

    public final LongStream d(V v11) {
        Objects.requireNonNull(v11);
        return new C0317z(this, C0213d3.f29119p | C0213d3.f29117n, v11, 1);
    }

    public final IntStream distinct() {
        return ((C0232h2) ((C0232h2) boxed()).distinct()).E(new C0199b(17));
    }

    public final C0186k findAny() {
        return (C0186k) j1(K.f28957d);
    }

    public final C0186k findFirst() {
        return (C0186k) j1(K.f28956c);
    }

    public final PrimitiveIterator$OfInt iterator() {
        return Spliterators.g(spliterator());
    }

    public final IntStream k(Y y11) {
        Objects.requireNonNull(y11);
        return new C0313y(this, C0213d3.f29119p | C0213d3.f29117n, y11, 2);
    }

    /* access modifiers changed from: package-private */
    public final H0 l1(C0314y0 y0Var, Spliterator spliterator, boolean z11, IntFunction intFunction) {
        return C0314y0.G0(y0Var, spliterator, z11);
    }

    public final IntStream limit(long j11) {
        if (j11 >= 0) {
            return C0314y0.Y0(this, 0, j11);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    /* access modifiers changed from: package-private */
    public final boolean m1(Spliterator spliterator, C0272p2 p2Var) {
        K k11;
        boolean h11;
        D B1 = B1(spliterator);
        if (p2Var instanceof K) {
            k11 = (K) p2Var;
        } else if (!X3.f29067a) {
            Objects.requireNonNull(p2Var);
            k11 = new Y(p2Var);
        } else {
            X3.a(C0204c.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        }
        do {
            h11 = p2Var.h();
            if (h11 || !B1.j(k11)) {
                return h11;
            }
            h11 = p2Var.h();
            break;
        } while (!B1.j(k11));
        return h11;
    }

    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new C0303w(this, C0213d3.f29119p | C0213d3.f29117n, intFunction, 1);
    }

    public final C0186k max() {
        return U(new X(4));
    }

    public final C0186k min() {
        return U(new N0(29));
    }

    /* access modifiers changed from: package-private */
    public final C0218e3 n1() {
        return C0218e3.INT_VALUE;
    }

    public final int r(int i11, G g11) {
        Objects.requireNonNull(g11);
        return ((Integer) j1(new N1(C0218e3.INT_VALUE, g11, i11))).intValue();
    }

    /* access modifiers changed from: package-private */
    public final Spliterator r1(Supplier supplier) {
        return new C0263n3(supplier);
    }

    public final boolean s(IntPredicate intPredicate) {
        return ((Boolean) j1(C0314y0.Z0(intPredicate, C0299v0.NONE))).booleanValue();
    }

    public final IntStream skip(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            return i11 == 0 ? this : C0314y0.Y0(this, j11, -1);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    public final IntStream sorted() {
        return new I2(this);
    }

    public final D spliterator() {
        return B1(super.spliterator());
    }

    public final int sum() {
        return r(0, new X(0));
    }

    public final C0182g summaryStatistics() {
        return (C0182g) z(new N0(13), new X(1), new X(2));
    }

    public final int[] toArray() {
        return (int[]) C0314y0.R0((E0) k1(new C0199b(21))).b();
    }

    public final BaseStream unordered() {
        return !p1() ? this : new C0205c0(this, C0213d3.f29121r);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator y1(C0314y0 y0Var, C0194a aVar, boolean z11) {
        return new C0302v3(y0Var, aVar, z11);
    }

    public final Object z(Supplier supplier, A0 a02, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0288t tVar = new C0288t(1, biConsumer);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(a02);
        return j1(new C1(C0218e3.INT_VALUE, tVar, a02, supplier, 4));
    }
}
