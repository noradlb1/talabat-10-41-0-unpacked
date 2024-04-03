package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;

public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends U> f21940c;

    public static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, ? extends U> f21941g;

        public MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f21941g = function;
        }

        public void onNext(T t11) {
            if (!this.f19009e) {
                if (this.f19010f != 0) {
                    this.f19006b.onNext(null);
                    return;
                }
                try {
                    Object apply = this.f21941g.apply(t11);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.f19006b.onNext(apply);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public U poll() throws Throwable {
            T poll = this.f19008d.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f21941g.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f21940c = function;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f21304b.subscribe(new MapObserver(observer, this.f21940c));
    }
}
