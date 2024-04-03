package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, K> f21650c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super K, ? super K> f21651d;

    public static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, K> f21652g;

        /* renamed from: h  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f21653h;

        /* renamed from: i  reason: collision with root package name */
        public K f21654i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f21655j;

        public DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f21652g = function;
            this.f21653h = biPredicate;
        }

        public void onNext(T t11) {
            if (!this.f19009e) {
                if (this.f19010f != 0) {
                    this.f19006b.onNext(t11);
                    return;
                }
                try {
                    K apply = this.f21652g.apply(t11);
                    if (this.f21655j) {
                        boolean test = this.f21653h.test(this.f21654i, apply);
                        this.f21654i = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.f21655j = true;
                        this.f21654i = apply;
                    }
                    this.f19006b.onNext(t11);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            while (true) {
                T poll = this.f19008d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f21652g.apply(poll);
                if (!this.f21655j) {
                    this.f21655j = true;
                    this.f21654i = apply;
                    return poll;
                } else if (!this.f21653h.test(this.f21654i, apply)) {
                    this.f21654i = apply;
                    return poll;
                } else {
                    this.f21654i = apply;
                }
            }
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f21650c = function;
        this.f21651d = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DistinctUntilChangedObserver(observer, this.f21650c, this.f21651d));
    }
}
