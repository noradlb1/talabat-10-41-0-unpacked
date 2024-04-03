package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {
    R apply(T1 t12, T2 t22, T3 t32, T4 t42) throws Throwable;
}
