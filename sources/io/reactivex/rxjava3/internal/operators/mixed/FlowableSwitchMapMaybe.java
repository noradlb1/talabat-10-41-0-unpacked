package io.reactivex.rxjava3.internal.operators.mixed;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f21181c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21182d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21183e;

    public static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: l  reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f21184l = new SwitchMapMaybeObserver<>((SwitchMapMaybeSubscriber) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f21185b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f21186c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21187d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21188e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f21189f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<SwitchMapMaybeObserver<R>> f21190g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f21191h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21192i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21193j;

        /* renamed from: k  reason: collision with root package name */
        public long f21194k;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapMaybeSubscriber<?, R> f21195b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f21196c;

            public SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.f21195b = switchMapMaybeSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21195b.c(this);
            }

            public void onError(Throwable th2) {
                this.f21195b.d(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21196c = r11;
                this.f21195b.b();
            }
        }

        public SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
            this.f21185b = subscriber;
            this.f21186c = function;
            this.f21187d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f21190g;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f21184l;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f21185b;
                AtomicThrowable atomicThrowable = this.f21188e;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f21190g;
                AtomicLong atomicLong = this.f21189f;
                long j11 = this.f21194k;
                int i11 = 1;
                while (!this.f21193j) {
                    if (atomicThrowable.get() == null || this.f21187d) {
                        boolean z12 = this.f21192i;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        if (switchMapMaybeObserver == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                            return;
                        } else if (z11 || switchMapMaybeObserver.f21196c == null || j11 == atomicLong.get()) {
                            this.f21194k = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            subscriber.onNext(switchMapMaybeObserver.f21196c);
                            j11++;
                        }
                    } else {
                        atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (b.a(this.f21190g, switchMapMaybeObserver, (Object) null)) {
                b();
            }
        }

        public void cancel() {
            this.f21193j = true;
            this.f21191h.cancel();
            a();
            this.f21188e.tryTerminateAndReport();
        }

        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!b.a(this.f21190g, switchMapMaybeObserver, (Object) null)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f21188e.tryAddThrowableOrReport(th2)) {
                if (!this.f21187d) {
                    this.f21191h.cancel();
                    a();
                }
                b();
            }
        }

        public void onComplete() {
            this.f21192i = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f21188e.tryAddThrowableOrReport(th2)) {
                if (!this.f21187d) {
                    a();
                }
                this.f21192i = true;
                b();
            }
        }

        public void onNext(T t11) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.f21190g.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                Object apply = this.f21186c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.f21190g.get();
                    if (switchMapMaybeObserver == f21184l) {
                        return;
                    }
                } while (!b.a(this.f21190g, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21191h.cancel();
                this.f21190g.getAndSet(f21184l);
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f21191h, subscription)) {
                this.f21191h = subscription;
                this.f21185b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f21189f, j11);
            b();
        }
    }

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        this.f21181c = flowable;
        this.f21182d = function;
        this.f21183e = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21181c.subscribe(new SwitchMapMaybeSubscriber(subscriber, this.f21182d, this.f21183e));
    }
}
