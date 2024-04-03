package io.reactivex.internal.operators.flowable;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

public final class BlockingFlowableIterable<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f14764b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14765c;

    public static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable, j$.util.Iterator {
        private static final long serialVersionUID = 6695226475494099826L;

        /* renamed from: b  reason: collision with root package name */
        public final SpscArrayQueue<T> f14766b;

        /* renamed from: c  reason: collision with root package name */
        public final long f14767c;

        /* renamed from: d  reason: collision with root package name */
        public final long f14768d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f14769e;

        /* renamed from: f  reason: collision with root package name */
        public final Condition f14770f;

        /* renamed from: g  reason: collision with root package name */
        public long f14771g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f14772h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Throwable f14773i;

        public BlockingFlowableIterator(int i11) {
            this.f14766b = new SpscArrayQueue<>(i11);
            this.f14767c = (long) i11;
            this.f14768d = (long) (i11 - (i11 >> 2));
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f14769e = reentrantLock;
            this.f14770f = reentrantLock.newCondition();
        }

        public void a() {
            this.f14769e.lock();
            try {
                this.f14770f.signalAll();
            } finally {
                this.f14769e.unlock();
            }
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
            a();
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z11 = this.f14772h;
                boolean isEmpty = this.f14766b.isEmpty();
                if (z11) {
                    Throwable th2 = this.f14773i;
                    if (th2 != null) {
                        throw ExceptionHelper.wrapOrThrow(th2);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.verifyNonBlocking();
                this.f14769e.lock();
                while (!this.f14772h && this.f14766b.isEmpty() && !isDisposed()) {
                    try {
                        this.f14770f.await();
                    } catch (InterruptedException e11) {
                        run();
                        throw ExceptionHelper.wrapOrThrow(e11);
                    } catch (Throwable th3) {
                        this.f14769e.unlock();
                        throw th3;
                    }
                }
                this.f14769e.unlock();
            }
            Throwable th4 = this.f14773i;
            if (th4 == null) {
                return false;
            }
            throw ExceptionHelper.wrapOrThrow(th4);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public T next() {
            if (hasNext()) {
                T poll = this.f14766b.poll();
                long j11 = this.f14771g + 1;
                if (j11 == this.f14768d) {
                    this.f14771g = 0;
                    ((Subscription) get()).request(j11);
                } else {
                    this.f14771g = j11;
                }
                return poll;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.f14772h = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f14773i = th2;
            this.f14772h = true;
            a();
        }

        public void onNext(T t11) {
            if (!this.f14766b.offer(t11)) {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            a();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.f14767c);
        }

        public void remove() {
            throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
        }

        public void run() {
            SubscriptionHelper.cancel(this);
            a();
        }
    }

    public BlockingFlowableIterable(Flowable<T> flowable, int i11) {
        this.f14764b = flowable;
        this.f14765c = i11;
    }

    public java.util.Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.f14765c);
        this.f14764b.subscribe(blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
