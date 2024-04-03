package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.9", status = API.Status.EXPERIMENTAL)
public interface TestInstancePreConstructCallback extends Extension {
    void preConstructTestInstance(TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext) throws Exception;
}
