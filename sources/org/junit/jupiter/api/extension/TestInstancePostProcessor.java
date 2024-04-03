package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface TestInstancePostProcessor extends Extension {
    void postProcessTestInstance(Object obj, ExtensionContext extensionContext) throws Exception;
}
