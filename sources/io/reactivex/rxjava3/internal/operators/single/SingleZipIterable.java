package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;
import io.reactivex.rxjava3.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class SingleZipIterable<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends SingleSource<? extends T>> f23013b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f23014c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            R apply = SingleZipIterable.this.f23014c.apply(new Object[]{t11});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f23013b = iterable;
        this.f23014c = function;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            int i11 = 0;
            for (SingleSource singleSource : this.f23013b) {
                if (singleSource == null) {
                    EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (SingleObserver<?>) singleObserver);
                    return;
                }
                if (i11 == singleSourceArr.length) {
                    singleSourceArr = (SingleSource[]) Arrays.copyOf(singleSourceArr, (i11 >> 2) + i11);
                }
                int i12 = i11 + 1;
                singleSourceArr[i11] = singleSource;
                i11 = i12;
            }
            if (i11 == 0) {
                EmptyDisposable.error((Throwable) new NoSuchElementException(), (SingleObserver<?>) singleObserver);
            } else if (i11 == 1) {
                singleSourceArr[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            } else {
                SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(singleObserver, i11, this.f23014c);
                singleObserver.onSubscribe(zipCoordinator);
                for (int i13 = 0; i13 < i11 && !zipCoordinator.isDisposed(); i13++) {
                    singleSourceArr[i13].subscribe(zipCoordinator.f23009d[i13]);
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
