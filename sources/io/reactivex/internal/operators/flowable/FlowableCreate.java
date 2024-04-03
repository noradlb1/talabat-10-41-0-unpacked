package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableOnSubscribe<T> f15050c;

    /* renamed from: d  reason: collision with root package name */
    public final BackpressureStrategy f15051d;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15052a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15052a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15052a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f15052a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f15052a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15053b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f15054c = new SequentialDisposable();

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.f15053b = subscriber;
        }

        public void a() {
            if (!isCancelled()) {
                try {
                    this.f15053b.onComplete();
                } finally {
                    this.f15054c.dispose();
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.f15053b.onError(th2);
                this.f15054c.dispose();
                return true;
            } catch (Throwable th3) {
                this.f15054c.dispose();
                throw th3;
            }
        }

        public void c() {
        }

        public final void cancel() {
            this.f15054c.dispose();
            d();
        }

        public void d() {
        }

        public final boolean isCancelled() {
            return this.f15054c.isDisposed();
        }

        public void onComplete() {
            a();
        }

        public final void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
                c();
            }
        }

        public final long requested() {
            return get();
        }

        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        public final void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        public final void setDisposable(Disposable disposable) {
            this.f15054c.update(disposable);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }

        public boolean tryOnError(Throwable th2) {
            return b(th2);
        }
    }

    public static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f15055d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f15056e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15057f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f15058g = new AtomicInteger();

        public BufferAsyncEmitter(Subscriber<? super T> subscriber, int i11) {
            super(subscriber);
            this.f15055d = new SpscLinkedArrayQueue<>(i11);
        }

        public void c() {
            e();
        }

        public void d() {
            if (this.f15058g.getAndIncrement() == 0) {
                this.f15055d.clear();
            }
        }

        public void e() {
            int i11;
            boolean z11;
            if (this.f15058g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f15053b;
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f15055d;
                int i12 = 1;
                do {
                    long j11 = get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z12 = this.f15057f;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                Throwable th2 = this.f15056e;
                                if (th2 != null) {
                                    b(th2);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            } else if (z11) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j12++;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z13 = this.f15057f;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z13 && isEmpty) {
                            Throwable th3 = this.f15056e;
                            if (th3 != null) {
                                b(th3);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                    if (j12 != 0) {
                        BackpressureHelper.produced(this, j12);
                    }
                    i12 = this.f15058g.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void onComplete() {
            this.f15057f = true;
            e();
        }

        public void onNext(T t11) {
            if (!this.f15057f && !isCancelled()) {
                if (t11 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f15055d.offer(t11);
                e();
            }
        }

        public boolean tryOnError(Throwable th2) {
            if (this.f15057f || isCancelled()) {
                return false;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f15056e = th2;
            this.f15057f = true;
            e();
            return true;
        }
    }

    public static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void e() {
        }
    }

    public static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        public ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void e() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<T> f15059d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Throwable f15060e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15061f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f15062g = new AtomicInteger();

        public LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void c() {
            e();
        }

        public void d() {
            if (this.f15062g.getAndIncrement() == 0) {
                this.f15059d.lazySet((Object) null);
            }
        }

        public void e() {
            int i11;
            boolean z11;
            boolean z12;
            if (this.f15062g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f15053b;
                AtomicReference<T> atomicReference = this.f15059d;
                int i12 = 1;
                do {
                    long j11 = get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        z11 = false;
                        if (i11 == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z13 = this.f15061f;
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (andSet == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z12) {
                                Throwable th2 = this.f15060e;
                                if (th2 != null) {
                                    b(th2);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            } else if (z12) {
                                break;
                            } else {
                                subscriber.onNext(andSet);
                                j12++;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z14 = this.f15061f;
                        if (atomicReference.get() == null) {
                            z11 = true;
                        }
                        if (z14 && z11) {
                            Throwable th3 = this.f15060e;
                            if (th3 != null) {
                                b(th3);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                    if (j12 != 0) {
                        BackpressureHelper.produced(this, j12);
                    }
                    i12 = this.f15062g.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void onComplete() {
            this.f15061f = true;
            e();
        }

        public void onNext(T t11) {
            if (!this.f15061f && !isCancelled()) {
                if (t11 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f15059d.set(t11);
                e();
            }
        }

        public boolean tryOnError(Throwable th2) {
            if (this.f15061f || isCancelled()) {
                return false;
            }
            if (th2 == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f15060e = th2;
            this.f15061f = true;
            e();
            return true;
        }
    }

    public static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t11) {
            long j11;
            if (!isCancelled()) {
                if (t11 != null) {
                    this.f15053b.onNext(t11);
                    do {
                        j11 = get();
                        if (j11 == 0 || compareAndSet(j11, j11 - 1)) {
                            return;
                        }
                        j11 = get();
                        return;
                    } while (compareAndSet(j11, j11 - 1));
                    return;
                }
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    public static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public abstract void e();

        public final void onNext(T t11) {
            if (!isCancelled()) {
                if (t11 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.f15053b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                } else {
                    e();
                }
            }
        }
    }

    public static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;

        /* renamed from: b  reason: collision with root package name */
        public final BaseEmitter<T> f15063b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f15064c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final SimplePlainQueue<T> f15065d = new SpscLinkedArrayQueue(16);

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f15066e;

        public SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.f15063b = baseEmitter;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            boolean z11;
            BaseEmitter<T> baseEmitter = this.f15063b;
            SimplePlainQueue<T> simplePlainQueue = this.f15065d;
            AtomicThrowable atomicThrowable = this.f15064c;
            int i11 = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z12 = this.f15066e;
                T poll = simplePlainQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11) {
                    baseEmitter.onComplete();
                    return;
                } else if (z11) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(poll);
                }
            }
            simplePlainQueue.clear();
        }

        public boolean isCancelled() {
            return this.f15063b.isCancelled();
        }

        public void onComplete() {
            if (!this.f15063b.isCancelled() && !this.f15066e) {
                this.f15066e = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f15063b.isCancelled() && !this.f15066e) {
                if (t11 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<T> simplePlainQueue = this.f15065d;
                    synchronized (simplePlainQueue) {
                        simplePlainQueue.offer(t11);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.f15063b.onNext(t11);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                b();
            }
        }

        public long requested() {
            return this.f15063b.requested();
        }

        public FlowableEmitter<T> serialize() {
            return this;
        }

        public void setCancellable(Cancellable cancellable) {
            this.f15063b.setCancellable(cancellable);
        }

        public void setDisposable(Disposable disposable) {
            this.f15063b.setDisposable(disposable);
        }

        public String toString() {
            return this.f15063b.toString();
        }

        public boolean tryOnError(Throwable th2) {
            if (!this.f15063b.isCancelled() && !this.f15066e) {
                if (th2 == null) {
                    th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.f15064c.addThrowable(th2)) {
                    this.f15066e = true;
                    a();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.f15050c = flowableOnSubscribe;
        this.f15051d = backpressureStrategy;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        BaseEmitter baseEmitter;
        int i11 = AnonymousClass1.f15052a[this.f15051d.ordinal()];
        if (i11 == 1) {
            baseEmitter = new MissingEmitter(subscriber);
        } else if (i11 == 2) {
            baseEmitter = new ErrorAsyncEmitter(subscriber);
        } else if (i11 == 3) {
            baseEmitter = new DropAsyncEmitter(subscriber);
        } else if (i11 != 4) {
            baseEmitter = new BufferAsyncEmitter(subscriber, Flowable.bufferSize());
        } else {
            baseEmitter = new LatestAsyncEmitter(subscriber);
        }
        subscriber.onSubscribe(baseEmitter);
        try {
            this.f15050c.subscribe(baseEmitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            baseEmitter.onError(th2);
        }
    }
}
