package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends TRight> f19954d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f19955e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> f19956f;

    /* renamed from: g  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> f19957g;

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f19958p = 1;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f19959q = 2;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f19960r = 3;

        /* renamed from: s  reason: collision with root package name */
        public static final Integer f19961s = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19962b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f19963c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f19964d = new SpscLinkedArrayQueue<>(Flowable.bufferSize());

        /* renamed from: e  reason: collision with root package name */
        public final CompositeDisposable f19965e = new CompositeDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, TLeft> f19966f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final Map<Integer, TRight> f19967g = new LinkedHashMap();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Throwable> f19968h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f19969i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> f19970j;

        /* renamed from: k  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> f19971k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicInteger f19972l;

        /* renamed from: m  reason: collision with root package name */
        public int f19973m;

        /* renamed from: n  reason: collision with root package name */
        public int f19974n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f19975o;

        public JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f19962b = subscriber;
            this.f19969i = function;
            this.f19970j = function2;
            this.f19971k = biFunction;
            this.f19972l = new AtomicInteger(2);
        }

        public void a() {
            this.f19965e.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19964d;
                Subscriber<? super R> subscriber = this.f19962b;
                boolean z13 = true;
                int i11 = 1;
                while (!this.f19975o) {
                    if (this.f19968h.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(subscriber);
                        return;
                    }
                    if (this.f19972l.get() == 0) {
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
                        this.f19966f.clear();
                        this.f19967g.clear();
                        this.f19965e.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f19958p) {
                            int i12 = this.f19973m;
                            this.f19973m = i12 + 1;
                            this.f19966f.put(Integer.valueOf(i12), poll);
                            try {
                                Object apply = this.f19969i.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z13, i12);
                                this.f19965e.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (this.f19968h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                long j11 = this.f19963c.get();
                                long j12 = 0;
                                for (TRight apply2 : this.f19967g.values()) {
                                    try {
                                        Object apply3 = this.f19971k.apply(poll, apply2);
                                        Objects.requireNonNull(apply3, "The resultSelector returned a null value");
                                        if (j12 != j11) {
                                            subscriber.onNext(apply3);
                                            j12++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.f19968h, new MissingBackpressureException("Could not emit value due to lack of requests"));
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
                                    BackpressureHelper.produced(this.f19963c, j12);
                                }
                            } catch (Throwable th3) {
                                d(th3, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f19959q) {
                            int i13 = this.f19974n;
                            this.f19974n = i13 + 1;
                            this.f19967g.put(Integer.valueOf(i13), poll);
                            try {
                                Object apply4 = this.f19970j.apply(poll);
                                Objects.requireNonNull(apply4, "The rightEnd returned a null Publisher");
                                Publisher publisher2 = (Publisher) apply4;
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i13);
                                this.f19965e.add(leftRightEndSubscriber2);
                                publisher2.subscribe(leftRightEndSubscriber2);
                                if (this.f19968h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                long j13 = this.f19963c.get();
                                long j14 = 0;
                                for (TLeft apply5 : this.f19966f.values()) {
                                    try {
                                        Object apply6 = this.f19971k.apply(apply5, poll);
                                        Objects.requireNonNull(apply6, "The resultSelector returned a null value");
                                        if (j14 != j13) {
                                            subscriber.onNext(apply6);
                                            j14++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.f19968h, new MissingBackpressureException("Could not emit value due to lack of requests"));
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
                                    BackpressureHelper.produced(this.f19963c, j14);
                                }
                            } catch (Throwable th5) {
                                d(th5, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f19960r) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.f19966f.remove(Integer.valueOf(leftRightEndSubscriber3.f19909d));
                            this.f19965e.remove(leftRightEndSubscriber3);
                        } else {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.f19967g.remove(Integer.valueOf(leftRightEndSubscriber4.f19909d));
                            this.f19965e.remove(leftRightEndSubscriber4);
                        }
                        z13 = true;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.f19968h);
            this.f19966f.clear();
            this.f19967g.clear();
            subscriber.onError(terminate);
        }

        public void cancel() {
            if (!this.f19975o) {
                this.f19975o = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f19964d.clear();
                }
            }
        }

        public void d(Throwable th2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f19968h, th2);
            simpleQueue.clear();
            a();
            c(subscriber);
        }

        public void innerClose(boolean z11, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19964d;
                if (z11) {
                    num = f19960r;
                } else {
                    num = f19961s;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndSubscriber);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f19968h, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.f19965e.delete(leftRightSubscriber);
            this.f19972l.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f19968h, th2)) {
                this.f19972l.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19964d;
                if (z11) {
                    num = f19958p;
                } else {
                    num = f19959q;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19963c, j11);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.f19954d = publisher;
        this.f19955e = function;
        this.f19956f = function2;
        this.f19957g = biFunction;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.f19955e, this.f19956f, this.f19957g);
        subscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.f19965e.add(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.f19965e.add(leftRightSubscriber2);
        this.f19260c.subscribe(leftRightSubscriber);
        this.f19954d.subscribe(leftRightSubscriber2);
    }
}
