package com.huawei.hms.feature.dynamic.e;

import android.util.Log;
import dalvik.system.DexClassLoader;

public final class b extends DexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48793a = "b";

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public Class<?> loadClass(String str, boolean z11) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                String str2 = f48793a;
                Log.w(str2, "Cannot find The class:" + str);
            }
        }
        return super.loadClass(str, z11);
    }
}
