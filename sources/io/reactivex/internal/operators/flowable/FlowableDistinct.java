package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, K> f15124d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f15125e;

    public static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Collection<? super K> f15126g;

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super T, K> f15127h;

        public DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.f15127h = function;
            this.f15126g = collection;
        }

        public void clear() {
            this.f15126g.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.f18554e) {
                this.f18554e = true;
                this.f15126g.clear();
                this.f18551b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18554e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18554e = true;
            this.f15126g.clear();
            this.f18551b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18554e) {
                if (this.f18555f == 0) {
                    try {
                        if (this.f15126g.add(ObjectHelper.requireNonNull(this.f15127h.apply(t11), "The keySelector returned a null key"))) {
                            this.f18551b.onNext(t11);
                        } else {
                            this.f18552c.request(1);
                        }
                    } catch (Throwable th2) {
                        c(th2);
                    }
                } else {
                    this.f18551b.onNext(null);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll;
            while (true) {
                poll = this.f18553d.poll();
                if (poll == null || this.f15126g.add(ObjectHelper.requireNonNull(this.f15127h.apply(poll), "The keySelector returned a null key"))) {
                    return poll;
                }
                if (this.f18555f == 2) {
                    this.f18552c.request(1);
                }
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(flowable);
        this.f15124d = function;
        this.f15125e = callable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.f14763c.subscribe(new DistinctSubscriber(subscriber, this.f15124d, (Collection) ObjectHelper.requireNonNull(this.f15125e.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
