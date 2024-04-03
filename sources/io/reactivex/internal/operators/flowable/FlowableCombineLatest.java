package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f14950c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends Publisher<? extends T>> f14951d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f14952e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14953f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f14954g;

    public static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f14955b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f14956c;

        /* renamed from: d  reason: collision with root package name */
        public final CombineLatestInnerSubscriber<T>[] f14957d;

        /* renamed from: e  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f14958e;

        /* renamed from: f  reason: collision with root package name */
        public final Object[] f14959f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f14960g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f14961h;

        /* renamed from: i  reason: collision with root package name */
        public int f14962i;

        /* renamed from: j  reason: collision with root package name */
        public int f14963j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f14964k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f14965l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f14966m;

        /* renamed from: n  reason: collision with root package name */
        public final AtomicReference<Throwable> f14967n;

        public CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i11, int i12, boolean z11) {
            this.f14955b = subscriber;
            this.f14956c = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                combineLatestInnerSubscriberArr[i13] = new CombineLatestInnerSubscriber<>(this, i13, i12);
            }
            this.f14957d = combineLatestInnerSubscriberArr;
            this.f14959f = new Object[i11];
            this.f14958e = new SpscLinkedArrayQueue<>(i12);
            this.f14965l = new AtomicLong();
            this.f14967n = new AtomicReference<>();
            this.f14960g = z11;
        }

        public void a() {
            for (CombineLatestInnerSubscriber<T> cancel : this.f14957d) {
                cancel.cancel();
            }
        }

        public boolean b(boolean z11, boolean z12, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f14964k) {
                a();
                spscLinkedArrayQueue.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.f14960g) {
                    Throwable terminate = ExceptionHelper.terminate(this.f14967n);
                    if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                        a();
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(terminate);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        a();
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    a();
                    Throwable terminate2 = ExceptionHelper.terminate(this.f14967n);
                    if (terminate2 == null || terminate2 == ExceptionHelper.TERMINATED) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(terminate2);
                    }
                    return true;
                }
            }
        }

        public void c() {
            int i11;
            boolean z11;
            Subscriber<? super R> subscriber = this.f14955b;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f14958e;
            int i12 = 1;
            do {
                long j11 = this.f14965l.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f14966m;
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!b(z12, z11, subscriber, spscLinkedArrayQueue)) {
                        if (z11) {
                            break;
                        }
                        try {
                            subscriber.onNext(ObjectHelper.requireNonNull(this.f14956c.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).requestOne();
                            j12++;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            a();
                            ExceptionHelper.addThrowable(this.f14967n, th2);
                            subscriber.onError(ExceptionHelper.terminate(this.f14967n));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i11 != 0 || !b(this.f14966m, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                        this.f14965l.addAndGet(-j12);
                    }
                    i12 = addAndGet(-i12);
                } else {
                    return;
                }
            } while (i12 != 0);
        }

        public void cancel() {
            this.f14964k = true;
            a();
        }

        public void clear() {
            this.f14958e.clear();
        }

        public void d() {
            Subscriber<? super R> subscriber = this.f14955b;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f14958e;
            int i11 = 1;
            while (!this.f14964k) {
                Throwable th2 = this.f14967n.get();
                if (th2 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return;
                }
                boolean z11 = this.f14966m;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (!z11 || !isEmpty) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.f14961h) {
                    d();
                } else {
                    c();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(int r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                java.lang.Object[] r0 = r2.f14959f     // Catch:{ all -> 0x001c }
                r3 = r0[r3]     // Catch:{ all -> 0x001c }
                r1 = 1
                if (r3 == 0) goto L_0x0015
                int r3 = r2.f14963j     // Catch:{ all -> 0x001c }
                int r3 = r3 + r1
                int r0 = r0.length     // Catch:{ all -> 0x001c }
                if (r3 != r0) goto L_0x0011
                r2.f14966m = r1     // Catch:{ all -> 0x001c }
                goto L_0x0017
            L_0x0011:
                r2.f14963j = r3     // Catch:{ all -> 0x001c }
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                return
            L_0x0015:
                r2.f14966m = r1     // Catch:{ all -> 0x001c }
            L_0x0017:
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                r2.drain()
                return
            L_0x001c:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCombineLatest.CombineLatestCoordinator.e(int):void");
        }

        public void f(int i11, Throwable th2) {
            if (!ExceptionHelper.addThrowable(this.f14967n, th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f14960g) {
                a();
                this.f14966m = true;
                drain();
            } else {
                e(i11);
            }
        }

        public void g(int i11, T t11) {
            boolean z11;
            synchronized (this) {
                Object[] objArr = this.f14959f;
                int i12 = this.f14962i;
                if (objArr[i11] == null) {
                    i12++;
                    this.f14962i = i12;
                }
                objArr[i11] = t11;
                if (objArr.length == i12) {
                    this.f14958e.offer(this.f14957d[i11], objArr.clone());
                    z11 = false;
                } else {
                    z11 = true;
                }
            }
            if (z11) {
                this.f14957d[i11].requestOne();
            } else {
                drain();
            }
        }

        public void h(Publisher<? extends T>[] publisherArr, int i11) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.f14957d;
            for (int i12 = 0; i12 < i11 && !this.f14966m && !this.f14964k; i12++) {
                publisherArr[i12].subscribe(combineLatestInnerSubscriberArr[i12]);
            }
        }

        public boolean isEmpty() {
            return this.f14958e.isEmpty();
        }

        @Nullable
        public R poll() throws Exception {
            Object poll = this.f14958e.poll();
            if (poll == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(this.f14956c.apply((Object[]) this.f14958e.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return requireNonNull;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f14965l, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            boolean z11 = false;
            if ((i11 & 4) != 0) {
                return 0;
            }
            int i12 = i11 & 2;
            if (i12 != 0) {
                z11 = true;
            }
            this.f14961h = z11;
            return i12;
        }
    }

    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;

        /* renamed from: b  reason: collision with root package name */
        public final CombineLatestCoordinator<T, ?> f14968b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14969c;

        /* renamed from: d  reason: collision with root package name */
        public final int f14970d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14971e;

        /* renamed from: f  reason: collision with root package name */
        public int f14972f;

        public CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i11, int i12) {
            this.f14968b = combineLatestCoordinator;
            this.f14969c = i11;
            this.f14970d = i12;
            this.f14971e = i12 - (i12 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f14968b.e(this.f14969c);
        }

        public void onError(Throwable th2) {
            this.f14968b.f(this.f14969c, th2);
        }

        public void onNext(T t11) {
            this.f14968b.g(this.f14969c, t11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.f14970d);
        }

        public void requestOne() {
            int i11 = this.f14972f + 1;
            if (i11 == this.f14971e) {
                this.f14972f = 0;
                ((Subscription) get()).request((long) i11);
                return;
            }
            this.f14972f = i11;
        }
    }

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Exception {
            return FlowableCombineLatest.this.f14952e.apply(new Object[]{t11});
        }
    }

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f14950c = publisherArr;
        this.f14951d = null;
        this.f14952e = function;
        this.f14953f = i11;
        this.f14954g = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11;
        Publisher<? extends T>[] publisherArr = this.f14950c;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.requireNonNull(this.f14951d.iterator(), "The iterator returned is null");
                i11 = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) ObjectHelper.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                            if (i11 == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[((i11 >> 2) + i11)];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, i11);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[i11] = publisher;
                            i11++;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            EmptySubscription.error(th2, subscriber);
                            return;
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        EmptySubscription.error(th3, subscriber);
                        return;
                    }
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                EmptySubscription.error(th4, subscriber);
                return;
            }
        } else {
            i11 = publisherArr.length;
        }
        int i12 = i11;
        if (i12 == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i12 == 1) {
            publisherArr[0].subscribe(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.f14952e, i12, this.f14953f, this.f14954g);
            subscriber.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.h(publisherArr, i12);
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f14950c = null;
        this.f14951d = iterable;
        this.f14952e = function;
        this.f14953f = i11;
        this.f14954g = z11;
    }
}
