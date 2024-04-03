package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@CheckForNull String str) {
        super(str);
    }

    public VerifyException(@CheckForNull Throwable th2) {
        super(th2);
    }

    public VerifyException(@CheckForNull String str, @CheckForNull Throwable th2) {
        super(str, th2);
    }
}
