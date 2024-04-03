package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> f22126c;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22127b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f22128c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f22129d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final Subject<Throwable> f22130e;

        /* renamed from: f  reason: collision with root package name */
        public final RepeatWhenObserver<T>.InnerRepeatObserver f22131f = new InnerRepeatObserver();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f22132g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final ObservableSource<T> f22133h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f22134i;

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

        public RepeatWhenObserver(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
            this.f22127b = observer;
            this.f22130e = subject;
            this.f22133h = observableSource;
        }

        public void a() {
            DisposableHelper.dispose(this.f22132g);
            HalfSerializer.onComplete((Observer<?>) this.f22127b, (AtomicInteger) this, this.f22129d);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f22132g);
            HalfSerializer.onError((Observer<?>) this.f22127b, th2, (AtomicInteger) this, this.f22129d);
        }

        public void c() {
            d();
        }

        public void d() {
            if (this.f22128c.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f22134i) {
                        this.f22134i = true;
                        this.f22133h.subscribe(this);
                    }
                    if (this.f22128c.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22132g);
            DisposableHelper.dispose(this.f22131f);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22132g.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f22131f);
            HalfSerializer.onComplete((Observer<?>) this.f22127b, (AtomicInteger) this, this.f22129d);
        }

        public void onError(Throwable th2) {
            DisposableHelper.replace(this.f22132g, (Disposable) null);
            this.f22134i = false;
            this.f22130e.onNext(th2);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f22127b, t11, (AtomicInteger) this, this.f22129d);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f22132g, disposable);
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f22126c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Subject serialized = PublishSubject.create().toSerialized();
        try {
            Object apply = this.f22126c.apply(serialized);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serialized, this.f21304b);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f22131f);
            repeatWhenObserver.d();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
