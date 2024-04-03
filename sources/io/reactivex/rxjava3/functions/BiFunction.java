package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface BiFunction<T1, T2, R> {
    R apply(T1 t12, T2 t22) throws Throwable;
}
