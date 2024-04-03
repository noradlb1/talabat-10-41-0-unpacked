package org.reactivestreams;

public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t11);

    void onSubscribe(Subscription subscription);
}
