package io.reactivex.internal.operators.mixed;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f16663c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f16664d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16665e;

    public static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: l  reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f16666l = new SwitchMapMaybeObserver<>((SwitchMapMaybeSubscriber) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16667b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f16668c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16669d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16670e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f16671f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<SwitchMapMaybeObserver<R>> f16672g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f16673h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16674i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16675j;

        /* renamed from: k  reason: collision with root package name */
        public long f16676k;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapMaybeSubscriber<?, R> f16677b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f16678c;

            public SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.f16677b = switchMapMaybeSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16677b.c(this);
            }

            public void onError(Throwable th2) {
                this.f16677b.d(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16678c = r11;
                this.f16677b.b();
            }
        }

        public SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
            this.f16667b = subscriber;
            this.f16668c = function;
            this.f16669d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f16672g;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f16666l;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f16667b;
                AtomicThrowable atomicThrowable = this.f16670e;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f16672g;
                AtomicLong atomicLong = this.f16671f;
                long j11 = this.f16676k;
                int i11 = 1;
                while (!this.f16675j) {
                    if (atomicThrowable.get() == null || this.f16669d) {
                        boolean z12 = this.f16674i;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        if (switchMapMaybeObserver == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                subscriber.onError(terminate);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (z11 || switchMapMaybeObserver.f16678c == null || j11 == atomicLong.get()) {
                            this.f16676k = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            subscriber.onNext(switchMapMaybeObserver.f16678c);
                            j11++;
                        }
                    } else {
                        subscriber.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (b.a(this.f16672g, switchMapMaybeObserver, (Object) null)) {
                b();
            }
        }

        public void cancel() {
            this.f16675j = true;
            this.f16673h.cancel();
            a();
        }

        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!b.a(this.f16672g, switchMapMaybeObserver, (Object) null) || !this.f16670e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f16669d) {
                this.f16673h.cancel();
                a();
            }
            b();
        }

        public void onComplete() {
            this.f16674i = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f16670e.addThrowable(th2)) {
                if (!this.f16669d) {
                    a();
                }
                this.f16674i = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.f16672g.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16668c.apply(t11), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.f16672g.get();
                    if (switchMapMaybeObserver == f16666l) {
                        return;
                    }
                } while (!b.a(this.f16672g, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16673h.cancel();
                this.f16672g.getAndSet(f16666l);
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16673h, subscription)) {
                this.f16673h = subscription;
                this.f16667b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f16671f, j11);
            b();
        }
    }

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        this.f16663c = flowable;
        this.f16664d = function;
        this.f16665e = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16663c.subscribe(new SwitchMapMaybeSubscriber(subscriber, this.f16664d, this.f16665e));
    }
}
