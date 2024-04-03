package org.junit.platform.commons.util;

import org.apiguardian.api.API;

@Deprecated
@API(since = "1.7", status = API.Status.DEPRECATED)
public final class BlacklistedExceptions {
    private BlacklistedExceptions() {
    }

    @Deprecated
    public static void rethrowIfBlacklisted(Throwable th2) {
        UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
    }
}
