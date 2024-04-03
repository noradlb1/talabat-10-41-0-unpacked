package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f17413c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17414b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17415c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver<T> f17416d = new OtherObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f17417e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public volatile SimplePlainQueue<T> f17418f;

        /* renamed from: g  reason: collision with root package name */
        public T f17419g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17420h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17421i;

        /* renamed from: j  reason: collision with root package name */
        public volatile int f17422j;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<T> f17423b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f17423b = mergeWithObserver;
            }

            public void onComplete() {
                this.f17423b.d();
            }

            public void onError(Throwable th2) {
                this.f17423b.e(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f17423b.f(t11);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.f17414b = observer;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            T t11;
            boolean z11;
            Observer<? super T> observer = this.f17414b;
            int i11 = 1;
            while (!this.f17420h) {
                if (this.f17417e.get() != null) {
                    this.f17419g = null;
                    this.f17418f = null;
                    observer.onError(this.f17417e.terminate());
                    return;
                }
                int i12 = this.f17422j;
                if (i12 == 1) {
                    T t12 = this.f17419g;
                    this.f17419g = null;
                    this.f17422j = 2;
                    observer.onNext(t12);
                    i12 = 2;
                }
                boolean z12 = this.f17421i;
                SimplePlainQueue<T> simplePlainQueue = this.f17418f;
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
                    this.f17418f = null;
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
            this.f17419g = null;
            this.f17418f = null;
        }

        public SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.f17418f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.f17418f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        public void d() {
            this.f17422j = 2;
            a();
        }

        public void dispose() {
            this.f17420h = true;
            DisposableHelper.dispose(this.f17415c);
            DisposableHelper.dispose(this.f17416d);
            if (getAndIncrement() == 0) {
                this.f17418f = null;
                this.f17419g = null;
            }
        }

        public void e(Throwable th2) {
            if (this.f17417e.addThrowable(th2)) {
                DisposableHelper.dispose(this.f17415c);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void f(T t11) {
            if (compareAndSet(0, 1)) {
                this.f17414b.onNext(t11);
                this.f17422j = 2;
            } else {
                this.f17419g = t11;
                this.f17422j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17415c.get());
        }

        public void onComplete() {
            this.f17421i = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f17417e.addThrowable(th2)) {
                DisposableHelper.dispose(this.f17416d);
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (compareAndSet(0, 1)) {
                this.f17414b.onNext(t11);
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
            DisposableHelper.setOnce(this.f17415c, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f17413c = maybeSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f16799b.subscribe(mergeWithObserver);
        this.f17413c.subscribe(mergeWithObserver.f17416d);
    }
}
