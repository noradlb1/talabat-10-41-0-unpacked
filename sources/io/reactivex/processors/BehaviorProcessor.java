package io.reactivex.processors;

import i.b;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: j  reason: collision with root package name */
    public static final Object[] f18671j = new Object[0];

    /* renamed from: k  reason: collision with root package name */
    public static final BehaviorSubscription[] f18672k = new BehaviorSubscription[0];

    /* renamed from: l  reason: collision with root package name */
    public static final BehaviorSubscription[] f18673l = new BehaviorSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<BehaviorSubscription<T>[]> f18674c;

    /* renamed from: d  reason: collision with root package name */
    public final ReadWriteLock f18675d;

    /* renamed from: e  reason: collision with root package name */
    public final Lock f18676e;

    /* renamed from: f  reason: collision with root package name */
    public final Lock f18677f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<Object> f18678g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<Throwable> f18679h;

    /* renamed from: i  reason: collision with root package name */
    public long f18680i;

    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18681b;

        /* renamed from: c  reason: collision with root package name */
        public final BehaviorProcessor<T> f18682c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18683d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18684e;

        /* renamed from: f  reason: collision with root package name */
        public AppendOnlyLinkedArrayList<Object> f18685f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18686g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f18687h;

        /* renamed from: i  reason: collision with root package name */
        public long f18688i;

        public BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.f18681b = subscriber;
            this.f18682c = behaviorProcessor;
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
                boolean r0 = r4.f18687h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f18687h     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f18683d     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.reactivex.processors.BehaviorProcessor<T> r0 = r4.f18682c     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f18676e     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f18680i     // Catch:{ all -> 0x003e }
                r4.f18688i = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f18678g     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f18684e = r2     // Catch:{ all -> 0x003e }
                r4.f18683d = r1     // Catch:{ all -> 0x003e }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.forEachWhile(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f18687h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f18685f     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f18684e = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f18685f = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.forEachWhile(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.b():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.f18686g = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.f18687h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.f18686g
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.f18687h     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.f18688i     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.f18684e     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r4 = r2.f18685f     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r4 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.f18685f = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.add(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.f18683d = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.f18686g = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.BehaviorProcessor.BehaviorSubscription.c(java.lang.Object, long):void");
        }

        public void cancel() {
            if (!this.f18687h) {
                this.f18687h = true;
                this.f18682c.c(this);
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
            if (this.f18687h) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.f18681b.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.f18681b.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j11 = get();
                if (j11 != 0) {
                    this.f18681b.onNext(NotificationLite.getValue(obj));
                    if (j11 == Long.MAX_VALUE) {
                        return false;
                    }
                    decrementAndGet();
                    return false;
                }
                cancel();
                this.f18681b.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    public BehaviorProcessor() {
        this.f18678g = new AtomicReference<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f18675d = reentrantReadWriteLock;
        this.f18676e = reentrantReadWriteLock.readLock();
        this.f18677f = reentrantReadWriteLock.writeLock();
        this.f18674c = new AtomicReference<>(f18672k);
        this.f18679h = new AtomicReference<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> createDefault(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultValue is null");
        return new BehaviorProcessor<>(t11);
    }

    public boolean b(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.f18674c.get();
            if (behaviorSubscriptionArr == f18673l) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[(length + 1)];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!b.a(this.f18674c, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    public void c(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.f18674c.get();
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
                        behaviorSubscriptionArr2 = f18672k;
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
        } while (!b.a(this.f18674c, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    public void d(Object obj) {
        Lock lock = this.f18677f;
        lock.lock();
        this.f18680i++;
        this.f18678g.lazySet(obj);
        lock.unlock();
    }

    public BehaviorSubscription<T>[] e(Object obj) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.f18674c.get();
        BehaviorSubscription<T>[] behaviorSubscriptionArr2 = f18673l;
        if (!(behaviorSubscriptionArr == behaviorSubscriptionArr2 || (behaviorSubscriptionArr = (BehaviorSubscription[]) this.f18674c.getAndSet(behaviorSubscriptionArr2)) == behaviorSubscriptionArr2)) {
            d(obj);
        }
        return behaviorSubscriptionArr;
    }

    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f18678g.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        Object obj = this.f18678g.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return NotificationLite.getValue(obj);
    }

    @Deprecated
    public Object[] getValues() {
        Object[] objArr = f18671j;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f18678g.get());
    }

    public boolean hasSubscribers() {
        return ((BehaviorSubscription[]) this.f18674c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.f18678g.get());
    }

    public boolean hasValue() {
        Object obj = this.f18678g.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return false;
        }
        return true;
    }

    public boolean offer(T t11) {
        if (t11 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.f18674c.get();
        for (BehaviorSubscription isFull : behaviorSubscriptionArr) {
            if (isFull.isFull()) {
                return false;
            }
        }
        Object next = NotificationLite.next(t11);
        d(next);
        for (BehaviorSubscription c11 : behaviorSubscriptionArr) {
            c11.c(next, this.f18680i);
        }
        return true;
    }

    public void onComplete() {
        if (b.a(this.f18679h, (Object) null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription c11 : e(complete)) {
                c11.c(complete, this.f18680i);
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!b.a(this.f18679h, (Object) null, th2)) {
            RxJavaPlugins.onError(th2);
            return;
        }
        Object error = NotificationLite.error(th2);
        for (BehaviorSubscription c11 : e(error)) {
            c11.c(error, this.f18680i);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f18679h.get() == null) {
            Object next = NotificationLite.next(t11);
            d(next);
            for (BehaviorSubscription c11 : (BehaviorSubscription[]) this.f18674c.get()) {
                c11.c(next, this.f18680i);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f18679h.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (!b(behaviorSubscription)) {
            Throwable th2 = this.f18679h.get();
            if (th2 == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th2);
            }
        } else if (behaviorSubscription.f18687h) {
            c(behaviorSubscription);
        } else {
            behaviorSubscription.a();
        }
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        Object obj = this.f18678g.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        T value = NotificationLite.getValue(obj);
        if (tArr.length != 0) {
            tArr[0] = value;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = null;
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
        tArr2[0] = value;
        return tArr2;
    }

    public BehaviorProcessor(T t11) {
        this();
        this.f18678g.lazySet(ObjectHelper.requireNonNull(t11, "defaultValue is null"));
    }
}
