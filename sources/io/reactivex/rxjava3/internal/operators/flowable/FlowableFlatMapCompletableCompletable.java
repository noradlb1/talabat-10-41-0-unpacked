package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19749b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f19750c;

    /* renamed from: d  reason: collision with root package name */
    public final int f19751d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19752e;

    public static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19753b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f19754c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f19755d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f19756e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f19757f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final int f19758g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f19759h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f19760i;

        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableMainSubscriber.this.b(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
            this.f19753b = completableObserver;
            this.f19755d = function;
            this.f19756e = z11;
            this.f19758g = i11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.f19757f.delete(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th2) {
            this.f19757f.delete(innerObserver);
            onError(th2);
        }

        public void dispose() {
            this.f19760i = true;
            this.f19759h.cancel();
            this.f19757f.dispose();
            this.f19754c.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f19757f.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f19754c.tryTerminateConsumer(this.f19753b);
            } else if (this.f19758g != Integer.MAX_VALUE) {
                this.f19759h.request(1);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f19754c.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (!this.f19756e) {
                this.f19760i = true;
                this.f19759h.cancel();
                this.f19757f.dispose();
                this.f19754c.tryTerminateConsumer(this.f19753b);
            } else if (decrementAndGet() == 0) {
                this.f19754c.tryTerminateConsumer(this.f19753b);
            } else if (this.f19758g != Integer.MAX_VALUE) {
                this.f19759h.request(1);
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f19755d.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f19760i && this.f19757f.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19759h.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19759h, subscription)) {
                this.f19759h = subscription;
                this.f19753b.onSubscribe(this);
                int i11 = this.f19758g;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        this.f19749b = flowable;
        this.f19750c = function;
        this.f19752e = z11;
        this.f19751d = i11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable(this.f19749b, this.f19750c, this.f19752e, this.f19751d));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19749b.subscribe(new FlatMapCompletableMainSubscriber(completableObserver, this.f19750c, this.f19752e, this.f19751d));
    }
}
