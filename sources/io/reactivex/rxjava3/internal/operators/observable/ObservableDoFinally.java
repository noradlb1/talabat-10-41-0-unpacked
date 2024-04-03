package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Action f21658c;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21659b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f21660c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21661d;

        /* renamed from: e  reason: collision with root package name */
        public QueueDisposable<T> f21662e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21663f;

        public DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.f21659b = observer;
            this.f21660c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f21660c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void clear() {
            this.f21662e.clear();
        }

        public void dispose() {
            this.f21661d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f21661d.isDisposed();
        }

        public boolean isEmpty() {
            return this.f21662e.isEmpty();
        }

        public void onComplete() {
            this.f21659b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f21659b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f21659b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21661d, disposable)) {
                this.f21661d = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f21662e = (QueueDisposable) disposable;
                }
                this.f21659b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f21662e.poll();
            if (poll == null && this.f21663f) {
                a();
            }
            return poll;
        }

        public int requestFusion(int i11) {
            QueueDisposable<T> queueDisposable = this.f21662e;
            boolean z11 = false;
            if (queueDisposable == null || (i11 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i11);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z11 = true;
                }
                this.f21663f = z11;
            }
            return requestFusion;
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f21658c = action;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DoFinallyObserver(observer, this.f21658c));
    }
}
