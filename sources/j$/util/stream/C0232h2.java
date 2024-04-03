package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.C0147d;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: j$.util.stream.h2  reason: case insensitive filesystem */
abstract class C0232h2 extends C0204c implements Stream {
    C0232h2(Spliterator spliterator, int i11, boolean z11) {
        super(spliterator, i11, z11);
    }

    C0232h2(Supplier supplier, int i11, boolean z11) {
        super(supplier, i11, z11);
    }

    C0232h2(C0204c cVar, int i11) {
        super(cVar, i11);
    }

    public final Object C(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return j1(new C1(C0218e3.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }

    public final IntStream E(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new C0313y(this, C0213d3.f29119p | C0213d3.f29117n, toIntFunction, 6);
    }

    public final LongStream S(Function function) {
        Objects.requireNonNull(function);
        return new C0317z(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, function, 6);
    }

    public final LongStream X(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new C0317z(this, C0213d3.f29119p | C0213d3.f29117n, toLongFunction, 7);
    }

    public final DoubleStream Z(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new C0308x(this, C0213d3.f29119p | C0213d3.f29117n, toDoubleFunction, 6);
    }

    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) j1(C0314y0.d1(predicate, C0299v0.ALL))).booleanValue();
    }

    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) j1(C0314y0.d1(predicate, C0299v0.ANY))).booleanValue();
    }

    public final IntStream c(Function function) {
        Objects.requireNonNull(function);
        return new C0313y(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, function, 7);
    }

    public final Object c0(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return j1(new C1(C0218e3.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    /* access modifiers changed from: package-private */
    public final C0 c1(long j11, IntFunction intFunction) {
        return C0314y0.D0(j11, intFunction);
    }

    public final Object collect(Collector collector) {
        Object obj;
        if (!isParallel() || !collector.characteristics().contains(C0234i.CONCURRENT) || (p1() && !collector.characteristics().contains(C0234i.UNORDERED))) {
            Objects.requireNonNull(collector);
            Supplier supplier = collector.supplier();
            obj = j1(new J1(C0218e3.REFERENCE, collector.combiner(), collector.accumulator(), supplier, collector));
        } else {
            obj = collector.supplier().get();
            forEach(new C0269p(5, collector.accumulator(), obj));
        }
        return collector.characteristics().contains(C0234i.IDENTITY_FINISH) ? obj : collector.finisher().apply(obj);
    }

    public final long count() {
        return ((Long) j1(new E1(C0218e3.REFERENCE, 2))).longValue();
    }

    public final Stream distinct() {
        return new C0283s(this, C0213d3.f29116m | C0213d3.f29123t);
    }

    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new C0303w(this, C0213d3.f29123t, predicate, 4);
    }

    public final Optional findAny() {
        return (Optional) j1(M.f28974d);
    }

    public final Optional findFirst() {
        return (Optional) j1(M.f28973c);
    }

    public final Stream flatMap(Function function) {
        Objects.requireNonNull(function);
        return new C0207c2(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, function, 1);
    }

    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        j1(new T(consumer, false));
    }

    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        j1(new T(consumer, true));
    }

    public final Iterator iterator() {
        return Spliterators.i(spliterator());
    }

    public final Object l(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return j1(new C1(C0218e3.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    /* access modifiers changed from: package-private */
    public final H0 l1(C0314y0 y0Var, Spliterator spliterator, boolean z11, IntFunction intFunction) {
        return C0314y0.E0(y0Var, spliterator, z11, intFunction);
    }

    public final Stream limit(long j11) {
        if (j11 >= 0) {
            return C0314y0.e1(this, 0, j11);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    final boolean m1(j$.util.Spliterator r3, j$.util.stream.C0272p2 r4) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r4.h()
            if (r0 != 0) goto L_0x000c
            boolean r1 = r3.a(r4)
            if (r1 != 0) goto L_0x0000
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0232h2.m1(j$.util.Spliterator, j$.util.stream.p2):boolean");
    }

    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new C0207c2(this, C0213d3.f29119p | C0213d3.f29117n, function, 0);
    }

    public final Optional max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new C0147d(comparator, 0));
    }

    public final Optional min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new C0147d(comparator, 1));
    }

    public final DoubleStream n(Function function) {
        Objects.requireNonNull(function);
        return new C0308x(this, C0213d3.f29119p | C0213d3.f29117n | C0213d3.f29123t, function, 7);
    }

    /* access modifiers changed from: package-private */
    public final C0218e3 n1() {
        return C0218e3.REFERENCE;
    }

    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) j1(C0314y0.d1(predicate, C0299v0.NONE))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final Spliterator r1(Supplier supplier) {
        return new C0278q3(supplier);
    }

    public final Optional reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (Optional) j1(new A1(C0218e3.REFERENCE, binaryOperator, 2));
    }

    public final Stream skip(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            return i11 == 0 ? this : C0314y0.e1(this, j11, -1);
        }
        throw new IllegalArgumentException(Long.toString(j11));
    }

    public final Stream sorted() {
        return new K2(this);
    }

    public final Stream sorted(Comparator comparator) {
        return new K2(this, comparator);
    }

    public final Stream t(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0303w(this, 0, consumer, 3);
    }

    public final Object[] toArray() {
        return toArray(new N0(1));
    }

    public final Object[] toArray(IntFunction intFunction) {
        return C0314y0.P0(k1(intFunction), intFunction).o(intFunction);
    }

    public final BaseStream unordered() {
        return !p1() ? this : new C0202b2(this, C0213d3.f29121r);
    }

    /* access modifiers changed from: package-private */
    public final Spliterator y1(C0314y0 y0Var, C0194a aVar, boolean z11) {
        return new P3(y0Var, aVar, z11);
    }
}
