package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import j$.util.Optional;
import java.util.Objects;

public final class ObservableMapOptional<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f18942b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, Optional<? extends R>> f18943c;

    public static final class MapOptionalObserver<T, R> extends BasicFuseableObserver<T, R> {

        /* renamed from: g  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18944g;

        public MapOptionalObserver(Observer<? super R> observer, Function<? super T, Optional<? extends R>> function) {
            super(observer);
            this.f18944g = function;
        }

        public void onNext(T t11) {
            if (!this.f19009e) {
                if (this.f19010f != 0) {
                    this.f19006b.onNext(null);
                    return;
                }
                try {
                    Optional<? extends R> apply = this.f18944g.apply(t11);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional optional = apply;
                    if (optional.isPresent()) {
                        this.f19006b.onNext(optional.get());
                    }
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        public R poll() throws Throwable {
            Optional optional;
            do {
                T poll = this.f19008d.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.f18944g.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                optional = apply;
            } while (!optional.isPresent());
            return optional.get();
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public ObservableMapOptional(Observable<T> observable, Function<? super T, Optional<? extends R>> function) {
        this.f18942b = observable;
        this.f18943c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f18942b.subscribe(new MapOptionalObserver(observer, this.f18943c));
    }
}
