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

public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Observable<Object>, ? extends ObservableSource<?>> f22074c;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22075b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f22076c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f22077d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final Subject<Object> f22078e;

        /* renamed from: f  reason: collision with root package name */
        public final RepeatWhenObserver<T>.InnerRepeatObserver f22079f = new InnerRepeatObserver();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f22080g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final ObservableSource<T> f22081h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f22082i;

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
            this.f22075b = observer;
            this.f22078e = subject;
            this.f22081h = observableSource;
        }

        public void a() {
            DisposableHelper.dispose(this.f22080g);
            HalfSerializer.onComplete((Observer<?>) this.f22075b, (AtomicInteger) this, this.f22077d);
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f22080g);
            HalfSerializer.onError((Observer<?>) this.f22075b, th2, (AtomicInteger) this, this.f22077d);
        }

        public void c() {
            d();
        }

        public void d() {
            if (this.f22076c.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f22082i) {
                        this.f22082i = true;
                        this.f22081h.subscribe(this);
                    }
                    if (this.f22076c.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22080g);
            DisposableHelper.dispose(this.f22079f);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22080g.get());
        }

        public void onComplete() {
            DisposableHelper.replace(this.f22080g, (Disposable) null);
            this.f22082i = false;
            this.f22078e.onNext(0);
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f22079f);
            HalfSerializer.onError((Observer<?>) this.f22075b, th2, (AtomicInteger) this, this.f22077d);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f22075b, t11, (AtomicInteger) this, this.f22077d);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22080g, disposable);
        }
    }

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f22074c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Subject serialized = PublishSubject.create().toSerialized();
        try {
            Object apply = this.f22074c.apply(serialized);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serialized, this.f21304b);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f22079f);
            repeatWhenObserver.d();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
