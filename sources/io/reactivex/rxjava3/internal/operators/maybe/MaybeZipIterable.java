package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMap;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;
import java.util.Objects;

public final class MaybeZipIterable<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends MaybeSource<? extends T>> f21094b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f21095c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            R apply = MaybeZipIterable.this.f21095c.apply(new Object[]{t11});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f21094b = iterable;
        this.f21095c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i11 = 0;
            for (MaybeSource maybeSource : this.f21094b) {
                if (maybeSource == null) {
                    EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (MaybeObserver<?>) maybeObserver);
                    return;
                }
                if (i11 == maybeSourceArr.length) {
                    maybeSourceArr = (MaybeSource[]) Arrays.copyOf(maybeSourceArr, (i11 >> 2) + i11);
                }
                int i12 = i11 + 1;
                maybeSourceArr[i11] = maybeSource;
                i11 = i12;
            }
            if (i11 == 0) {
                EmptyDisposable.complete((MaybeObserver<?>) maybeObserver);
            } else if (i11 == 1) {
                maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            } else {
                MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(maybeObserver, i11, this.f21095c);
                maybeObserver.onSubscribe(zipCoordinator);
                for (int i13 = 0; i13 < i11 && !zipCoordinator.isDisposed(); i13++) {
                    maybeSourceArr[i13].subscribe(zipCoordinator.f21090d[i13]);
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }
}
