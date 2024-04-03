package org.junit.platform.commons.util;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.Optional;
import java.net.URL;
import java.security.CodeSource;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class ClassLoaderUtils {
    private ClassLoaderUtils() {
    }

    public static ClassLoader getDefaultClassLoader() {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader;
            }
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
        }
        return ClassLoader.getSystemClassLoader();
    }

    public static Optional<URL> getLocation(Object obj) {
        Preconditions.notNull(obj, "object must not be null");
        ClassLoader classLoader = obj.getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
            while (classLoader != null && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
        }
        if (classLoader != null) {
            String name2 = obj.getClass().getName();
            try {
                return Optional.ofNullable(classLoader.getResource(name2.replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "/") + ".class"));
            } catch (Throwable th2) {
                UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            }
        }
        try {
            CodeSource codeSource = obj.getClass().getProtectionDomain().getCodeSource();
            if (codeSource != null) {
                return Optional.ofNullable(codeSource.getLocation());
            }
        } catch (SecurityException unused) {
        }
        return Optional.empty();
    }
}
