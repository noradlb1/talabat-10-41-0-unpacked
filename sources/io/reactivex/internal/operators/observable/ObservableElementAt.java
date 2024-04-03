package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17147c;

    /* renamed from: d  reason: collision with root package name */
    public final T f17148d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17149e;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17150b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17151c;

        /* renamed from: d  reason: collision with root package name */
        public final T f17152d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17153e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17154f;

        /* renamed from: g  reason: collision with root package name */
        public long f17155g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17156h;

        public ElementAtObserver(Observer<? super T> observer, long j11, T t11, boolean z11) {
            this.f17150b = observer;
            this.f17151c = j11;
            this.f17152d = t11;
            this.f17153e = z11;
        }

        public void dispose() {
            this.f17154f.dispose();
        }

        public boolean isDisposed() {
            return this.f17154f.isDisposed();
        }

        public void onComplete() {
            if (!this.f17156h) {
                this.f17156h = true;
                T t11 = this.f17152d;
                if (t11 != null || !this.f17153e) {
                    if (t11 != null) {
                        this.f17150b.onNext(t11);
                    }
                    this.f17150b.onComplete();
                    return;
                }
                this.f17150b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            if (this.f17156h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17156h = true;
            this.f17150b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17156h) {
                long j11 = this.f17155g;
                if (j11 == this.f17151c) {
                    this.f17156h = true;
                    this.f17154f.dispose();
                    this.f17150b.onNext(t11);
                    this.f17150b.onComplete();
                    return;
                }
                this.f17155g = j11 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17154f, disposable)) {
                this.f17154f = disposable;
                this.f17150b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j11, T t11, boolean z11) {
        super(observableSource);
        this.f17147c = j11;
        this.f17148d = t11;
        this.f17149e = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new ElementAtObserver(observer, this.f17147c, this.f17148d, this.f17149e));
    }
}
