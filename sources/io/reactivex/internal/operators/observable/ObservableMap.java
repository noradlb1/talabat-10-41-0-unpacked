package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends U> f17393c;

    public static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends U> f17394g;

        public MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f17394g = function;
        }

        public void onNext(T t11) {
            if (!this.f14533e) {
                if (this.f14534f != 0) {
                    this.f14530b.onNext(null);
                    return;
                }
                try {
                    this.f14530b.onNext(ObjectHelper.requireNonNull(this.f17394g.apply(t11), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public U poll() throws Exception {
            T poll = this.f14532d.poll();
            if (poll != null) {
                return ObjectHelper.requireNonNull(this.f17394g.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f17393c = function;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f16799b.subscribe(new MapObserver(observer, this.f17393c));
    }
}
