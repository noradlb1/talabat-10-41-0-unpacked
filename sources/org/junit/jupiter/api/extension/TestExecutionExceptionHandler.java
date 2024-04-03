package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface TestExecutionExceptionHandler extends Extension {
    void handleTestExecutionException(ExtensionContext extensionContext, Throwable th2) throws Throwable;
}
