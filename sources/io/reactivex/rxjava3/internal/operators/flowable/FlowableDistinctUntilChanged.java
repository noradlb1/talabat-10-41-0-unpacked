package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, K> f19634d;

    /* renamed from: e  reason: collision with root package name */
    public final BiPredicate<? super K, ? super K> f19635e;

    public static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, K> f19636g;

        /* renamed from: h  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f19637h;

        /* renamed from: i  reason: collision with root package name */
        public K f19638i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f19639j;

        public DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.f19636g = function;
            this.f19637h = biPredicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f23104c.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            while (true) {
                T poll = this.f23105d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f19636g.apply(poll);
                if (!this.f19639j) {
                    this.f19639j = true;
                    this.f19638i = apply;
                    return poll;
                } else if (!this.f19637h.test(this.f19638i, apply)) {
                    this.f19638i = apply;
                    return poll;
                } else {
                    this.f19638i = apply;
                    if (this.f23107f != 1) {
                        this.f23104c.request(1);
                    }
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
                return this.f23103b.tryOnNext(t11);
            }
            try {
                K apply = this.f19636g.apply(t11);
                if (this.f19639j) {
                    boolean test = this.f19637h.test(this.f19638i, apply);
                    this.f19638i = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f19639j = true;
                    this.f19638i = apply;
                }
                this.f23103b.onNext(t11);
                return true;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, K> f19640g;

        /* renamed from: h  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f19641h;

        /* renamed from: i  reason: collision with root package name */
        public K f19642i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f19643j;

        public DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.f19640g = function;
            this.f19641h = biPredicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f23109c.request(1);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            while (true) {
                T poll = this.f23110d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f19640g.apply(poll);
                if (!this.f19643j) {
                    this.f19643j = true;
                    this.f19642i = apply;
                    return poll;
                } else if (!this.f19641h.test(this.f19642i, apply)) {
                    this.f19642i = apply;
                    return poll;
                } else {
                    this.f19642i = apply;
                    if (this.f23112f != 1) {
                        this.f23109c.request(1);
                    }
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
                this.f23108b.onNext(t11);
                return true;
            }
            try {
                K apply = this.f19640g.apply(t11);
                if (this.f19643j) {
                    boolean test = this.f19641h.test(this.f19642i, apply);
                    this.f19642i = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f19643j = true;
                    this.f19642i = apply;
                }
                this.f23108b.onNext(t11);
                return true;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.f19634d = function;
        this.f19635e = biPredicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.f19634d, this.f19635e));
        } else {
            this.f19260c.subscribe(new DistinctUntilChangedSubscriber(subscriber, this.f19634d, this.f19635e));
        }
    }
}
