package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f19737d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19738e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f19739f;

    public static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19740b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f19741c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f19742d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f19743e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f19744f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final int f19745g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f19746h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f19747i;

        public final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerConsumer() {
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

        public FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
            this.f19740b = subscriber;
            this.f19742d = function;
            this.f19743e = z11;
            this.f19745g = i11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.f19744f.delete(innerConsumer);
            onComplete();
        }

        public void b(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th2) {
            this.f19744f.delete(innerConsumer);
            onError(th2);
        }

        public void cancel() {
            this.f19747i = true;
            this.f19746h.cancel();
            this.f19744f.dispose();
            this.f19741c.tryTerminateAndReport();
        }

        public void clear() {
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f19741c.tryTerminateConsumer((Subscriber<?>) this.f19740b);
            } else if (this.f19745g != Integer.MAX_VALUE) {
                this.f19746h.request(1);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f19741c.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (!this.f19743e) {
                this.f19747i = true;
                this.f19746h.cancel();
                this.f19744f.dispose();
                this.f19741c.tryTerminateConsumer((Subscriber<?>) this.f19740b);
            } else if (decrementAndGet() == 0) {
                this.f19741c.tryTerminateConsumer((Subscriber<?>) this.f19740b);
            } else if (this.f19745g != Integer.MAX_VALUE) {
                this.f19746h.request(1);
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f19742d.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (!this.f19747i && this.f19744f.add(innerConsumer)) {
                    completableSource.subscribe(innerConsumer);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19746h.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19746h, subscription)) {
                this.f19746h = subscription;
                this.f19740b.onSubscribe(this);
                int i11 = this.f19745g;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        @Nullable
        public T poll() {
            return null;
        }

        public void request(long j11) {
        }

        public int requestFusion(int i11) {
            return i11 & 2;
        }
    }

    public FlowableFlatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        super(flowable);
        this.f19737d = function;
        this.f19739f = z11;
        this.f19738e = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new FlatMapCompletableMainSubscriber(subscriber, this.f19737d, this.f19739f, this.f19738e));
    }
}
