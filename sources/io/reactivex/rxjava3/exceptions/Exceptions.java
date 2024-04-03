package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static RuntimeException propagate(@NonNull Throwable th2) {
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public static void throwIfFatal(@NonNull Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }
}
