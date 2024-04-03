package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20488d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20489e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f20490f;

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20491b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20492c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f20493d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f20494e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f20495f;

        /* renamed from: g  reason: collision with root package name */
        public final SequentialDisposable f20496g = new SequentialDisposable();

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20497h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f20498i;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f20491b = subscriber;
            this.f20492c = j11;
            this.f20493d = timeUnit;
            this.f20494e = worker;
        }

        public void cancel() {
            this.f20495f.cancel();
            this.f20494e.dispose();
        }

        public void onComplete() {
            if (!this.f20498i) {
                this.f20498i = true;
                this.f20491b.onComplete();
                this.f20494e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20498i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20498i = true;
            this.f20491b.onError(th2);
            this.f20494e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f20498i && !this.f20497h) {
                this.f20497h = true;
                if (get() != 0) {
                    this.f20491b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                    Disposable disposable = (Disposable) this.f20496g.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f20496g.replace(this.f20494e.schedule(this, this.f20492c, this.f20493d));
                    return;
                }
                this.f20498i = true;
                cancel();
                this.f20491b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20495f, subscription)) {
                this.f20495f = subscription;
                this.f20491b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void run() {
            this.f20497h = false;
        }
    }

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f20488d = j11;
        this.f20489e = timeUnit;
        this.f20490f = scheduler;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f20488d, this.f20489e, this.f20490f.createWorker()));
    }
}
