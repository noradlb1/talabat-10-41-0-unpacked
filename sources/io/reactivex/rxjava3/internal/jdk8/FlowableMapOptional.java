package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import j$.util.Optional;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMapOptional<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f18869c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, Optional<? extends R>> f18870d;

    public static final class MapOptionalConditionalSubscriber<T, R> extends BasicFuseableConditionalSubscriber<T, R> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18871g;

        public MapOptionalConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function) {
            super(conditionalSubscriber);
            this.f18871g = function;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f23104c.request(1);
            }
        }

        public R poll() throws Throwable {
            while (true) {
                T poll = this.f23105d.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.f18871g.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (optional.isPresent()) {
                    return optional.get();
                }
                if (this.f23107f == 2) {
                    this.f23105d.request(1);
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f23106e) {
                return true;
            }
            if (this.f23107f != 0) {
                this.f23103b.onNext(null);
                return true;
            }
            try {
                Optional<? extends R> apply = this.f18871g.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (optional.isPresent()) {
                    return this.f23103b.tryOnNext(optional.get());
                }
                return false;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class MapOptionalSubscriber<T, R> extends BasicFuseableSubscriber<T, R> implements ConditionalSubscriber<T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18872g;

        public MapOptionalSubscriber(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function) {
            super(subscriber);
            this.f18872g = function;
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f23109c.request(1);
            }
        }

        public R poll() throws Throwable {
            while (true) {
                T poll = this.f23110d.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.f18872g.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (optional.isPresent()) {
                    return optional.get();
                }
                if (this.f23112f == 2) {
                    this.f23110d.request(1);
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f23111e) {
                return true;
            }
            if (this.f23112f != 0) {
                this.f23108b.onNext(null);
                return true;
            }
            try {
                Optional<? extends R> apply = this.f18872g.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (!optional.isPresent()) {
                    return false;
                }
                this.f23108b.onNext(optional.get());
                return true;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public FlowableMapOptional(Flowable<T> flowable, Function<? super T, Optional<? extends R>> function) {
        this.f18869c = flowable;
        this.f18870d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f18869c.subscribe(new MapOptionalConditionalSubscriber((ConditionalSubscriber) subscriber, this.f18870d));
        } else {
            this.f18869c.subscribe(new MapOptionalSubscriber(subscriber, this.f18870d));
        }
    }
}
