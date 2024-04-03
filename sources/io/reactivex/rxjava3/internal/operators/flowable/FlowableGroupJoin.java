package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends TRight> f19885d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f19886e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<? super TRight, ? extends Publisher<TRightEnd>> f19887f;

    /* renamed from: g  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f19888g;

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f19889p = 1;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f19890q = 2;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f19891r = 3;

        /* renamed from: s  reason: collision with root package name */
        public static final Integer f19892s = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19893b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f19894c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f19895d = new SpscLinkedArrayQueue<>(Flowable.bufferSize());

        /* renamed from: e  reason: collision with root package name */
        public final CompositeDisposable f19896e = new CompositeDisposable();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, UnicastProcessor<TRight>> f19897f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final Map<Integer, TRight> f19898g = new LinkedHashMap();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Throwable> f19899h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TLeft, ? extends Publisher<TLeftEnd>> f19900i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super TRight, ? extends Publisher<TRightEnd>> f19901j;

        /* renamed from: k  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f19902k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicInteger f19903l;

        /* renamed from: m  reason: collision with root package name */
        public int f19904m;

        /* renamed from: n  reason: collision with root package name */
        public int f19905n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f19906o;

        public GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
            this.f19893b = subscriber;
            this.f19900i = function;
            this.f19901j = function2;
            this.f19902k = biFunction;
            this.f19903l = new AtomicInteger(2);
        }

        public void a() {
            this.f19896e.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19895d;
                Subscriber<? super R> subscriber = this.f19893b;
                int i11 = 1;
                while (!this.f19906o) {
                    if (this.f19899h.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(subscriber);
                        return;
                    }
                    if (this.f19903l.get() == 0) {
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
                        for (UnicastProcessor<TRight> onComplete : this.f19897f.values()) {
                            onComplete.onComplete();
                        }
                        this.f19897f.clear();
                        this.f19898g.clear();
                        this.f19896e.dispose();
                        subscriber.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f19889p) {
                            UnicastProcessor create = UnicastProcessor.create();
                            int i12 = this.f19904m;
                            this.f19904m = i12 + 1;
                            this.f19897f.put(Integer.valueOf(i12), create);
                            try {
                                Object apply = this.f19900i.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i12);
                                this.f19896e.add(leftRightEndSubscriber);
                                publisher.subscribe(leftRightEndSubscriber);
                                if (this.f19899h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                try {
                                    Object apply2 = this.f19902k.apply(poll, create);
                                    Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                    if (this.f19894c.get() != 0) {
                                        subscriber.onNext(apply2);
                                        BackpressureHelper.produced(this.f19894c, 1);
                                        for (TRight onNext : this.f19898g.values()) {
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
                        } else if (num == f19890q) {
                            int i13 = this.f19905n;
                            this.f19905n = i13 + 1;
                            this.f19898g.put(Integer.valueOf(i13), poll);
                            try {
                                Object apply3 = this.f19901j.apply(poll);
                                Objects.requireNonNull(apply3, "The rightEnd returned a null Publisher");
                                Publisher publisher2 = (Publisher) apply3;
                                LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i13);
                                this.f19896e.add(leftRightEndSubscriber2);
                                publisher2.subscribe(leftRightEndSubscriber2);
                                if (this.f19899h.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(subscriber);
                                    return;
                                }
                                for (UnicastProcessor<TRight> onNext2 : this.f19897f.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th4) {
                                d(th4, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f19891r) {
                            LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) poll;
                            UnicastProcessor remove = this.f19897f.remove(Integer.valueOf(leftRightEndSubscriber3.f19909d));
                            this.f19896e.remove(leftRightEndSubscriber3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else {
                            LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) poll;
                            this.f19898g.remove(Integer.valueOf(leftRightEndSubscriber4.f19909d));
                            this.f19896e.remove(leftRightEndSubscriber4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.f19899h);
            for (UnicastProcessor<TRight> onError : this.f19897f.values()) {
                onError.onError(terminate);
            }
            this.f19897f.clear();
            this.f19898g.clear();
            subscriber.onError(terminate);
        }

        public void cancel() {
            if (!this.f19906o) {
                this.f19906o = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f19895d.clear();
                }
            }
        }

        public void d(Throwable th2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f19899h, th2);
            simpleQueue.clear();
            a();
            c(subscriber);
        }

        public void innerClose(boolean z11, LeftRightEndSubscriber leftRightEndSubscriber) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19895d;
                if (z11) {
                    num = f19891r;
                } else {
                    num = f19892s;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndSubscriber);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f19899h, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(LeftRightSubscriber leftRightSubscriber) {
            this.f19896e.delete(leftRightSubscriber);
            this.f19903l.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f19899h, th2)) {
                this.f19903l.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19895d;
                if (z11) {
                    num = f19889p;
                } else {
                    num = f19890q;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19894c, j11);
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
        public final JoinSupport f19907b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f19908c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19909d;

        public LeftRightEndSubscriber(JoinSupport joinSupport, boolean z11, int i11) {
            this.f19907b = joinSupport;
            this.f19908c = z11;
            this.f19909d = i11;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19907b.innerClose(this.f19908c, this);
        }

        public void onError(Throwable th2) {
            this.f19907b.innerCloseError(th2);
        }

        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.f19907b.innerClose(this.f19908c, this);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSupport f19910b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f19911c;

        public LeftRightSubscriber(JoinSupport joinSupport, boolean z11) {
            this.f19910b = joinSupport;
            this.f19911c = z11;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19910b.innerComplete(this);
        }

        public void onError(Throwable th2) {
            this.f19910b.innerError(th2);
        }

        public void onNext(Object obj) {
            this.f19910b.innerValue(this.f19911c, obj);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.f19885d = publisher;
        this.f19886e = function;
        this.f19887f = function2;
        this.f19888g = biFunction;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.f19886e, this.f19887f, this.f19888g);
        subscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.f19896e.add(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.f19896e.add(leftRightSubscriber2);
        this.f19260c.subscribe(leftRightSubscriber);
        this.f19885d.subscribe(leftRightSubscriber2);
    }
}
