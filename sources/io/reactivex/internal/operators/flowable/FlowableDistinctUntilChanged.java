package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, K> f15128d;

    /* renamed from: e  reason: collision with root package name */
    public final BiPredicate<? super K, ? super K> f15129e;

    public static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, K> f15130g;

        /* renamed from: h  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f15131h;

        /* renamed from: i  reason: collision with root package name */
        public K f15132i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f15133j;

        public DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.f15130g = function;
            this.f15131h = biPredicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18547c.request(1);
            }
        }

        @Nullable
        public T poll() throws Exception {
            while (true) {
                T poll = this.f18548d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f15130g.apply(poll);
                if (!this.f15133j) {
                    this.f15133j = true;
                    this.f15132i = apply;
                    return poll;
                } else if (!this.f15131h.test(this.f15132i, apply)) {
                    this.f15132i = apply;
                    return poll;
                } else {
                    this.f15132i = apply;
                    if (this.f18550f != 1) {
                        this.f18547c.request(1);
                    }
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
                return this.f18546b.tryOnNext(t11);
            }
            try {
                K apply = this.f15130g.apply(t11);
                if (this.f15133j) {
                    boolean test = this.f15131h.test(this.f15132i, apply);
                    this.f15132i = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f15133j = true;
                    this.f15132i = apply;
                }
                this.f18546b.onNext(t11);
                return true;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, K> f15134g;

        /* renamed from: h  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f15135h;

        /* renamed from: i  reason: collision with root package name */
        public K f15136i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f15137j;

        public DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.f15134g = function;
            this.f15135h = biPredicate;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18552c.request(1);
            }
        }

        @Nullable
        public T poll() throws Exception {
            while (true) {
                T poll = this.f18553d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f15134g.apply(poll);
                if (!this.f15137j) {
                    this.f15137j = true;
                    this.f15136i = apply;
                    return poll;
                } else if (!this.f15135h.test(this.f15136i, apply)) {
                    this.f15136i = apply;
                    return poll;
                } else {
                    this.f15136i = apply;
                    if (this.f18555f != 1) {
                        this.f18552c.request(1);
                    }
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
                this.f18551b.onNext(t11);
                return true;
            }
            try {
                K apply = this.f15134g.apply(t11);
                if (this.f15137j) {
                    boolean test = this.f15135h.test(this.f15136i, apply);
                    this.f15136i = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.f15137j = true;
                    this.f15136i = apply;
                }
                this.f18551b.onNext(t11);
                return true;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.f15128d = function;
        this.f15129e = biPredicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.f15128d, this.f15129e));
        } else {
            this.f14763c.subscribe(new DistinctUntilChangedSubscriber(subscriber, this.f15128d, this.f15129e));
        }
    }
}
