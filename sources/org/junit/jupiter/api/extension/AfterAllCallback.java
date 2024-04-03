package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface AfterAllCallback extends Extension {
    void afterAll(ExtensionContext extensionContext) throws Exception;
}
