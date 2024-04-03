package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.functions.Supplier;

@FunctionalInterface
public interface ScalarSupplier<T> extends Supplier<T> {
    T get();
}
