package io.reactivex.rxjava3.functions;

@FunctionalInterface
public interface Function5<T1, T2, T3, T4, T5, R> {
    R apply(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52) throws Throwable;
}
