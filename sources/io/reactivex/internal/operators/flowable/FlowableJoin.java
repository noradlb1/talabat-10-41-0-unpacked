package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends TRight> f15427d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f15428e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> f15429f;

    /* renamed from: g  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> f15430g;

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f15431p = 1;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f15432q = 2;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f15433r = 3;

        /* renamed from: s  reason: collision with root package name */
        public static final Integer f15434s = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15435b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f15436c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f15437d = new SpscLinkedArrayQueue<>(Flowable.bufferSize());

        /* renamed from: e  reason: collision with root package name */
        public final CompositeDisposable f15438e = new CompositeDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, TLeft> f15439f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final Map<Integer, TRight> f15440g = new LinkedHashMap();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Throwable> f15441h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f15442i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> f15443j;

        /* renamed from: k  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> f15444k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicInteger f15445l;

        /* renamed from: m  reason: collision with root package name */
        public int f15446m;

        /* renamed from: n  reason: collision with root package name */
        public int f15447n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f15448o;

        public JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f15435b = subscriber;
            this.f15442i = function;
            this.f15443j = function2;
            this.f15444k = biFunction;
            this.f15445l = new AtomicInteger(2);
        }

        public void a() {
            this.f15438e.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15437d;
                Subscriber<? super R> subscriber = this.f15435b;
                boolean z13 = true;
                int i11 = 1;
                while (!this.f15448o) {
                    if (this.f15441h.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(subscriber);
                        return;
                    }
                    if (this.f15445l.get() == 0) {
                        z11 = z13;
                    } else {
                        z11 = false;
                    }
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    if (num == null) {
                        z12 = z13;
                    } else {
                        z12 = false;
                    }
                    if (z11 && z12) {
                        this.f15439f.clear();
                        this.f15440g.clear();
                        this.f15438e.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f15431p) {
                            int i12 = this.f15446m;
                            this.f15446m = i12 + 1;
                            this.f15439f.put(Integer.valueOf(i12), poll);
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15442i.apply(poll), "The leftEnd returned a null Publisher");
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z13, i12);
                                this.f15438e.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (this.f15441h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                long j11 = this.f15436c.get();
                                long j12 = 0;
                                for (TRight apply : this.f15440g.values()) {
                                    try {
                                        Object requireNonNull = ObjectHelper.requireNonNull(this.f15444k.apply(poll, apply), "The resultSelector returned a null value");
                                        if (j12 != j11) {
                                            subscriber.onNext(requireNonNull);
                                            j12++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.f15441h, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            a();
                                            c(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        d(th2, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j12 != 0) {
                                    BackpressureHelper.produced(this.f15436c, j12);
                                }
                            } catch (Throwable th3) {
                                d(th3, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f15432q) {
                            int i13 = this.f15447n;
                            this.f15447n = i13 + 1;
                            this.f15440g.put(Integer.valueOf(i13), poll);
                            try {
                                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.f15443j.apply(poll), "The rightEnd returned a null Publisher");
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i13);
                                this.f15438e.add(leftRightEndSubscriber2);
                                publisher2.subscribe(leftRightEndSubscriber2);
                                if (this.f15441h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                long j13 = this.f15436c.get();
                                long j14 = 0;
                                for (TLeft apply2 : this.f15439f.values()) {
                                    try {
                                        Object requireNonNull2 = ObjectHelper.requireNonNull(this.f15444k.apply(apply2, poll), "The resultSelector returned a null value");
                                        if (j14 != j13) {
                                            subscriber.onNext(requireNonNull2);
                                            j14++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.f15441h, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            spscLinkedArrayQueue.clear();
                                            a();
                                            c(subscriber);
                                            return;
                                        }
                                    } catch (Throwable th4) {
                                        d(th4, subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                                if (j14 != 0) {
                                    BackpressureHelper.produced(this.f15436c, j14);
                                }
                            } catch (Throwable th5) {
                                d(th5, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f15433r) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.f15439f.remove(Integer.valueOf(leftRightEndSubscriber3.f15393d));
                            this.f15438e.remove(leftRightEndSubscriber3);
                        } else if (num == f15434s) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.f15440g.remove(Integer.valueOf(leftRightEndSubscriber4.f15393d));
                            this.f15438e.remove(leftRightEndSubscriber4);
                        }
                        z13 = true;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.f15441h);
            this.f15439f.clear();
            this.f15440g.clear();
            subscriber.onError(terminate);
        }

        public void cancel() {
            if (!this.f15448o) {
                this.f15448o = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f15437d.clear();
                }
            }
        }

        public void d(Throwable th2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f15441h, th2);
            simpleQueue.clear();
            a();
            c(subscriber);
        }

        public void innerClose(boolean z11, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15437d;
                if (z11) {
                    num = f15433r;
                } else {
                    num = f15434s;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndSubscriber);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f15441h, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.f15438e.delete(leftRightSubscriber);
            this.f15445l.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f15441h, th2)) {
                this.f15445l.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15437d;
                if (z11) {
                    num = f15431p;
                } else {
                    num = f15432q;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15436c, j11);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.f15427d = publisher;
        this.f15428e = function;
        this.f15429f = function2;
        this.f15430g = biFunction;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.f15428e, this.f15429f, this.f15430g);
        subscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.f15438e.add(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.f15438e.add(leftRightSubscriber2);
        this.f14763c.subscribe(leftRightSubscriber);
        this.f15427d.subscribe(leftRightSubscriber2);
    }
}
