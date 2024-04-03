package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> {
    R apply(T1 t12, T2 t22, T3 t32) throws Throwable;
}
