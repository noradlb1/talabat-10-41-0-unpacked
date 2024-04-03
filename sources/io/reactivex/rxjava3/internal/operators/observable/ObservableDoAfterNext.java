package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f21656c;

    public static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f21657g;

        public DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f21657g = consumer;
        }

        public void onNext(T t11) {
            this.f19006b.onNext(t11);
            if (this.f19010f == 0) {
                try {
                    this.f21657g.accept(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll = this.f19008d.poll();
            if (poll != null) {
                this.f21657g.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f21656c = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DoAfterObserver(observer, this.f21656c));
    }
}
