package org.junit.jupiter.api.extension;

import j$.util.stream.Stream;
import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public interface TestTemplateInvocationContextProvider extends Extension {
    Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext);

    boolean supportsTestTemplate(ExtensionContext extensionContext);
}
