package j$.util.stream;

import j$.util.C0184i;
import j$.util.DesugarArrays;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0149e;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.H0;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.IntStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface Stream<T> extends BaseStream<T, Stream<T>> {

    /* renamed from: j$.util.stream.Stream$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static <T> Stream<T> concat(Stream<? extends T> stream, Stream<? extends T> stream2) {
            Objects.requireNonNull(stream);
            Objects.requireNonNull(stream2);
            return (Stream) StreamSupport.stream(new R3(stream.spliterator(), stream2.spliterator()), stream.isParallel() || stream2.isParallel()).onClose(new Q3(1, stream, stream2));
        }

        public static <T> Stream<T> of(T t11) {
            return StreamSupport.stream(new T3(t11), false);
        }

        public static <T> Stream<T> of(T... tArr) {
            return DesugarArrays.stream(tArr);
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.stream.Stream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.Stream convert(Stream stream) {
            if (stream == null) {
                return null;
            }
            return stream instanceof C0198a3 ? ((C0198a3) stream).f29082a : new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(Predicate predicate) {
            return Stream.this.allMatch(Predicate.VivifiedWrapper.convert(predicate));
        }

        public final /* synthetic */ boolean anyMatch(java.util.function.Predicate predicate) {
            return Stream.this.anyMatch(Predicate.VivifiedWrapper.convert(predicate));
        }

        public final /* synthetic */ void close() {
            Stream.this.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            return Stream.this.C(H0.a(supplier), BiConsumer.VivifiedWrapper.convert(biConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer2));
        }

        public final /* synthetic */ Object collect(Collector collector) {
            return Stream.this.collect(C0239j.a(collector));
        }

        public final /* synthetic */ long count() {
            return Stream.this.count();
        }

        public final /* synthetic */ java.util.stream.Stream distinct() {
            return convert(Stream.this.distinct());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Stream stream = Stream.this;
            if (obj instanceof Wrapper) {
                obj = Stream.this;
            }
            return stream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.Stream filter(java.util.function.Predicate predicate) {
            return convert(Stream.this.filter(Predicate.VivifiedWrapper.convert(predicate)));
        }

        public final /* synthetic */ Optional findAny() {
            return C0184i.e(Stream.this.findAny());
        }

        public final /* synthetic */ Optional findFirst() {
            return C0184i.e(Stream.this.findFirst());
        }

        public final /* synthetic */ java.util.stream.Stream flatMap(Function function) {
            return convert(Stream.this.flatMap(Function.VivifiedWrapper.convert(function)));
        }

        public final /* synthetic */ DoubleStream flatMapToDouble(java.util.function.Function function) {
            return H.v(Stream.this.n(Function.VivifiedWrapper.convert(function)));
        }

        public final /* synthetic */ IntStream flatMapToInt(java.util.function.Function function) {
            return IntStream.Wrapper.convert(Stream.this.c(Function.VivifiedWrapper.convert(function)));
        }

        public final /* synthetic */ LongStream flatMapToLong(java.util.function.Function function) {
            return C0270p0.v(Stream.this.S(Function.VivifiedWrapper.convert(function)));
        }

        public final /* synthetic */ void forEach(Consumer consumer) {
            Stream.this.forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final /* synthetic */ void forEachOrdered(java.util.function.Consumer consumer) {
            Stream.this.forEachOrdered(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final /* synthetic */ int hashCode() {
            return Stream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return Stream.this.isParallel();
        }

        public final /* synthetic */ Iterator iterator() {
            return Stream.this.iterator();
        }

        public final /* synthetic */ java.util.stream.Stream limit(long j11) {
            return convert(Stream.this.limit(j11));
        }

        public final /* synthetic */ java.util.stream.Stream map(java.util.function.Function function) {
            return convert(Stream.this.map(Function.VivifiedWrapper.convert(function)));
        }

        public final /* synthetic */ DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
            return H.v(Stream.this.Z(ToDoubleFunction.VivifiedWrapper.convert(toDoubleFunction)));
        }

        public final /* synthetic */ java.util.stream.IntStream mapToInt(ToIntFunction toIntFunction) {
            return IntStream.Wrapper.convert(Stream.this.E(ToIntFunction.VivifiedWrapper.convert(toIntFunction)));
        }

        public final /* synthetic */ LongStream mapToLong(ToLongFunction toLongFunction) {
            return C0270p0.v(Stream.this.X(ToLongFunction.VivifiedWrapper.convert(toLongFunction)));
        }

        public final /* synthetic */ Optional max(Comparator comparator) {
            return C0184i.e(Stream.this.max(comparator));
        }

        public final /* synthetic */ Optional min(Comparator comparator) {
            return C0184i.e(Stream.this.min(comparator));
        }

        public final /* synthetic */ boolean noneMatch(java.util.function.Predicate predicate) {
            return Stream.this.noneMatch(Predicate.VivifiedWrapper.convert(predicate));
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return C0229h.v(Stream.this.onClose(runnable));
        }

        public final /* synthetic */ BaseStream parallel() {
            return C0229h.v(Stream.this.parallel());
        }

        public final /* synthetic */ java.util.stream.Stream peek(java.util.function.Consumer consumer) {
            return convert(Stream.this.t(Consumer.VivifiedWrapper.convert(consumer)));
        }

        public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            return Stream.this.l(obj, BiFunction.VivifiedWrapper.convert(biFunction), C0149e.a(binaryOperator));
        }

        public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
            return Stream.this.c0(obj, C0149e.a(binaryOperator));
        }

        public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
            return C0184i.e(Stream.this.reduce(C0149e.a(binaryOperator)));
        }

        public final /* synthetic */ BaseStream sequential() {
            return C0229h.v(Stream.this.sequential());
        }

        public final /* synthetic */ java.util.stream.Stream skip(long j11) {
            return convert(Stream.this.skip(j11));
        }

        public final /* synthetic */ java.util.stream.Stream sorted() {
            return convert(Stream.this.sorted());
        }

        public final /* synthetic */ java.util.stream.Stream sorted(Comparator comparator) {
            return convert(Stream.this.sorted(comparator));
        }

        public final /* synthetic */ Spliterator spliterator() {
            return Spliterator.Wrapper.convert(Stream.this.spliterator());
        }

        public final /* synthetic */ Object[] toArray() {
            return Stream.this.toArray();
        }

        public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Stream.this.toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }

        public final /* synthetic */ BaseStream unordered() {
            return C0229h.v(Stream.this.unordered());
        }
    }

    Object C(j$.util.function.Supplier supplier, j$.util.function.BiConsumer biConsumer, j$.util.function.BiConsumer biConsumer2);

    IntStream E(j$.util.function.ToIntFunction toIntFunction);

    LongStream S(j$.util.function.Function function);

    LongStream X(j$.util.function.ToLongFunction toLongFunction);

    DoubleStream Z(j$.util.function.ToDoubleFunction toDoubleFunction);

    boolean allMatch(j$.util.function.Predicate<? super T> predicate);

    boolean anyMatch(j$.util.function.Predicate<? super T> predicate);

    IntStream c(j$.util.function.Function function);

    Object c0(Object obj, j$.util.function.BinaryOperator binaryOperator);

    <R, A> R collect(Collector<? super T, A, R> collector);

    long count();

    Stream<T> distinct();

    Stream<T> filter(j$.util.function.Predicate<? super T> predicate);

    j$.util.Optional<T> findAny();

    j$.util.Optional<T> findFirst();

    <R> Stream<R> flatMap(j$.util.function.Function<? super T, ? extends Stream<? extends R>> function);

    void forEach(j$.util.function.Consumer<? super T> consumer);

    void forEachOrdered(j$.util.function.Consumer<? super T> consumer);

    Object l(Object obj, j$.util.function.BiFunction biFunction, j$.util.function.BinaryOperator binaryOperator);

    Stream limit(long j11);

    <R> Stream<R> map(j$.util.function.Function<? super T, ? extends R> function);

    j$.util.Optional max(Comparator comparator);

    j$.util.Optional min(Comparator comparator);

    DoubleStream n(j$.util.function.Function function);

    boolean noneMatch(j$.util.function.Predicate<? super T> predicate);

    j$.util.Optional<T> reduce(j$.util.function.BinaryOperator<T> binaryOperator);

    Stream skip(long j11);

    Stream sorted();

    Stream<T> sorted(Comparator<? super T> comparator);

    Stream t(j$.util.function.Consumer consumer);

    Object[] toArray();

    <A> A[] toArray(j$.util.function.IntFunction<A[]> intFunction);
}
