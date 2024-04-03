package j$.util.stream;

import j$.util.C0184i;
import j$.util.function.BiConsumer;
import j$.util.function.C0153g;
import j$.util.function.C0161k;
import j$.util.function.C0167n;
import j$.util.function.C0173q;
import j$.util.function.C0175t;
import j$.util.function.C0178w;
import j$.util.function.C0181z;
import j$.util.function.H0;
import j$.util.function.v0;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class H implements DoubleStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleStream f28930a;

    private /* synthetic */ H(DoubleStream doubleStream) {
        this.f28930a = doubleStream;
    }

    public static /* synthetic */ DoubleStream v(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof G ? ((G) doubleStream).f28921a : new H(doubleStream);
    }

    public final /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.f28930a.P(C0173q.b(doublePredicate));
    }

    public final /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.f28930a.u(C0173q.b(doublePredicate));
    }

    public final /* synthetic */ OptionalDouble average() {
        return C0184i.f(this.f28930a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return Stream.Wrapper.convert(this.f28930a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f28930a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f28930a.o(H0.a(supplier), v0.a(objDoubleConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public final /* synthetic */ long count() {
        return this.f28930a.count();
    }

    public final /* synthetic */ DoubleStream distinct() {
        return v(this.f28930a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.f28930a;
        if (obj instanceof H) {
            obj = ((H) obj).f28930a;
        }
        return doubleStream.equals(obj);
    }

    public final /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
        return v(this.f28930a.h(C0173q.b(doublePredicate)));
    }

    public final /* synthetic */ OptionalDouble findAny() {
        return C0184i.f(this.f28930a.findAny());
    }

    public final /* synthetic */ OptionalDouble findFirst() {
        return C0184i.f(this.f28930a.findFirst());
    }

    public final /* synthetic */ DoubleStream flatMap(DoubleFunction doubleFunction) {
        return v(this.f28930a.i(C0167n.a(doubleFunction)));
    }

    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f28930a.D(C0161k.a(doubleConsumer));
    }

    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f28930a.a0(C0161k.a(doubleConsumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f28930a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f28930a.isParallel();
    }

    public final /* synthetic */ DoubleStream limit(long j11) {
        return v(this.f28930a.limit(j11));
    }

    public final /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return v(this.f28930a.p(C0181z.d(doubleUnaryOperator)));
    }

    public final /* synthetic */ IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return IntStream.Wrapper.convert(this.f28930a.A(C0175t.b(doubleToIntFunction)));
    }

    public final /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return C0270p0.v(this.f28930a.j(C0178w.b(doubleToLongFunction)));
    }

    public final /* synthetic */ java.util.stream.Stream mapToObj(DoubleFunction doubleFunction) {
        return Stream.Wrapper.convert(this.f28930a.q(C0167n.a(doubleFunction)));
    }

    public final /* synthetic */ OptionalDouble max() {
        return C0184i.f(this.f28930a.max());
    }

    public final /* synthetic */ OptionalDouble min() {
        return C0184i.f(this.f28930a.min());
    }

    public final /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.f28930a.L(C0173q.b(doublePredicate));
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0229h.v(this.f28930a.onClose(runnable));
    }

    public final /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return v(this.f28930a.b(C0161k.a(doubleConsumer)));
    }

    public final /* synthetic */ double reduce(double d11, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f28930a.K(d11, C0153g.a(doubleBinaryOperator));
    }

    public final /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return C0184i.f(this.f28930a.I(C0153g.a(doubleBinaryOperator)));
    }

    public final /* synthetic */ DoubleStream skip(long j11) {
        return v(this.f28930a.skip(j11));
    }

    public final /* synthetic */ DoubleStream sorted() {
        return v(this.f28930a.sorted());
    }

    public final /* synthetic */ double sum() {
        return this.f28930a.sum();
    }

    public final DoubleSummaryStatistics summaryStatistics() {
        this.f28930a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public final /* synthetic */ double[] toArray() {
        return this.f28930a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0229h.v(this.f28930a.unordered());
    }
}
