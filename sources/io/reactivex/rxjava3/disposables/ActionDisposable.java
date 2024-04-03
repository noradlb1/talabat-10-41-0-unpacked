package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action action) {
        super(action);
    }

    /* renamed from: b */
    public void a(@NonNull Action action) {
        try {
            action.run();
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public String toString() {
        return "ActionDisposable(disposed=" + isDisposed() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + get() + ")";
    }
}
