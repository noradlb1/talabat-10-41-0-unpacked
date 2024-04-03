package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableOnSubscribe<T> f19556c;

    /* renamed from: d  reason: collision with root package name */
    public final BackpressureStrategy f19557d;

    /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19558a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.rxjava3.core.BackpressureStrategy[] r0 = io.reactivex.rxjava3.core.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19558a = r0
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19558a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19558a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19558a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19559b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f19560c = new SequentialDisposable();

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.f19559b = subscriber;
        }

        public void a() {
            if (!isCancelled()) {
                try {
                    this.f19559b.onComplete();
                } finally {
                    this.f19560c.dispose();
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Throwable th2) {
            if (isCancelled()) {
                return false;
            }
            try {
                this.f19559b.onError(th2);
                this.f19560c.dispose();
                return true;
            } catch (Throwable th3) {
                this.f19560c.dispose();
                throw th3;
            }
        }

        public void c() {
        }

        public final void cancel() {
            this.f19560c.dispose();
            d();
        }

        public void d() {
        }

        public final boolean isCancelled() {
            return this.f19560c.isDisposed();
        }

        public void onComplete() {
            a();
        }

        public final void onError(Throwable th2) {
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (!signalError(th2)) {
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
            this.f19560c.update(disposable);
        }

        public boolean signalError(Throwable th2) {
            return b(th2);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }

        public final boolean tryOnError(Throwable th2) {
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("tryOnError called with a null Throwable.");
            }
            return signalError(th2);
        }
    }

    public static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f19561d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f19562e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f19563f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f19564g = new AtomicInteger();

        public BufferAsyncEmitter(Subscriber<? super T> subscriber, int i11) {
            super(subscriber);
            this.f19561d = new SpscLinkedArrayQueue<>(i11);
        }

        public void c() {
            e();
        }

        public void d() {
            if (this.f19564g.getAndIncrement() == 0) {
                this.f19561d.clear();
            }
        }

        public void e() {
            int i11;
            boolean z11;
            if (this.f19564g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f19559b;
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f19561d;
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
                            boolean z12 = this.f19563f;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                Throwable th2 = this.f19562e;
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
                        boolean z13 = this.f19563f;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z13 && isEmpty) {
                            Throwable th3 = this.f19562e;
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
                    i12 = this.f19564g.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void onComplete() {
            this.f19563f = true;
            e();
        }

        public void onNext(T t11) {
            if (!this.f19563f && !isCancelled()) {
                if (t11 == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                this.f19561d.offer(t11);
                e();
            }
        }

        public boolean signalError(Throwable th2) {
            if (this.f19563f || isCancelled()) {
                return false;
            }
            this.f19562e = th2;
            this.f19563f = true;
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
        public final AtomicReference<T> f19565d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Throwable f19566e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f19567f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f19568g = new AtomicInteger();

        public LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void c() {
            e();
        }

        public void d() {
            if (this.f19568g.getAndIncrement() == 0) {
                this.f19565d.lazySet((Object) null);
            }
        }

        public void e() {
            int i11;
            boolean z11;
            boolean z12;
            if (this.f19568g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f19559b;
                AtomicReference<T> atomicReference = this.f19565d;
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
                            boolean z13 = this.f19567f;
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (andSet == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z12) {
                                Throwable th2 = this.f19566e;
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
                        boolean z14 = this.f19567f;
                        if (atomicReference.get() == null) {
                            z11 = true;
                        }
                        if (z14 && z11) {
                            Throwable th3 = this.f19566e;
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
                    i12 = this.f19568g.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void onComplete() {
            this.f19567f = true;
            e();
        }

        public void onNext(T t11) {
            if (!this.f19567f && !isCancelled()) {
                if (t11 == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                this.f19565d.set(t11);
                e();
            }
        }

        public boolean signalError(Throwable th2) {
            if (this.f19567f || isCancelled()) {
                return false;
            }
            this.f19566e = th2;
            this.f19567f = true;
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
                    this.f19559b.onNext(t11);
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
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
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
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                } else if (get() != 0) {
                    this.f19559b.onNext(t11);
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
        public final BaseEmitter<T> f19569b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f19570c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final SimplePlainQueue<T> f19571d = new SpscLinkedArrayQueue(16);

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f19572e;

        public SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.f19569b = baseEmitter;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            boolean z11;
            BaseEmitter<T> baseEmitter = this.f19569b;
            SimplePlainQueue<T> simplePlainQueue = this.f19571d;
            AtomicThrowable atomicThrowable = this.f19570c;
            int i11 = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    atomicThrowable.tryTerminateConsumer((Emitter<?>) baseEmitter);
                    return;
                }
                boolean z12 = this.f19572e;
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
            return this.f19569b.isCancelled();
        }

        public void onComplete() {
            if (!this.f19569b.isCancelled() && !this.f19572e) {
                this.f19572e = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f19569b.isCancelled() && !this.f19572e) {
                if (t11 == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<T> simplePlainQueue = this.f19571d;
                    synchronized (simplePlainQueue) {
                        simplePlainQueue.offer(t11);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.f19569b.onNext(t11);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                b();
            }
        }

        public long requested() {
            return this.f19569b.requested();
        }

        public FlowableEmitter<T> serialize() {
            return this;
        }

        public void setCancellable(Cancellable cancellable) {
            this.f19569b.setCancellable(cancellable);
        }

        public void setDisposable(Disposable disposable) {
            this.f19569b.setDisposable(disposable);
        }

        public String toString() {
            return this.f19569b.toString();
        }

        public boolean tryOnError(Throwable th2) {
            if (!this.f19569b.isCancelled() && !this.f19572e) {
                if (th2 == null) {
                    th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
                }
                if (this.f19570c.tryAddThrowable(th2)) {
                    this.f19572e = true;
                    a();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.f19556c = flowableOnSubscribe;
        this.f19557d = backpressureStrategy;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        BaseEmitter baseEmitter;
        int i11 = AnonymousClass1.f19558a[this.f19557d.ordinal()];
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
            this.f19556c.subscribe(baseEmitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            baseEmitter.onError(th2);
        }
    }
}
