package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Observable<T>, ? extends ObservableSource<R>> f22019c;

    public static final class SourceObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final PublishSubject<T> f22020b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f22021c;

        public SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.f22020b = publishSubject;
            this.f22021c = atomicReference;
        }

        public void onComplete() {
            this.f22020b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22020b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22020b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22021c, disposable);
        }
    }

    public static final class TargetObserver<R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22022b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22023c;

        public TargetObserver(Observer<? super R> observer) {
            this.f22022b = observer;
        }

        public void dispose() {
            this.f22023c.dispose();
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.f22023c.isDisposed();
        }

        public void onComplete() {
            DisposableHelper.dispose(this);
            this.f22022b.onComplete();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this);
            this.f22022b.onError(th2);
        }

        public void onNext(R r11) {
            this.f22022b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22023c, disposable)) {
                this.f22023c = disposable;
                this.f22022b.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f22019c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        PublishSubject create = PublishSubject.create();
        try {
            Object apply = this.f22019c.apply(create);
            Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.f21304b.subscribe(new SourceObserver(create, targetObserver));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
