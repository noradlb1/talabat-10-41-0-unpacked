package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f17128c;

    public static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<? super T> f17129g;

        public DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f17129g = consumer;
        }

        public void onNext(T t11) {
            this.f14530b.onNext(t11);
            if (this.f14534f == 0) {
                try {
                    this.f17129g.accept(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f14532d.poll();
            if (poll != null) {
                this.f17129g.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f17128c = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DoAfterObserver(observer, this.f17128c));
    }
}
