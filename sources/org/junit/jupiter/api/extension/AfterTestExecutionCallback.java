package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface AfterTestExecutionCallback extends Extension {
    void afterTestExecution(ExtensionContext extensionContext) throws Exception;
}
