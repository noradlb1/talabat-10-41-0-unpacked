package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> subscriber, T t11);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i11);

    long produced(long j11);

    long requested();
}
