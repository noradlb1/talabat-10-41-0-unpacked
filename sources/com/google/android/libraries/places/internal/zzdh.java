package com.google.android.libraries.places.internal;

import android.content.Context;
import android.os.DropBoxManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;

public final class zzdh {
    @GuardedBy("CrashReporter.class")
    @Nullable
    private static DropBoxManager zza;
    @GuardedBy("CrashReporter.class")
    private static final LinkedHashMap<Long, Integer> zzb = new zzdg(16, 0.75f, true);
    @GuardedBy("CrashReporter.class")
    @Nullable
    private static String zzc;

    public static synchronized void zza(Context context, boolean z11) {
        synchronized (zzdh.class) {
            if (zza == null) {
                zza = (DropBoxManager) context.getApplicationContext().getSystemService("dropbox");
                zzc = "com.google.android.libraries.places";
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void zzb(java.lang.Throwable r17) {
        /*
            java.lang.Class<com.google.android.libraries.places.internal.zzdh> r1 = com.google.android.libraries.places.internal.zzdh.class
            monitor-enter(r1)
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00bc }
            long r2 = r0.getId()     // Catch:{ all -> 0x00bc }
            int r0 = r17.hashCode()     // Catch:{ all -> 0x00bc }
            java.util.LinkedHashMap<java.lang.Long, java.lang.Integer> r4 = zzb     // Catch:{ all -> 0x00bc }
            java.lang.Long r5 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00bc }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00bc }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x0026
            int r4 = r4.intValue()     // Catch:{ all -> 0x00bc }
            if (r4 == r0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            android.os.DropBoxManager r4 = zza     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x00ba
            java.lang.String r5 = "system_app_crash"
            boolean r4 = r4.isTagEnabled(r5)     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x00ba
            android.os.DropBoxManager r4 = zza     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r5.<init>()     // Catch:{ all -> 0x00bc }
            r6 = 3
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x00bc }
            java.lang.String r8 = zzc     // Catch:{ all -> 0x00bc }
            r9 = 0
            r7[r9] = r8     // Catch:{ all -> 0x00bc }
            r8 = 46
            com.google.android.libraries.places.internal.zzfq r8 = com.google.android.libraries.places.internal.zzfq.zzb(r8)     // Catch:{ all -> 0x00bc }
            java.lang.String r10 = "2.5.0"
            java.util.List r8 = r8.zzc(r10)     // Catch:{ all -> 0x00bc }
            int r10 = r8.size()     // Catch:{ all -> 0x00bc }
            if (r10 == r6) goto L_0x0056
        L_0x0053:
            r11 = -1
            goto L_0x0072
        L_0x0056:
            r13 = 0
            r6 = r9
        L_0x0059:
            int r10 = r8.size()     // Catch:{ NumberFormatException -> 0x0053 }
            if (r6 >= r10) goto L_0x0071
            r15 = 100
            long r13 = r13 * r15
            java.lang.Object r10 = r8.get(r6)     // Catch:{ NumberFormatException -> 0x0053 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x0053 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x0053 }
            long r11 = (long) r10
            long r13 = r13 + r11
            int r6 = r6 + 1
            goto L_0x0059
        L_0x0071:
            r11 = r13
        L_0x0072:
            java.lang.Long r6 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x00bc }
            r8 = 1
            r7[r8] = r6     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = "2.5.0"
            r10 = 2
            r7[r10] = r6     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = "Package: %s v%d (%s)\n"
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00bc }
            r5.append(r6)     // Catch:{ all -> 0x00bc }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x00bc }
            java.lang.String r7 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x00bc }
            r6[r9] = r7     // Catch:{ all -> 0x00bc }
            java.lang.String r7 = "Build: %s\n"
            java.lang.String r6 = java.lang.String.format(r7, r6)     // Catch:{ all -> 0x00bc }
            r5.append(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = "\n"
            r5.append(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = android.util.Log.getStackTraceString(r17)     // Catch:{ all -> 0x00bc }
            r5.append(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = "system_app_crash"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00bc }
            r4.addText(r6, r5)     // Catch:{ all -> 0x00bc }
            java.util.LinkedHashMap<java.lang.Long, java.lang.Integer> r4 = zzb     // Catch:{ all -> 0x00bc }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00bc }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00bc }
            r4.put(r2, r0)     // Catch:{ all -> 0x00bc }
            monitor-exit(r1)
            return
        L_0x00ba:
            monitor-exit(r1)
            return
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzdh.zzb(java.lang.Throwable):void");
    }
}
