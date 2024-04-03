package org.junit.platform.commons.util;

import f30.l;
import j$.util.DesugarArrays;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import l30.x;
import org.apiguardian.api.API;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class ClassUtils {
    private ClassUtils() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$nullSafeToString$0(Function function, Class cls) {
        if (cls == null) {
            return "null";
        }
        return (String) function.apply(cls);
    }

    public static String nullSafeToString(Class<?> cls) {
        return cls == null ? "null" : cls.getName();
    }

    public static String nullSafeToString(Class<?>... clsArr) {
        return nullSafeToString(new l(), clsArr);
    }

    public static String nullSafeToString(Function<? super Class<?>, ? extends String> function, Class<?>... clsArr) {
        Preconditions.notNull(function, "Mapping function must not be null");
        return (clsArr == null || clsArr.length == 0) ? "" : (String) DesugarArrays.stream((T[]) clsArr).map(new x(function)).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
    }
}
