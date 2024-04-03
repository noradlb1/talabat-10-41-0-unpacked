package m30;

import j$.util.Optional;
import j$.util.function.Function;
import org.junit.platform.commons.util.ModuleUtils;
import org.junit.platform.commons.util.PackageUtils;
import org.junit.platform.engine.TestEngine;

public final /* synthetic */ class r {
    public static Optional a(TestEngine testEngine) {
        Optional<String> moduleName = ModuleUtils.getModuleName(testEngine.getClass());
        if (moduleName.isPresent()) {
            return moduleName;
        }
        return PackageUtils.getAttribute(testEngine.getClass(), (Function<Package, String>) new p());
    }

    public static Optional b(TestEngine testEngine) {
        return Optional.empty();
    }

    public static Optional c(TestEngine testEngine) {
        Class<?> cls = testEngine.getClass();
        Optional<String> attribute = PackageUtils.getAttribute(cls, "Engine-Version-" + testEngine.getId());
        if (attribute.isPresent()) {
            return attribute;
        }
        Optional<String> moduleVersion = ModuleUtils.getModuleVersion(testEngine.getClass());
        if (moduleVersion.isPresent()) {
            return moduleVersion;
        }
        return Optional.of(PackageUtils.getAttribute(testEngine.getClass(), (Function<Package, String>) new q()).orElse("DEVELOPMENT"));
    }
}
