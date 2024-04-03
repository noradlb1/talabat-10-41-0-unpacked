package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f15229d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15230e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f15231f;

    public static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15232b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f15233c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f15234d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15235e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f15236f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final int f15237g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f15238h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15239i;

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
            this.f15232b = subscriber;
            this.f15234d = function;
            this.f15235e = z11;
            this.f15237g = i11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.f15236f.delete(innerConsumer);
            onComplete();
        }

        public void b(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th2) {
            this.f15236f.delete(innerConsumer);
            onError(th2);
        }

        public void cancel() {
            this.f15239i = true;
            this.f15238h.cancel();
            this.f15236f.dispose();
        }

        public void clear() {
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.f15233c.terminate();
                if (terminate != null) {
                    this.f15232b.onError(terminate);
                } else {
                    this.f15232b.onComplete();
                }
            } else if (this.f15237g != Integer.MAX_VALUE) {
                this.f15238h.request(1);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f15233c.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f15235e) {
                cancel();
                if (getAndSet(0) > 0) {
                    this.f15232b.onError(this.f15233c.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.f15232b.onError(this.f15233c.terminate());
            } else if (this.f15237g != Integer.MAX_VALUE) {
                this.f15238h.request(1);
            }
        }

        public void onNext(T t11) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f15234d.apply(t11), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (!this.f15239i && this.f15236f.add(innerConsumer)) {
                    completableSource.subscribe(innerConsumer);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15238h.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15238h, subscription)) {
                this.f15238h = subscription;
                this.f15232b.onSubscribe(this);
                int i11 = this.f15237g;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
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
        this.f15229d = function;
        this.f15231f = z11;
        this.f15230e = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new FlatMapCompletableMainSubscriber(subscriber, this.f15229d, this.f15231f, this.f15230e));
    }
}
