package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends MaybeSource<? extends T>> f16296c;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16297b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f16298c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Object> f16299d = new AtomicReference<>(NotificationLite.COMPLETE);

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f16300e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final Iterator<? extends MaybeSource<? extends T>> f16301f;

        /* renamed from: g  reason: collision with root package name */
        public long f16302g;

        public ConcatMaybeObserver(Subscriber<? super T> subscriber, Iterator<? extends MaybeSource<? extends T>> it) {
            this.f16297b = subscriber;
            this.f16301f = it;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.f16299d;
                Subscriber<? super T> subscriber = this.f16297b;
                SequentialDisposable sequentialDisposable = this.f16300e;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z11 = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j11 = this.f16302g;
                            if (j11 != this.f16298c.get()) {
                                this.f16302g = j11 + 1;
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
                                if (this.f16301f.hasNext()) {
                                    try {
                                        ((MaybeSource) ObjectHelper.requireNonNull(this.f16301f.next(), "The source Iterator returned a null MaybeSource")).subscribe(this);
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
            this.f16300e.dispose();
        }

        public void onComplete() {
            this.f16299d.lazySet(NotificationLite.COMPLETE);
            a();
        }

        public void onError(Throwable th2) {
            this.f16297b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f16300e.replace(disposable);
        }

        public void onSuccess(T t11) {
            this.f16299d.lazySet(t11);
            a();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16298c, j11);
                a();
            }
        }
    }

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.f16296c = iterable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, (Iterator) ObjectHelper.requireNonNull(this.f16296c.iterator(), "The sources Iterable returned a null Iterator"));
            subscriber.onSubscribe(concatMaybeObserver);
            concatMaybeObserver.a();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
