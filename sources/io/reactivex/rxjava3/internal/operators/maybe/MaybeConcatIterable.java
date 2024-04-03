package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends MaybeSource<? extends T>> f20795c;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20796b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f20797c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Object> f20798d = new AtomicReference<>(NotificationLite.COMPLETE);

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f20799e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final Iterator<? extends MaybeSource<? extends T>> f20800f;

        /* renamed from: g  reason: collision with root package name */
        public long f20801g;

        public ConcatMaybeObserver(Subscriber<? super T> subscriber, Iterator<? extends MaybeSource<? extends T>> it) {
            this.f20796b = subscriber;
            this.f20800f = it;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.f20798d;
                Subscriber<? super T> subscriber = this.f20796b;
                SequentialDisposable sequentialDisposable = this.f20799e;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z11 = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j11 = this.f20801g;
                            if (j11 != this.f20797c.get()) {
                                this.f20801g = j11 + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            } else {
                                z11 = false;
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (z11 && !sequentialDisposable.isDisposed()) {
                            try {
                                if (this.f20800f.hasNext()) {
                                    try {
                                        Object next = this.f20800f.next();
                                        Objects.requireNonNull(next, "The source Iterator returned a null MaybeSource");
                                        ((MaybeSource) next).subscribe(this);
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        subscriber.onError(th2);
                                        return;
                                    }
                                } else {
                                    subscriber.onComplete();
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                subscriber.onError(th3);
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void cancel() {
            this.f20799e.dispose();
        }

        public void onComplete() {
            this.f20798d.lazySet(NotificationLite.COMPLETE);
            a();
        }

        public void onError(Throwable th2) {
            this.f20796b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f20799e.replace(disposable);
        }

        public void onSuccess(T t11) {
            this.f20798d.lazySet(t11);
            a();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20797c, j11);
                a();
            }
        }
    }

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.f20795c = iterable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends MaybeSource<? extends T>> it = this.f20795c.iterator();
            Objects.requireNonNull(it, "The sources Iterable returned a null Iterator");
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, it);
            subscriber.onSubscribe(concatMaybeObserver);
            concatMaybeObserver.a();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
