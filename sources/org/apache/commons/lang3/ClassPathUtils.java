package org.apache.commons.lang3;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package packageR, String str) {
        Validate.notNull(packageR, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return packageR.getName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str;
    }

    public static String toFullyQualifiedPath(Package packageR, String str) {
        Validate.notNull(packageR, "Parameter '%s' must not be null!", "context");
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return packageR.getName().replace('.', '/') + "/" + str;
    }
}
