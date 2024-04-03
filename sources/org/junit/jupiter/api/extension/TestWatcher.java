package org.junit.jupiter.api.extension;

import j$.util.Optional;
import org.apiguardian.api.API;

@API(since = "5.7", status = API.Status.STABLE)
public interface TestWatcher extends Extension {
    void testAborted(ExtensionContext extensionContext, Throwable th2);

    void testDisabled(ExtensionContext extensionContext, Optional<String> optional);

    void testFailed(ExtensionContext extensionContext, Throwable th2);

    void testSuccessful(ExtensionContext extensionContext);
}
