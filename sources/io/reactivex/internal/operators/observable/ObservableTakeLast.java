package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final int f17750c;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17751b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17752c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17753d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f17754e;

        public TakeLastObserver(Observer<? super T> observer, int i11) {
            this.f17751b = observer;
            this.f17752c = i11;
        }

        public void dispose() {
            if (!this.f17754e) {
                this.f17754e = true;
                this.f17753d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f17754e;
        }

        public void onComplete() {
            Observer<? super T> observer = this.f17751b;
            while (!this.f17754e) {
                Object poll = poll();
                if (poll != null) {
                    observer.onNext(poll);
                } else if (!this.f17754e) {
                    observer.onComplete();
                    return;
                } else {
                    return;
                }
            }
        }

        public void onError(Throwable th2) {
            this.f17751b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17752c == size()) {
                poll();
            }
            offer(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17753d, disposable)) {
                this.f17753d = disposable;
                this.f17751b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i11) {
        super(observableSource);
        this.f17750c = i11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new TakeLastObserver(observer, this.f17750c));
    }
}
