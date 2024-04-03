package io.reactivex.rxjava3.internal.operators.mixed;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
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

public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f21200c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21201d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21202e;

    public static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: l  reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f21203l = new SwitchMapSingleObserver<>((SwitchMapSingleSubscriber) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f21204b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f21205c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21206d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21207e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f21208f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<SwitchMapSingleObserver<R>> f21209g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f21210h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21211i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21212j;

        /* renamed from: k  reason: collision with root package name */
        public long f21213k;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapSingleSubscriber<?, R> f21214b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f21215c;

            public SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                this.f21214b = switchMapSingleSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f21214b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21215c = r11;
                this.f21214b.b();
            }
        }

        public SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
            this.f21204b = subscriber;
            this.f21205c = function;
            this.f21206d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f21209g;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f21203l;
            SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
            if (andSet != null && andSet != switchMapSingleObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f21204b;
                AtomicThrowable atomicThrowable = this.f21207e;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f21209g;
                AtomicLong atomicLong = this.f21208f;
                long j11 = this.f21213k;
                int i11 = 1;
                while (!this.f21212j) {
                    if (atomicThrowable.get() == null || this.f21206d) {
                        boolean z12 = this.f21211i;
                        SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                        if (switchMapSingleObserver == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                            return;
                        } else if (z11 || switchMapSingleObserver.f21215c == null || j11 == atomicLong.get()) {
                            this.f21213k = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapSingleObserver, (Object) null);
                            subscriber.onNext(switchMapSingleObserver.f21215c);
                            j11++;
                        }
                    } else {
                        atomicThrowable.tryTerminateConsumer((Subscriber<?>) subscriber);
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
            if (!b.a(this.f21209g, switchMapSingleObserver, (Object) null)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f21207e.tryAddThrowableOrReport(th2)) {
                if (!this.f21206d) {
                    this.f21210h.cancel();
                    a();
                }
                b();
            }
        }

        public void cancel() {
            this.f21212j = true;
            this.f21210h.cancel();
            a();
            this.f21207e.tryTerminateAndReport();
        }

        public void onComplete() {
            this.f21211i = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f21207e.tryAddThrowableOrReport(th2)) {
                if (!this.f21206d) {
                    a();
                }
                this.f21211i = true;
                b();
            }
        }

        public void onNext(T t11) {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = this.f21209g.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                Object apply = this.f21205c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.f21209g.get();
                    if (switchMapSingleObserver == f21203l) {
                        return;
                    }
                } while (!b.a(this.f21209g, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21210h.cancel();
                this.f21209g.getAndSet(f21203l);
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f21210h, subscription)) {
                this.f21210h = subscription;
                this.f21204b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f21208f, j11);
            b();
        }
    }

    public FlowableSwitchMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        this.f21200c = flowable;
        this.f21201d = function;
        this.f21202e = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21200c.subscribe(new SwitchMapSingleSubscriber(subscriber, this.f21201d, this.f21202e));
    }
}
