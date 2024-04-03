package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final int f22293c;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22294b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22295c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22296d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f22297e;

        public TakeLastObserver(Observer<? super T> observer, int i11) {
            this.f22294b = observer;
            this.f22295c = i11;
        }

        public void dispose() {
            if (!this.f22297e) {
                this.f22297e = true;
                this.f22296d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f22297e;
        }

        public void onComplete() {
            Observer<? super T> observer = this.f22294b;
            while (!this.f22297e) {
                Object poll = poll();
                if (poll == null) {
                    observer.onComplete();
                    return;
                }
                observer.onNext(poll);
            }
        }

        public void onError(Throwable th2) {
            this.f22294b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f22295c == size()) {
                poll();
            }
            offer(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22296d, disposable)) {
                this.f22296d = disposable;
                this.f22294b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i11) {
        super(observableSource);
        this.f22293c = i11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new TakeLastObserver(observer, this.f22293c));
    }
}
