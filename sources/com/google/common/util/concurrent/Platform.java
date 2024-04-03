package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {
    private Platform() {
    }

    public static boolean isInstanceOfThrowableClass(@CheckForNull Throwable th2, Class<? extends Throwable> cls) {
        return cls.isInstance(th2);
    }

    public static void restoreInterruptIfIsInterruptedException(Throwable th2) {
        Preconditions.checkNotNull(th2);
        if (th2 instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
