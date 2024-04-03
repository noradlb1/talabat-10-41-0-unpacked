package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

public final class MaybeMergeArray<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T>[] f20970c;

    public static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;

        /* renamed from: b  reason: collision with root package name */
        public int f20971b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f20972c = new AtomicInteger();

        public int consumerIndex() {
            return this.f20971b;
        }

        public void drop() {
            poll();
        }

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public T poll() {
            T poll = super.poll();
            if (poll != null) {
                this.f20971b++;
            }
            return poll;
        }

        public int producerIndex() {
            return this.f20972c.get();
        }

        public boolean offer(T t11) {
            this.f20972c.getAndIncrement();
            return super.offer(t11);
        }
    }

    public static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20973b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f20974c = new CompositeDisposable();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f20975d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public final SimpleQueueWithConsumerIndex<Object> f20976e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f20977f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public final int f20978g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20979h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f20980i;

        /* renamed from: j  reason: collision with root package name */
        public long f20981j;

        public MergeMaybeObserver(Subscriber<? super T> subscriber, int i11, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.f20973b = subscriber;
            this.f20978g = i11;
            this.f20976e = simpleQueueWithConsumerIndex;
        }

        public void a() {
            boolean z11;
            Subscriber<? super T> subscriber = this.f20973b;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.f20976e;
            int i11 = 1;
            while (!this.f20979h) {
                Throwable th2 = (Throwable) this.f20977f.get();
                if (th2 != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th2);
                    return;
                }
                if (simpleQueueWithConsumerIndex.producerIndex() == this.f20978g) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z11) {
                    subscriber.onComplete();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        public void b() {
            int i11;
            Subscriber<? super T> subscriber = this.f20973b;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.f20976e;
            long j11 = this.f20981j;
            int i12 = 1;
            do {
                long j12 = this.f20975d.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (this.f20979h) {
                        simpleQueueWithConsumerIndex.clear();
                        return;
                    } else if (((Throwable) this.f20977f.get()) != null) {
                        simpleQueueWithConsumerIndex.clear();
                        this.f20977f.tryTerminateConsumer((Subscriber<?>) this.f20973b);
                        return;
                    } else if (simpleQueueWithConsumerIndex.consumerIndex() == this.f20978g) {
                        subscriber.onComplete();
                        return;
                    } else {
                        Object poll = simpleQueueWithConsumerIndex.poll();
                        if (poll == null) {
                            break;
                        } else if (poll != NotificationLite.COMPLETE) {
                            subscriber.onNext(poll);
                            j11++;
                        }
                    }
                }
                if (i11 == 0) {
                    if (((Throwable) this.f20977f.get()) != null) {
                        simpleQueueWithConsumerIndex.clear();
                        this.f20977f.tryTerminateConsumer((Subscriber<?>) this.f20973b);
                        return;
                    }
                    while (simpleQueueWithConsumerIndex.peek() == NotificationLite.COMPLETE) {
                        simpleQueueWithConsumerIndex.drop();
                    }
                    if (simpleQueueWithConsumerIndex.consumerIndex() == this.f20978g) {
                        subscriber.onComplete();
                        return;
                    }
                }
                this.f20981j = j11;
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }

        public void cancel() {
            if (!this.f20979h) {
                this.f20979h = true;
                this.f20974c.dispose();
                if (getAndIncrement() == 0) {
                    this.f20976e.clear();
                }
            }
        }

        public void clear() {
            this.f20976e.clear();
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.f20980i) {
                    a();
                } else {
                    b();
                }
            }
        }

        public boolean isCancelled() {
            return this.f20979h;
        }

        public boolean isEmpty() {
            return this.f20976e.isEmpty();
        }

        public void onComplete() {
            this.f20976e.offer(NotificationLite.COMPLETE);
            drain();
        }

        public void onError(Throwable th2) {
            if (this.f20977f.tryAddThrowableOrReport(th2)) {
                this.f20974c.dispose();
                this.f20976e.offer(NotificationLite.COMPLETE);
                drain();
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f20974c.add(disposable);
        }

        public void onSuccess(T t11) {
            this.f20976e.offer(t11);
            drain();
        }

        @Nullable
        public T poll() {
            T poll;
            do {
                poll = this.f20976e.poll();
            } while (poll == NotificationLite.COMPLETE);
            return poll;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20975d, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f20980i = true;
            return 2;
        }
    }

    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Nullable
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.f20970c = maybeSourceArr;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex;
        MaybeSource<? extends T>[] maybeSourceArr = this.f20970c;
        int length = maybeSourceArr.length;
        if (length <= Flowable.bufferSize()) {
            simpleQueueWithConsumerIndex = new MpscFillOnceSimpleQueue(length);
        } else {
            simpleQueueWithConsumerIndex = new ClqSimpleQueue();
        }
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, simpleQueueWithConsumerIndex);
        subscriber.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.f20977f;
        int length2 = maybeSourceArr.length;
        int i11 = 0;
        while (i11 < length2) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i11];
            if (!mergeMaybeObserver.isCancelled() && atomicThrowable.get() == null) {
                maybeSource.subscribe(mergeMaybeObserver);
                i11++;
            } else {
                return;
            }
        }
    }

    public static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f20982b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        public int f20983c;

        public MpscFillOnceSimpleQueue(int i11) {
            super(i11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void clear() {
            /*
                r1 = this;
            L_0x0000:
                java.lang.Object r0 = r1.poll()
                if (r0 == 0) goto L_0x000d
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto L_0x000d
                goto L_0x0000
            L_0x000d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.MpscFillOnceSimpleQueue.clear():void");
        }

        public int consumerIndex() {
            return this.f20983c;
        }

        public void drop() {
            int i11 = this.f20983c;
            lazySet(i11, (Object) null);
            this.f20983c = i11 + 1;
        }

        public boolean isEmpty() {
            return this.f20983c == producerIndex();
        }

        public boolean offer(T t11) {
            Objects.requireNonNull(t11, "value is null");
            int andIncrement = this.f20982b.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t11);
            return true;
        }

        public T peek() {
            int i11 = this.f20983c;
            if (i11 == length()) {
                return null;
            }
            return get(i11);
        }

        @Nullable
        public T poll() {
            int i11 = this.f20983c;
            if (i11 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.f20982b;
            do {
                T t11 = get(i11);
                if (t11 != null) {
                    this.f20983c = i11 + 1;
                    lazySet(i11, (Object) null);
                    return t11;
                }
            } while (atomicInteger.get() != i11);
            return null;
        }

        public int producerIndex() {
            return this.f20982b.get();
        }

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException();
        }
    }
}
