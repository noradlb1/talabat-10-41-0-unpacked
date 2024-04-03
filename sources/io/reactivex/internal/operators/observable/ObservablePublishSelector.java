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
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Observable<T>, ? extends ObservableSource<R>> f17480c;

    public static final class SourceObserver<T, R> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final PublishSubject<T> f17481b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17482c;

        public SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.f17481b = publishSubject;
            this.f17482c = atomicReference;
        }

        public void onComplete() {
            this.f17481b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17481b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17481b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17482c, disposable);
        }
    }

    public static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17483b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17484c;

        public TargetObserver(Observer<? super R> observer) {
            this.f17483b = observer;
        }

        public void dispose() {
            this.f17484c.dispose();
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.f17484c.isDisposed();
        }

        public void onComplete() {
            DisposableHelper.dispose(this);
            this.f17483b.onComplete();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this);
            this.f17483b.onError(th2);
        }

        public void onNext(R r11) {
            this.f17483b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17484c, disposable)) {
                this.f17484c = disposable;
                this.f17483b.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f17480c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        PublishSubject create = PublishSubject.create();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17480c.apply(create), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.f16799b.subscribe(new SourceObserver(create, targetObserver));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
