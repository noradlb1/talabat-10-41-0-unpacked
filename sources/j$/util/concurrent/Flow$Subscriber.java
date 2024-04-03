package j$.util.concurrent;

public interface Flow$Subscriber<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t11);

    void onSubscribe(Flow$Subscription flow$Subscription);
}
