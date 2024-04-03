package org.junit.platform.commons.util;

import j$.util.Optional;
import j$.util.function.Function;
import java.io.File;
import java.util.jar.JarFile;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class PackageUtils {
    private PackageUtils() {
    }

    public static Optional<String> getAttribute(Class<?> cls, Function<Package, String> function) {
        Preconditions.notNull(cls, "type must not be null");
        Preconditions.notNull(function, "function must not be null");
        return Optional.ofNullable(cls.getPackage()).map(function);
    }

    public static Optional<String> getAttribute(Class<?> cls, String str) {
        JarFile jarFile;
        Preconditions.notNull(cls, "type must not be null");
        Preconditions.notBlank(str, "name must not be blank");
        try {
            jarFile = new JarFile(new File(cls.getProtectionDomain().getCodeSource().getLocation().toURI()));
            Optional<String> ofNullable = Optional.ofNullable(jarFile.getManifest().getMainAttributes().getValue(str));
            jarFile.close();
            return ofNullable;
        } catch (Exception unused) {
            return Optional.empty();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
