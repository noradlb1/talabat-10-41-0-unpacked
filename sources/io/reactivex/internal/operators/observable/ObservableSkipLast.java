package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final int f17682c;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3807491841935125653L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17683b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17684c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17685d;

        public SkipLastObserver(Observer<? super T> observer, int i11) {
            super(i11);
            this.f17683b = observer;
            this.f17684c = i11;
        }

        public void dispose() {
            this.f17685d.dispose();
        }

        public boolean isDisposed() {
            return this.f17685d.isDisposed();
        }

        public void onComplete() {
            this.f17683b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17683b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17684c == size()) {
                this.f17683b.onNext(poll());
            }
            offer(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17685d, disposable)) {
                this.f17685d = disposable;
                this.f17683b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i11) {
        super(observableSource);
        this.f17682c = i11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new SkipLastObserver(observer, this.f17682c));
    }
}
