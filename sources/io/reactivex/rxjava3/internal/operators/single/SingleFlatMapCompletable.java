package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22875b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f22876c;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f22877b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f22878c;

        public FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f22877b = completableObserver;
            this.f22878c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f22877b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22877b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f22878c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
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
        this.f22875b = singleSource;
        this.f22876c = function;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f22876c);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f22875b.subscribe(flatMapCompletableObserver);
    }
}
