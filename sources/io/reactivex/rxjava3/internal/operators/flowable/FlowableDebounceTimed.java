package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f19585d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f19586e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f19587f;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;

        /* renamed from: b  reason: collision with root package name */
        public final T f19588b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19589c;

        /* renamed from: d  reason: collision with root package name */
        public final DebounceTimedSubscriber<T> f19590d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f19591e = new AtomicBoolean();

        public DebounceEmitter(T t11, long j11, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.f19588b = t11;
            this.f19589c = j11;
            this.f19590d = debounceTimedSubscriber;
        }

        public void a() {
            if (this.f19591e.compareAndSet(false, true)) {
                this.f19590d.a(this.f19589c, this.f19588b, this);
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
        public final Subscriber<? super T> f19592b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19593c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f19594d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f19595e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f19596f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f19597g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f19598h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19599i;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f19592b = subscriber;
            this.f19593c = j11;
            this.f19594d = timeUnit;
            this.f19595e = worker;
        }

        public void a(long j11, T t11, DebounceEmitter<T> debounceEmitter) {
            if (j11 != this.f19598h) {
                return;
            }
            if (get() != 0) {
                this.f19592b.onNext(t11);
                BackpressureHelper.produced(this, 1);
                debounceEmitter.dispose();
                return;
            }
            cancel();
            this.f19592b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        public void cancel() {
            this.f19596f.cancel();
            this.f19595e.dispose();
        }

        public void onComplete() {
            if (!this.f19599i) {
                this.f19599i = true;
                Disposable disposable = this.f19597g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.a();
                }
                this.f19592b.onComplete();
                this.f19595e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19599i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19599i = true;
            Disposable disposable = this.f19597g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f19592b.onError(th2);
            this.f19595e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f19599i) {
                long j11 = this.f19598h + 1;
                this.f19598h = j11;
                Disposable disposable = this.f19597g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t11, j11, this);
                this.f19597g = debounceEmitter;
                debounceEmitter.setResource(this.f19595e.schedule(debounceEmitter, this.f19593c, this.f19594d));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19596f, subscription)) {
                this.f19596f = subscription;
                this.f19592b.onSubscribe(this);
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
        this.f19585d = j11;
        this.f19586e = timeUnit;
        this.f19587f = scheduler;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f19585d, this.f19586e, this.f19587f.createWorker()));
    }
}
