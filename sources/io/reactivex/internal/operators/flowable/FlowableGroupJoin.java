package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends TRight> f15369d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f15370e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> f15371f;

    /* renamed from: g  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f15372g;

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f15373p = 1;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f15374q = 2;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f15375r = 3;

        /* renamed from: s  reason: collision with root package name */
        public static final Integer f15376s = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15377b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f15378c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f15379d = new SpscLinkedArrayQueue<>(Flowable.bufferSize());

        /* renamed from: e  reason: collision with root package name */
        public final CompositeDisposable f15380e = new CompositeDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, UnicastProcessor<TRight>> f15381f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final Map<Integer, TRight> f15382g = new LinkedHashMap();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Throwable> f15383h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f15384i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> f15385j;

        /* renamed from: k  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f15386k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicInteger f15387l;

        /* renamed from: m  reason: collision with root package name */
        public int f15388m;

        /* renamed from: n  reason: collision with root package name */
        public int f15389n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f15390o;

        public GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
            this.f15377b = subscriber;
            this.f15384i = function;
            this.f15385j = function2;
            this.f15386k = biFunction;
            this.f15387l = new AtomicInteger(2);
        }

        public void a() {
            this.f15380e.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15379d;
                Subscriber<? super R> subscriber = this.f15377b;
                int i11 = 1;
                while (!this.f15390o) {
                    if (this.f15383h.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(subscriber);
                        return;
                    }
                    if (this.f15387l.get() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    if (num == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z11 && z12) {
                        for (UnicastProcessor<TRight> onComplete : this.f15381f.values()) {
                            onComplete.onComplete();
                        }
                        this.f15381f.clear();
                        this.f15382g.clear();
                        this.f15380e.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f15373p) {
                            UnicastProcessor create = UnicastProcessor.create();
                            int i12 = this.f15388m;
                            this.f15388m = i12 + 1;
                            this.f15381f.put(Integer.valueOf(i12), create);
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f15384i.apply(poll), "The leftEnd returned a null Publisher");
                                LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i12);
                                this.f15380e.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (this.f15383h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                try {
                                    Object requireNonNull = ObjectHelper.requireNonNull(this.f15386k.apply(poll, create), "The resultSelector returned a null value");
                                    if (this.f15378c.get() != 0) {
                                        subscriber.onNext(requireNonNull);
                                        BackpressureHelper.produced(this.f15378c, 1);
                                        for (TRight onNext : this.f15382g.values()) {
                                            create.onNext(onNext);
                                        }
                                    } else {
                                        d(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    d(th2, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th3) {
                                d(th3, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f15374q) {
                            int i13 = this.f15389n;
                            this.f15389n = i13 + 1;
                            this.f15382g.put(Integer.valueOf(i13), poll);
                            try {
                                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.f15385j.apply(poll), "The rightEnd returned a null Publisher");
                                LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i13);
                                this.f15380e.add(leftRightEndSubscriber2);
                                publisher2.subscribe(leftRightEndSubscriber2);
                                if (this.f15383h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                for (UnicastProcessor<TRight> onNext2 : this.f15381f.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th4) {
                                d(th4, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f15375r) {
                            LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) poll;
                            UnicastProcessor remove = this.f15381f.remove(Integer.valueOf(leftRightEndSubscriber3.f15393d));
                            this.f15380e.remove(leftRightEndSubscriber3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else if (num == f15376s) {
                            LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) poll;
                            this.f15382g.remove(Integer.valueOf(leftRightEndSubscriber4.f15393d));
                            this.f15380e.remove(leftRightEndSubscriber4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.f15383h);
            for (UnicastProcessor<TRight> onError : this.f15381f.values()) {
                onError.onError(terminate);
            }
            this.f15381f.clear();
            this.f15382g.clear();
            subscriber.onError(terminate);
        }

        public void cancel() {
            if (!this.f15390o) {
                this.f15390o = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f15379d.clear();
                }
            }
        }

        public void d(Throwable th2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f15383h, th2);
            simpleQueue.clear();
            a();
            c(subscriber);
        }

        public void innerClose(boolean z11, LeftRightEndSubscriber leftRightEndSubscriber) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15379d;
                if (z11) {
                    num = f15375r;
                } else {
                    num = f15376s;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndSubscriber);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f15383h, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(LeftRightSubscriber leftRightSubscriber) {
            this.f15380e.delete(leftRightSubscriber);
            this.f15387l.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f15383h, th2)) {
                this.f15387l.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15379d;
                if (z11) {
                    num = f15373p;
                } else {
                    num = f15374q;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15378c, j11);
            }
        }
    }

    public interface JoinSupport {
        void innerClose(boolean z11, LeftRightEndSubscriber leftRightEndSubscriber);

        void innerCloseError(Throwable th2);

        void innerComplete(LeftRightSubscriber leftRightSubscriber);

        void innerError(Throwable th2);

        void innerValue(boolean z11, Object obj);
    }

    public static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSupport f15391b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15392c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15393d;

        public LeftRightEndSubscriber(JoinSupport joinSupport, boolean z11, int i11) {
            this.f15391b = joinSupport;
            this.f15392c = z11;
            this.f15393d = i11;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15391b.innerClose(this.f15392c, this);
        }

        public void onError(Throwable th2) {
            this.f15391b.innerCloseError(th2);
        }

        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.f15391b.innerClose(this.f15392c, this);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSupport f15394b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15395c;

        public LeftRightSubscriber(JoinSupport joinSupport, boolean z11) {
            this.f15394b = joinSupport;
            this.f15395c = z11;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15394b.innerComplete(this);
        }

        public void onError(Throwable th2) {
            this.f15394b.innerError(th2);
        }

        public void onNext(Object obj) {
            this.f15394b.innerValue(this.f15395c, obj);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.f15369d = publisher;
        this.f15370e = function;
        this.f15371f = function2;
        this.f15372g = biFunction;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.f15370e, this.f15371f, this.f15372g);
        subscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.f15380e.add(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.f15380e.add(leftRightSubscriber2);
        this.f14763c.subscribe(leftRightSubscriber);
        this.f15369d.subscribe(leftRightSubscriber2);
    }
}
