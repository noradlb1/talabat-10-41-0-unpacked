package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Action f17130c;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17131b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f17132c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17133d;

        /* renamed from: e  reason: collision with root package name */
        public QueueDisposable<T> f17134e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17135f;

        public DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.f17131b = observer;
            this.f17132c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f17132c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void clear() {
            this.f17134e.clear();
        }

        public void dispose() {
            this.f17133d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f17133d.isDisposed();
        }

        public boolean isEmpty() {
            return this.f17134e.isEmpty();
        }

        public void onComplete() {
            this.f17131b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f17131b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f17131b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17133d, disposable)) {
                this.f17133d = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f17134e = (QueueDisposable) disposable;
                }
                this.f17131b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f17134e.poll();
            if (poll == null && this.f17135f) {
                a();
            }
            return poll;
        }

        public int requestFusion(int i11) {
            QueueDisposable<T> queueDisposable = this.f17134e;
            boolean z11 = false;
            if (queueDisposable == null || (i11 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i11);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z11 = true;
                }
                this.f17135f = z11;
            }
            return requestFusion;
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f17130c = action;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DoFinallyObserver(observer, this.f17130c));
    }
}
