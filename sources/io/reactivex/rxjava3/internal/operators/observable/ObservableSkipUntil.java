package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f22244c;

    public final class SkipUntil implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        public final ArrayCompositeDisposable f22245b;

        /* renamed from: c  reason: collision with root package name */
        public final SkipUntilObserver<T> f22246c;

        /* renamed from: d  reason: collision with root package name */
        public final SerializedObserver<T> f22247d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22248e;

        public SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.f22245b = arrayCompositeDisposable;
            this.f22246c = skipUntilObserver;
            this.f22247d = serializedObserver;
        }

        public void onComplete() {
            this.f22246c.f22253e = true;
        }

        public void onError(Throwable th2) {
            this.f22245b.dispose();
            this.f22247d.onError(th2);
        }

        public void onNext(U u11) {
            this.f22248e.dispose();
            this.f22246c.f22253e = true;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22248e, disposable)) {
                this.f22248e = disposable;
                this.f22245b.setResource(1, disposable);
            }
        }
    }

    public static final class SkipUntilObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22250b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayCompositeDisposable f22251c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22252d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f22253e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22254f;

        public SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f22250b = observer;
            this.f22251c = arrayCompositeDisposable;
        }

        public void onComplete() {
            this.f22251c.dispose();
            this.f22250b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22251c.dispose();
            this.f22250b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f22254f) {
                this.f22250b.onNext(t11);
            } else if (this.f22253e) {
                this.f22254f = true;
                this.f22250b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22252d, disposable)) {
                this.f22252d = disposable;
                this.f22251c.setResource(0, disposable);
            }
        }
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f22244c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.f22244c.subscribe(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.f21304b.subscribe(skipUntilObserver);
    }
}
