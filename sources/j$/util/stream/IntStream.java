package j$.util.stream;

import j$.util.C0182g;
import j$.util.C0184i;
import j$.util.C0185j;
import j$.util.C0186k;
import j$.util.D;
import j$.util.DesugarArrays;
import j$.util.PrimitiveIterator$OfInt;
import j$.util.Spliterators;
import j$.util.function.A0;
import j$.util.function.BiConsumer;
import j$.util.function.E;
import j$.util.function.F;
import j$.util.function.G;
import j$.util.function.H0;
import j$.util.function.I;
import j$.util.function.I0;
import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.J;
import j$.util.function.K;
import j$.util.function.L;
import j$.util.function.N;
import j$.util.function.O;
import j$.util.function.P;
import j$.util.function.Q;
import j$.util.function.S;
import j$.util.function.Supplier;
import j$.util.function.T;
import j$.util.function.U;
import j$.util.function.V;
import j$.util.function.W;
import j$.util.function.X;
import j$.util.function.Y;
import j$.util.function.y0;
import j$.util.function.z0;
import j$.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface IntStream extends BaseStream<Integer, IntStream> {

    /* renamed from: j$.util.stream.IntStream$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IntStream of(int... iArr) {
            return DesugarArrays.stream(iArr);
        }

        public static IntStream range(int i11, int i12) {
            if (i11 >= i12) {
                D c11 = Spliterators.c();
                return new C0210d0(c11, C0213d3.h(c11));
            }
            S3 s32 = new S3(i11, i12, false);
            return new C0210d0(s32, C0213d3.h(s32));
        }

        public static IntStream rangeClosed(int i11, int i12) {
            if (i11 > i12) {
                D c11 = Spliterators.c();
                return new C0210d0(c11, C0213d3.h(c11));
            }
            S3 s32 = new S3(i11, i12, true);
            return new C0210d0(s32, C0213d3.h(s32));
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements IntStream {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.stream.IntStream f28944a;

        private /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.f28944a = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        public final /* synthetic */ void J(K k11) {
            this.f28944a.forEachOrdered(J.a(k11));
        }

        public final /* synthetic */ IntStream M(IntFunction intFunction) {
            return convert(this.f28944a.flatMap(L.a(intFunction)));
        }

        public final /* synthetic */ void Q(K k11) {
            this.f28944a.forEach(J.a(k11));
        }

        public final /* synthetic */ DoubleStream R(S s11) {
            return G.v(this.f28944a.mapToDouble(Q.a(s11)));
        }

        public final /* synthetic */ IntStream T(IntPredicate intPredicate) {
            return convert(this.f28944a.filter(O.a(intPredicate)));
        }

        public final /* synthetic */ C0186k U(G g11) {
            return C0184i.c(this.f28944a.reduce(F.a(g11)));
        }

        public final /* synthetic */ IntStream V(K k11) {
            return convert(this.f28944a.peek(J.a(k11)));
        }

        public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return this.f28944a.allMatch(O.a(intPredicate));
        }

        public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return this.f28944a.anyMatch(O.a(intPredicate));
        }

        public final /* synthetic */ DoubleStream asDoubleStream() {
            return G.v(this.f28944a.asDoubleStream());
        }

        public final /* synthetic */ LongStream asLongStream() {
            return C0265o0.v(this.f28944a.asLongStream());
        }

        public final /* synthetic */ C0185j average() {
            return C0184i.b(this.f28944a.average());
        }

        public final /* synthetic */ Stream boxed() {
            return C0198a3.v(this.f28944a.boxed());
        }

        public final /* synthetic */ void close() {
            this.f28944a.close();
        }

        public final /* synthetic */ long count() {
            return this.f28944a.count();
        }

        public final /* synthetic */ LongStream d(V v11) {
            return C0265o0.v(this.f28944a.mapToLong(U.a(v11)));
        }

        public final /* synthetic */ IntStream distinct() {
            return convert(this.f28944a.distinct());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f28944a;
            }
            return this.f28944a.equals(obj);
        }

        public final /* synthetic */ C0186k findAny() {
            return C0184i.c(this.f28944a.findAny());
        }

        public final /* synthetic */ C0186k findFirst() {
            return C0184i.c(this.f28944a.findFirst());
        }

        public final /* synthetic */ int hashCode() {
            return this.f28944a.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return this.f28944a.isParallel();
        }

        public final /* synthetic */ IntStream k(Y y11) {
            return convert(this.f28944a.map(X.a(y11)));
        }

        public final /* synthetic */ IntStream limit(long j11) {
            return convert(this.f28944a.limit(j11));
        }

        public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return C0198a3.v(this.f28944a.mapToObj(L.a(intFunction)));
        }

        public final /* synthetic */ C0186k max() {
            return C0184i.c(this.f28944a.max());
        }

        public final /* synthetic */ C0186k min() {
            return C0184i.c(this.f28944a.min());
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return C0224g.v(this.f28944a.onClose(runnable));
        }

        public final /* synthetic */ int r(int i11, G g11) {
            return this.f28944a.reduce(i11, F.a(g11));
        }

        public final /* synthetic */ boolean s(IntPredicate intPredicate) {
            return this.f28944a.noneMatch(O.a(intPredicate));
        }

        public final /* synthetic */ IntStream skip(long j11) {
            return convert(this.f28944a.skip(j11));
        }

        public final /* synthetic */ IntStream sorted() {
            return convert(this.f28944a.sorted());
        }

        public final /* synthetic */ int sum() {
            return this.f28944a.sum();
        }

        public final C0182g summaryStatistics() {
            this.f28944a.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        public final /* synthetic */ int[] toArray() {
            return this.f28944a.toArray();
        }

        public final /* synthetic */ BaseStream unordered() {
            return C0224g.v(this.f28944a.unordered());
        }

        public final /* synthetic */ Object z(Supplier supplier, A0 a02, BiConsumer biConsumer) {
            return this.f28944a.collect(I0.a(supplier), z0.a(a02), BiConsumer.Wrapper.convert(biConsumer));
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).f28944a : new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.allMatch(N.a(intPredicate));
        }

        public final /* synthetic */ boolean anyMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.anyMatch(N.a(intPredicate));
        }

        public final /* synthetic */ DoubleStream asDoubleStream() {
            return H.v(IntStream.this.asDoubleStream());
        }

        public final /* synthetic */ LongStream asLongStream() {
            return C0270p0.v(IntStream.this.asLongStream());
        }

        public final /* synthetic */ OptionalDouble average() {
            return C0184i.f(IntStream.this.average());
        }

        public final /* synthetic */ Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        public final /* synthetic */ Object collect(java.util.function.Supplier supplier, ObjIntConsumer objIntConsumer, java.util.function.BiConsumer biConsumer) {
            return IntStream.this.z(H0.a(supplier), y0.a(objIntConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
        }

        public final /* synthetic */ long count() {
            return IntStream.this.count();
        }

        public final /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.IntStream filter(java.util.function.IntPredicate intPredicate) {
            return convert(IntStream.this.T(N.a(intPredicate)));
        }

        public final /* synthetic */ OptionalInt findAny() {
            return C0184i.g(IntStream.this.findAny());
        }

        public final /* synthetic */ OptionalInt findFirst() {
            return C0184i.g(IntStream.this.findFirst());
        }

        public final /* synthetic */ java.util.stream.IntStream flatMap(java.util.function.IntFunction intFunction) {
            return convert(IntStream.this.M(IntFunction.VivifiedWrapper.convert(intFunction)));
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.Q(I.a(intConsumer));
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.J(I.a(intConsumer));
        }

        public final /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        public final /* synthetic */ java.util.stream.IntStream limit(long j11) {
            return convert(IntStream.this.limit(j11));
        }

        public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.k(W.d(intUnaryOperator)));
        }

        public final /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return H.v(IntStream.this.R(P.b(intToDoubleFunction)));
        }

        public final /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return C0270p0.v(IntStream.this.d(T.b(intToLongFunction)));
        }

        public final /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.mapToObj(IntFunction.VivifiedWrapper.convert(intFunction)));
        }

        public final /* synthetic */ OptionalInt max() {
            return C0184i.g(IntStream.this.max());
        }

        public final /* synthetic */ OptionalInt min() {
            return C0184i.g(IntStream.this.min());
        }

        public final /* synthetic */ boolean noneMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.s(N.a(intPredicate));
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return C0229h.v(IntStream.this.onClose(runnable));
        }

        public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.V(I.a(intConsumer)));
        }

        public final /* synthetic */ int reduce(int i11, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.r(i11, E.a(intBinaryOperator));
        }

        public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return C0184i.g(IntStream.this.U(E.a(intBinaryOperator)));
        }

        public final /* synthetic */ java.util.stream.IntStream skip(long j11) {
            return convert(IntStream.this.skip(j11));
        }

        public final /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        public final /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        public final IntSummaryStatistics summaryStatistics() {
            IntStream.this.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        public final /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        public final /* synthetic */ BaseStream unordered() {
            return C0229h.v(IntStream.this.unordered());
        }
    }

    void J(K k11);

    IntStream M(IntFunction intFunction);

    void Q(K k11);

    DoubleStream R(S s11);

    IntStream T(IntPredicate intPredicate);

    C0186k U(G g11);

    IntStream V(K k11);

    boolean allMatch(IntPredicate intPredicate);

    boolean anyMatch(IntPredicate intPredicate);

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    C0185j average();

    Stream<Integer> boxed();

    long count();

    LongStream d(V v11);

    IntStream distinct();

    C0186k findAny();

    C0186k findFirst();

    PrimitiveIterator$OfInt iterator();

    IntStream k(Y y11);

    IntStream limit(long j11);

    <U> Stream<U> mapToObj(IntFunction<? extends U> intFunction);

    C0186k max();

    C0186k min();

    IntStream parallel();

    int r(int i11, G g11);

    boolean s(IntPredicate intPredicate);

    IntStream sequential();

    IntStream skip(long j11);

    IntStream sorted();

    D spliterator();

    int sum();

    C0182g summaryStatistics();

    int[] toArray();

    Object z(Supplier supplier, A0 a02, BiConsumer biConsumer);
}
