package com.instabug.apm.util.debug;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.apm.di.a;

public class b implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Context f45586a = a.r();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.logger.internal.a f45587b = a.f();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r9.getMessage() == null) goto L_0x0030;
     */
    @android.annotation.SuppressLint({"PrivateApi"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.String r3 = "get"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0040 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0040 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{ NoSuchMethodException -> 0x0040 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0022 }
            r3[r7] = r9     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0022 }
            java.lang.Object r9 = r2.invoke(r1, r3)     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0022 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0022 }
            return r9
        L_0x0022:
            r9 = move-exception
            com.instabug.apm.logger.internal.a r2 = r8.f45587b     // Catch:{ NoSuchMethodException -> 0x0040 }
            java.lang.String r3 = r9.getMessage()     // Catch:{ NoSuchMethodException -> 0x0040 }
            if (r3 == 0) goto L_0x0030
        L_0x002b:
            java.lang.String r3 = r9.getMessage()     // Catch:{ NoSuchMethodException -> 0x0040 }
            goto L_0x003c
        L_0x0030:
            r3 = r0
            goto L_0x003c
        L_0x0032:
            r9 = move-exception
            com.instabug.apm.logger.internal.a r2 = r8.f45587b     // Catch:{ NoSuchMethodException -> 0x0040 }
            java.lang.String r3 = r9.getMessage()     // Catch:{ NoSuchMethodException -> 0x0040 }
            if (r3 == 0) goto L_0x0030
            goto L_0x002b
        L_0x003c:
            r2.a(r3, r9)     // Catch:{ NoSuchMethodException -> 0x0040 }
            goto L_0x0063
        L_0x0040:
            r9 = move-exception
            com.instabug.apm.logger.internal.a r2 = r8.f45587b     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.String r3 = r9.getMessage()     // Catch:{ ClassNotFoundException -> 0x0053 }
            if (r3 == 0) goto L_0x004e
            java.lang.String r3 = r9.getMessage()     // Catch:{ ClassNotFoundException -> 0x0053 }
            goto L_0x004f
        L_0x004e:
            r3 = r0
        L_0x004f:
            r2.a(r3, r9)     // Catch:{ ClassNotFoundException -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r9 = move-exception
            com.instabug.apm.logger.internal.a r2 = r8.f45587b
            java.lang.String r3 = r9.getMessage()
            if (r3 == 0) goto L_0x0060
            java.lang.String r0 = r9.getMessage()
        L_0x0060:
            r2.a(r0, r9)
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.util.debug.b.a(java.lang.String):java.lang.String");
    }

    public boolean a() {
        Context context = this.f45586a;
        String packageName = context != null ? context.getApplicationContext().getPackageName() : "";
        return !packageName.isEmpty() && packageName.equals(a("debug.instabug.apm.app"));
    }
}
