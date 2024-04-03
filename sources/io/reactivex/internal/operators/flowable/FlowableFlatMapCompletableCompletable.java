package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15241b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f15242c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15243d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15244e;

    public static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f15245b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f15246c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f15247d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15248e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f15249f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final int f15250g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f15251h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15252i;

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
            this.f15245b = completableObserver;
            this.f15247d = function;
            this.f15248e = z11;
            this.f15250g = i11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.f15249f.delete(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th2) {
            this.f15249f.delete(innerObserver);
            onError(th2);
        }

        public void dispose() {
            this.f15252i = true;
            this.f15251h.cancel();
            this.f15249f.dispose();
        }

        public boolean isDisposed() {
            return this.f15249f.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.f15246c.terminate();
                if (terminate != null) {
                    this.f15245b.onError(terminate);
                } else {
                    this.f15245b.onComplete();
                }
            } else if (this.f15250g != Integer.MAX_VALUE) {
                this.f15251h.request(1);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f15246c.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f15248e) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f15245b.onError(this.f15246c.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.f15245b.onError(this.f15246c.terminate());
            } else if (this.f15250g != Integer.MAX_VALUE) {
                this.f15251h.request(1);
            }
        }

        public void onNext(T t11) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f15247d.apply(t11), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f15252i && this.f15249f.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15251h.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15251h, subscription)) {
                this.f15251h = subscription;
                this.f15245b.onSubscribe(this);
                int i11 = this.f15250g;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        this.f15241b = flowable;
        this.f15242c = function;
        this.f15244e = z11;
        this.f15243d = i11;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable(this.f15241b, this.f15242c, this.f15244e, this.f15243d));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f15241b.subscribe(new FlatMapCompletableMainSubscriber(completableObserver, this.f15242c, this.f15244e, this.f15243d));
    }
}
