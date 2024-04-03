package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f21675c;

    /* renamed from: d  reason: collision with root package name */
    public final T f21676d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21677e;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21678b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21679c;

        /* renamed from: d  reason: collision with root package name */
        public final T f21680d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f21681e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f21682f;

        /* renamed from: g  reason: collision with root package name */
        public long f21683g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f21684h;

        public ElementAtObserver(Observer<? super T> observer, long j11, T t11, boolean z11) {
            this.f21678b = observer;
            this.f21679c = j11;
            this.f21680d = t11;
            this.f21681e = z11;
        }

        public void dispose() {
            this.f21682f.dispose();
        }

        public boolean isDisposed() {
            return this.f21682f.isDisposed();
        }

        public void onComplete() {
            if (!this.f21684h) {
                this.f21684h = true;
                T t11 = this.f21680d;
                if (t11 != null || !this.f21681e) {
                    if (t11 != null) {
                        this.f21678b.onNext(t11);
                    }
                    this.f21678b.onComplete();
                    return;
                }
                this.f21678b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            if (this.f21684h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21684h = true;
            this.f21678b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21684h) {
                long j11 = this.f21683g;
                if (j11 == this.f21679c) {
                    this.f21684h = true;
                    this.f21682f.dispose();
                    this.f21678b.onNext(t11);
                    this.f21678b.onComplete();
                    return;
                }
                this.f21683g = j11 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21682f, disposable)) {
                this.f21682f = disposable;
                this.f21678b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j11, T t11, boolean z11) {
        super(observableSource);
        this.f21675c = j11;
        this.f21676d = t11;
        this.f21677e = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new ElementAtObserver(observer, this.f21675c, this.f21676d, this.f21677e));
    }
}
