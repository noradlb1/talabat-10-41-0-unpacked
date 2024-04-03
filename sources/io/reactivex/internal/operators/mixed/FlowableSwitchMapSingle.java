package io.reactivex.internal.operators.mixed;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f16679c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f16680d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16681e;

    public static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: l  reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f16682l = new SwitchMapSingleObserver<>((SwitchMapSingleSubscriber) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16683b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f16684c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16685d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16686e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f16687f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<SwitchMapSingleObserver<R>> f16688g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f16689h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16690i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16691j;

        /* renamed from: k  reason: collision with root package name */
        public long f16692k;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapSingleSubscriber<?, R> f16693b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f16694c;

            public SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                this.f16693b = switchMapSingleSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f16693b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16694c = r11;
                this.f16693b.b();
            }
        }

        public SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
            this.f16683b = subscriber;
            this.f16684c = function;
            this.f16685d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f16688g;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f16682l;
            SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
            if (andSet != null && andSet != switchMapSingleObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.f16683b;
                AtomicThrowable atomicThrowable = this.f16686e;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f16688g;
                AtomicLong atomicLong = this.f16687f;
                long j11 = this.f16692k;
                int i11 = 1;
                while (!this.f16691j) {
                    if (atomicThrowable.get() == null || this.f16685d) {
                        boolean z12 = this.f16690i;
                        SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                        if (switchMapSingleObserver == null) {
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
                        } else if (z11 || switchMapSingleObserver.f16694c == null || j11 == atomicLong.get()) {
                            this.f16692k = j11;
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapSingleObserver, (Object) null);
                            subscriber.onNext(switchMapSingleObserver.f16694c);
                            j11++;
                        }
                    } else {
                        subscriber.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
            if (!b.a(this.f16688g, switchMapSingleObserver, (Object) null) || !this.f16686e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f16685d) {
                this.f16689h.cancel();
                a();
            }
            b();
        }

        public void cancel() {
            this.f16691j = true;
            this.f16689h.cancel();
            a();
        }

        public void onComplete() {
            this.f16690i = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f16686e.addThrowable(th2)) {
                if (!this.f16685d) {
                    a();
                }
                this.f16690i = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = this.f16688g.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f16684c.apply(t11), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.f16688g.get();
                    if (switchMapSingleObserver == f16682l) {
                        return;
                    }
                } while (!b.a(this.f16688g, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16689h.cancel();
                this.f16688g.getAndSet(f16682l);
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16689h, subscription)) {
                this.f16689h = subscription;
                this.f16683b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            BackpressureHelper.add(this.f16687f, j11);
            b();
        }
    }

    public FlowableSwitchMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        this.f16679c = flowable;
        this.f16680d = function;
        this.f16681e = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16679c.subscribe(new SwitchMapSingleSubscriber(subscriber, this.f16680d, this.f16681e));
    }
}
