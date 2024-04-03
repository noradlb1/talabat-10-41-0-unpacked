package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;

public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, K> f21646c;

    /* renamed from: d  reason: collision with root package name */
    public final Supplier<? extends Collection<? super K>> f21647d;

    public static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* renamed from: g  reason: collision with root package name */
        public final Collection<? super K> f21648g;

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super T, K> f21649h;

        public DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.f21649h = function;
            this.f21648g = collection;
        }

        public void clear() {
            this.f21648g.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.f19009e) {
                this.f19009e = true;
                this.f21648g.clear();
                this.f19006b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19009e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19009e = true;
            this.f21648g.clear();
            this.f19006b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19009e) {
                if (this.f19010f == 0) {
                    try {
                        K apply = this.f21649h.apply(t11);
                        Objects.requireNonNull(apply, "The keySelector returned a null key");
                        if (this.f21648g.add(apply)) {
                            this.f19006b.onNext(t11);
                        }
                    } catch (Throwable th2) {
                        c(th2);
                    }
                } else {
                    this.f19006b.onNext(null);
                }
            }
        }

        @Nullable
        public T poll() throws Throwable {
            T poll;
            Collection<? super K> collection;
            K apply;
            do {
                poll = this.f19008d.poll();
                if (poll == null) {
                    break;
                }
                collection = this.f21648g;
                apply = this.f21649h.apply(poll);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
            } while (!collection.add(apply));
            return poll;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Supplier<? extends Collection<? super K>> supplier) {
        super(observableSource);
        this.f21646c = function;
        this.f21647d = supplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            this.f21304b.subscribe(new DistinctObserver(observer, this.f21646c, (Collection) ExceptionHelper.nullCheck(this.f21647d.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
