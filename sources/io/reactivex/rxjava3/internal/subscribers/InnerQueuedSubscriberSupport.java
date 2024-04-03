package io.reactivex.rxjava3.internal.subscribers;

public interface InnerQueuedSubscriberSupport<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void innerError(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th2);

    void innerNext(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t11);
}
