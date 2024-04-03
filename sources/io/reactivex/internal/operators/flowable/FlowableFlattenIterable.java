package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f15289d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15290e;

    public static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15291b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f15292c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15293d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15294e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15295f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public Subscription f15296g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f15297h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f15298i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f15299j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<Throwable> f15300k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        public Iterator<? extends R> f15301l;

        /* renamed from: m  reason: collision with root package name */
        public int f15302m;

        /* renamed from: n  reason: collision with root package name */
        public int f15303n;

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i11) {
            this.f15291b = subscriber;
            this.f15292c = function;
            this.f15293d = i11;
            this.f15294e = i11 - (i11 >> 2);
        }

        public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.f15299j) {
                this.f15301l = null;
                simpleQueue.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (this.f15300k.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.f15300k);
                    this.f15301l = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void b(boolean z11) {
            if (z11) {
                int i11 = this.f15302m + 1;
                if (i11 == this.f15294e) {
                    this.f15302m = 0;
                    this.f15296g.request((long) i11);
                    return;
                }
                this.f15302m = i11;
            }
        }

        public void cancel() {
            if (!this.f15299j) {
                this.f15299j = true;
                this.f15296g.cancel();
                if (getAndIncrement() == 0) {
                    this.f15297h.clear();
                }
            }
        }

        public void clear() {
            this.f15301l = null;
            this.f15297h.clear();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0121, code lost:
            if (r6 == null) goto L_0x012c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r18 = this;
                r1 = r18
                int r0 = r18.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.f15291b
                io.reactivex.internal.fuseable.SimpleQueue<T> r3 = r1.f15297h
                int r0 = r1.f15303n
                r4 = 0
                r5 = 1
                if (r0 == r5) goto L_0x0015
                r0 = r5
                goto L_0x0016
            L_0x0015:
                r0 = r4
            L_0x0016:
                java.util.Iterator<? extends R> r6 = r1.f15301l
                r7 = r5
            L_0x0019:
                r8 = 0
                if (r6 != 0) goto L_0x0080
                boolean r9 = r1.f15298i
                java.lang.Object r10 = r3.poll()     // Catch:{ all -> 0x0062 }
                if (r10 != 0) goto L_0x0026
                r11 = r5
                goto L_0x0027
            L_0x0026:
                r11 = r4
            L_0x0027:
                boolean r9 = r1.a(r9, r11, r2, r3)
                if (r9 == 0) goto L_0x002e
                return
            L_0x002e:
                if (r10 == 0) goto L_0x0080
                io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> r6 = r1.f15292c     // Catch:{ all -> 0x004a }
                java.lang.Object r6 = r6.apply(r10)     // Catch:{ all -> 0x004a }
                java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x004a }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004a }
                boolean r9 = r6.hasNext()     // Catch:{ all -> 0x004a }
                if (r9 != 0) goto L_0x0047
                r1.b(r0)
                r6 = r8
                goto L_0x0019
            L_0x0047:
                r1.f15301l = r6
                goto L_0x0080
            L_0x004a:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                org.reactivestreams.Subscription r3 = r1.f15296g
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.f15300k
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r3, r0)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f15300k
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x0062:
                r0 = move-exception
                r4 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r4)
                org.reactivestreams.Subscription r0 = r1.f15296g
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f15300k
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r0, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f15300k
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r1.f15301l = r8
                r3.clear()
                r2.onError(r0)
                return
            L_0x0080:
                if (r6 == 0) goto L_0x0124
                java.util.concurrent.atomic.AtomicLong r9 = r1.f15295f
                long r9 = r9.get()
                r11 = 0
                r13 = r11
            L_0x008b:
                int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r15 == 0) goto L_0x00f6
                boolean r15 = r1.f15298i
                boolean r15 = r1.a(r15, r4, r2, r3)
                if (r15 == 0) goto L_0x0098
                return
            L_0x0098:
                java.lang.Object r15 = r6.next()     // Catch:{ all -> 0x00dc }
                java.lang.String r5 = "The iterator returned a null value"
                java.lang.Object r5 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r15, (java.lang.String) r5)     // Catch:{ all -> 0x00dc }
                r2.onNext(r5)
                boolean r5 = r1.f15298i
                boolean r5 = r1.a(r5, r4, r2, r3)
                if (r5 == 0) goto L_0x00ae
                return
            L_0x00ae:
                r16 = 1
                long r13 = r13 + r16
                boolean r5 = r6.hasNext()     // Catch:{ all -> 0x00c1 }
                if (r5 != 0) goto L_0x00bf
                r1.b(r0)
                r1.f15301l = r8
                r6 = r8
                goto L_0x00f6
            L_0x00bf:
                r5 = 1
                goto L_0x008b
            L_0x00c1:
                r0 = move-exception
                r3 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r1.f15301l = r8
                org.reactivestreams.Subscription r0 = r1.f15296g
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f15300k
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r0, r3)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f15300k
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x00dc:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r1.f15301l = r8
                org.reactivestreams.Subscription r3 = r1.f15296g
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.f15300k
                io.reactivex.internal.util.ExceptionHelper.addThrowable(r3, r0)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f15300k
                java.lang.Throwable r0 = io.reactivex.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x00f6:
                int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r5 != 0) goto L_0x010e
                boolean r5 = r1.f15298i
                boolean r8 = r3.isEmpty()
                if (r8 == 0) goto L_0x0106
                if (r6 != 0) goto L_0x0106
                r8 = 1
                goto L_0x0107
            L_0x0106:
                r8 = r4
            L_0x0107:
                boolean r5 = r1.a(r5, r8, r2, r3)
                if (r5 == 0) goto L_0x010e
                return
            L_0x010e:
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0121
                r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0121
                java.util.concurrent.atomic.AtomicLong r5 = r1.f15295f
                long r8 = -r13
                r5.addAndGet(r8)
            L_0x0121:
                if (r6 != 0) goto L_0x0124
                goto L_0x012c
            L_0x0124:
                int r5 = -r7
                int r7 = r1.addAndGet(r5)
                if (r7 != 0) goto L_0x012c
                return
            L_0x012c:
                r5 = 1
                goto L_0x0019
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        public boolean isEmpty() {
            return this.f15301l == null && this.f15297h.isEmpty();
        }

        public void onComplete() {
            if (!this.f15298i) {
                this.f15298i = true;
                drain();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15298i || !ExceptionHelper.addThrowable(this.f15300k, th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15298i = true;
            drain();
        }

        public void onNext(T t11) {
            if (!this.f15298i) {
                if (this.f15303n != 0 || this.f15297h.offer(t11)) {
                    drain();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15296g, subscription)) {
                this.f15296g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f15303n = requestFusion;
                        this.f15297h = queueSubscription;
                        this.f15298i = true;
                        this.f15291b.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f15303n = requestFusion;
                        this.f15297h = queueSubscription;
                        this.f15291b.onSubscribe(this);
                        subscription.request((long) this.f15293d);
                        return;
                    }
                }
                this.f15297h = new SpscArrayQueue(this.f15293d);
                this.f15291b.onSubscribe(this);
                subscription.request((long) this.f15293d);
            }
        }

        @Nullable
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f15301l;
            while (true) {
                if (it == null) {
                    T poll = this.f15297h.poll();
                    if (poll != null) {
                        it = ((Iterable) this.f15292c.apply(poll)).iterator();
                        if (it.hasNext()) {
                            this.f15301l = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f15301l = null;
            }
            return requireNonNull;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15295f, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            return ((i11 & 1) == 0 || this.f15303n != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i11) {
        super(flowable);
        this.f15289d = function;
        this.f15290e = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.f14763c;
        if (flowable instanceof Callable) {
            try {
                Object call = ((Callable) flowable).call();
                if (call == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.f15289d.apply(call)).iterator());
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
            }
        } else {
            flowable.subscribe((FlowableSubscriber<? super T>) new FlattenIterableSubscriber(subscriber, this.f15289d, this.f15290e));
        }
    }
}
