package com.huawei.secure.android.common.activity.protect;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Method;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33696a = "Reflection";

    /* renamed from: b  reason: collision with root package name */
    private static Object f33697b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Method f33698c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final int f33699d = -21;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            if (r2 < r3) goto L_0x007a
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x005f }
            r4 = 0
            r3[r4] = r0     // Catch:{ all -> 0x005f }
            java.lang.String r5 = "forName"
            java.lang.reflect.Method r3 = r1.getDeclaredMethod(r5, r3)     // Catch:{ all -> 0x005f }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x005f }
            r6[r4] = r0     // Catch:{ all -> 0x005f }
            java.lang.Class<java.lang.Class[]> r0 = java.lang.Class[].class
            r6[r2] = r0     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "getDeclaredMethod"
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r0, r6)     // Catch:{ all -> 0x005f }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x005f }
            java.lang.String r6 = "dalvik.system.VMRuntime"
            r1[r4] = r6     // Catch:{ all -> 0x005f }
            r6 = 0
            java.lang.Object r1 = r3.invoke(r6, r1)     // Catch:{ all -> 0x005f }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x005f }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "getRuntime"
            r3[r4] = r7     // Catch:{ all -> 0x005f }
            r3[r2] = r6     // Catch:{ all -> 0x005f }
            java.lang.Object r3 = r0.invoke(r1, r3)     // Catch:{ all -> 0x005f }
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch:{ all -> 0x005f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "setHiddenApiExemptions"
            r5[r4] = r7     // Catch:{ all -> 0x005f }
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x005f }
            java.lang.Class<java.lang.String[]> r8 = java.lang.String[].class
            r7[r4] = r8     // Catch:{ all -> 0x005f }
            r5[r2] = r7     // Catch:{ all -> 0x005f }
            java.lang.Object r0 = r0.invoke(r1, r5)     // Catch:{ all -> 0x005f }
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ all -> 0x005f }
            f33698c = r0     // Catch:{ all -> 0x005f }
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x005f }
            java.lang.Object r0 = r3.invoke(r6, r0)     // Catch:{ all -> 0x005f }
            f33697b = r0     // Catch:{ all -> 0x005f }
            goto L_0x007a
        L_0x005f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "reflect failed : "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "Reflection"
            com.huawei.secure.android.common.activity.a.a((java.lang.String) r1, (java.lang.String) r0)
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.activity.protect.f.<clinit>():void");
    }

    public static int a(Context context) {
        if (Build.VERSION.SDK_INT >= 28 && !a()) {
            return f33699d;
        }
        return 0;
    }

    public static boolean a(String str) {
        return a(str);
    }

    public static boolean a(String... strArr) {
        Method method;
        Object obj = f33697b;
        if (!(obj == null || (method = f33698c) == null)) {
            try {
                method.invoke(obj, new Object[]{strArr});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a() {
        return a("L");
    }
}
