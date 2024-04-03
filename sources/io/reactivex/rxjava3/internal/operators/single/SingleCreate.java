package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCreate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleOnSubscribe<T> f22767b;

    public static final class Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22768b;

        public Emitter(SingleObserver<? super T> singleObserver) {
            this.f22768b = singleObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSuccess(T t11) {
            Disposable disposable;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                if (t11 == null) {
                    try {
                        this.f22768b.onError(ExceptionHelper.createNullPointerException("onSuccess called with a null value."));
                    } catch (Throwable th2) {
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        throw th2;
                    }
                } else {
                    this.f22768b.onSuccess(t11);
                }
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }

        public void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{Emitter.class.getSimpleName(), super.toString()});
        }

        public boolean tryOnError(Throwable th2) {
            Disposable disposable;
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.f22768b.onError(th2);
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
    }

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.f22767b = singleOnSubscribe;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Emitter emitter = new Emitter(singleObserver);
        singleObserver.onSubscribe(emitter);
        try {
            this.f22767b.subscribe(emitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            emitter.onError(th2);
        }
    }
}
