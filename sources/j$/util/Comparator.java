package j$.util;

import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Objects;

public interface Comparator<T> {

    /* renamed from: j$.util.Comparator$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function) {
            return EL.thenComparing(comparator, comparing(function));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function, java.util.Comparator comparator2) {
            return EL.thenComparing(comparator, comparing(function, comparator2));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, java.util.Comparator comparator2) {
            Objects.requireNonNull(comparator2);
            return new C0114c(comparator, comparator2, 0);
        }

        public static java.util.Comparator $default$thenComparingDouble(java.util.Comparator comparator, ToDoubleFunction toDoubleFunction) {
            Objects.requireNonNull(toDoubleFunction);
            return EL.thenComparing(comparator, (java.util.Comparator) new C0113b(0, toDoubleFunction));
        }

        public static java.util.Comparator $default$thenComparingInt(java.util.Comparator comparator, ToIntFunction toIntFunction) {
            return EL.thenComparing(comparator, comparingInt(toIntFunction));
        }

        public static java.util.Comparator $default$thenComparingLong(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            return EL.thenComparing(comparator, comparingLong(toLongFunction));
        }

        public static <T, U extends Comparable<? super U>> java.util.Comparator<T> comparing(Function<? super T, ? extends U> function) {
            Objects.requireNonNull(function);
            return new C0113b(3, function);
        }

        public static <T, U> java.util.Comparator<T> comparing(Function<? super T, ? extends U> function, java.util.Comparator<? super U> comparator) {
            Objects.requireNonNull(function);
            Objects.requireNonNull(comparator);
            return new C0114c(comparator, function, 1);
        }

        public static <T> java.util.Comparator<T> comparingInt(ToIntFunction<? super T> toIntFunction) {
            Objects.requireNonNull(toIntFunction);
            return new C0113b(1, toIntFunction);
        }

        public static <T> java.util.Comparator<T> comparingLong(ToLongFunction<? super T> toLongFunction) {
            Objects.requireNonNull(toLongFunction);
            return new C0113b(2, toLongFunction);
        }

        public static <T extends Comparable<? super T>> java.util.Comparator<T> naturalOrder() {
            return C0138d.INSTANCE;
        }
    }

    /* renamed from: j$.util.Comparator$-EL  reason: invalid class name */
    public final /* synthetic */ class EL {
        public static java.util.Comparator reversed(java.util.Comparator comparator) {
            return comparator instanceof Comparator ? ((Comparator) comparator).reversed() : Collections.reverseOrder(comparator);
        }

        public static /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator, Function function) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(function) : CC.$default$thenComparing(comparator, function);
        }

        public static /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator, java.util.Comparator comparator2) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(comparator2) : CC.$default$thenComparing(comparator, comparator2);
        }

        public static /* synthetic */ java.util.Comparator thenComparingLong(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            return comparator instanceof Comparator ? ((Comparator) comparator).thenComparingLong(toLongFunction) : CC.$default$thenComparingLong(comparator, toLongFunction);
        }
    }

    int compare(T t11, T t12);

    boolean equals(Object obj);

    java.util.Comparator<T> reversed();

    <U extends Comparable<? super U>> java.util.Comparator<T> thenComparing(Function<? super T, ? extends U> function);

    <U> java.util.Comparator<T> thenComparing(Function<? super T, ? extends U> function, java.util.Comparator<? super U> comparator);

    java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator);

    java.util.Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> toDoubleFunction);

    java.util.Comparator<T> thenComparingInt(ToIntFunction<? super T> toIntFunction);

    java.util.Comparator<T> thenComparingLong(ToLongFunction<? super T> toLongFunction);
}
