package io.reactivex.internal.operators.single;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18326b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f18327c;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f18328b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f18329c;

        public FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f18328b = completableObserver;
            this.f18329c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f18328b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18328b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f18329c.apply(t11), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    completableSource.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public SingleFlatMapCompletable(SingleSource<T> singleSource, Function<? super T, ? extends CompletableSource> function) {
        this.f18326b = singleSource;
        this.f18327c = function;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f18327c);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f18326b.subscribe(flatMapCompletableObserver);
    }
}
