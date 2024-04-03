package j$.util.stream;

import j$.util.A;
import j$.util.C0140f;
import j$.util.C0185j;
import j$.util.PrimitiveIterator$OfDouble;
import j$.util.Spliterators;
import j$.util.function.B;
import j$.util.function.BiConsumer;
import j$.util.function.C0157i;
import j$.util.function.C0165m;
import j$.util.function.C0171p;
import j$.util.function.C0174s;
import j$.util.function.C0177v;
import j$.util.function.C0180y;
import j$.util.function.Supplier;
import j$.util.function.x0;

public interface DoubleStream extends BaseStream<Double, DoubleStream> {

    /* renamed from: j$.util.stream.DoubleStream$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static DoubleStream of(double... dArr) {
            A j11 = Spliterators.j(dArr, 0, dArr.length);
            return new C(j11, C0213d3.h(j11));
        }
    }

    IntStream A(C0177v vVar);

    void D(C0165m mVar);

    C0185j I(C0157i iVar);

    double K(double d11, C0157i iVar);

    boolean L(C0174s sVar);

    boolean P(C0174s sVar);

    void a0(C0165m mVar);

    C0185j average();

    DoubleStream b(C0165m mVar);

    Stream<Double> boxed();

    long count();

    DoubleStream distinct();

    C0185j findAny();

    C0185j findFirst();

    DoubleStream h(C0174s sVar);

    DoubleStream i(C0171p pVar);

    PrimitiveIterator$OfDouble iterator();

    LongStream j(C0180y yVar);

    DoubleStream limit(long j11);

    C0185j max();

    C0185j min();

    Object o(Supplier supplier, x0 x0Var, BiConsumer biConsumer);

    DoubleStream p(B b11);

    DoubleStream parallel();

    Stream q(C0171p pVar);

    DoubleStream sequential();

    DoubleStream skip(long j11);

    DoubleStream sorted();

    A spliterator();

    double sum();

    C0140f summaryStatistics();

    double[] toArray();

    boolean u(C0174s sVar);
}
