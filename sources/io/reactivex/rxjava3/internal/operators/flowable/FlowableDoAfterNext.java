package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f19644d;

    public static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f19645g;

        public DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.f19645g = consumer;
        }

        public void onNext(T t11) {
            this.f23103b.onNext(t11);
            if (this.f23107f == 0) {
                try {
                    this.f19645g.accept(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f23105d.poll();
            if (poll != null) {
                this.f19645g.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            boolean tryOnNext = this.f23103b.tryOnNext(t11);
            try {
                this.f19645g.accept(t11);
            } catch (Throwable th2) {
                c(th2);
            }
            return tryOnNext;
        }
    }

    public static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f19646g;

        public DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.f19646g = consumer;
        }

        public void onNext(T t11) {
            if (!this.f23111e) {
                this.f23108b.onNext(t11);
                if (this.f23112f == 0) {
                    try {
                        this.f19646g.accept(t11);
                    } catch (Throwable th2) {
                        c(th2);
                    }
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f23110d.poll();
            if (poll != null) {
                this.f19646g.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableDoAfterNext(Flowable<T> flowable, Consumer<? super T> consumer) {
        super(flowable);
        this.f19644d = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f19644d));
        } else {
            this.f19260c.subscribe(new DoAfterSubscriber(subscriber, this.f19644d));
        }
    }
}
