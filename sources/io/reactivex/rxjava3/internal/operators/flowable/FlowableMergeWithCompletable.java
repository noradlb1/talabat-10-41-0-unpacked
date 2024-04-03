package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final CompletableSource f19998d;

    public static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19999b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f20000c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver f20001d = new OtherObserver(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f20002e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20003f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f20004g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20005h;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithSubscriber<?> f20006b;

            public OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.f20006b = mergeWithSubscriber;
            }

            public void onComplete() {
                this.f20006b.a();
            }

            public void onError(Throwable th2) {
                this.f20006b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.f19999b = subscriber;
        }

        public void a() {
            this.f20005h = true;
            if (this.f20004g) {
                HalfSerializer.onComplete((Subscriber<?>) this.f19999b, (AtomicInteger) this, this.f20002e);
            }
        }

        public void b(Throwable th2) {
            SubscriptionHelper.cancel(this.f20000c);
            HalfSerializer.onError((Subscriber<?>) this.f19999b, th2, (AtomicInteger) this, this.f20002e);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20000c);
            DisposableHelper.dispose(this.f20001d);
            this.f20002e.tryTerminateAndReport();
        }

        public void onComplete() {
            this.f20004g = true;
            if (this.f20005h) {
                HalfSerializer.onComplete((Subscriber<?>) this.f19999b, (AtomicInteger) this, this.f20002e);
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f20001d);
            HalfSerializer.onError((Subscriber<?>) this.f19999b, th2, (AtomicInteger) this, this.f20002e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f19999b, t11, (AtomicInteger) this, this.f20002e);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20000c, this.f20003f, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20000c, this.f20003f, j11);
        }
    }

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f19998d = completableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.f19260c.subscribe(mergeWithSubscriber);
        this.f19998d.subscribe(mergeWithSubscriber.f20001d);
    }
}
