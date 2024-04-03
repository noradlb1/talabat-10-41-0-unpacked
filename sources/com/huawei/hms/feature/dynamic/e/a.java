package com.huawei.hms.feature.dynamic.e;

import android.util.Log;
import dalvik.system.PathClassLoader;

public final class a extends PathClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48792a = "a";

    public a(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    public Class<?> loadClass(String str, boolean z11) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                String str2 = f48792a;
                Log.w(str2, "Cannot find The class:" + str);
            }
        }
        return super.loadClass(str, z11);
    }
}
