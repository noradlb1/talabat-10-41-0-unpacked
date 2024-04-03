package j$.util.stream;

import j$.util.C0184i;
import j$.util.function.B0;
import j$.util.function.BiConsumer;
import j$.util.function.C0148d0;
import j$.util.function.C0154g0;
import j$.util.function.C0160j0;
import j$.util.function.C0166m0;
import j$.util.function.C0172p0;
import j$.util.function.H0;
import j$.util.function.Z;
import j$.util.function.s0;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.p0  reason: case insensitive filesystem */
public final /* synthetic */ class C0270p0 implements LongStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongStream f29194a;

    private /* synthetic */ C0270p0(LongStream longStream) {
        this.f29194a = longStream;
    }

    public static /* synthetic */ LongStream v(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof C0265o0 ? ((C0265o0) longStream).f29190a : new C0270p0(longStream);
    }

    public final /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.f29194a.y(C0160j0.b(longPredicate));
    }

    public final /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.f29194a.W(C0160j0.b(longPredicate));
    }

    public final /* synthetic */ DoubleStream asDoubleStream() {
        return H.v(this.f29194a.asDoubleStream());
    }

    public final /* synthetic */ OptionalDouble average() {
        return C0184i.f(this.f29194a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return Stream.Wrapper.convert(this.f29194a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f29194a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f29194a.x(H0.a(supplier), B0.a(objLongConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public final /* synthetic */ long count() {
        return this.f29194a.count();
    }

    public final /* synthetic */ LongStream distinct() {
        return v(this.f29194a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        LongStream longStream = this.f29194a;
        if (obj instanceof C0270p0) {
            obj = ((C0270p0) obj).f29194a;
        }
        return longStream.equals(obj);
    }

    public final /* synthetic */ LongStream filter(LongPredicate longPredicate) {
        return v(this.f29194a.Y(C0160j0.b(longPredicate)));
    }

    public final /* synthetic */ OptionalLong findAny() {
        return C0184i.h(this.f29194a.findAny());
    }

    public final /* synthetic */ OptionalLong findFirst() {
        return C0184i.h(this.f29194a.findFirst());
    }

    public final /* synthetic */ LongStream flatMap(LongFunction longFunction) {
        return v(this.f29194a.g(C0154g0.a(longFunction)));
    }

    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f29194a.B(C0148d0.a(longConsumer));
    }

    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f29194a.w(C0148d0.a(longConsumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f29194a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f29194a.isParallel();
    }

    public final /* synthetic */ LongStream limit(long j11) {
        return v(this.f29194a.limit(j11));
    }

    public final /* synthetic */ LongStream map(LongUnaryOperator longUnaryOperator) {
        return v(this.f29194a.H(s0.d(longUnaryOperator)));
    }

    public final /* synthetic */ DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return H.v(this.f29194a.F(C0166m0.b(longToDoubleFunction)));
    }

    public final /* synthetic */ IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return IntStream.Wrapper.convert(this.f29194a.N(C0172p0.b(longToIntFunction)));
    }

    public final /* synthetic */ java.util.stream.Stream mapToObj(LongFunction longFunction) {
        return Stream.Wrapper.convert(this.f29194a.O(C0154g0.a(longFunction)));
    }

    public final /* synthetic */ OptionalLong max() {
        return C0184i.h(this.f29194a.max());
    }

    public final /* synthetic */ OptionalLong min() {
        return C0184i.h(this.f29194a.min());
    }

    public final /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.f29194a.a(C0160j0.b(longPredicate));
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0229h.v(this.f29194a.onClose(runnable));
    }

    public final /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return v(this.f29194a.f(C0148d0.a(longConsumer)));
    }

    public final /* synthetic */ long reduce(long j11, LongBinaryOperator longBinaryOperator) {
        return this.f29194a.m(j11, Z.a(longBinaryOperator));
    }

    public final /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return C0184i.h(this.f29194a.e(Z.a(longBinaryOperator)));
    }

    public final /* synthetic */ LongStream skip(long j11) {
        return v(this.f29194a.skip(j11));
    }

    public final /* synthetic */ LongStream sorted() {
        return v(this.f29194a.sorted());
    }

    public final /* synthetic */ long sum() {
        return this.f29194a.sum();
    }

    public final LongSummaryStatistics summaryStatistics() {
        this.f29194a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public final /* synthetic */ long[] toArray() {
        return this.f29194a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0229h.v(this.f29194a.unordered());
    }
}
