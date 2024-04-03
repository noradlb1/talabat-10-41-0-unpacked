package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends U> f15464d;

    public static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends U> f15465g;

        public MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.f15465g = function;
        }

        public void onNext(T t11) {
            if (!this.f18549e) {
                if (this.f18550f != 0) {
                    this.f18546b.onNext(null);
                    return;
                }
                try {
                    this.f18546b.onNext(ObjectHelper.requireNonNull(this.f15465g.apply(t11), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public U poll() throws Exception {
            T poll = this.f18548d.poll();
            if (poll != null) {
                return ObjectHelper.requireNonNull(this.f15465g.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18549e) {
                return false;
            }
            try {
                return this.f18546b.tryOnNext(ObjectHelper.requireNonNull(this.f15465g.apply(t11), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends U> f15466g;

        public MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.f15466g = function;
        }

        public void onNext(T t11) {
            if (!this.f18554e) {
                if (this.f18555f != 0) {
                    this.f18551b.onNext(null);
                    return;
                }
                try {
                    this.f18551b.onNext(ObjectHelper.requireNonNull(this.f15466g.apply(t11), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public U poll() throws Exception {
            T poll = this.f18553d.poll();
            if (poll != null) {
                return ObjectHelper.requireNonNull(this.f15466g.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.f15464d = function;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f15464d));
        } else {
            this.f14763c.subscribe(new MapSubscriber(subscriber, this.f15464d));
        }
    }
}
