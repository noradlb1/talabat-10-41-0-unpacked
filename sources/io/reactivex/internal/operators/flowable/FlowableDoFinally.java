package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Action f15141d;

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f15142b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f15143c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15144d;

        /* renamed from: e  reason: collision with root package name */
        public QueueSubscription<T> f15145e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15146f;

        public DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
            this.f15142b = conditionalSubscriber;
            this.f15143c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f15143c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            this.f15144d.cancel();
            a();
        }

        public void clear() {
            this.f15145e.clear();
        }

        public boolean isEmpty() {
            return this.f15145e.isEmpty();
        }

        public void onComplete() {
            this.f15142b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f15142b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f15142b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15144d, subscription)) {
                this.f15144d = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f15145e = (QueueSubscription) subscription;
                }
                this.f15142b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f15145e.poll();
            if (poll == null && this.f15146f) {
                a();
            }
            return poll;
        }

        public void request(long j11) {
            this.f15144d.request(j11);
        }

        public int requestFusion(int i11) {
            QueueSubscription<T> queueSubscription = this.f15145e;
            boolean z11 = false;
            if (queueSubscription == null || (i11 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i11);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z11 = true;
                }
                this.f15146f = z11;
            }
            return requestFusion;
        }

        public boolean tryOnNext(T t11) {
            return this.f15142b.tryOnNext(t11);
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15147b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f15148c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15149d;

        /* renamed from: e  reason: collision with root package name */
        public QueueSubscription<T> f15150e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15151f;

        public DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
            this.f15147b = subscriber;
            this.f15148c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f15148c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            this.f15149d.cancel();
            a();
        }

        public void clear() {
            this.f15150e.clear();
        }

        public boolean isEmpty() {
            return this.f15150e.isEmpty();
        }

        public void onComplete() {
            this.f15147b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f15147b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f15147b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15149d, subscription)) {
                this.f15149d = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f15150e = (QueueSubscription) subscription;
                }
                this.f15147b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f15150e.poll();
            if (poll == null && this.f15151f) {
                a();
            }
            return poll;
        }

        public void request(long j11) {
            this.f15149d.request(j11);
        }

        public int requestFusion(int i11) {
            QueueSubscription<T> queueSubscription = this.f15150e;
            boolean z11 = false;
            if (queueSubscription == null || (i11 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i11);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z11 = true;
                }
                this.f15151f = z11;
            }
            return requestFusion;
        }
    }

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.f15141d = action;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new DoFinallyConditionalSubscriber((ConditionalSubscriber) subscriber, this.f15141d));
        } else {
            this.f14763c.subscribe(new DoFinallySubscriber(subscriber, this.f15141d));
        }
    }
}
