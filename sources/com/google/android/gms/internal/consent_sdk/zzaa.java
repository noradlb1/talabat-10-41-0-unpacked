package com.google.android.gms.internal.consent_sdk;

final class zzaa {
    private final zzz zza;
    private final zzby zzb;
    private int zzc = 0;
    private int zzd = 0;

    public zzaa(zzz zzz, zzby zzby) {
        this.zza = zzz;
        this.zzb = zzby;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.consent_sdk.zzy zza() throws com.google.android.gms.internal.consent_sdk.zzk {
        /*
            r12 = this;
            int[] r0 = com.google.android.gms.internal.consent_sdk.zzx.zza
            com.google.android.gms.internal.consent_sdk.zzby r1 = r12.zzb
            int r2 = r1.zza
            r3 = 1
            int r2 = r2 - r3
            r0 = r0[r2]
            r2 = 2
            r4 = 0
            r5 = 3
            switch(r0) {
                case 1: goto L_0x006c;
                case 2: goto L_0x0067;
                case 3: goto L_0x0062;
                case 4: goto L_0x005d;
                case 5: goto L_0x0058;
                case 6: goto L_0x0038;
                case 7: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            com.google.android.gms.internal.consent_sdk.zzk r0 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r1 = "Invalid response from server."
            r0.<init>(r3, r1)
            throw r0
        L_0x0018:
            com.google.android.gms.internal.consent_sdk.zzk r0 = new com.google.android.gms.internal.consent_sdk.zzk
            com.google.android.gms.internal.consent_sdk.zzby r1 = r12.zzb
            java.lang.String r1 = r1.zzd
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            java.lang.String r3 = "Publisher misconfiguration: "
            if (r2 == 0) goto L_0x002f
            java.lang.String r1 = r3.concat(r1)
            goto L_0x0034
        L_0x002f:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x0034:
            r0.<init>(r5, r1)
            throw r0
        L_0x0038:
            com.google.android.gms.internal.consent_sdk.zzk r0 = new com.google.android.gms.internal.consent_sdk.zzk
            com.google.android.gms.internal.consent_sdk.zzby r1 = r12.zzb
            java.lang.String r1 = r1.zzd
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            java.lang.String r4 = "Invalid response from server: "
            if (r2 == 0) goto L_0x004f
            java.lang.String r1 = r4.concat(r1)
            goto L_0x0054
        L_0x004f:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
        L_0x0054:
            r0.<init>(r3, r1)
            throw r0
        L_0x0058:
            r12.zzc = r5
            r12.zzd = r4
            goto L_0x0070
        L_0x005d:
            r12.zzc = r5
            r12.zzd = r3
            goto L_0x0070
        L_0x0062:
            r12.zzc = r5
            r12.zzd = r2
            goto L_0x0070
        L_0x0067:
            r12.zzc = r2
            r12.zzd = r4
            goto L_0x0070
        L_0x006c:
            r12.zzc = r3
            r12.zzd = r4
        L_0x0070:
            java.lang.String r0 = r1.zzb
            r6 = 0
            if (r0 != 0) goto L_0x0077
            r7 = r6
            goto L_0x007e
        L_0x0077:
            com.google.android.gms.internal.consent_sdk.zzbb r7 = new com.google.android.gms.internal.consent_sdk.zzbb
            java.lang.String r1 = r1.zzc
            r7.<init>(r1, r0)
        L_0x007e:
            com.google.android.gms.internal.consent_sdk.zzz r0 = r12.zza
            com.google.android.gms.internal.consent_sdk.zzal r0 = r0.zzc
            java.util.HashSet r1 = new java.util.HashSet
            com.google.android.gms.internal.consent_sdk.zzby r8 = r12.zzb
            java.util.List<java.lang.String> r8 = r8.zze
            r1.<init>(r8)
            r0.zza((java.util.Set<java.lang.String>) r1)
            com.google.android.gms.internal.consent_sdk.zzby r0 = r12.zzb
            java.util.List<com.google.android.gms.internal.consent_sdk.zzbx> r0 = r0.zzf
            java.util.Iterator r0 = r0.iterator()
        L_0x0098:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d1
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.consent_sdk.zzbx r1 = (com.google.android.gms.internal.consent_sdk.zzbx) r1
            int[] r8 = com.google.android.gms.internal.consent_sdk.zzx.zzb
            int r9 = r1.zza
            int r9 = r9 - r3
            r8 = r8[r9]
            if (r8 == r3) goto L_0x00b8
            if (r8 == r2) goto L_0x00b5
            if (r8 == r5) goto L_0x00b2
            goto L_0x00b8
        L_0x00b2:
            java.lang.String r8 = "clear"
            goto L_0x00b9
        L_0x00b5:
            java.lang.String r8 = "write"
            goto L_0x00b9
        L_0x00b8:
            r8 = r6
        L_0x00b9:
            if (r8 == 0) goto L_0x0098
            com.google.android.gms.internal.consent_sdk.zzz r9 = r12.zza
            com.google.android.gms.internal.consent_sdk.zze r9 = r9.zza
            java.lang.String r1 = r1.zzb
            com.google.android.gms.internal.consent_sdk.zzi[] r10 = new com.google.android.gms.internal.consent_sdk.zzi[r3]
            com.google.android.gms.internal.consent_sdk.zzz r11 = r12.zza
            com.google.android.gms.internal.consent_sdk.zzaj r11 = r11.zzb
            r10[r4] = r11
            r9.zza(r8, r1, r10)
            goto L_0x0098
        L_0x00d1:
            com.google.android.gms.internal.consent_sdk.zzy r0 = new com.google.android.gms.internal.consent_sdk.zzy
            int r1 = r12.zzc
            int r2 = r12.zzd
            r0.<init>(r1, r2, r7, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzaa.zza():com.google.android.gms.internal.consent_sdk.zzy");
    }
}
