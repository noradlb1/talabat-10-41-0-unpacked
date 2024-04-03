package org.junit.jupiter.engine.extension;

import com.visa.checkout.Profile;
import j$.util.Optional;
import java.lang.reflect.Method;
import java.util.Set;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.ToStringBuilder;

class TestInfoParameterResolver implements ParameterResolver {

    public static class DefaultTestInfo implements TestInfo {
        private final String displayName;
        private final Set<String> tags;
        private final Optional<Class<?>> testClass;
        private final Optional<Method> testMethod;

        public DefaultTestInfo(ExtensionContext extensionContext) {
            this.displayName = extensionContext.getDisplayName();
            this.tags = extensionContext.getTags();
            this.testClass = extensionContext.getTestClass();
            this.testMethod = extensionContext.getTestMethod();
        }

        private static Object nullSafeGet(Optional<?> optional) {
            if (optional != null) {
                return optional.orElse(null);
            }
            return null;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public Set<String> getTags() {
            return this.tags;
        }

        public Optional<Class<?>> getTestClass() {
            return this.testClass;
        }

        public Optional<Method> getTestMethod() {
            return this.testMethod;
        }

        public String toString() {
            return new ToStringBuilder((Object) this).append(Profile.DISPLAY_NAME, this.displayName).append("tags", this.tags).append("testClass", nullSafeGet(this.testClass)).append("testMethod", nullSafeGet(this.testMethod)).toString();
        }
    }

    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == TestInfo.class;
    }

    public TestInfo resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return new DefaultTestInfo(extensionContext);
    }
}
