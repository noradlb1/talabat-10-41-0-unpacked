package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: b */
    public void a(@NonNull Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + get() + ")";
    }
}
