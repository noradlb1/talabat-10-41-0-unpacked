package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f17701c;

    public final class SkipUntil implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        public final ArrayCompositeDisposable f17702b;

        /* renamed from: c  reason: collision with root package name */
        public final SkipUntilObserver<T> f17703c;

        /* renamed from: d  reason: collision with root package name */
        public final SerializedObserver<T> f17704d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17705e;

        public SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.f17702b = arrayCompositeDisposable;
            this.f17703c = skipUntilObserver;
            this.f17704d = serializedObserver;
        }

        public void onComplete() {
            this.f17703c.f17710e = true;
        }

        public void onError(Throwable th2) {
            this.f17702b.dispose();
            this.f17704d.onError(th2);
        }

        public void onNext(U u11) {
            this.f17705e.dispose();
            this.f17703c.f17710e = true;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17705e, disposable)) {
                this.f17705e = disposable;
                this.f17702b.setResource(1, disposable);
            }
        }
    }

    public static final class SkipUntilObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17707b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayCompositeDisposable f17708c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17709d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f17710e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17711f;

        public SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f17707b = observer;
            this.f17708c = arrayCompositeDisposable;
        }

        public void onComplete() {
            this.f17708c.dispose();
            this.f17707b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17708c.dispose();
            this.f17707b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17711f) {
                this.f17707b.onNext(t11);
            } else if (this.f17710e) {
                this.f17711f = true;
                this.f17707b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17709d, disposable)) {
                this.f17709d = disposable;
                this.f17708c.setResource(0, disposable);
            }
        }
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f17701c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.f17701c.subscribe(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.f16799b.subscribe(skipUntilObserver);
    }
}
