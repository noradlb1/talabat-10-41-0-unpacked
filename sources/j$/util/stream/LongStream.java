package j$.util.stream;

import j$.util.C0183h;
import j$.util.C0185j;
import j$.util.C0187l;
import j$.util.G;
import j$.util.PrimitiveIterator$OfLong;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.C0144b0;
import j$.util.function.C0152f0;
import j$.util.function.C0158i0;
import j$.util.function.C0164l0;
import j$.util.function.C0170o0;
import j$.util.function.D0;
import j$.util.function.Supplier;
import j$.util.function.r0;
import j$.util.function.u0;

public interface LongStream extends BaseStream<Long, LongStream> {

    /* renamed from: j$.util.stream.LongStream$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static LongStream of(long... jArr) {
            G l11 = Spliterators.l(jArr, 0, jArr.length);
            return new C0245k0(l11, C0213d3.h(l11));
        }
    }

    void B(C0152f0 f0Var);

    DoubleStream F(C0170o0 o0Var);

    LongStream H(u0 u0Var);

    IntStream N(r0 r0Var);

    Stream O(C0158i0 i0Var);

    boolean W(C0164l0 l0Var);

    LongStream Y(C0164l0 l0Var);

    boolean a(C0164l0 l0Var);

    DoubleStream asDoubleStream();

    C0185j average();

    Stream<Long> boxed();

    long count();

    LongStream distinct();

    C0187l e(C0144b0 b0Var);

    LongStream f(C0152f0 f0Var);

    C0187l findAny();

    C0187l findFirst();

    LongStream g(C0158i0 i0Var);

    PrimitiveIterator$OfLong iterator();

    LongStream limit(long j11);

    long m(long j11, C0144b0 b0Var);

    C0187l max();

    C0187l min();

    LongStream parallel();

    LongStream sequential();

    LongStream skip(long j11);

    LongStream sorted();

    G spliterator();

    long sum();

    C0183h summaryStatistics();

    long[] toArray();

    void w(C0152f0 f0Var);

    Object x(Supplier supplier, D0 d02, BiConsumer biConsumer);

    boolean y(C0164l0 l0Var);
}
