package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f15138d;

    public static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f15139g;

        public DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.f15139g = consumer;
        }

        public void onNext(T t11) {
            this.f18546b.onNext(t11);
            if (this.f18550f == 0) {
                try {
                    this.f15139g.accept(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f18548d.poll();
            if (poll != null) {
                this.f15139g.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            boolean tryOnNext = this.f18546b.tryOnNext(t11);
            try {
                this.f15139g.accept(t11);
            } catch (Throwable th2) {
                c(th2);
            }
            return tryOnNext;
        }
    }

    public static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f15140g;

        public DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.f15140g = consumer;
        }

        public void onNext(T t11) {
            if (!this.f18554e) {
                this.f18551b.onNext(t11);
                if (this.f18555f == 0) {
                    try {
                        this.f15140g.accept(t11);
                    } catch (Throwable th2) {
                        c(th2);
                    }
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f18553d.poll();
            if (poll != null) {
                this.f15140g.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f15138d = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f15138d));
        } else {
            this.f14763c.subscribe(new DoAfterSubscriber(subscriber, this.f15138d));
        }
    }
}
