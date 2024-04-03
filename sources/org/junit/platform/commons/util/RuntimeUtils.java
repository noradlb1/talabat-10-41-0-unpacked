package org.junit.platform.commons.util;

import j$.util.Optional;
import java.util.List;
import l30.i2;
import org.apiguardian.api.API;

@API(since = "1.6", status = API.Status.INTERNAL)
public final class RuntimeUtils {
    private RuntimeUtils() {
    }

    public static Optional<List<String>> c() {
        Optional<Class<?>> optional = ReflectionUtils.tryToLoadClass("java.lang.management.ManagementFactory").toOptional();
        if (!optional.isPresent()) {
            return Optional.empty();
        }
        try {
            return Optional.of((List) ReflectionUtils.tryToLoadClass("java.lang.management.RuntimeMXBean").get().getMethod("getInputArguments", new Class[0]).invoke(optional.get().getMethod("getRuntimeMXBean", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]));
        } catch (Exception unused) {
            return Optional.empty();
        }
    }

    public static boolean isDebugMode() {
        return ((Boolean) c().map(new i2()).orElse(Boolean.FALSE)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isDebugMode$0(String str) {
        if (str.startsWith("-agentlib:jdwp") || str.startsWith("-Xrunjdwp")) {
            return true;
        }
        return false;
    }
}
