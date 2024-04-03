package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final int f22225c;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3807491841935125653L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22226b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22227c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22228d;

        public SkipLastObserver(Observer<? super T> observer, int i11) {
            super(i11);
            this.f22226b = observer;
            this.f22227c = i11;
        }

        public void dispose() {
            this.f22228d.dispose();
        }

        public boolean isDisposed() {
            return this.f22228d.isDisposed();
        }

        public void onComplete() {
            this.f22226b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22226b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f22227c == size()) {
                this.f22226b.onNext(poll());
            }
            offer(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22228d, disposable)) {
                this.f22228d = disposable;
                this.f22226b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i11) {
        super(observableSource);
        this.f22225c = i11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new SkipLastObserver(observer, this.f22225c));
    }
}
