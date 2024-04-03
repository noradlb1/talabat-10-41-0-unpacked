package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;

public final class MaybeZipIterable<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends MaybeSource<? extends T>> f16581b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f16582c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Exception {
            return ObjectHelper.requireNonNull(MaybeZipIterable.this.f16582c.apply(new Object[]{t11}), "The zipper returned a null value");
        }
    }

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f16581b = iterable;
        this.f16582c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i11 = 0;
            for (MaybeSource maybeSource : this.f16581b) {
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
                MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(maybeObserver, i11, this.f16582c);
                maybeObserver.onSubscribe(zipCoordinator);
                for (int i13 = 0; i13 < i11 && !zipCoordinator.isDisposed(); i13++) {
                    maybeSourceArr[i13].subscribe(zipCoordinator.f16577d[i13]);
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }
}
