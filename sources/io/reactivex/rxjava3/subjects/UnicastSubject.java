package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SpscLinkedArrayQueue<T> f23463b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Observer<? super T>> f23464c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Runnable> f23465d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f23466e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f23467f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23468g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f23469h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f23470i = new AtomicBoolean();

    /* renamed from: j  reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f23471j = new UnicastQueueDisposable();

    /* renamed from: k  reason: collision with root package name */
    public boolean f23472k;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        public void clear() {
            UnicastSubject.this.f23463b.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f23467f) {
                UnicastSubject.this.f23467f = true;
                UnicastSubject.this.a();
                UnicastSubject.this.f23464c.lazySet((Object) null);
                if (UnicastSubject.this.f23471j.getAndIncrement() == 0) {
                    UnicastSubject.this.f23464c.lazySet((Object) null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.f23472k) {
                        unicastSubject.f23463b.clear();
                    }
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f23467f;
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f23463b.isEmpty();
        }

        @Nullable
        public T poll() {
            return UnicastSubject.this.f23463b.poll();
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f23472k = true;
            return 2;
        }
    }

    public UnicastSubject(int i11, Runnable runnable, boolean z11) {
        this.f23463b = new SpscLinkedArrayQueue<>(i11);
        this.f23465d = new AtomicReference<>(runnable);
        this.f23466e = z11;
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize(), (Runnable) null, true);
    }

    public void a() {
        Runnable runnable = this.f23465d.get();
        if (runnable != null && b.a(this.f23465d, runnable, (Object) null)) {
            runnable.run();
        }
    }

    public void b() {
        if (this.f23471j.getAndIncrement() == 0) {
            Observer observer = this.f23464c.get();
            int i11 = 1;
            while (observer == null) {
                i11 = this.f23471j.addAndGet(-i11);
                if (i11 != 0) {
                    observer = this.f23464c.get();
                } else {
                    return;
                }
            }
            if (this.f23472k) {
                c(observer);
            } else {
                d(observer);
            }
        }
    }

    public void c(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f23463b;
        int i11 = 1;
        boolean z11 = !this.f23466e;
        while (!this.f23467f) {
            boolean z12 = this.f23468g;
            if (!z11 || !z12 || !f(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z12) {
                    e(observer);
                    return;
                }
                i11 = this.f23471j.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f23464c.lazySet((Object) null);
    }

    public void d(Observer<? super T> observer) {
        boolean z11;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f23463b;
        boolean z12 = !this.f23466e;
        boolean z13 = true;
        int i11 = 1;
        while (!this.f23467f) {
            boolean z14 = this.f23468g;
            T poll = this.f23463b.poll();
            if (poll == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z14) {
                if (z12 && z13) {
                    if (!f(spscLinkedArrayQueue, observer)) {
                        z13 = false;
                    } else {
                        return;
                    }
                }
                if (z11) {
                    e(observer);
                    return;
                }
            }
            if (z11) {
                i11 = this.f23471j.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f23464c.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    public void e(Observer<? super T> observer) {
        this.f23464c.lazySet((Object) null);
        Throwable th2 = this.f23469h;
        if (th2 != null) {
            observer.onError(th2);
        } else {
            observer.onComplete();
        }
    }

    public boolean f(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th2 = this.f23469h;
        if (th2 == null) {
            return false;
        }
        this.f23464c.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th2);
        return true;
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f23468g) {
            return this.f23469h;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23468g && this.f23469h == null;
    }

    @CheckReturnValue
    public boolean hasObservers() {
        return this.f23464c.get() != null;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23468g && this.f23469h != null;
    }

    public void onComplete() {
        if (!this.f23468g && !this.f23467f) {
            this.f23468g = true;
            a();
            b();
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23468g || this.f23467f) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23469h = th2;
        this.f23468g = true;
        a();
        b();
    }

    public void onNext(T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (!this.f23468g && !this.f23467f) {
            this.f23463b.offer(t11);
            b();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23468g || this.f23467f) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f23470i.get() || !this.f23470i.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (Observer<?>) observer);
            return;
        }
        observer.onSubscribe(this.f23471j);
        this.f23464c.lazySet(observer);
        if (this.f23467f) {
            this.f23464c.lazySet((Object) null);
        } else {
            b();
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return new UnicastSubject<>(i11, (Runnable) null, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i11, @NonNull Runnable runnable) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i11, runnable, true);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i11, @NonNull Runnable runnable, boolean z11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i11, runnable, z11);
    }

    @NonNull
    @CheckReturnValue
    public static <T> UnicastSubject<T> create(boolean z11) {
        return new UnicastSubject<>(Observable.bufferSize(), (Runnable) null, z11);
    }
}
