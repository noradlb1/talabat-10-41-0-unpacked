package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import org.reactivestreams.Subscriber;

public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f19703d;

    public static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Predicate<? super T> f19704g;

        public FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.f19704g = predicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f23104c.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            QueueSubscription<T> queueSubscription = this.f23105d;
            Predicate<? super T> predicate = this.f19704g;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.f23107f == 2) {
                    queueSubscription.request(1);
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f23106e) {
                return false;
            }
            if (this.f23107f != 0) {
                return this.f23103b.tryOnNext(null);
            }
            try {
                if (!this.f19704g.test(t11) || !this.f23103b.tryOnNext(t11)) {
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
        public final Predicate<? super T> f19705g;

        public FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f19705g = predicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f23109c.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            QueueSubscription<T> queueSubscription = this.f23110d;
            Predicate<? super T> predicate = this.f19705g;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.f23112f == 2) {
                    queueSubscription.request(1);
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f23111e) {
                return false;
            }
            if (this.f23112f != 0) {
                this.f23108b.onNext(null);
                return true;
            }
            try {
                boolean test = this.f19705g.test(t11);
                if (test) {
                    this.f23108b.onNext(t11);
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
        this.f19703d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f19703d));
        } else {
            this.f19260c.subscribe(new FilterSubscriber(subscriber, this.f19703d));
        }
    }
}
