package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends U> f19987d;

    public static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends U> f19988g;

        public MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.f19988g = function;
        }

        public void onNext(T t11) {
            if (!this.f23106e) {
                if (this.f23107f != 0) {
                    this.f23103b.onNext(null);
                    return;
                }
                try {
                    Object apply = this.f19988g.apply(t11);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.f23103b.onNext(apply);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.f23105d.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f19988g.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f23106e) {
                return true;
            }
            if (this.f23107f != 0) {
                this.f23103b.tryOnNext(null);
                return true;
            }
            try {
                Object apply = this.f19988g.apply(t11);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return this.f23103b.tryOnNext(apply);
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends U> f19989g;

        public MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.f19989g = function;
        }

        public void onNext(T t11) {
            if (!this.f23111e) {
                if (this.f23112f != 0) {
                    this.f23108b.onNext(null);
                    return;
                }
                try {
                    Object apply = this.f19989g.apply(t11);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.f23108b.onNext(apply);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.f23110d.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f19989g.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.f19987d = function;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f19987d));
        } else {
            this.f19260c.subscribe(new MapSubscriber(subscriber, this.f19987d));
        }
    }
}
