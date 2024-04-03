package org.junit.jupiter.engine.discovery;

import j$.util.Optional;
import j$.util.function.Supplier;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;

class MethodFinder {
    private static final Pattern METHOD_PATTERN = Pattern.compile("(.+)\\((.*)\\)");

    public Optional<Method> b(String str, Class<?> cls) {
        Matcher matcher = METHOD_PATTERN.matcher(str);
        Preconditions.condition(matcher.matches(), (Supplier<String>) new b0(str));
        return ReflectionUtils.findMethod(cls, matcher.group(1), matcher.group(2));
    }
}
