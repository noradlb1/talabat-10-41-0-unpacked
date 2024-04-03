package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class AutoCloseableDisposable extends ReferenceDisposable<AutoCloseable> {
    private static final long serialVersionUID = -6646144244598696847L;

    public AutoCloseableDisposable(AutoCloseable autoCloseable) {
        super(autoCloseable);
    }

    /* renamed from: b */
    public void a(@NonNull AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public String toString() {
        return "AutoCloseableDisposable(disposed=" + isDisposed() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + get() + ")";
    }
}
