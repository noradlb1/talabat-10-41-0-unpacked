package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, K> f17118c;

    /* renamed from: d  reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f17119d;

    public static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Collection<? super K> f17120g;

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super T, K> f17121h;

        public DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.f17121h = function;
            this.f17120g = collection;
        }

        public void clear() {
            this.f17120g.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.f14533e) {
                this.f14533e = true;
                this.f17120g.clear();
                this.f14530b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14533e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14533e = true;
            this.f17120g.clear();
            this.f14530b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14533e) {
                if (this.f14534f == 0) {
                    try {
                        if (this.f17120g.add(ObjectHelper.requireNonNull(this.f17121h.apply(t11), "The keySelector returned a null key"))) {
                            this.f14530b.onNext(t11);
                        }
                    } catch (Throwable th2) {
                        c(th2);
                    }
                } else {
                    this.f14530b.onNext(null);
                }
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            /*
                r4 = this;
            L_0x0000:
                io.reactivex.internal.fuseable.QueueDisposable<T> r0 = r4.f14532d
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x001c
                java.util.Collection<? super K> r1 = r4.f17120g
                io.reactivex.functions.Function<? super T, K> r2 = r4.f17121h
                java.lang.Object r2 = r2.apply(r0)
                java.lang.String r3 = "The keySelector returned a null key"
                java.lang.Object r2 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, (java.lang.String) r3)
                boolean r1 = r1.add(r2)
                if (r1 == 0) goto L_0x0000
            L_0x001c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableDistinct.DistinctObserver.poll():java.lang.Object");
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.f17118c = function;
        this.f17119d = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            this.f16799b.subscribe(new DistinctObserver(observer, this.f17118c, (Collection) ObjectHelper.requireNonNull(this.f17119d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
