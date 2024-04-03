package j$.util.stream;

import j$.util.A;
import j$.util.C0140f;
import j$.util.C0185j;
import j$.util.PrimitiveIterator$OfDouble;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.B;
import j$.util.function.BiConsumer;
import j$.util.function.C0157i;
import j$.util.function.C0165m;
import j$.util.function.C0171p;
import j$.util.function.C0174s;
import j$.util.function.C0177v;
import j$.util.function.C0180y;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import j$.util.function.x0;
import java.util.Objects;
import java.util.Set;

abstract class F extends C0204c implements DoubleStream {
    F(Spliterator spliterator, int i11) {
        super(spliterator, i11, false);
    }

    F(C0204c cVar, int i11) {
        super(cVar, i11);
    }

    /* access modifiers changed from: private */
    public static A B1(Spliterator spliterator) {
        if (spliterator instanceof A) {
            return (A) spliterator;
        }
        if (X3.f29067a) {
            X3.a(C0204c.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    public final IntStream A(C0177v vVar) {
        Objects.requireNonNull(vVar);
        return new C0313y(this, C0213d3.f29119p | C0213d3.f29117n, vVar, 0);
    }

    public void D(C0165m mVar) {
        Objects.requireNonNull(mVar);
        j1(new P(mVar, false));
    }

    public final C0185j I(C0157i iVar) {
        Objects.requireNonNull(iVar);
        return (C0185j) j1(new A1(C0218e3.DOUBLE_VALUE, iVar, 1));
    }

    public final double K(double d11, C0157i iVar) {
        Objects.requireNonNull(iVar);
        return ((Double) j1(new G1(C0218e3.DOUBLE_VALUE, iVar, d11))).doubleValue();
    }

    public final boolean L(C0174s sVar) {
        return ((Boolean) j1(C0314y0.X0(sVar, C0299v0.NONE))).booleanValue();
    }

    public final boolean P(C0174s sVar) {
        return ((Boolean) j1(C0314y0.X0(sVar, C0299v0.ALL))).booleanValue();
    }

    public void a0(C0165m mVar) {
        Objects.requireNonNull(mVar);
        j1(new P(mVar, true));
    }

    public final C0185j average() {
        double[] dArr = (double[]) o(new C0199b(7), new C0199b(8), new C0199b(9));
        if (dArr[2] <= 0.0d) {
            return C0185j.a();
        }
        Set set = Collectors.f28907a;
        double d11 = dArr[0] + dArr[1];
        double d12 = dArr[dArr.length - 1];
        if (Double.isNaN(d11) && Double.isInfinite(d12)) {
            d11 = d12;
        }
        return C0185j.d(d11 / dArr[2]);
    }

    public final DoubleStream b(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0308x(this, 0, mVar, 3);
    }

    public final Stream boxed() {
        return new C0303w(this, 0, new N0(22), 0);
    }

    /* access modifiers changed from: package-private */
    public final C0 c1(long j11, IntFunction intFunction) {
        return C0314y0.L0(j11);
    }

    public final long count() {
        return ((Long) j1(new E1(C0218e3.DOUBLE_VALUE, 1))).longValue();
    }

    public final DoubleStream distinct() {
        return ((C0232h2) ((C0232h2) boxed()).distinct()).Z(new C0199b(10));
    }

    public final C0185j findAny() {
        return (C0185j) j1(J.f28947d);
    }

    public final C0185j findFirst() {
        return (C0185j) j1(J.f28946c);
    }

    public final DoubleStream h(C0174s sVar) {
        Objects.requireNonNull(sVar);
        return new C0308x(this, C0213d3.f29123t, sVar, 2);
    }

    public final DoubleStream i(C0171p pVar) {
        Objects.requireNonNull(pVar);
        return new C0308x(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, pVar, 1);
    }

    public final PrimitiveIterator$OfDouble iterator() {
        return Spliterators.f(spliterator());
    }

    public final LongStream j(C0180y yVar) {
        Objects.requireNonNull(yVar);
        return new C0317z(this, C0213d3.f29119p | C0213d3.f29117n, yVar, 0);
    }

    /* access modifiers changed from: package-private */
    public final H0 l1(C0314y0 y0Var, Spliterator spliterator, boolean z11, IntFunction intFunction) {
        return C0314y0.F0(y0Var, spliterator, z11);
    }

    public final DoubleStream limit(long j11) {
        if (j11 >= 0) {
            return C0314y0.W0(this, 0, j11);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    /* access modifiers changed from: package-private */
    public final boolean m1(Spliterator spliterator, C0272p2 p2Var) {
        C0165m mVar;
        boolean h11;
        A B1 = B1(spliterator);
        if (p2Var instanceof C0165m) {
            mVar = (C0165m) p2Var;
        } else if (!X3.f29067a) {
            Objects.requireNonNull(p2Var);
            mVar = new C0293u(p2Var);
        } else {
            X3.a(C0204c.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        }
        do {
            h11 = p2Var.h();
            if (h11 || !B1.o(mVar)) {
                return h11;
            }
            h11 = p2Var.h();
            break;
        } while (!B1.o(mVar));
        return h11;
    }

    public final C0185j max() {
        return I(new N0(21));
    }

    public final C0185j min() {
        return I(new N0(20));
    }

    /* access modifiers changed from: package-private */
    public final C0218e3 n1() {
        return C0218e3.DOUBLE_VALUE;
    }

    public final Object o(Supplier supplier, x0 x0Var, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0288t tVar = new C0288t(0, biConsumer);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(x0Var);
        return j1(new C1(C0218e3.DOUBLE_VALUE, tVar, x0Var, supplier, 1));
    }

    public final DoubleStream p(B b11) {
        Objects.requireNonNull(b11);
        return new C0308x(this, C0213d3.f29119p | C0213d3.f29117n, b11, 0);
    }

    public final Stream q(C0171p pVar) {
        Objects.requireNonNull(pVar);
        return new C0303w(this, C0213d3.f29119p | C0213d3.f29117n, pVar, 0);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator r1(Supplier supplier) {
        return new C0258m3(supplier);
    }

    public final DoubleStream skip(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            return i11 == 0 ? this : C0314y0.W0(this, j11, -1);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    public final DoubleStream sorted() {
        return new H2(this);
    }

    public final A spliterator() {
        return B1(super.spliterator());
    }

    public final double sum() {
        double[] dArr = (double[]) o(new C0199b(11), new C0199b(5), new C0199b(6));
        Set set = Collectors.f28907a;
        double d11 = dArr[0] + dArr[1];
        double d12 = dArr[dArr.length - 1];
        return (!Double.isNaN(d11) || !Double.isInfinite(d12)) ? d11 : d12;
    }

    public final C0140f summaryStatistics() {
        return (C0140f) o(new N0(8), new N0(23), new N0(24));
    }

    public final double[] toArray() {
        return (double[]) C0314y0.Q0((D0) k1(new C0199b(4))).b();
    }

    public final boolean u(C0174s sVar) {
        return ((Boolean) j1(C0314y0.X0(sVar, C0299v0.ANY))).booleanValue();
    }

    public final BaseStream unordered() {
        return !p1() ? this : new B(this, C0213d3.f29121r, 0);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator y1(C0314y0 y0Var, C0194a aVar, boolean z11) {
        return new C0292t3(y0Var, aVar, z11);
    }
}
