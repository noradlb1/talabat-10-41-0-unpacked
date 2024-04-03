package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class QueueDrainHelper {
    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            return true;
        }
    }

    public static <T> boolean b(long j11, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j12 = j11 & Long.MIN_VALUE;
        while (true) {
            if (j12 != j11) {
                if (a(booleanSupplier)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j12++;
            } else if (a(booleanSupplier)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j11 = atomicLong.get();
                if (j11 == j12) {
                    long addAndGet = atomicLong.addAndGet(-(j12 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j11 = addAndGet;
                    j12 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, U> boolean checkTerminated(boolean z11, boolean z12, Subscriber<?> subscriber, boolean z13, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        if (queueDrain.cancelled()) {
            simpleQueue.clear();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!z13) {
                Throwable error = queueDrain.error();
                if (error != null) {
                    simpleQueue.clear();
                    subscriber.onError(error);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                Throwable error2 = queueDrain.error();
                if (error2 != null) {
                    subscriber.onError(error2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public static <T> SimpleQueue<T> createQueue(int i11) {
        if (i11 < 0) {
            return new SpscLinkedArrayQueue(-i11);
        }
        return new SpscArrayQueue(i11);
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z11, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        boolean z12;
        int i11 = 1;
        while (!checkTerminated(observableQueueDrain.done(), simplePlainQueue.isEmpty(), observer, z11, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean done = observableQueueDrain.done();
                T poll = simplePlainQueue.poll();
                if (poll == null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!checkTerminated(done, z12, observer, z11, simplePlainQueue, disposable, observableQueueDrain)) {
                    if (z12) {
                        i11 = observableQueueDrain.leave(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        observableQueueDrain.accept(observer, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> simplePlainQueue, Subscriber<? super U> subscriber, boolean z11, Disposable disposable, QueueDrain<T, U> queueDrain) {
        boolean z12;
        int i11 = 1;
        while (true) {
            boolean done = queueDrain.done();
            T poll = simplePlainQueue.poll();
            if (poll == null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (checkTerminated(done, z12, subscriber, z11, simplePlainQueue, queueDrain)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            } else if (z12) {
                i11 = queueDrain.leave(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                long requested = queueDrain.requested();
                if (requested == 0) {
                    simplePlainQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                } else if (queueDrain.accept(subscriber, poll) && requested != Long.MAX_VALUE) {
                    queueDrain.produced(1);
                }
            }
        }
    }

    public static <T> void postComplete(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j11;
        long j12;
        if (queue.isEmpty()) {
            subscriber.onComplete();
        } else if (!b(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            do {
                j11 = atomicLong.get();
                if ((j11 & Long.MIN_VALUE) == 0) {
                    j12 = j11 | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j11, j12));
            if (j11 != 0) {
                b(j12, subscriber, queue, atomicLong, booleanSupplier);
            }
        }
    }

    public static <T> boolean postCompleteRequest(long j11, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j12;
        long j13 = j11;
        do {
            j12 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j12, BackpressureHelper.addCap(Long.MAX_VALUE & j12, j11) | (j12 & Long.MIN_VALUE)));
        if (j12 != Long.MIN_VALUE) {
            return false;
        }
        b(j13 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }

    public static void request(Subscription subscription, int i11) {
        subscription.request(i11 < 0 ? Long.MAX_VALUE : (long) i11);
    }

    public static <T, U> boolean checkTerminated(boolean z11, boolean z12, Observer<?> observer, boolean z13, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.cancelled()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (!z13) {
                Throwable error = observableQueueDrain.error();
                if (error != null) {
                    simpleQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onError(error);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onComplete();
                    return true;
                }
            } else if (!z12) {
                return false;
            } else {
                if (disposable != null) {
                    disposable.dispose();
                }
                Throwable error2 = observableQueueDrain.error();
                if (error2 != null) {
                    observer.onError(error2);
                } else {
                    observer.onComplete();
                }
                return true;
            }
        }
    }
}
