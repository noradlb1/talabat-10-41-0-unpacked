package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Notification<R>> f21639c;

    public static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21640b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Notification<R>> f21641c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21642d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f21643e;

        public DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
            this.f21640b = observer;
            this.f21641c = function;
        }

        public void dispose() {
            this.f21643e.dispose();
        }

        public boolean isDisposed() {
            return this.f21643e.isDisposed();
        }

        public void onComplete() {
            if (!this.f21642d) {
                this.f21642d = true;
                this.f21640b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21642d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21642d = true;
            this.f21640b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21642d) {
                try {
                    Object apply = this.f21641c.apply(t11);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification = (Notification) apply;
                    if (notification.isOnError()) {
                        this.f21643e.dispose();
                        onError(notification.getError());
                    } else if (notification.isOnComplete()) {
                        this.f21643e.dispose();
                        onComplete();
                    } else {
                        this.f21640b.onNext(notification.getValue());
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21643e.dispose();
                    onError(th2);
                }
            } else if (t11 instanceof Notification) {
                Notification notification2 = (Notification) t11;
                if (notification2.isOnError()) {
                    RxJavaPlugins.onError(notification2.getError());
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21643e, disposable)) {
                this.f21643e = disposable;
                this.f21640b.onSubscribe(this);
            }
        }
    }

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.f21639c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f21304b.subscribe(new DematerializeObserver(observer, this.f21639c));
    }
}
