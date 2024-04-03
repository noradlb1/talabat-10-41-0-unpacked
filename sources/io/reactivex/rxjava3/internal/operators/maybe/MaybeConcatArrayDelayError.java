package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T>[] f20786c;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20787b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f20788c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Object> f20789d = new AtomicReference<>(NotificationLite.COMPLETE);

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f20790e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final MaybeSource<? extends T>[] f20791f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f20792g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public int f20793h;

        /* renamed from: i  reason: collision with root package name */
        public long f20794i;

        public ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.f20787b = subscriber;
            this.f20791f = maybeSourceArr;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.f20789d;
                Subscriber<? super T> subscriber = this.f20787b;
                SequentialDisposable sequentialDisposable = this.f20790e;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z11 = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j11 = this.f20794i;
                            if (j11 != this.f20788c.get()) {
                                this.f20794i = j11 + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            } else {
                                z11 = false;
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (z11 && !sequentialDisposable.isDisposed()) {
                            int i11 = this.f20793h;
                            MaybeSource<? extends T>[] maybeSourceArr = this.f20791f;
                            if (i11 == maybeSourceArr.length) {
                                this.f20792g.tryTerminateConsumer((Subscriber<?>) this.f20787b);
                                return;
                            } else {
                                this.f20793h = i11 + 1;
                                maybeSourceArr[i11].subscribe(this);
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
            this.f20790e.dispose();
            this.f20792g.tryTerminateAndReport();
        }

        public void onComplete() {
            this.f20789d.lazySet(NotificationLite.COMPLETE);
            a();
        }

        public void onError(Throwable th2) {
            this.f20789d.lazySet(NotificationLite.COMPLETE);
            if (this.f20792g.tryAddThrowableOrReport(th2)) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f20790e.replace(disposable);
        }

        public void onSuccess(T t11) {
            this.f20789d.lazySet(t11);
            a();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20788c, j11);
                a();
            }
        }
    }

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f20786c = maybeSourceArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.f20786c);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.a();
    }
}
