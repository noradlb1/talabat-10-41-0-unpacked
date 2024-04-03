package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCreate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleOnSubscribe<T> f18233b;

    public static final class Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18234b;

        public Emitter(SingleObserver<? super T> singleObserver) {
            this.f18234b = singleObserver;
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
                        this.f18234b.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                    } catch (Throwable th2) {
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        throw th2;
                    }
                } else {
                    this.f18234b.onSuccess(t11);
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
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.f18234b.onError(th2);
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
    }

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.f18233b = singleOnSubscribe;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Emitter emitter = new Emitter(singleObserver);
        singleObserver.onSubscribe(emitter);
        try {
            this.f18233b.subscribe(emitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            emitter.onError(th2);
        }
    }
}
