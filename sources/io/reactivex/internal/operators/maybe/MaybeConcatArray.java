package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArray<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T>[] f16279c;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16280b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f16281c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Object> f16282d = new AtomicReference<>(NotificationLite.COMPLETE);

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f16283e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final MaybeSource<? extends T>[] f16284f;

        /* renamed from: g  reason: collision with root package name */
        public int f16285g;

        /* renamed from: h  reason: collision with root package name */
        public long f16286h;

        public ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.f16280b = subscriber;
            this.f16284f = maybeSourceArr;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.f16282d;
                Subscriber<? super T> subscriber = this.f16280b;
                SequentialDisposable sequentialDisposable = this.f16283e;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        boolean z11 = true;
                        if (obj != NotificationLite.COMPLETE) {
                            long j11 = this.f16286h;
                            if (j11 != this.f16281c.get()) {
                                this.f16286h = j11 + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            } else {
                                z11 = false;
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (z11 && !sequentialDisposable.isDisposed()) {
                            int i11 = this.f16285g;
                            MaybeSource<? extends T>[] maybeSourceArr = this.f16284f;
                            if (i11 == maybeSourceArr.length) {
                                subscriber.onComplete();
                                return;
                            } else {
                                this.f16285g = i11 + 1;
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
            this.f16283e.dispose();
        }

        public void onComplete() {
            this.f16282d.lazySet(NotificationLite.COMPLETE);
            a();
        }

        public void onError(Throwable th2) {
            this.f16280b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f16283e.replace(disposable);
        }

        public void onSuccess(T t11) {
            this.f16282d.lazySet(t11);
            a();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16281c, j11);
                a();
            }
        }
    }

    public MaybeConcatArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f16279c = maybeSourceArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.f16279c);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.a();
    }
}
