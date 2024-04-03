package com.newrelic.agent.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InstantApps {
    private static Boolean isInstantApp;
    private static Context lastApplicationContext;
    private static PackageManagerWrapper packageManagerWrapper;

    public static class PackageManagerWrapper {
        private static Method isInstantAppMethod;
        private final PackageManager packageManager;

        public PackageManagerWrapper(PackageManager packageManager2) {
            this.packageManager = packageManager2;
        }

        public Boolean isInstantApp() {
            if (isInstantAppMethod == null) {
                try {
                    isInstantAppMethod = PackageManager.class.getDeclaredMethod("isInstantApp", new Class[0]);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
            try {
                return (Boolean) isInstantAppMethod.invoke(this.packageManager, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return null;
            }
        }
    }

    private static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isInstantApp(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                throw new IllegalStateException("Application context is null!");
            } else if (isInstantApp != null && applicationContext.equals(lastApplicationContext)) {
                return isInstantApp.booleanValue();
            } else {
                Boolean bool = null;
                isInstantApp = null;
                if (isAtLeastO()) {
                    if (packageManagerWrapper == null || !applicationContext.equals(lastApplicationContext)) {
                        packageManagerWrapper = new PackageManagerWrapper(applicationContext.getPackageManager());
                    }
                    bool = packageManagerWrapper.isInstantApp();
                }
                lastApplicationContext = applicationContext;
                if (bool != null) {
                    isInstantApp = bool;
                } else {
                    try {
                        applicationContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        isInstantApp = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        isInstantApp = Boolean.FALSE;
                    }
                }
                return isInstantApp.booleanValue();
            }
        } else {
            throw new IllegalArgumentException("Context must be non-null");
        }
    }
}
