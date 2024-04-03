package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@CheckForNull String str) {
        super(str);
    }

    public UncheckedTimeoutException(@CheckForNull Throwable th2) {
        super(th2);
    }

    public UncheckedTimeoutException(@CheckForNull String str, @CheckForNull Throwable th2) {
        super(str, th2);
    }
}
