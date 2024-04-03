package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15079d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15080e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f15081f;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;

        /* renamed from: b  reason: collision with root package name */
        public final T f15082b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15083c;

        /* renamed from: d  reason: collision with root package name */
        public final DebounceTimedSubscriber<T> f15084d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f15085e = new AtomicBoolean();

        public DebounceEmitter(T t11, long j11, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.f15082b = t11;
            this.f15083c = j11;
            this.f15084d = debounceTimedSubscriber;
        }

        public void a() {
            if (this.f15085e.compareAndSet(false, true)) {
                this.f15084d.a(this.f15083c, this.f15082b, this);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            a();
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15086b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15087c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f15088d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f15089e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f15090f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f15091g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f15092h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15093i;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f15086b = subscriber;
            this.f15087c = j11;
            this.f15088d = timeUnit;
            this.f15089e = worker;
        }

        public void a(long j11, T t11, DebounceEmitter<T> debounceEmitter) {
            if (j11 != this.f15092h) {
                return;
            }
            if (get() != 0) {
                this.f15086b.onNext(t11);
                BackpressureHelper.produced(this, 1);
                debounceEmitter.dispose();
                return;
            }
            cancel();
            this.f15086b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        public void cancel() {
            this.f15090f.cancel();
            this.f15089e.dispose();
        }

        public void onComplete() {
            if (!this.f15093i) {
                this.f15093i = true;
                Disposable disposable = this.f15091g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.a();
                }
                this.f15086b.onComplete();
                this.f15089e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15093i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15093i = true;
            Disposable disposable = this.f15091g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f15086b.onError(th2);
            this.f15089e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f15093i) {
                long j11 = this.f15092h + 1;
                this.f15092h = j11;
                Disposable disposable = this.f15091g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t11, j11, this);
                this.f15091g = debounceEmitter;
                debounceEmitter.setResource(this.f15089e.schedule(debounceEmitter, this.f15087c, this.f15088d));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15090f, subscription)) {
                this.f15090f = subscription;
                this.f15086b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }
    }

    public FlowableDebounceTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f15079d = j11;
        this.f15080e = timeUnit;
        this.f15081f = scheduler;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f15079d, this.f15080e, this.f15081f.createWorker()));
    }
}
