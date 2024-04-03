package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzemd implements zzdob {
    private final Context zza;
    private final zzdwj zzb;
    private final zzfef zzc;
    private final zzcjf zzd;
    private final zzfdn zze;
    private final zzfxa<zzdvo> zzf;
    private final zzcop zzg;
    private final zzbrw zzh;
    private final boolean zzi;

    public zzemd(Context context, zzdwj zzdwj, zzfef zzfef, zzcjf zzcjf, zzfdn zzfdn, zzfxa<zzdvo> zzfxa, zzcop zzcop, zzbrw zzbrw, boolean z11) {
        this.zza = context;
        this.zzb = zzdwj;
        this.zzc = zzfef;
        this.zzd = zzcjf;
        this.zze = zzfdn;
        this.zzf = zzfxa;
        this.zzg = zzcop;
        this.zzh = zzbrw;
        this.zzi = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23, com.google.android.gms.internal.ads.zzdfe r24) {
        /*
            r21 = this;
            r1 = r21
            com.google.android.gms.internal.ads.zzfxa<com.google.android.gms.internal.ads.zzdvo> r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzfwq.zzq(r0)
            com.google.android.gms.internal.ads.zzdvo r0 = (com.google.android.gms.internal.ads.zzdvo) r0
            com.google.android.gms.internal.ads.zzfdn r2 = r1.zze     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzcop r3 = r1.zzg     // Catch:{ zzcpa -> 0x00fc }
            boolean r3 = r3.zzaD()     // Catch:{ zzcpa -> 0x00fc }
            r4 = 1
            if (r3 != 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzcop r2 = r1.zzg     // Catch:{ zzcpa -> 0x00fc }
        L_0x0017:
            r11 = r2
            goto L_0x007e
        L_0x0019:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzblj.zzaB     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzblh r5 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ zzcpa -> 0x00fc }
            java.lang.Object r3 = r5.zzb(r3)     // Catch:{ zzcpa -> 0x00fc }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzcpa -> 0x00fc }
            boolean r3 = r3.booleanValue()     // Catch:{ zzcpa -> 0x00fc }
            if (r3 != 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzcop r2 = r1.zzg     // Catch:{ zzcpa -> 0x00fc }
            goto L_0x0017
        L_0x002e:
            com.google.android.gms.internal.ads.zzdwj r3 = r1.zzb     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzfef r5 = r1.zzc     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzbfi r5 = r5.zze     // Catch:{ zzcpa -> 0x00fc }
            r6 = 0
            com.google.android.gms.internal.ads.zzcop r3 = r3.zza(r5, r6, r6)     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzdmm r5 = r0.zzg()     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzbsj.zzb(r3, r5)     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzdwn r5 = new com.google.android.gms.internal.ads.zzdwn     // Catch:{ zzcpa -> 0x00fc }
            r5.<init>()     // Catch:{ zzcpa -> 0x00fc }
            android.content.Context r7 = r1.zza     // Catch:{ zzcpa -> 0x00fc }
            r8 = r3
            android.view.View r8 = (android.view.View) r8     // Catch:{ zzcpa -> 0x00fc }
            r5.zza(r7, r8)     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzdwi r7 = r0.zzl()     // Catch:{ zzcpa -> 0x00fc }
            boolean r8 = r1.zzi     // Catch:{ zzcpa -> 0x00fc }
            if (r8 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbrw r8 = r1.zzh     // Catch:{ zzcpa -> 0x00fc }
            goto L_0x0059
        L_0x0058:
            r8 = r6
        L_0x0059:
            r7.zzi(r3, r4, r8)     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzcqc r7 = r3.zzP()     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzemb r8 = new com.google.android.gms.internal.ads.zzemb     // Catch:{ zzcpa -> 0x00fc }
            r8.<init>(r5, r3)     // Catch:{ zzcpa -> 0x00fc }
            r7.zzz(r8)     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzcqc r5 = r3.zzP()     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzemc r7 = new com.google.android.gms.internal.ads.zzemc     // Catch:{ zzcpa -> 0x00fc }
            r7.<init>(r3)     // Catch:{ zzcpa -> 0x00fc }
            r5.zzF(r7)     // Catch:{ zzcpa -> 0x00fc }
            com.google.android.gms.internal.ads.zzfds r2 = r2.zzt     // Catch:{ zzcpa -> 0x00fc }
            java.lang.String r5 = r2.zzb     // Catch:{ zzcpa -> 0x00fc }
            java.lang.String r2 = r2.zza     // Catch:{ zzcpa -> 0x00fc }
            r3.zzad(r5, r2, r6)     // Catch:{ zzcpa -> 0x00fc }
            r11 = r3
        L_0x007e:
            r11.zzap(r4)
            com.google.android.gms.ads.internal.zzj r2 = new com.google.android.gms.ads.internal.zzj
            boolean r3 = r1.zzi
            r5 = 0
            if (r3 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzbrw r3 = r1.zzh
            boolean r3 = r3.zze(r5)
            r13 = r3
            goto L_0x0091
        L_0x0090:
            r13 = r5
        L_0x0091:
            com.google.android.gms.ads.internal.zzt.zzp()
            android.content.Context r3 = r1.zza
            boolean r14 = com.google.android.gms.ads.internal.util.zzt.zzM(r3)
            boolean r3 = r1.zzi
            if (r3 == 0) goto L_0x00a6
            com.google.android.gms.internal.ads.zzbrw r3 = r1.zzh
            boolean r3 = r3.zzd()
            r15 = r3
            goto L_0x00a7
        L_0x00a6:
            r15 = r5
        L_0x00a7:
            boolean r3 = r1.zzi
            if (r3 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzbrw r3 = r1.zzh
            float r3 = r3.zza()
            goto L_0x00b3
        L_0x00b2:
            r3 = 0
        L_0x00b3:
            r16 = r3
            com.google.android.gms.internal.ads.zzfdn r3 = r1.zze
            r17 = -1
            boolean r5 = r3.zzL
            boolean r3 = r3.zzM
            r12 = r2
            r18 = r22
            r19 = r5
            r20 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r24 == 0) goto L_0x00cc
            r24.zzf()
        L_0x00cc:
            com.google.android.gms.ads.internal.zzt.zzj()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdnq r9 = r0.zzj()
            com.google.android.gms.internal.ads.zzfdn r0 = r1.zze
            int r12 = r0.zzN
            com.google.android.gms.internal.ads.zzcjf r13 = r1.zzd
            java.lang.String r14 = r0.zzC
            com.google.android.gms.internal.ads.zzfds r0 = r0.zzt
            r8 = 0
            r10 = 0
            java.lang.String r5 = r0.zzb
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.ads.zzfef r6 = r1.zzc
            java.lang.String r6 = r6.zzf
            r7 = r3
            r15 = r2
            r16 = r5
            r17 = r0
            r18 = r6
            r19 = r24
            r7.<init>((com.google.android.gms.internal.ads.zzbes) r8, (com.google.android.gms.ads.internal.overlay.zzo) r9, (com.google.android.gms.ads.internal.overlay.zzw) r10, (com.google.android.gms.internal.ads.zzcop) r11, (int) r12, (com.google.android.gms.internal.ads.zzcjf) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzj) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (com.google.android.gms.internal.ads.zzdfe) r19)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzm.zza(r0, r3, r4)
            return
        L_0x00fc:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.internal.ads.zzciz.zzh(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemd.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzdfe):void");
    }
}
