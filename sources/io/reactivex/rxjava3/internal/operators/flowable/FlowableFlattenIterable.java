package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f19800d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19801e;

    public static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19802b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f19803c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19804d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19805e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f19806f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public Subscription f19807g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f19808h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f19809i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f19810j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<Throwable> f19811k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        public Iterator<? extends R> f19812l;

        /* renamed from: m  reason: collision with root package name */
        public int f19813m;

        /* renamed from: n  reason: collision with root package name */
        public int f19814n;

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i11) {
            this.f19802b = subscriber;
            this.f19803c = function;
            this.f19804d = i11;
            this.f19805e = i11 - (i11 >> 2);
        }

        public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.f19810j) {
                this.f19812l = null;
                simpleQueue.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (this.f19811k.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.f19811k);
                    this.f19812l = null;
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
                int i11 = this.f19813m + 1;
                if (i11 == this.f19805e) {
                    this.f19813m = 0;
                    this.f19807g.request((long) i11);
                    return;
                }
                this.f19813m = i11;
            }
        }

        public void cancel() {
            if (!this.f19810j) {
                this.f19810j = true;
                this.f19807g.cancel();
                if (getAndIncrement() == 0) {
                    this.f19808h.clear();
                }
            }
        }

        public void clear() {
            this.f19812l = null;
            this.f19808h.clear();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0120, code lost:
            if (r6 == null) goto L_0x012b;
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
                org.reactivestreams.Subscriber<? super R> r2 = r1.f19802b
                io.reactivex.rxjava3.operators.SimpleQueue<T> r3 = r1.f19808h
                int r0 = r1.f19814n
                r4 = 0
                r5 = 1
                if (r0 == r5) goto L_0x0015
                r0 = r5
                goto L_0x0016
            L_0x0015:
                r0 = r4
            L_0x0016:
                java.util.Iterator<? extends R> r6 = r1.f19812l
                r7 = r5
            L_0x0019:
                r8 = 0
                if (r6 != 0) goto L_0x0080
                boolean r9 = r1.f19809i
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
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> r6 = r1.f19803c     // Catch:{ all -> 0x004a }
                java.lang.Object r6 = r6.apply(r10)     // Catch:{ all -> 0x004a }
                java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x004a }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004a }
                boolean r9 = r6.hasNext()     // Catch:{ all -> 0x004a }
                if (r9 != 0) goto L_0x0047
                r1.b(r0)
                r6 = r8
                goto L_0x0019
            L_0x0047:
                r1.f19812l = r6
                goto L_0x0080
            L_0x004a:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                org.reactivestreams.Subscription r3 = r1.f19807g
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.f19811k
                io.reactivex.rxjava3.internal.util.ExceptionHelper.addThrowable(r3, r0)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f19811k
                java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x0062:
                r0 = move-exception
                r4 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                org.reactivestreams.Subscription r0 = r1.f19807g
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f19811k
                io.reactivex.rxjava3.internal.util.ExceptionHelper.addThrowable(r0, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f19811k
                java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.terminate(r0)
                r1.f19812l = r8
                r3.clear()
                r2.onError(r0)
                return
            L_0x0080:
                if (r6 == 0) goto L_0x0123
                java.util.concurrent.atomic.AtomicLong r9 = r1.f19806f
                long r9 = r9.get()
                r11 = 0
                r13 = r11
            L_0x008b:
                int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r15 == 0) goto L_0x00f5
                boolean r15 = r1.f19809i
                boolean r15 = r1.a(r15, r4, r2, r3)
                if (r15 == 0) goto L_0x0098
                return
            L_0x0098:
                java.lang.Object r15 = r6.next()     // Catch:{ all -> 0x00db }
                java.lang.String r5 = "The iterator returned a null value"
                java.util.Objects.requireNonNull(r15, r5)     // Catch:{ all -> 0x00db }
                r2.onNext(r15)
                boolean r5 = r1.f19809i
                boolean r5 = r1.a(r5, r4, r2, r3)
                if (r5 == 0) goto L_0x00ad
                return
            L_0x00ad:
                r16 = 1
                long r13 = r13 + r16
                boolean r5 = r6.hasNext()     // Catch:{ all -> 0x00c0 }
                if (r5 != 0) goto L_0x00be
                r1.b(r0)
                r1.f19812l = r8
                r6 = r8
                goto L_0x00f5
            L_0x00be:
                r5 = 1
                goto L_0x008b
            L_0x00c0:
                r0 = move-exception
                r3 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r3)
                r1.f19812l = r8
                org.reactivestreams.Subscription r0 = r1.f19807g
                r0.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f19811k
                io.reactivex.rxjava3.internal.util.ExceptionHelper.addThrowable(r0, r3)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f19811k
                java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x00db:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.f19812l = r8
                org.reactivestreams.Subscription r3 = r1.f19807g
                r3.cancel()
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.f19811k
                io.reactivex.rxjava3.internal.util.ExceptionHelper.addThrowable(r3, r0)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f19811k
                java.lang.Throwable r0 = io.reactivex.rxjava3.internal.util.ExceptionHelper.terminate(r0)
                r2.onError(r0)
                return
            L_0x00f5:
                int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r5 != 0) goto L_0x010d
                boolean r5 = r1.f19809i
                boolean r8 = r3.isEmpty()
                if (r8 == 0) goto L_0x0105
                if (r6 != 0) goto L_0x0105
                r8 = 1
                goto L_0x0106
            L_0x0105:
                r8 = r4
            L_0x0106:
                boolean r5 = r1.a(r5, r8, r2, r3)
                if (r5 == 0) goto L_0x010d
                return
            L_0x010d:
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                java.util.concurrent.atomic.AtomicLong r5 = r1.f19806f
                long r8 = -r13
                r5.addAndGet(r8)
            L_0x0120:
                if (r6 != 0) goto L_0x0123
                goto L_0x012b
            L_0x0123:
                int r5 = -r7
                int r7 = r1.addAndGet(r5)
                if (r7 != 0) goto L_0x012b
                return
            L_0x012b:
                r5 = 1
                goto L_0x0019
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        public boolean isEmpty() {
            return this.f19812l == null && this.f19808h.isEmpty();
        }

        public void onComplete() {
            if (!this.f19809i) {
                this.f19809i = true;
                drain();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19809i || !ExceptionHelper.addThrowable(this.f19811k, th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19809i = true;
            drain();
        }

        public void onNext(T t11) {
            if (!this.f19809i) {
                if (this.f19814n != 0 || this.f19808h.offer(t11)) {
                    drain();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19807g, subscription)) {
                this.f19807g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f19814n = requestFusion;
                        this.f19808h = queueSubscription;
                        this.f19809i = true;
                        this.f19802b.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f19814n = requestFusion;
                        this.f19808h = queueSubscription;
                        this.f19802b.onSubscribe(this);
                        subscription.request((long) this.f19804d);
                        return;
                    }
                }
                this.f19808h = new SpscArrayQueue(this.f19804d);
                this.f19802b.onSubscribe(this);
                subscription.request((long) this.f19804d);
            }
        }

        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.f19812l;
            while (true) {
                if (it == null) {
                    T poll = this.f19808h.poll();
                    if (poll != null) {
                        it = ((Iterable) this.f19803c.apply(poll)).iterator();
                        if (it.hasNext()) {
                            this.f19812l = it;
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
            R next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f19812l = null;
            }
            return next;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19806f, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            return ((i11 & 1) == 0 || this.f19814n != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i11) {
        super(flowable);
        this.f19800d = function;
        this.f19801e = i11;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i11) {
        return new FlattenIterableSubscriber(subscriber, function, i11);
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.f19260c;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.f19800d.apply(obj)).iterator());
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
            }
        } else {
            flowable.subscribe((FlowableSubscriber<? super T>) new FlattenIterableSubscriber(subscriber, this.f19800d, this.f19801e));
        }
    }
}
