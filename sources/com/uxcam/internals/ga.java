package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

public class ga {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f13429a;

    /* renamed from: b  reason: collision with root package name */
    public static bt f13430b;

    public static bt a() {
        if (f13430b == null) {
            f13430b = new bu();
        }
        return f13430b;
    }

    public static SharedPreferences b() {
        Context context;
        if (f13429a == null && (context = ia.f13617c) != null) {
            f13429a = context.getSharedPreferences("UXCamPreferences", 0);
        }
        return f13429a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        r0 = r0.f13089b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r5, java.lang.String r6) {
        /*
            android.content.SharedPreferences r0 = b()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.content.SharedPreferences$Editor r0 = r0.edit()
            com.uxcam.internals.bt r1 = a()
            com.uxcam.internals.bu r1 = (com.uxcam.internals.bu) r1
            boolean r2 = r1.f13088a
            if (r2 != 0) goto L_0x0016
            goto L_0x0037
        L_0x0016:
            java.lang.String r2 = "AES/GCM/NoPadding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ Exception -> 0x0037 }
            r1.f13089b = r2     // Catch:{ Exception -> 0x0037 }
            javax.crypto.SecretKey r3 = r1.a()     // Catch:{ Exception -> 0x0037 }
            r4 = 1
            r2.init(r4, r3)     // Catch:{ Exception -> 0x0037 }
            javax.crypto.Cipher r1 = r1.f13089b     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = "UTF-8"
            byte[] r2 = r6.getBytes(r2)     // Catch:{ Exception -> 0x0037 }
            byte[] r1 = r1.doFinal(r2)     // Catch:{ Exception -> 0x0037 }
            r2 = 0
            java.lang.String r6 = android.util.Base64.encodeToString(r1, r2)     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            android.content.SharedPreferences$Editor r6 = r0.putString(r5, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "_iv"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.uxcam.internals.bt r0 = a()
            com.uxcam.internals.bu r0 = (com.uxcam.internals.bu) r0
            boolean r1 = r0.f13088a
            if (r1 == 0) goto L_0x0064
            javax.crypto.Cipher r0 = r0.f13089b
            if (r0 == 0) goto L_0x0064
            byte[] r0 = r0.getIV()
            r1 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)
            goto L_0x0066
        L_0x0064:
            java.lang.String r0 = ""
        L_0x0066:
            android.content.SharedPreferences$Editor r5 = r6.putString(r5, r0)
            r5.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ga.a(java.lang.String, java.lang.String):void");
    }

    public static byte[] a(String str) {
        SharedPreferences b11 = b();
        String string = b11.getString(str + "_iv", "");
        return (string == null || string.isEmpty()) ? new byte[0] : Base64.decode(string, 2);
    }
}
