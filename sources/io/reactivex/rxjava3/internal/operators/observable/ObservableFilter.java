package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f21702c;

    public static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Predicate<? super T> f21703g;

        public FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.f21703g = predicate;
        }

        public void onNext(T t11) {
            if (this.f19010f == 0) {
                try {
                    if (this.f21703g.test(t11)) {
                        this.f19006b.onNext(t11);
                    }
                } catch (Throwable th2) {
                    c(th2);
                }
            } else {
                this.f19006b.onNext(null);
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        @io.reactivex.rxjava3.annotations.Nullable
        public T poll() throws java.lang.Throwable {
            /*
                r2 = this;
            L_0x0000:
                io.reactivex.rxjava3.operators.QueueDisposable<T> r0 = r2.f19008d
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                io.reactivex.rxjava3.functions.Predicate<? super T> r1 = r2.f21703g
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableFilter.FilterObserver.poll():java.lang.Object");
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f21702c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new FilterObserver(observer, this.f21702c));
    }
}
