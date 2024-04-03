package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Observable<Object>, ? extends ObservableSource<?>> f17535c;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17536b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f17537c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f17538d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final Subject<Object> f17539e;

        /* renamed from: f  reason: collision with root package name */
        public final RepeatWhenObserver<T>.InnerRepeatObserver f17540f = new InnerRepeatObserver();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f17541g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final ObservableSource<T> f17542h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17543i;

        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            public void onComplete() {
                RepeatWhenObserver.this.a();
            }

            public void onError(Throwable th2) {
                RepeatWhenObserver.this.b(th2);
            }

            public void onNext(Object obj) {
                RepeatWhenObserver.this.c();
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.f17536b = observer;
            this.f17539e = subject;
            this.f17542h = observableSource;
        }

        public void a() {
            DisposableHelper.dispose(this.f17541g);
            HalfSerializer.onComplete((Observer<?>) this.f17536b, (AtomicInteger) this, this.f17538d);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f17541g);
            HalfSerializer.onError((Observer<?>) this.f17536b, th2, (AtomicInteger) this, this.f17538d);
        }

        public void c() {
            d();
        }

        public void d() {
            if (this.f17537c.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f17543i) {
                        this.f17543i = true;
                        this.f17542h.subscribe(this);
                    }
                    if (this.f17537c.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17541g);
            DisposableHelper.dispose(this.f17540f);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17541g.get());
        }

        public void onComplete() {
            DisposableHelper.replace(this.f17541g, (Disposable) null);
            this.f17543i = false;
            this.f17539e.onNext(0);
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f17540f);
            HalfSerializer.onError((Observer<?>) this.f17536b, th2, (AtomicInteger) this, this.f17538d);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f17536b, t11, (AtomicInteger) this, this.f17538d);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17541g, disposable);
        }
    }

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f17535c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Subject serialized = PublishSubject.create().toSerialized();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17535c.apply(serialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serialized, this.f16799b);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f17540f);
            repeatWhenObserver.d();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
