package org.junit.jupiter.engine.execution;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

@FunctionalInterface
@API(since = "5.0", status = API.Status.INTERNAL)
public interface AfterEachMethodAdapter extends Extension {
    void invokeAfterEachMethod(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable;
}
