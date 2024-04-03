package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f21960c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21961b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f21962c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f21963d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21964e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f21965f;

        /* renamed from: g  reason: collision with root package name */
        public T f21966g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21967h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21968i;

        /* renamed from: j  reason: collision with root package name */
        public volatile int f21969j;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f21970b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f21970b = mergeWithObserver;
            }

            public void onComplete() {
                this.f21970b.d();
            }

            public void onError(Throwable th2) {
                this.f21970b.e(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f21970b.f(t11);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.f21961b = observer;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            T t11;
            boolean z11;
            Observer<? super T> observer = this.f21961b;
            int i11 = 1;
            while (!this.f21967h) {
                if (this.f21964e.get() != null) {
                    this.f21966g = null;
                    this.f21965f = null;
                    this.f21964e.tryTerminateConsumer((Observer<?>) observer);
                    return;
                }
                int i12 = this.f21969j;
                if (i12 == 1) {
                    T t12 = this.f21966g;
                    this.f21966g = null;
                    this.f21969j = 2;
                    observer.onNext(t12);
                    i12 = 2;
                }
                boolean z12 = this.f21968i;
                SimplePlainQueue<T> simplePlainQueue = this.f21965f;
                if (simplePlainQueue != null) {
                    t11 = simplePlainQueue.poll();
                } else {
                    t11 = null;
                }
                if (t11 == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11 && i12 == 2) {
                    this.f21965f = null;
                    observer.onComplete();
                    return;
                } else if (z11) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(t11);
                }
            }
            this.f21966g = null;
            this.f21965f = null;
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f21965f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.f21965f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        public void d() {
            this.f21969j = 2;
            a();
        }

        public void dispose() {
            this.f21967h = true;
            DisposableHelper.dispose(this.f21962c);
            DisposableHelper.dispose(this.f21963d);
            this.f21964e.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.f21965f = null;
                this.f21966g = null;
            }
        }

        public void e(Throwable th2) {
            if (this.f21964e.tryAddThrowableOrReport(th2)) {
                DisposableHelper.dispose(this.f21962c);
                a();
            }
        }

        public void f(T t11) {
            if (compareAndSet(0, 1)) {
                this.f21961b.onNext(t11);
                this.f21969j = 2;
            } else {
                this.f21966g = t11;
                this.f21969j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f21962c.get());
        }

        public void onComplete() {
            this.f21968i = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f21964e.tryAddThrowableOrReport(th2)) {
                DisposableHelper.dispose(this.f21963d);
                a();
            }
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                this.f21961b.onNext(t11);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t11);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f21962c, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f21960c = maybeSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f21304b.subscribe(mergeWithObserver);
        this.f21960c.subscribe(mergeWithObserver.f21963d);
    }
}
