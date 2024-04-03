package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.7", status = API.Status.STABLE)
public interface TestInstancePreDestroyCallback extends Extension {
    void preDestroyTestInstance(ExtensionContext extensionContext) throws Exception;
}
