package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Set;

public interface Collector<T, A, R> {
    BiConsumer<A, T> accumulator();

    Set characteristics();

    BinaryOperator<A> combiner();

    Function<A, R> finisher();

    Supplier<A> supplier();
}
