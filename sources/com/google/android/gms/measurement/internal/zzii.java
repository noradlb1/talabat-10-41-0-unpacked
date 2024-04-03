package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class zzii implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzij zze;

    public zzii(zzij zzij, boolean z11, Uri uri, String str, String str2) {
        this.zze = zzij;
        this.zza = z11;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3 A[SYNTHETIC, Splitter:B:32:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fb A[Catch:{ RuntimeException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fd A[Catch:{ RuntimeException -> 0x0190 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            com.google.android.gms.measurement.internal.zzij r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzik r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzik r6 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzlp r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.internal.measurement.zzra.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzik r7 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzag r7 = r7.zzf()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzef r8 = com.google.android.gms.measurement.internal.zzeg.zzav     // Catch:{ RuntimeException -> 0x0190 }
            r9 = 0
            boolean r7 = r7.zzs(r9, r8)     // Catch:{ RuntimeException -> 0x0190 }
            boolean r10 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r11 = "Activity created with data 'referrer' without required params"
            java.lang.String r12 = "utm_medium"
            java.lang.String r13 = "_cis"
            java.lang.String r14 = "utm_source"
            java.lang.String r15 = "utm_campaign"
            java.lang.String r9 = "gclid"
            if (r10 == 0) goto L_0x003f
        L_0x003d:
            r6 = 0
            goto L_0x009f
        L_0x003f:
            boolean r10 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            boolean r10 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            boolean r10 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            boolean r10 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "utm_id"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "dclid"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "srsltid"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "sfmc_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0190 }
            if (r7 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r7 = 1
            goto L_0x008a
        L_0x007c:
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            r6.zza(r11)     // Catch:{ RuntimeException -> 0x0190 }
            goto L_0x003d
        L_0x008a:
            java.lang.String r10 = "https://google.com/search?"
            java.lang.String r10 = r10.concat(r5)     // Catch:{ RuntimeException -> 0x0190 }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ RuntimeException -> 0x0190 }
            android.os.Bundle r6 = r6.zzs(r10, r7)     // Catch:{ RuntimeException -> 0x0190 }
            if (r6 == 0) goto L_0x009f
            java.lang.String r7 = "referrer"
            r6.putString(r13, r7)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x009f:
            java.lang.String r7 = "_cmp"
            if (r0 == 0) goto L_0x00f5
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzlp r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.internal.measurement.zzra.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzik r10 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r10 = r10.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzag r10 = r10.zzf()     // Catch:{ RuntimeException -> 0x0190 }
            r1 = 0
            boolean r8 = r10.zzs(r1, r8)     // Catch:{ RuntimeException -> 0x0190 }
            android.os.Bundle r0 = r0.zzs(r3, r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x00f5
            java.lang.String r1 = "intent"
            r0.putString(r13, r1)     // Catch:{ RuntimeException -> 0x0190 }
            boolean r1 = r0.containsKey(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r1 != 0) goto L_0x00e9
            if (r6 == 0) goto L_0x00e9
            boolean r1 = r6.containsKey(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r1 == 0) goto L_0x00e9
            java.lang.String r1 = "_cer"
            java.lang.String r3 = "gclid=%s"
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r8 = r6.getString(r9)     // Catch:{ RuntimeException -> 0x0190 }
            r13 = 0
            r10[r13] = r8     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r3 = java.lang.String.format(r3, r10)     // Catch:{ RuntimeException -> 0x0190 }
            r0.putString(r1, r3)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00e9:
            com.google.android.gms.measurement.internal.zzik r1 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            r1.zzG(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzik r1 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzs r1 = r1.zzb     // Catch:{ RuntimeException -> 0x0190 }
            r1.zza(r4, r0)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00f5:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x00fd
            goto L_0x017f
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r1 = "Activity created with referrer"
            r0.zzb(r1, r5)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzef r1 = com.google.android.gms.measurement.internal.zzeg.zzaa     // Catch:{ RuntimeException -> 0x0190 }
            r3 = 0
            boolean r0 = r0.zzs(r3, r1)     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r1 = "_ldl"
            java.lang.String r3 = "auto"
            if (r0 == 0) goto L_0x014b
            if (r6 == 0) goto L_0x0132
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            r0.zzG(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb     // Catch:{ RuntimeException -> 0x0190 }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x0190 }
            goto L_0x0143
        L_0x0132:
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x0143:
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            r4 = 1
            r5 = 0
            r0.zzW(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0190 }
            return
        L_0x014b:
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x0180
            boolean r0 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x0180
        L_0x0173:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x017f
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            r4 = 1
            r0.zzW(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x017f:
            return
        L_0x0180:
            com.google.android.gms.measurement.internal.zzik r0 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            r0.zza(r11)     // Catch:{ RuntimeException -> 0x0190 }
            return
        L_0x0190:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzik r1 = r2.zza
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzd()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzii.run():void");
    }
}
