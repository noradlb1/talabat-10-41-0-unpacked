package com.google.android.gms.internal.vision;

public final class zzds {
    private static final zzdv zzmc;
    private static final int zzmd;

    public static final class zza extends zzdv {
        public final void zza(Throwable th2) {
            th2.printStackTrace();
        }

        public final void zza(Throwable th2, Throwable th3) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = zzci()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0015
            int r2 = r1.intValue()     // Catch:{ all -> 0x002a }
            r3 = 19
            if (r2 < r3) goto L_0x0015
            com.google.android.gms.internal.vision.zzdy r2 = new com.google.android.gms.internal.vision.zzdy     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x005f
        L_0x0015:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ all -> 0x002a }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.vision.zzdw r2 = new com.google.android.gms.internal.vision.zzdw     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x005f
        L_0x0024:
            com.google.android.gms.internal.vision.zzds$zza r2 = new com.google.android.gms.internal.vision.zzds$zza     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x005f
        L_0x002a:
            r2 = move-exception
            goto L_0x002e
        L_0x002c:
            r2 = move-exception
            r1 = 0
        L_0x002e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.vision.zzds$zza> r4 = com.google.android.gms.internal.vision.zzds.zza.class
            java.lang.String r4 = r4.getName()
            int r5 = r4.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.vision.zzds$zza r2 = new com.google.android.gms.internal.vision.zzds$zza
            r2.<init>()
        L_0x005f:
            zzmc = r2
            if (r1 != 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            int r0 = r1.intValue()
        L_0x0068:
            zzmd = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzds.<clinit>():void");
    }

    public static void zza(Throwable th2, Throwable th3) {
        zzmc.zza(th2, th3);
    }

    private static Integer zzci() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e11) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e11.printStackTrace(System.err);
            return null;
        }
    }

    public static void zza(Throwable th2) {
        zzmc.zza(th2);
    }
}
