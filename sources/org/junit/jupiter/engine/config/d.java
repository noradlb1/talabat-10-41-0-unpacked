package org.junit.jupiter.engine.config;

import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class d implements Try.Transformer {
    public final Object apply(Object obj) {
        return ReflectionUtils.newInstance((Class) obj, new Object[0]);
    }
}
