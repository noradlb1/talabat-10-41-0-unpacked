package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapStream<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f18841c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18842d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18843e;

    public static final class FlatMapStreamSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5127032662980523968L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18844b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Stream<? extends R>> f18845c;

        /* renamed from: d  reason: collision with root package name */
        public final int f18846d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f18847e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public SimpleQueue<T> f18848f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f18849g;

        /* renamed from: h  reason: collision with root package name */
        public Iterator<? extends R> f18850h;

        /* renamed from: i  reason: collision with root package name */
        public AutoCloseable f18851i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f18852j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f18853k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicThrowable f18854l = new AtomicThrowable();

        /* renamed from: m  reason: collision with root package name */
        public long f18855m;

        /* renamed from: n  reason: collision with root package name */
        public int f18856n;

        /* renamed from: o  reason: collision with root package name */
        public int f18857o;

        public FlatMapStreamSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i11) {
            this.f18844b = subscriber;
            this.f18845c = function;
            this.f18846d = i11;
        }

        public void a() throws Throwable {
            this.f18850h = null;
            AutoCloseable autoCloseable = this.f18851i;
            this.f18851i = null;
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        }

        public void b() {
            try {
                a();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.f18844b
                io.reactivex.rxjava3.operators.SimpleQueue<T> r3 = r1.f18848f
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r1.f18854l
                java.util.Iterator<? extends R> r0 = r1.f18850h
                java.util.concurrent.atomic.AtomicLong r5 = r1.f18847e
                long r5 = r5.get()
                long r7 = r1.f18855m
                int r9 = r1.f18846d
                int r10 = r9 >> 2
                int r9 = r9 - r10
                int r10 = r1.f18857o
                r11 = 0
                r12 = 1
                if (r10 == r12) goto L_0x0026
                r10 = r12
                goto L_0x0027
            L_0x0026:
                r10 = r11
            L_0x0027:
                r13 = r7
                r8 = r12
                r6 = r5
                r5 = r0
            L_0x002b:
                boolean r0 = r1.f18852j
                if (r0 == 0) goto L_0x0037
                r3.clear()
                r17.b()
                goto L_0x00e2
            L_0x0037:
                boolean r0 = r1.f18853k
                java.lang.Object r15 = r4.get()
                if (r15 == 0) goto L_0x004c
                java.lang.Object r0 = r4.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                r1.f18852j = r12
                goto L_0x00de
            L_0x004c:
                if (r5 != 0) goto L_0x00a5
                java.lang.Object r15 = r3.poll()     // Catch:{ all -> 0x009c }
                if (r15 != 0) goto L_0x0057
                r16 = r12
                goto L_0x0059
            L_0x0057:
                r16 = r11
            L_0x0059:
                if (r0 == 0) goto L_0x0063
                if (r16 == 0) goto L_0x0063
                r2.onComplete()
                r1.f18852j = r12
                goto L_0x00a5
            L_0x0063:
                if (r16 != 0) goto L_0x00a5
                if (r10 == 0) goto L_0x0076
                int r0 = r1.f18856n
                int r0 = r0 + r12
                r1.f18856n = r0
                if (r0 != r9) goto L_0x0076
                r1.f18856n = r11
                org.reactivestreams.Subscription r0 = r1.f18849g
                long r11 = (long) r9
                r0.request(r11)
            L_0x0076:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends j$.util.stream.Stream<? extends R>> r0 = r1.f18845c     // Catch:{ all -> 0x0094 }
                java.lang.Object r0 = r0.apply(r15)     // Catch:{ all -> 0x0094 }
                java.lang.String r11 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x0094 }
                j$.util.stream.Stream r0 = (j$.util.stream.Stream) r0     // Catch:{ all -> 0x0094 }
                java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0094 }
                boolean r11 = r5.hasNext()     // Catch:{ all -> 0x0094 }
                if (r11 == 0) goto L_0x0092
                r1.f18850h = r5     // Catch:{ all -> 0x0094 }
                r1.f18851i = r0     // Catch:{ all -> 0x0094 }
                goto L_0x00de
            L_0x0092:
                r5 = 0
                goto L_0x00de
            L_0x0094:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.d(r2, r0)
                goto L_0x00de
            L_0x009c:
                r0 = move-exception
                r11 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r11)
                r1.d(r2, r11)
                goto L_0x00de
            L_0x00a5:
                if (r5 == 0) goto L_0x00e2
                int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00e2
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00d7 }
                java.lang.String r11 = "The Stream.Iterator returned a null value"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x00d7 }
                boolean r11 = r1.f18852j
                if (r11 != 0) goto L_0x00de
                r2.onNext(r0)
                r11 = 1
                long r13 = r13 + r11
                boolean r0 = r1.f18852j
                if (r0 != 0) goto L_0x00de
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00cf }
                if (r0 != 0) goto L_0x00de
                r17.a()     // Catch:{ all -> 0x00cc }
                goto L_0x0092
            L_0x00cc:
                r0 = move-exception
                r5 = 0
                goto L_0x00d0
            L_0x00cf:
                r0 = move-exception
            L_0x00d0:
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.d(r2, r0)
                goto L_0x00de
            L_0x00d7:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.d(r2, r0)
            L_0x00de:
                r11 = 0
                r12 = 1
                goto L_0x002b
            L_0x00e2:
                r1.f18855m = r13
                int r0 = -r8
                int r8 = r1.addAndGet(r0)
                if (r8 != 0) goto L_0x00ec
                return
            L_0x00ec:
                java.util.concurrent.atomic.AtomicLong r0 = r1.f18847e
                long r6 = r0.get()
                goto L_0x00de
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream.FlatMapStreamSubscriber.c():void");
        }

        public void cancel() {
            this.f18852j = true;
            this.f18849g.cancel();
            c();
        }

        public void d(Subscriber<?> subscriber, Throwable th2) {
            if (this.f18854l.compareAndSet((Object) null, th2)) {
                this.f18849g.cancel();
                this.f18852j = true;
                subscriber.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onComplete() {
            this.f18853k = true;
            c();
        }

        public void onError(Throwable th2) {
            if (this.f18854l.compareAndSet((Object) null, th2)) {
                this.f18853k = true;
                c();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f18857o == 2 || this.f18848f.offer(t11)) {
                c();
                return;
            }
            this.f18849g.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public void onSubscribe(@NonNull Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18849g, subscription)) {
                this.f18849g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f18857o = requestFusion;
                        this.f18848f = queueSubscription;
                        this.f18853k = true;
                        this.f18844b.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.f18857o = requestFusion;
                        this.f18848f = queueSubscription;
                        this.f18844b.onSubscribe(this);
                        subscription.request((long) this.f18846d);
                        return;
                    }
                }
                this.f18848f = new SpscArrayQueue(this.f18846d);
                this.f18844b.onSubscribe(this);
                subscription.request((long) this.f18846d);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f18847e, j11);
                c();
            }
        }
    }

    public FlowableFlatMapStream(Flowable<T> flowable, Function<? super T, ? extends Stream<? extends R>> function, int i11) {
        this.f18841c = flowable;
        this.f18842d = function;
        this.f18843e = i11;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i11) {
        return new FlatMapStreamSubscriber(subscriber, function, i11);
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Stream stream;
        Flowable<T> flowable = this.f18841c;
        if (flowable instanceof Supplier) {
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj != null) {
                    Object apply = this.f18842d.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = (Stream) apply;
                } else {
                    stream = null;
                }
                if (stream != null) {
                    FlowableFromStream.subscribeStream(subscriber, stream);
                } else {
                    EmptySubscription.complete(subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        } else {
            flowable.subscribe(subscribe(subscriber, this.f18842d, this.f18843e));
        }
    }
}
