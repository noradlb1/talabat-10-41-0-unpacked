package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f19658d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Throwable> f19659e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f19660f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f19661g;

    public static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f19662g;

        /* renamed from: h  reason: collision with root package name */
        public final Consumer<? super Throwable> f19663h;

        /* renamed from: i  reason: collision with root package name */
        public final Action f19664i;

        /* renamed from: j  reason: collision with root package name */
        public final Action f19665j;

        public DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.f19662g = consumer;
            this.f19663h = consumer2;
            this.f19664i = action;
            this.f19665j = action2;
        }

        public void onComplete() {
            if (!this.f23106e) {
                try {
                    this.f19664i.run();
                    this.f23106e = true;
                    this.f23103b.onComplete();
                    try {
                        this.f19665j.run();
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
            if (this.f23106e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            boolean z11 = true;
            this.f23106e = true;
            try {
                this.f19663h.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f23103b.onError(new CompositeException(th2, th3));
                z11 = false;
            }
            if (z11) {
                this.f23103b.onError(th2);
            }
            try {
                this.f19665j.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f23106e) {
                if (this.f23107f != 0) {
                    this.f23103b.onNext(null);
                    return;
                }
                try {
                    this.f19662g.accept(t11);
                    this.f23103b.onNext(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        public T poll() throws Throwable {
            try {
                T poll = this.f23105d.poll();
                if (poll != null) {
                    try {
                        this.f19662g.accept(poll);
                        this.f19665j.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        throw new CompositeException(th, th2);
                    }
                } else if (this.f23107f == 1) {
                    this.f19664i.run();
                    this.f19665j.run();
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                throw new CompositeException(th, th3);
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f23106e) {
                return false;
            }
            try {
                this.f19662g.accept(t11);
                return this.f23103b.tryOnNext(t11);
            } catch (Throwable th2) {
                c(th2);
                return false;
            }
        }
    }

    public static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f19666g;

        /* renamed from: h  reason: collision with root package name */
        public final Consumer<? super Throwable> f19667h;

        /* renamed from: i  reason: collision with root package name */
        public final Action f19668i;

        /* renamed from: j  reason: collision with root package name */
        public final Action f19669j;

        public DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.f19666g = consumer;
            this.f19667h = consumer2;
            this.f19668i = action;
            this.f19669j = action2;
        }

        public void onComplete() {
            if (!this.f23111e) {
                try {
                    this.f19668i.run();
                    this.f23111e = true;
                    this.f23108b.onComplete();
                    try {
                        this.f19669j.run();
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
            if (this.f23111e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            boolean z11 = true;
            this.f23111e = true;
            try {
                this.f19667h.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f23108b.onError(new CompositeException(th2, th3));
                z11 = false;
            }
            if (z11) {
                this.f23108b.onError(th2);
            }
            try {
                this.f19669j.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f23111e) {
                if (this.f23112f != 0) {
                    this.f23108b.onNext(null);
                    return;
                }
                try {
                    this.f19666g.accept(t11);
                    this.f23108b.onNext(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        public T poll() throws Throwable {
            try {
                T poll = this.f23110d.poll();
                if (poll != null) {
                    try {
                        this.f19666g.accept(poll);
                        this.f19669j.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        throw new CompositeException(th, th2);
                    }
                } else if (this.f23112f == 1) {
                    this.f19668i.run();
                    this.f19669j.run();
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                throw new CompositeException(th, th3);
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.f19658d = consumer;
        this.f19659e = consumer2;
        this.f19660f = action;
        this.f19661g = action2;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f19260c.subscribe(new DoOnEachConditionalSubscriber((ConditionalSubscriber) subscriber, this.f19658d, this.f19659e, this.f19660f, this.f19661g));
            return;
        }
        this.f19260c.subscribe(new DoOnEachSubscriber(subscriber, this.f19658d, this.f19659e, this.f19660f, this.f19661g));
    }
}
