package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static void onComplete(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                subscriber.onError(terminate);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static void onError(Subscriber<?> subscriber, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th2)) {
            RxJavaPlugins.onError(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            subscriber.onError(atomicThrowable.terminate());
        }
    }

    public static <T> void onNext(Subscriber<? super T> subscriber, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t11);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    subscriber.onError(terminate);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    public static void onComplete(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                observer.onError(terminate);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void onError(Observer<?> observer, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th2)) {
            RxJavaPlugins.onError(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            observer.onError(atomicThrowable.terminate());
        }
    }

    public static <T> void onNext(Observer<? super T> observer, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t11);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    observer.onError(terminate);
                } else {
                    observer.onComplete();
                }
            }
        }
    }
}
