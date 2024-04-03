package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f15152d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Throwable> f15153e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f15154f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f15155g;

    public static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f15156g;

        /* renamed from: h  reason: collision with root package name */
        public final Consumer<? super Throwable> f15157h;

        /* renamed from: i  reason: collision with root package name */
        public final Action f15158i;

        /* renamed from: j  reason: collision with root package name */
        public final Action f15159j;

        public DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.f15156g = consumer;
            this.f15157h = consumer2;
            this.f15158i = action;
            this.f15159j = action2;
        }

        public void onComplete() {
            if (!this.f18549e) {
                try {
                    this.f15158i.run();
                    this.f18549e = true;
                    this.f18546b.onComplete();
                    try {
                        this.f15159j.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        RxJavaPlugins.onError(th2);
                    }
                } catch (Throwable th3) {
                    c(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18549e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            boolean z11 = true;
            this.f18549e = true;
            try {
                this.f15157h.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f18546b.onError(new CompositeException(th2, th3));
                z11 = false;
            }
            if (z11) {
                this.f18546b.onError(th2);
            }
            try {
                this.f15159j.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f18549e) {
                if (this.f18550f != 0) {
                    this.f18546b.onNext(null);
                    return;
                }
                try {
                    this.f15156g.accept(t11);
                    this.f18546b.onNext(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            try {
                T poll = this.f18548d.poll();
                if (poll != null) {
                    try {
                        this.f15156g.accept(poll);
                        this.f15159j.run();
                    } catch (Throwable th2) {
                        throw new CompositeException(th, th2);
                    }
                } else if (this.f18550f == 1) {
                    this.f15158i.run();
                    this.f15159j.run();
                }
                return poll;
            } catch (Throwable th3) {
                throw new CompositeException(th, th3);
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18549e) {
                return false;
            }
            try {
                this.f15156g.accept(t11);
                return this.f18546b.tryOnNext(t11);
            } catch (Throwable th2) {
                c(th2);
                return false;
            }
        }
    }

    public static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f15160g;

        /* renamed from: h  reason: collision with root package name */
        public final Consumer<? super Throwable> f15161h;

        /* renamed from: i  reason: collision with root package name */
        public final Action f15162i;

        /* renamed from: j  reason: collision with root package name */
        public final Action f15163j;

        public DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.f15160g = consumer;
            this.f15161h = consumer2;
            this.f15162i = action;
            this.f15163j = action2;
        }

        public void onComplete() {
            if (!this.f18554e) {
                try {
                    this.f15162i.run();
                    this.f18554e = true;
                    this.f18551b.onComplete();
                    try {
                        this.f15163j.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        RxJavaPlugins.onError(th2);
                    }
                } catch (Throwable th3) {
                    c(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18554e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            boolean z11 = true;
            this.f18554e = true;
            try {
                this.f15161h.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f18551b.onError(new CompositeException(th2, th3));
                z11 = false;
            }
            if (z11) {
                this.f18551b.onError(th2);
            }
            try {
                this.f15163j.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f18554e) {
                if (this.f18555f != 0) {
                    this.f18551b.onNext(null);
                    return;
                }
                try {
                    this.f15160g.accept(t11);
                    this.f18551b.onNext(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            try {
                T poll = this.f18553d.poll();
                if (poll != null) {
                    try {
                        this.f15160g.accept(poll);
                        this.f15163j.run();
                    } catch (Throwable th2) {
                        throw new CompositeException(th, th2);
                    }
                } else if (this.f18555f == 1) {
                    this.f15162i.run();
                    this.f15163j.run();
                }
                return poll;
            } catch (Throwable th3) {
                throw new CompositeException(th, th3);
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.f15152d = consumer;
        this.f15153e = consumer2;
        this.f15154f = action;
        this.f15155g = action2;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f14763c.subscribe(new DoOnEachConditionalSubscriber((ConditionalSubscriber) subscriber, this.f15152d, this.f15153e, this.f15154f, this.f15155g));
            return;
        }
        this.f14763c.subscribe(new DoOnEachSubscriber(subscriber, this.f15152d, this.f15153e, this.f15154f, this.f15155g));
    }
}
