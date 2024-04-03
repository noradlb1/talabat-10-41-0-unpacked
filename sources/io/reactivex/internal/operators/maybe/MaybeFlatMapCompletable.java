package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16386b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f16387c;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f16388b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f16389c;

        public FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f16388b = completableObserver;
            this.f16389c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16388b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16388b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f16389c.apply(t11), "The mapper returned a null CompletableSource");
                if (!isDisposed()) {
                    completableSource.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.f16386b = maybeSource;
        this.f16387c = function;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f16387c);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f16386b.subscribe(flatMapCompletableObserver);
    }
}
