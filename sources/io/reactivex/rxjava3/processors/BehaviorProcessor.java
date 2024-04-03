package io.reactivex.rxjava3.processors;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: j  reason: collision with root package name */
    public static final Object[] f23270j = new Object[0];

    /* renamed from: k  reason: collision with root package name */
    public static final BehaviorSubscription[] f23271k = new BehaviorSubscription[0];

    /* renamed from: l  reason: collision with root package name */
    public static final BehaviorSubscription[] f23272l = new BehaviorSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<BehaviorSubscription<T>[]> f23273c;

    /* renamed from: d  reason: collision with root package name */
    public final ReadWriteLock f23274d;

    /* renamed from: e  reason: collision with root package name */
    public final Lock f23275e;

    /* renamed from: f  reason: collision with root package name */
    public final Lock f23276f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Object> f23277g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<Throwable> f23278h;

    /* renamed from: i  reason: collision with root package name */
    public long f23279i;

    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f23280b;

        /* renamed from: c  reason: collision with root package name */
        public final BehaviorProcessor<T> f23281c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23282d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f23283e;

        /* renamed from: f  reason: collision with root package name */
        public AppendOnlyLinkedArrayList<Object> f23284f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23285g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f23286h;

        /* renamed from: i  reason: collision with root package name */
        public long f23287i;

        public BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.f23280b = subscriber;
            this.f23281c = behaviorProcessor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f23286h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f23286h     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f23282d     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.reactivex.rxjava3.processors.BehaviorProcessor<T> r0 = r4.f23281c     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f23275e     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f23279i     // Catch:{ all -> 0x003e }
                r4.f23287i = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f23277g     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f23283e = r2     // Catch:{ all -> 0x003e }
                r4.f23282d = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.b()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.forEachWhile(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f23286h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23284f     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f23283e = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f23284f = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.forEachWhile(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.b():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f23285g = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f23286h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f23285g
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f23286h     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f23287i     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f23283e     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r4 = r2.f23284f     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r4 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f23284f = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.add(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f23282d = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f23285g = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.BehaviorProcessor.BehaviorSubscription.c(java.lang.Object, long):void");
        }

        public void cancel() {
            if (!this.f23286h) {
                this.f23286h = true;
                this.f23281c.c(this);
            }
        }

        public boolean isFull() {
            return get() == 0;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public boolean test(Object obj) {
            if (this.f23286h) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.f23280b.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.f23280b.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j11 = get();
                if (j11 != 0) {
                    this.f23280b.onNext(NotificationLite.getValue(obj));
                    if (j11 == Long.MAX_VALUE) {
                        return false;
                    }
                    decrementAndGet();
                    return false;
                }
                cancel();
                this.f23280b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    public BehaviorProcessor() {
        this.f23277g = new AtomicReference<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f23274d = reentrantReadWriteLock;
        this.f23275e = reentrantReadWriteLock.readLock();
        this.f23276f = reentrantReadWriteLock.writeLock();
        this.f23273c = new AtomicReference<>(f23271k);
        this.f23278h = new AtomicReference<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<>();
    }

    @NonNull
    @CheckReturnValue
    public static <T> BehaviorProcessor<T> createDefault(T t11) {
        Objects.requireNonNull(t11, "defaultValue is null");
        return new BehaviorProcessor<>(t11);
    }

    public boolean b(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.f23273c.get();
            if (behaviorSubscriptionArr == f23272l) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[(length + 1)];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!b.a(this.f23273c, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    public void c(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.f23273c.get();
            int length = behaviorSubscriptionArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (behaviorSubscriptionArr[i11] == behaviorSubscription) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        behaviorSubscriptionArr2 = f23271k;
                    } else {
                        BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[(length - 1)];
                        System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i11);
                        System.arraycopy(behaviorSubscriptionArr, i11 + 1, behaviorSubscriptionArr3, i11, (length - i11) - 1);
                        behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23273c, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    public void d(Object obj) {
        Lock lock = this.f23276f;
        lock.lock();
        this.f23279i++;
        this.f23277g.lazySet(obj);
        lock.unlock();
    }

    public BehaviorSubscription<T>[] e(Object obj) {
        d(obj);
        return (BehaviorSubscription[]) this.f23273c.getAndSet(f23272l);
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f23277g.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        Object obj = this.f23277g.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f23277g.get());
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return ((BehaviorSubscription[]) this.f23273c.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f23277g.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        Object obj = this.f23277g.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "offer called with a null value.");
        BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.f23273c.get();
        for (BehaviorSubscription isFull : behaviorSubscriptionArr) {
            if (isFull.isFull()) {
                return false;
            }
        }
        Object next = NotificationLite.next(t11);
        d(next);
        for (BehaviorSubscription c11 : behaviorSubscriptionArr) {
            c11.c(next, this.f23279i);
        }
        return true;
    }

    public void onComplete() {
        if (b.a(this.f23278h, (Object) null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription c11 : e(complete)) {
                c11.c(complete, this.f23279i);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (!b.a(this.f23278h, (Object) null, th2)) {
            RxJavaPlugins.onError(th2);
            return;
        }
        Object error = NotificationLite.error(th2);
        for (BehaviorSubscription c11 : e(error)) {
            c11.c(error, this.f23279i);
        }
    }

    public void onNext(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (this.f23278h.get() == null) {
            Object next = NotificationLite.next(t11);
            d(next);
            for (BehaviorSubscription c11 : (BehaviorSubscription[]) this.f23273c.get()) {
                c11.c(next, this.f23279i);
            }
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.f23278h.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (!b(behaviorSubscription)) {
            Throwable th2 = this.f23278h.get();
            if (th2 == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th2);
            }
        } else if (behaviorSubscription.f23286h) {
            c(behaviorSubscription);
        } else {
            behaviorSubscription.a();
        }
    }

    public BehaviorProcessor(T t11) {
        this();
        this.f23277g.lazySet(t11);
    }
}
