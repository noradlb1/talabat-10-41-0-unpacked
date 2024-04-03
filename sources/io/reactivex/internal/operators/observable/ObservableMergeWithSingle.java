package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f17424c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17425b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17426c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f17427d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f17428e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f17429f;

        /* renamed from: g  reason: collision with root package name */
        public T f17430g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17431h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17432i;

        /* renamed from: j  reason: collision with root package name */
        public volatile int f17433j;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f17434b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f17434b = mergeWithObserver;
            }

            public void onError(Throwable th2) {
                this.f17434b.d(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f17434b.e(t11);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.f17425b = observer;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            T t11;
            boolean z11;
            Observer<? super T> observer = this.f17425b;
            int i11 = 1;
            while (!this.f17431h) {
                if (this.f17428e.get() != null) {
                    this.f17430g = null;
                    this.f17429f = null;
                    observer.onError(this.f17428e.terminate());
                    return;
                }
                int i12 = this.f17433j;
                if (i12 == 1) {
                    T t12 = this.f17430g;
                    this.f17430g = null;
                    this.f17433j = 2;
                    observer.onNext(t12);
                    i12 = 2;
                }
                boolean z12 = this.f17432i;
                SimplePlainQueue<T> simplePlainQueue = this.f17429f;
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
                    this.f17429f = null;
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
            this.f17430g = null;
            this.f17429f = null;
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f17429f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.f17429f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        public void d(Throwable th2) {
            if (this.f17428e.addThrowable(th2)) {
                DisposableHelper.dispose(this.f17426c);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void dispose() {
            this.f17431h = true;
            DisposableHelper.dispose(this.f17426c);
            DisposableHelper.dispose(this.f17427d);
            if (getAndIncrement() == 0) {
                this.f17429f = null;
                this.f17430g = null;
            }
        }

        public void e(T t11) {
            if (compareAndSet(0, 1)) {
                this.f17425b.onNext(t11);
                this.f17433j = 2;
            } else {
                this.f17430g = t11;
                this.f17433j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17426c.get());
        }

        public void onComplete() {
            this.f17432i = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f17428e.addThrowable(th2)) {
                DisposableHelper.dispose(this.f17427d);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                this.f17425b.onNext(t11);
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
            DisposableHelper.setOnce(this.f17426c, disposable);
        }
    }

    public ObservableMergeWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f17424c = singleSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f16799b.subscribe(mergeWithObserver);
        this.f17424c.subscribe(mergeWithObserver.f17427d);
    }
}
