package com.instabug.library.util.filters;

@FunctionalInterface
public interface Filter<T> {
    T apply(T t11);
}
