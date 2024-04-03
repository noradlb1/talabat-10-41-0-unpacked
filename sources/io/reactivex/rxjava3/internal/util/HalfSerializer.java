package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static void onComplete(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(subscriber);
        }
    }

    public static void onError(Subscriber<?> subscriber, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.tryAddThrowableOrReport(th2) && atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(subscriber);
        }
    }

    public static <T> boolean onNext(Subscriber<? super T> subscriber, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t11);
            if (atomicInteger.decrementAndGet() == 0) {
                return true;
            }
            atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
        }
        return false;
    }

    public static void onComplete(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(observer);
        }
    }

    public static void onError(Observer<?> observer, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.tryAddThrowableOrReport(th2) && atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(observer);
        }
    }

    public static <T> void onNext(Observer<? super T> observer, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t11);
            if (atomicInteger.decrementAndGet() != 0) {
                atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
            }
        }
    }
}
