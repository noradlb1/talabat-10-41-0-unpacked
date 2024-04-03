package j$.util.stream;

import j$.util.C0184i;
import j$.util.K;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.C0141a;
import j$.util.function.C0151f;
import j$.util.function.Consumer;
import j$.util.function.D;
import j$.util.function.Function;
import j$.util.function.G0;
import j$.util.function.I0;
import j$.util.function.IntFunction;
import j$.util.function.K0;
import j$.util.function.L;
import j$.util.function.M0;
import j$.util.function.O0;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.a3  reason: case insensitive filesystem */
public final /* synthetic */ class C0198a3 implements Stream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Stream f29082a;

    private /* synthetic */ C0198a3(Stream stream) {
        this.f29082a = stream;
    }

    public static /* synthetic */ Stream v(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new C0198a3(stream);
    }

    public final /* synthetic */ Object C(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f29082a.collect(I0.a(supplier), BiConsumer.Wrapper.convert(biConsumer), BiConsumer.Wrapper.convert(biConsumer2));
    }

    public final /* synthetic */ IntStream E(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f29082a.mapToInt(M0.a(toIntFunction)));
    }

    public final /* synthetic */ LongStream S(Function function) {
        return C0265o0.v(this.f29082a.flatMapToLong(D.a(function)));
    }

    public final /* synthetic */ LongStream X(ToLongFunction toLongFunction) {
        return C0265o0.v(this.f29082a.mapToLong(O0.a(toLongFunction)));
    }

    public final /* synthetic */ DoubleStream Z(ToDoubleFunction toDoubleFunction) {
        return G.v(this.f29082a.mapToDouble(K0.a(toDoubleFunction)));
    }

    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f29082a.allMatch(G0.a(predicate));
    }

    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f29082a.anyMatch(G0.a(predicate));
    }

    public final /* synthetic */ IntStream c(Function function) {
        return IntStream.VivifiedWrapper.convert(this.f29082a.flatMapToInt(D.a(function)));
    }

    public final /* synthetic */ Object c0(Object obj, BinaryOperator binaryOperator) {
        return this.f29082a.reduce(obj, C0151f.a(binaryOperator));
    }

    public final /* synthetic */ void close() {
        this.f29082a.close();
    }

    public final /* synthetic */ Object collect(Collector collector) {
        return this.f29082a.collect(C0244k.a(collector));
    }

    public final /* synthetic */ long count() {
        return this.f29082a.count();
    }

    public final /* synthetic */ Stream distinct() {
        return v(this.f29082a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0198a3) {
            obj = ((C0198a3) obj).f29082a;
        }
        return this.f29082a.equals(obj);
    }

    public final /* synthetic */ Stream filter(Predicate predicate) {
        return v(this.f29082a.filter(G0.a(predicate)));
    }

    public final /* synthetic */ Optional findAny() {
        return C0184i.a(this.f29082a.findAny());
    }

    public final /* synthetic */ Optional findFirst() {
        return C0184i.a(this.f29082a.findFirst());
    }

    public final /* synthetic */ Stream flatMap(Function function) {
        return v(this.f29082a.flatMap(D.a(function)));
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f29082a.forEach(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f29082a.forEachOrdered(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ int hashCode() {
        return this.f29082a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f29082a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f29082a.iterator();
    }

    public final /* synthetic */ Object l(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f29082a.reduce(obj, C0141a.a(biFunction), C0151f.a(binaryOperator));
    }

    public final /* synthetic */ Stream limit(long j11) {
        return v(this.f29082a.limit(j11));
    }

    public final /* synthetic */ Stream map(Function function) {
        return v(this.f29082a.map(D.a(function)));
    }

    public final /* synthetic */ Optional max(Comparator comparator) {
        return C0184i.a(this.f29082a.max(comparator));
    }

    public final /* synthetic */ Optional min(Comparator comparator) {
        return C0184i.a(this.f29082a.min(comparator));
    }

    public final /* synthetic */ DoubleStream n(Function function) {
        return G.v(this.f29082a.flatMapToDouble(D.a(function)));
    }

    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f29082a.noneMatch(G0.a(predicate));
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0224g.v(this.f29082a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return C0224g.v(this.f29082a.parallel());
    }

    public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
        return C0184i.a(this.f29082a.reduce(C0151f.a(binaryOperator)));
    }

    public final /* synthetic */ BaseStream sequential() {
        return C0224g.v(this.f29082a.sequential());
    }

    public final /* synthetic */ Stream skip(long j11) {
        return v(this.f29082a.skip(j11));
    }

    public final /* synthetic */ Stream sorted() {
        return v(this.f29082a.sorted());
    }

    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return v(this.f29082a.sorted(comparator));
    }

    public final /* synthetic */ Spliterator spliterator() {
        return K.f(this.f29082a.spliterator());
    }

    public final /* synthetic */ Stream t(Consumer consumer) {
        return v(this.f29082a.peek(Consumer.Wrapper.convert(consumer)));
    }

    public final /* synthetic */ Object[] toArray() {
        return this.f29082a.toArray();
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f29082a.toArray(L.a(intFunction));
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0224g.v(this.f29082a.unordered());
    }
}
