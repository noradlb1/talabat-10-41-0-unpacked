package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T>[] f16287c;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16288b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f16289c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Object> f16290d = new AtomicReference<>(NotificationLite.COMPLETE);

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f16291e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final MaybeSource<? extends T>[] f16292f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f16293g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public int f16294h;

        /* renamed from: i  reason: collision with root package name */
        public long f16295i;

        public ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.f16288b = subscriber;
            this.f16292f = maybeSourceArr;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.f16290d;
                Subscriber<? super T> subscriber = this.f16288b;
                SequentialDisposable sequentialDisposable = this.f16291e;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z11 = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j11 = this.f16295i;
                            if (j11 != this.f16289c.get()) {
                                this.f16295i = j11 + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            } else {
                                z11 = false;
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (z11 && !sequentialDisposable.isDisposed()) {
                            int i11 = this.f16294h;
                            MaybeSource<? extends T>[] maybeSourceArr = this.f16292f;
                            if (i11 != maybeSourceArr.length) {
                                this.f16294h = i11 + 1;
                                maybeSourceArr[i11].subscribe(this);
                            } else if (((Throwable) this.f16293g.get()) != null) {
                                subscriber.onError(this.f16293g.terminate());
                                return;
                            } else {
                                subscriber.onComplete();
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
            this.f16291e.dispose();
        }

        public void onComplete() {
            this.f16290d.lazySet(NotificationLite.COMPLETE);
            a();
        }

        public void onError(Throwable th2) {
            this.f16290d.lazySet(NotificationLite.COMPLETE);
            if (this.f16293g.addThrowable(th2)) {
                a();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f16291e.replace(disposable);
        }

        public void onSuccess(T t11) {
            this.f16290d.lazySet(t11);
            a();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16289c, j11);
                a();
            }
        }
    }

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f16287c = maybeSourceArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.f16287c);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.a();
    }
}
