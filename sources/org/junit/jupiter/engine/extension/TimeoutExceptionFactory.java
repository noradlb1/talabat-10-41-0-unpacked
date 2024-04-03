package org.junit.jupiter.engine.extension;

import java.util.concurrent.TimeoutException;
import org.junit.platform.commons.util.Preconditions;

class TimeoutExceptionFactory {
    private TimeoutExceptionFactory() {
    }

    public static TimeoutException a(String str, TimeoutDuration timeoutDuration, Throwable th2) {
        TimeoutException timeoutException = new TimeoutException(String.format("%s timed out after %s", new Object[]{Preconditions.notNull(str, "method signature must not be null"), Preconditions.notNull(timeoutDuration, "timeout duration must not be null")}));
        if (th2 != null) {
            timeoutException.addSuppressed(th2);
        }
        return timeoutException;
    }
}
