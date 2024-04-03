package io.reactivex.rxjava3.internal.operators.flowable;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
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
    public final Flowable<T> f19261b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19262c;

    public static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable, j$.util.Iterator {
        private static final long serialVersionUID = 6695226475494099826L;

        /* renamed from: b  reason: collision with root package name */
        public final SpscArrayQueue<T> f19263b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19264c;

        /* renamed from: d  reason: collision with root package name */
        public final long f19265d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f19266e;

        /* renamed from: f  reason: collision with root package name */
        public final Condition f19267f;

        /* renamed from: g  reason: collision with root package name */
        public long f19268g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f19269h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Throwable f19270i;

        public BlockingFlowableIterator(int i11) {
            this.f19263b = new SpscArrayQueue<>(i11);
            this.f19264c = (long) i11;
            this.f19265d = (long) (i11 - (i11 >> 2));
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f19266e = reentrantLock;
            this.f19267f = reentrantLock.newCondition();
        }

        public void a() {
            this.f19266e.lock();
            try {
                this.f19267f.signalAll();
            } finally {
                this.f19266e.unlock();
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
                boolean z11 = this.f19269h;
                boolean isEmpty = this.f19263b.isEmpty();
                if (z11) {
                    Throwable th2 = this.f19270i;
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
                this.f19266e.lock();
                while (!this.f19269h && this.f19263b.isEmpty() && !isDisposed()) {
                    try {
                        this.f19267f.await();
                    } catch (InterruptedException e11) {
                        run();
                        throw ExceptionHelper.wrapOrThrow(e11);
                    } catch (Throwable th3) {
                        this.f19266e.unlock();
                        throw th3;
                    }
                }
                this.f19266e.unlock();
            }
            Throwable th4 = this.f19270i;
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
                T poll = this.f19263b.poll();
                long j11 = this.f19268g + 1;
                if (j11 == this.f19265d) {
                    this.f19268g = 0;
                    ((Subscription) get()).request(j11);
                } else {
                    this.f19268g = j11;
                }
                return poll;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.f19269h = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f19270i = th2;
            this.f19269h = true;
            a();
        }

        public void onNext(T t11) {
            if (!this.f19263b.offer(t11)) {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            a();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.f19264c);
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
        this.f19261b = flowable;
        this.f19262c = i11;
    }

    public java.util.Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.f19262c);
        this.f19261b.subscribe(blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
