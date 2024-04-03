package z20;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.platform.commons.util.Preconditions;

public final /* synthetic */ class b {
    public static Class a(ExtensionContext extensionContext) {
        return (Class) Preconditions.notNull(extensionContext.getTestClass().orElse(null), "Illegal state: required test class is not present in the current ExtensionContext");
    }

    public static Object b(ExtensionContext extensionContext) {
        return Preconditions.notNull(extensionContext.getTestInstance().orElse(null), "Illegal state: required test instance is not present in the current ExtensionContext");
    }

    @API(since = "5.7", status = API.Status.STABLE)
    public static TestInstances c(ExtensionContext extensionContext) {
        return (TestInstances) Preconditions.notNull(extensionContext.getTestInstances().orElse(null), "Illegal state: required test instances are not present in the current ExtensionContext");
    }

    public static Method d(ExtensionContext extensionContext) {
        return (Method) Preconditions.notNull(extensionContext.getTestMethod().orElse(null), "Illegal state: required test method is not present in the current ExtensionContext");
    }

    @API(since = "5.3", status = API.Status.STABLE)
    public static void e(ExtensionContext extensionContext, String str) {
        extensionContext.publishReportEntry("value", str);
    }

    public static void f(ExtensionContext extensionContext, String str, String str2) {
        extensionContext.publishReportEntry((Map<String, String>) Collections.singletonMap(str, str2));
    }
}
