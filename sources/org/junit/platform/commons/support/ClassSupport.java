package org.junit.platform.commons.support;

import j$.util.function.Function;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ClassUtils;

@API(since = "1.1", status = API.Status.MAINTAINED)
public final class ClassSupport {
    private ClassSupport() {
    }

    public static String nullSafeToString(Class<?>... clsArr) {
        return ClassUtils.nullSafeToString(clsArr);
    }

    public static String nullSafeToString(Function<? super Class<?>, ? extends String> function, Class<?>... clsArr) {
        return ClassUtils.nullSafeToString(function, clsArr);
    }
}
