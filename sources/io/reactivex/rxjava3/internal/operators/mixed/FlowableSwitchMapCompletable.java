package io.reactivex.rxjava3.internal.operators.mixed;

import i.b;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f21166b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21167c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21168d;

    public static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final SwitchMapInnerObserver f21169i = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f21170b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f21171c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21172d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21173e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f21174f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f21175g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f21176h;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapCompletableObserver<?> f21177b;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f21177b = switchMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21177b.b(this);
            }

            public void onError(Throwable th2) {
                this.f21177b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z11) {
            this.f21170b = completableObserver;
            this.f21171c = function;
            this.f21172d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f21174f;
            SwitchMapInnerObserver switchMapInnerObserver = f21169i;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (b.a(this.f21174f, switchMapInnerObserver, (Object) null) && this.f21175g) {
                this.f21173e.tryTerminateConsumer(this.f21170b);
            }
        }

        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!b.a(this.f21174f, switchMapInnerObserver, (Object) null)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f21173e.tryAddThrowableOrReport(th2)) {
            } else {
                if (!this.f21172d) {
                    this.f21176h.cancel();
                    a();
                    this.f21173e.tryTerminateConsumer(this.f21170b);
                } else if (this.f21175g) {
                    this.f21173e.tryTerminateConsumer(this.f21170b);
                }
            }
        }

        public void dispose() {
            this.f21176h.cancel();
            a();
            this.f21173e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21174f.get() == f21169i;
        }

        public void onComplete() {
            this.f21175g = true;
            if (this.f21174f.get() == null) {
                this.f21173e.tryTerminateConsumer(this.f21170b);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f21173e.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (this.f21172d) {
                onComplete();
                return;
            }
            a();
            this.f21173e.tryTerminateConsumer(this.f21170b);
        }

        public void onNext(T t11) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                Object apply = this.f21171c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f21174f.get();
                    if (switchMapInnerObserver == f21169i) {
                        return;
                    }
                } while (!b.a(this.f21174f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.subscribe(switchMapInnerObserver2);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21176h.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f21176h, subscription)) {
                this.f21176h = subscription;
                this.f21170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f21166b = flowable;
        this.f21167c = function;
        this.f21168d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f21166b.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f21167c, this.f21168d));
    }
}
