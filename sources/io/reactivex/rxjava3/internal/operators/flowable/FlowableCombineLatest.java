package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f19438c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends Publisher<? extends T>> f19439d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f19440e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19441f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f19442g;

    public static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f19443b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f19444c;

        /* renamed from: d  reason: collision with root package name */
        public final CombineLatestInnerSubscriber<T>[] f19445d;

        /* renamed from: e  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f19446e;

        /* renamed from: f  reason: collision with root package name */
        public final Object[] f19447f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f19448g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19449h;

        /* renamed from: i  reason: collision with root package name */
        public int f19450i;

        /* renamed from: j  reason: collision with root package name */
        public int f19451j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f19452k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicLong f19453l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f19454m;

        /* renamed from: n  reason: collision with root package name */
        public final AtomicThrowable f19455n;

        public CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i11, int i12, boolean z11) {
            this.f19443b = subscriber;
            this.f19444c = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                combineLatestInnerSubscriberArr[i13] = new CombineLatestInnerSubscriber<>(this, i13, i12);
            }
            this.f19445d = combineLatestInnerSubscriberArr;
            this.f19447f = new Object[i11];
            this.f19446e = new SpscLinkedArrayQueue<>(i12);
            this.f19453l = new AtomicLong();
            this.f19455n = new AtomicThrowable();
            this.f19448g = z11;
        }

        public void a() {
            for (CombineLatestInnerSubscriber<T> cancel : this.f19445d) {
                cancel.cancel();
            }
        }

        public boolean b(boolean z11, boolean z12, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f19452k) {
                a();
                spscLinkedArrayQueue.clear();
                this.f19455n.tryTerminateAndReport();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.f19448g) {
                    Throwable terminate = ExceptionHelper.terminate(this.f19455n);
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
                    this.f19455n.tryTerminateConsumer(subscriber);
                    return true;
                }
            }
        }

        public void c() {
            int i11;
            boolean z11;
            Subscriber<? super R> subscriber = this.f19443b;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19446e;
            int i12 = 1;
            do {
                long j11 = this.f19453l.get();
                long j12 = 0;
                while (true) {
                    i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z12 = this.f19454m;
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
                            Object apply = this.f19444c.apply((Object[]) spscLinkedArrayQueue.poll());
                            Objects.requireNonNull(apply, "The combiner returned a null value");
                            subscriber.onNext(apply);
                            ((CombineLatestInnerSubscriber) poll).requestOne();
                            j12++;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            a();
                            ExceptionHelper.addThrowable(this.f19455n, th2);
                            subscriber.onError(ExceptionHelper.terminate(this.f19455n));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i11 != 0 || !b(this.f19454m, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                        this.f19453l.addAndGet(-j12);
                    }
                    i12 = addAndGet(-i12);
                } else {
                    return;
                }
            } while (i12 != 0);
        }

        public void cancel() {
            this.f19452k = true;
            a();
            drain();
        }

        public void clear() {
            this.f19446e.clear();
        }

        public void d() {
            Subscriber<? super R> subscriber = this.f19443b;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f19446e;
            int i11 = 1;
            while (!this.f19452k) {
                Throwable th2 = (Throwable) this.f19455n.get();
                if (th2 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return;
                }
                boolean z11 = this.f19454m;
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
                if (this.f19449h) {
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
                java.lang.Object[] r0 = r2.f19447f     // Catch:{ all -> 0x001c }
                r3 = r0[r3]     // Catch:{ all -> 0x001c }
                r1 = 1
                if (r3 == 0) goto L_0x0015
                int r3 = r2.f19451j     // Catch:{ all -> 0x001c }
                int r3 = r3 + r1
                int r0 = r0.length     // Catch:{ all -> 0x001c }
                if (r3 != r0) goto L_0x0011
                r2.f19454m = r1     // Catch:{ all -> 0x001c }
                goto L_0x0017
            L_0x0011:
                r2.f19451j = r3     // Catch:{ all -> 0x001c }
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                return
            L_0x0015:
                r2.f19454m = r1     // Catch:{ all -> 0x001c }
            L_0x0017:
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                r2.drain()
                return
            L_0x001c:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x001c }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest.CombineLatestCoordinator.e(int):void");
        }

        public void f(int i11, Throwable th2) {
            if (!ExceptionHelper.addThrowable(this.f19455n, th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f19448g) {
                a();
                this.f19454m = true;
                drain();
            } else {
                e(i11);
            }
        }

        public void g(int i11, T t11) {
            boolean z11;
            synchronized (this) {
                Object[] objArr = this.f19447f;
                int i12 = this.f19450i;
                if (objArr[i11] == null) {
                    i12++;
                    this.f19450i = i12;
                }
                objArr[i11] = t11;
                if (objArr.length == i12) {
                    this.f19446e.offer(this.f19445d[i11], objArr.clone());
                    z11 = false;
                } else {
                    z11 = true;
                }
            }
            if (z11) {
                this.f19445d[i11].requestOne();
            } else {
                drain();
            }
        }

        public void h(Publisher<? extends T>[] publisherArr, int i11) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.f19445d;
            for (int i12 = 0; i12 < i11 && !this.f19454m && !this.f19452k; i12++) {
                publisherArr[i12].subscribe(combineLatestInnerSubscriberArr[i12]);
            }
        }

        public boolean isEmpty() {
            return this.f19446e.isEmpty();
        }

        @Nullable
        public R poll() throws Throwable {
            Object poll = this.f19446e.poll();
            if (poll == null) {
                return null;
            }
            R apply = this.f19444c.apply((Object[]) this.f19446e.poll());
            Objects.requireNonNull(apply, "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return apply;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f19453l, j11);
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
            this.f19449h = z11;
            return i12;
        }
    }

    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;

        /* renamed from: b  reason: collision with root package name */
        public final CombineLatestCoordinator<T, ?> f19456b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19457c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19458d;

        /* renamed from: e  reason: collision with root package name */
        public final int f19459e;

        /* renamed from: f  reason: collision with root package name */
        public int f19460f;

        public CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i11, int i12) {
            this.f19456b = combineLatestCoordinator;
            this.f19457c = i11;
            this.f19458d = i12;
            this.f19459e = i12 - (i12 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f19456b.e(this.f19457c);
        }

        public void onError(Throwable th2) {
            this.f19456b.f(this.f19457c, th2);
        }

        public void onNext(T t11) {
            this.f19456b.g(this.f19457c, t11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.f19458d);
        }

        public void requestOne() {
            int i11 = this.f19460f + 1;
            if (i11 == this.f19459e) {
                this.f19460f = 0;
                ((Subscription) get()).request((long) i11);
                return;
            }
            this.f19460f = i11;
        }
    }

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            return FlowableCombineLatest.this.f19440e.apply(new Object[]{t11});
        }
    }

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f19438c = publisherArr;
        this.f19439d = null;
        this.f19440e = function;
        this.f19441f = i11;
        this.f19442g = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i11;
        Publisher<? extends T>[] publisherArr = this.f19438c;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i11 = 0;
                for (Publisher<? extends T> publisher : this.f19439d) {
                    if (i11 == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[((i11 >> 2) + i11)];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, i11);
                        publisherArr = publisherArr2;
                    }
                    int i12 = i11 + 1;
                    Objects.requireNonNull(publisher, "The Iterator returned a null Publisher");
                    publisherArr[i11] = publisher;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return;
            }
        } else {
            i11 = publisherArr.length;
        }
        int i13 = i11;
        if (i13 == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i13 == 1) {
            publisherArr[0].subscribe(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.f19440e, i13, this.f19441f, this.f19442g);
            subscriber.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.h(publisherArr, i13);
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f19438c = null;
        this.f19439d = iterable;
        this.f19440e = function;
        this.f19441f = i11;
        this.f19442g = z11;
    }
}
