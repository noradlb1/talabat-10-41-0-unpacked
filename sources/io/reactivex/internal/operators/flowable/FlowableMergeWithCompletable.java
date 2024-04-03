package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final CompletableSource f15475d;

    public static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15476b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f15477c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver f15478d = new OtherObserver(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f15479e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15480f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f15481g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15482h;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithSubscriber<?> f15483b;

            public OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.f15483b = mergeWithSubscriber;
            }

            public void onComplete() {
                this.f15483b.a();
            }

            public void onError(Throwable th2) {
                this.f15483b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.f15476b = subscriber;
        }

        public void a() {
            this.f15482h = true;
            if (this.f15481g) {
                HalfSerializer.onComplete((Subscriber<?>) this.f15476b, (AtomicInteger) this, this.f15479e);
            }
        }

        public void b(Throwable th2) {
            SubscriptionHelper.cancel(this.f15477c);
            HalfSerializer.onError((Subscriber<?>) this.f15476b, th2, (AtomicInteger) this, this.f15479e);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f15477c);
            DisposableHelper.dispose(this.f15478d);
        }

        public void onComplete() {
            this.f15481g = true;
            if (this.f15482h) {
                HalfSerializer.onComplete((Subscriber<?>) this.f15476b, (AtomicInteger) this, this.f15479e);
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f15478d);
            HalfSerializer.onError((Subscriber<?>) this.f15476b, th2, (AtomicInteger) this, this.f15479e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f15476b, t11, (AtomicInteger) this, this.f15479e);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f15477c, this.f15480f, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f15477c, this.f15480f, j11);
        }
    }

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f15475d = completableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.f14763c.subscribe(mergeWithSubscriber);
        this.f15475d.subscribe(mergeWithSubscriber.f15478d);
    }
}
