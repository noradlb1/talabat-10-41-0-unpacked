package io.reactivex.subjects;

import i.b;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SpscLinkedArrayQueue<T> f23658b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Observer<? super T>> f23659c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Runnable> f23660d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f23661e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f23662f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23663g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f23664h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f23665i;

    /* renamed from: j  reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f23666j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23667k;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        public void clear() {
            UnicastSubject.this.f23658b.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f23662f) {
                UnicastSubject.this.f23662f = true;
                UnicastSubject.this.a();
                UnicastSubject.this.f23659c.lazySet((Object) null);
                if (UnicastSubject.this.f23666j.getAndIncrement() == 0) {
                    UnicastSubject.this.f23659c.lazySet((Object) null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.f23667k) {
                        unicastSubject.f23658b.clear();
                    }
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f23662f;
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f23658b.isEmpty();
        }

        @Nullable
        public T poll() throws Exception {
            return UnicastSubject.this.f23658b.poll();
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f23667k = true;
            return 2;
        }
    }

    public UnicastSubject(int i11, boolean z11) {
        this.f23658b = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i11, "capacityHint"));
        this.f23660d = new AtomicReference<>();
        this.f23661e = z11;
        this.f23659c = new AtomicReference<>();
        this.f23665i = new AtomicBoolean();
        this.f23666j = new UnicastQueueDisposable();
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize(), true);
    }

    public void a() {
        Runnable runnable = this.f23660d.get();
        if (runnable != null && b.a(this.f23660d, runnable, (Object) null)) {
            runnable.run();
        }
    }

    public void b() {
        if (this.f23666j.getAndIncrement() == 0) {
            Observer observer = this.f23659c.get();
            int i11 = 1;
            while (observer == null) {
                i11 = this.f23666j.addAndGet(-i11);
                if (i11 != 0) {
                    observer = this.f23659c.get();
                } else {
                    return;
                }
            }
            if (this.f23667k) {
                c(observer);
            } else {
                d(observer);
            }
        }
    }

    public void c(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f23658b;
        int i11 = 1;
        boolean z11 = !this.f23661e;
        while (!this.f23662f) {
            boolean z12 = this.f23663g;
            if (!z11 || !z12 || !f(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z12) {
                    e(observer);
                    return;
                }
                i11 = this.f23666j.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f23659c.lazySet((Object) null);
    }

    public void d(Observer<? super T> observer) {
        boolean z11;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f23658b;
        boolean z12 = !this.f23661e;
        boolean z13 = true;
        int i11 = 1;
        while (!this.f23662f) {
            boolean z14 = this.f23663g;
            T poll = this.f23658b.poll();
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
                i11 = this.f23666j.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f23659c.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    public void e(Observer<? super T> observer) {
        this.f23659c.lazySet((Object) null);
        Throwable th2 = this.f23664h;
        if (th2 != null) {
            observer.onError(th2);
        } else {
            observer.onComplete();
        }
    }

    public boolean f(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th2 = this.f23664h;
        if (th2 == null) {
            return false;
        }
        this.f23659c.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th2);
        return true;
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23663g) {
            return this.f23664h;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f23663g && this.f23664h == null;
    }

    public boolean hasObservers() {
        return this.f23659c.get() != null;
    }

    public boolean hasThrowable() {
        return this.f23663g && this.f23664h != null;
    }

    public void onComplete() {
        if (!this.f23663g && !this.f23662f) {
            this.f23663g = true;
            a();
            b();
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23663g || this.f23662f) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23664h = th2;
        this.f23663g = true;
        a();
        b();
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f23663g && !this.f23662f) {
            this.f23658b.offer(t11);
            b();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23663g || this.f23662f) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        if (this.f23665i.get() || !this.f23665i.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (Observer<?>) observer);
            return;
        }
        observer.onSubscribe(this.f23666j);
        this.f23659c.lazySet(observer);
        if (this.f23662f) {
            this.f23659c.lazySet((Object) null);
        } else {
            b();
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i11) {
        return new UnicastSubject<>(i11, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i11, Runnable runnable) {
        return new UnicastSubject<>(i11, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i11, Runnable runnable, boolean z11) {
        return new UnicastSubject<>(i11, runnable, z11);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(boolean z11) {
        return new UnicastSubject<>(Observable.bufferSize(), z11);
    }

    public UnicastSubject(int i11, Runnable runnable, boolean z11) {
        this.f23658b = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i11, "capacityHint"));
        this.f23660d = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.f23661e = z11;
        this.f23659c = new AtomicReference<>();
        this.f23665i = new AtomicBoolean();
        this.f23666j = new UnicastQueueDisposable();
    }
}
