package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCreate extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableOnSubscribe f14626b;

    public static final class Emitter extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14627b;

        public Emitter(CompletableObserver completableObserver) {
            this.f14627b = completableObserver;
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
                    this.f14627b.onComplete();
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
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.f14627b.onError(th2);
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }
    }

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.f14626b = completableOnSubscribe;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Emitter emitter = new Emitter(completableObserver);
        completableObserver.onSubscribe(emitter);
        try {
            this.f14626b.subscribe(emitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            emitter.onError(th2);
        }
    }
}
