package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Action f19647d;

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f19648b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f19649c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19650d;

        /* renamed from: e  reason: collision with root package name */
        public QueueSubscription<T> f19651e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19652f;

        public DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
            this.f19648b = conditionalSubscriber;
            this.f19649c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f19649c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            this.f19650d.cancel();
            a();
        }

        public void clear() {
            this.f19651e.clear();
        }

        public boolean isEmpty() {
            return this.f19651e.isEmpty();
        }

        public void onComplete() {
            this.f19648b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f19648b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f19648b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19650d, subscription)) {
                this.f19650d = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f19651e = (QueueSubscription) subscription;
                }
                this.f19648b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f19651e.poll();
            if (poll == null && this.f19652f) {
                a();
            }
            return poll;
        }

        public void request(long j11) {
            this.f19650d.request(j11);
        }

        public int requestFusion(int i11) {
            QueueSubscription<T> queueSubscription = this.f19651e;
            boolean z11 = false;
            if (queueSubscription == null || (i11 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i11);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z11 = true;
                }
                this.f19652f = z11;
            }
            return requestFusion;
        }

        public boolean tryOnNext(T t11) {
            return this.f19648b.tryOnNext(t11);
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19653b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f19654c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19655d;

        /* renamed from: e  reason: collision with root package name */
        public QueueSubscription<T> f19656e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19657f;

        public DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
            this.f19653b = subscriber;
            this.f19654c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f19654c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            this.f19655d.cancel();
            a();
        }

        public void clear() {
            this.f19656e.clear();
        }

        public boolean isEmpty() {
            return this.f19656e.isEmpty();
        }

        public void onComplete() {
            this.f19653b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f19653b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f19653b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19655d, subscription)) {
                this.f19655d = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f19656e = (QueueSubscription) subscription;
                }
                this.f19653b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f19656e.poll();
            if (poll == null && this.f19657f) {
                a();
            }
            return poll;
        }

        public void request(long j11) {
            this.f19655d.request(j11);
        }

        public int requestFusion(int i11) {
            QueueSubscription<T> queueSubscription = this.f19656e;
            boolean z11 = false;
            if (queueSubscription == null || (i11 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i11);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z11 = true;
                }
                this.f19657f = z11;
            }
            return requestFusion;
        }
    }

    public FlowableDoFinally(Flowable<T> flowable, Action action) {
        super(flowable);
        this.f19647d = action;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new DoFinallyConditionalSubscriber((ConditionalSubscriber) subscriber, this.f19647d));
        } else {
            this.f19260c.subscribe(new DoFinallySubscriber(subscriber, this.f19647d));
        }
    }
}
