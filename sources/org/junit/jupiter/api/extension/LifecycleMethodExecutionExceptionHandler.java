package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@API(since = "5.5", status = API.Status.EXPERIMENTAL)
public interface LifecycleMethodExecutionExceptionHandler extends Extension {
    void handleAfterAllMethodExecutionException(ExtensionContext extensionContext, Throwable th2) throws Throwable;

    void handleAfterEachMethodExecutionException(ExtensionContext extensionContext, Throwable th2) throws Throwable;

    void handleBeforeAllMethodExecutionException(ExtensionContext extensionContext, Throwable th2) throws Throwable;

    void handleBeforeEachMethodExecutionException(ExtensionContext extensionContext, Throwable th2) throws Throwable;
}
