package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCreate extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableOnSubscribe f19111b;

    public static final class Emitter extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19112b;

        public Emitter(CompletableObserver completableObserver) {
            this.f19112b = completableObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            Disposable disposable;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    this.f19112b.onComplete();
                } finally {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                }
            }
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
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
                this.f19112b.onError(th2);
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
    }

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.f19111b = completableOnSubscribe;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Emitter emitter = new Emitter(completableObserver);
        completableObserver.onSubscribe(emitter);
        try {
            this.f19111b.subscribe(emitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            emitter.onError(th2);
        }
    }
}
