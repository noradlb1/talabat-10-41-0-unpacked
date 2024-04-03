package org.junit.platform.commons.util;

import j$.util.Optional;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import l30.j0;
import l30.k0;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

@API(since = "1.1", status = API.Status.INTERNAL)
public class ModuleUtils {
    private static final Logger logger = LoggerFactory.getLogger(ModuleUtils.class);

    public static List<Class<?>> findAllClassesInModule(String str, ClassFilter classFilter) {
        Preconditions.notBlank(str, "Module name must not be null or empty");
        Preconditions.notNull(classFilter, "Class filter must not be null");
        logger.config(new j0());
        return Collections.emptyList();
    }

    public static Set<String> findAllNonSystemBootModuleNames() {
        logger.config(new k0());
        return Collections.emptySet();
    }

    public static Optional<String> getModuleName(Class<?> cls) {
        return Optional.empty();
    }

    public static Optional<String> getModuleVersion(Class<?> cls) {
        return Optional.empty();
    }

    public static boolean isJavaPlatformModuleSystemAvailable() {
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findAllClassesInModule$1() {
        return "Basic version of findAllClassesInModule() always returns an empty list!";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findAllNonSystemBootModuleNames$0() {
        return "Basic version of findAllNonSystemBootModuleNames() always returns an empty set!";
    }
}
