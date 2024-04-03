package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;

public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> observer, T t11);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i11);
}
