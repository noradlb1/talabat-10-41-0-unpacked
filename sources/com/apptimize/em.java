package com.apptimize;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public class em {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42305a = "em";

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f42306b = {"com.localytics.android", "com.localytics.androidx"};

    public static Class<?> a(ClassLoader classLoader) {
        return a(classLoader, "Localytics");
    }

    public static Class<?> b(ClassLoader classLoader) {
        return a(classLoader, "Customer");
    }

    private static Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls = null;
        for (String str2 : f42306b) {
            cls = b(classLoader, str2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str);
            if (cls != null) {
                break;
            }
        }
        return cls;
    }

    private static Class<?> b(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            return Class.forName(str);
        }
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
            String str2 = f42305a;
            bo.k(str2, "Class path not found " + str);
            return null;
        }
    }
}
