package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, K> f17122c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super K, ? super K> f17123d;

    public static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, K> f17124g;

        /* renamed from: h  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f17125h;

        /* renamed from: i  reason: collision with root package name */
        public K f17126i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f17127j;

        public DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f17124g = function;
            this.f17125h = biPredicate;
        }

        public void onNext(T t11) {
            if (!this.f14533e) {
                if (this.f14534f != 0) {
                    this.f14530b.onNext(t11);
                    return;
                }
                try {
                    K apply = this.f17124g.apply(t11);
                    if (this.f17127j) {
                        boolean test = this.f17125h.test(this.f17126i, apply);
                        this.f17126i = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.f17127j = true;
                        this.f17126i = apply;
                    }
                    this.f14530b.onNext(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Exception {
            while (true) {
                T poll = this.f14532d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f17124g.apply(poll);
                if (!this.f17127j) {
                    this.f17127j = true;
                    this.f17126i = apply;
                    return poll;
                } else if (!this.f17125h.test(this.f17126i, apply)) {
                    this.f17126i = apply;
                    return poll;
                } else {
                    this.f17126i = apply;
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f17122c = function;
        this.f17123d = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DistinctUntilChangedObserver(observer, this.f17122c, this.f17123d));
    }
}
