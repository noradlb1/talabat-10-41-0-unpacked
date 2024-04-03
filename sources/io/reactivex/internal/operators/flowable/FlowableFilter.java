package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f15195d;

    public static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Predicate<? super T> f15196g;

        public FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.f15196g = predicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18547c.request(1);
            }
        }

        @Nullable
        public T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.f18548d;
            Predicate<? super T> predicate = this.f15196g;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.f18550f == 2) {
                    queueSubscription.request(1);
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18549e) {
                return false;
            }
            if (this.f18550f != 0) {
                return this.f18546b.tryOnNext(null);
            }
            try {
                if (!this.f15196g.test(t11) || !this.f18546b.tryOnNext(t11)) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* renamed from: g  reason: collision with root package name */
        public final Predicate<? super T> f15197g;

        public FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f15197g = predicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18552c.request(1);
            }
        }

        @Nullable
        public T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.f18553d;
            Predicate<? super T> predicate = this.f15197g;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.f18555f == 2) {
                    queueSubscription.request(1);
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18554e) {
                return false;
            }
            if (this.f18555f != 0) {
                this.f18551b.onNext(null);
                return true;
            }
            try {
                boolean test = this.f15197g.test(t11);
                if (test) {
                    this.f18551b.onNext(t11);
                }
                return test;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f15195d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f15195d));
        } else {
            this.f14763c.subscribe(new FilterSubscriber(subscriber, this.f15195d));
        }
    }
}
