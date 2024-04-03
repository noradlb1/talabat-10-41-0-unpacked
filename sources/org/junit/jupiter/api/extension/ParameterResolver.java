package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public interface ParameterResolver extends Extension {
    Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException;

    boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException;
}
