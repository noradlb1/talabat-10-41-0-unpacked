package org.junit.jupiter.engine.extension;

import g30.n;
import java.util.Objects;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

class TestReporterParameterResolver implements ParameterResolver {
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == TestReporter.class;
    }

    public TestReporter resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        Objects.requireNonNull(extensionContext);
        return new n(extensionContext);
    }
}
