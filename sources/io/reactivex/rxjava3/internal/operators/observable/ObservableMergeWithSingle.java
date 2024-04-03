package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f21971c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21972b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f21973c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f21974d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21975e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f21976f;

        /* renamed from: g  reason: collision with root package name */
        public T f21977g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21978h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21979i;

        /* renamed from: j  reason: collision with root package name */
        public volatile int f21980j;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f21981b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f21981b = mergeWithObserver;
            }

            public void onError(Throwable th2) {
                this.f21981b.d(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f21981b.e(t11);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.f21972b = observer;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            T t11;
            boolean z11;
            Observer<? super T> observer = this.f21972b;
            int i11 = 1;
            while (!this.f21978h) {
                if (this.f21975e.get() != null) {
                    this.f21977g = null;
                    this.f21976f = null;
                    this.f21975e.tryTerminateConsumer((Observer<?>) observer);
                    return;
                }
                int i12 = this.f21980j;
                if (i12 == 1) {
                    T t12 = this.f21977g;
                    this.f21977g = null;
                    this.f21980j = 2;
                    observer.onNext(t12);
                    i12 = 2;
                }
                boolean z12 = this.f21979i;
                SimplePlainQueue<T> simplePlainQueue = this.f21976f;
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
                    this.f21976f = null;
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
            this.f21977g = null;
            this.f21976f = null;
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f21976f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.f21976f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        public void d(Throwable th2) {
            if (this.f21975e.tryAddThrowableOrReport(th2)) {
                DisposableHelper.dispose(this.f21973c);
                a();
            }
        }

        public void dispose() {
            this.f21978h = true;
            DisposableHelper.dispose(this.f21973c);
            DisposableHelper.dispose(this.f21974d);
            this.f21975e.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.f21976f = null;
                this.f21977g = null;
            }
        }

        public void e(T t11) {
            if (compareAndSet(0, 1)) {
                this.f21972b.onNext(t11);
                this.f21980j = 2;
            } else {
                this.f21977g = t11;
                this.f21980j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f21973c.get());
        }

        public void onComplete() {
            this.f21979i = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f21975e.tryAddThrowableOrReport(th2)) {
                DisposableHelper.dispose(this.f21974d);
                a();
            }
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                this.f21972b.onNext(t11);
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
            DisposableHelper.setOnce(this.f21973c, disposable);
        }
    }

    public ObservableMergeWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f21971c = singleSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f21304b.subscribe(mergeWithObserver);
        this.f21971c.subscribe(mergeWithObserver.f21974d);
    }
}
