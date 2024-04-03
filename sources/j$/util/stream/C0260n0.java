package j$.util.stream;

import j$.util.C0183h;
import j$.util.C0185j;
import j$.util.C0187l;
import j$.util.G;
import j$.util.PrimitiveIterator$OfLong;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.C0144b0;
import j$.util.function.C0152f0;
import j$.util.function.C0158i0;
import j$.util.function.C0164l0;
import j$.util.function.C0170o0;
import j$.util.function.D0;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import j$.util.function.r0;
import j$.util.function.u0;
import java.util.Objects;

/* renamed from: j$.util.stream.n0  reason: case insensitive filesystem */
abstract class C0260n0 extends C0204c implements LongStream {
    C0260n0(Spliterator spliterator, int i11) {
        super(spliterator, i11, false);
    }

    C0260n0(C0204c cVar, int i11) {
        super(cVar, i11);
    }

    /* access modifiers changed from: private */
    public static G B1(Spliterator spliterator) {
        if (spliterator instanceof G) {
            return (G) spliterator;
        }
        if (X3.f29067a) {
            X3.a(C0204c.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    public void B(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        j1(new S(f0Var, false));
    }

    public final DoubleStream F(C0170o0 o0Var) {
        Objects.requireNonNull(o0Var);
        return new C0308x(this, C0213d3.f29119p | C0213d3.f29117n, o0Var, 5);
    }

    public final LongStream H(u0 u0Var) {
        Objects.requireNonNull(u0Var);
        return new C0317z(this, C0213d3.f29119p | C0213d3.f29117n, u0Var, 2);
    }

    public final IntStream N(r0 r0Var) {
        Objects.requireNonNull(r0Var);
        return new C0313y(this, C0213d3.f29119p | C0213d3.f29117n, r0Var, 5);
    }

    public final Stream O(C0158i0 i0Var) {
        Objects.requireNonNull(i0Var);
        return new C0303w(this, C0213d3.f29119p | C0213d3.f29117n, i0Var, 2);
    }

    public final boolean W(C0164l0 l0Var) {
        return ((Boolean) j1(C0314y0.b1(l0Var, C0299v0.ANY))).booleanValue();
    }

    public final LongStream Y(C0164l0 l0Var) {
        Objects.requireNonNull(l0Var);
        return new C0317z(this, C0213d3.f29123t, l0Var, 4);
    }

    public final boolean a(C0164l0 l0Var) {
        return ((Boolean) j1(C0314y0.b1(l0Var, C0299v0.NONE))).booleanValue();
    }

    public final DoubleStream asDoubleStream() {
        return new B(this, C0213d3.f29117n, 2);
    }

    public final C0185j average() {
        long[] jArr = (long[]) x(new C0199b(24), new C0199b(25), new C0199b(26));
        long j11 = jArr[0];
        return j11 > 0 ? C0185j.d(((double) jArr[1]) / ((double) j11)) : C0185j.a();
    }

    public final Stream boxed() {
        return new C0303w(this, 0, new X(6), 2);
    }

    /* access modifiers changed from: package-private */
    public final C0 c1(long j11, IntFunction intFunction) {
        return C0314y0.V0(j11);
    }

    public final long count() {
        return ((Long) j1(new E1(C0218e3.LONG_VALUE, 0))).longValue();
    }

    public final LongStream distinct() {
        return ((C0232h2) ((C0232h2) boxed()).distinct()).X(new C0199b(22));
    }

    public final C0187l e(C0144b0 b0Var) {
        Objects.requireNonNull(b0Var);
        return (C0187l) j1(new A1(C0218e3.LONG_VALUE, b0Var, 0));
    }

    public final LongStream f(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0317z(this, 0, f0Var, 5);
    }

    public final C0187l findAny() {
        return (C0187l) j1(L.f28966d);
    }

    public final C0187l findFirst() {
        return (C0187l) j1(L.f28965c);
    }

    public final LongStream g(C0158i0 i0Var) {
        Objects.requireNonNull(i0Var);
        return new C0317z(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, i0Var, 3);
    }

    public final PrimitiveIterator$OfLong iterator() {
        return Spliterators.h(spliterator());
    }

    /* access modifiers changed from: package-private */
    public final H0 l1(C0314y0 y0Var, Spliterator spliterator, boolean z11, IntFunction intFunction) {
        return C0314y0.H0(y0Var, spliterator, z11);
    }

    public final LongStream limit(long j11) {
        if (j11 >= 0) {
            return C0314y0.a1(this, 0, j11);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    public final long m(long j11, C0144b0 b0Var) {
        Objects.requireNonNull(b0Var);
        return ((Long) j1(new C0315y1(C0218e3.LONG_VALUE, b0Var, j11))).longValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean m1(Spliterator spliterator, C0272p2 p2Var) {
        C0152f0 f0Var;
        boolean h11;
        G B1 = B1(spliterator);
        if (p2Var instanceof C0152f0) {
            f0Var = (C0152f0) p2Var;
        } else if (!X3.f29067a) {
            Objects.requireNonNull(p2Var);
            f0Var = new C0230h0(p2Var);
        } else {
            X3.a(C0204c.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        }
        do {
            h11 = p2Var.h();
            if (h11 || !B1.e(f0Var)) {
                return h11;
            }
            h11 = p2Var.h();
            break;
        } while (!B1.e(f0Var));
        return h11;
    }

    public final C0187l max() {
        return e(new X(5));
    }

    public final C0187l min() {
        return e(new X(10));
    }

    /* access modifiers changed from: package-private */
    public final C0218e3 n1() {
        return C0218e3.LONG_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final Spliterator r1(Supplier supplier) {
        return new C0268o3(supplier);
    }

    public final LongStream skip(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            return i11 == 0 ? this : C0314y0.a1(this, j11, -1);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    public final LongStream sorted() {
        return new J2(this);
    }

    public final G spliterator() {
        return B1(super.spliterator());
    }

    public final long sum() {
        return m(0, new X(7));
    }

    public final C0183h summaryStatistics() {
        return (C0183h) x(new N0(14), new X(8), new X(9));
    }

    public final long[] toArray() {
        return (long[]) C0314y0.S0((F0) k1(new C0199b(23))).b();
    }

    public final BaseStream unordered() {
        return !p1() ? this : new C0195a0(this, C0213d3.f29121r, 1);
    }

    public void w(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        j1(new S(f0Var, true));
    }

    public final Object x(Supplier supplier, D0 d02, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0288t tVar = new C0288t(2, biConsumer);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(d02);
        return j1(new C1(C0218e3.LONG_VALUE, tVar, d02, supplier, 0));
    }

    public final boolean y(C0164l0 l0Var) {
        return ((Boolean) j1(C0314y0.b1(l0Var, C0299v0.ALL))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final Spliterator y1(C0314y0 y0Var, C0194a aVar, boolean z11) {
        return new C0312x3(y0Var, aVar, z11);
    }
}
