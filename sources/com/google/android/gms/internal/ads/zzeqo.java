package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeqo implements zzevn<zzeqq> {
    private final zzfxb zza;
    private final zzdww zzb;
    private final zzebb zzc;
    private final zzeqr zzd;

    public zzeqo(zzfxb zzfxb, zzdww zzdww, zzebb zzebb, zzeqr zzeqr) {
        this.zza = zzfxb;
        this.zzb = zzdww;
        this.zzc = zzebb;
        this.zzd = zzeqr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:4|5|6|7|8|(1:10)|11|12|(1:14)|15|16|21|19|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053 A[Catch:{ zzfek -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeqq zza() throws java.lang.Exception {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzblb<java.lang.String> r0 = com.google.android.gms.internal.ads.zzblj.zzbc
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzdww r3 = r7.zzb     // Catch:{ zzfek -> 0x001f }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ zzfek -> 0x001f }
            r4.<init>()     // Catch:{ zzfek -> 0x001f }
            com.google.android.gms.internal.ads.zzfev r3 = r3.zzb(r2, r4)     // Catch:{ zzfek -> 0x001f }
            r3.zzA()     // Catch:{ zzfek -> 0x001f }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ zzfek -> 0x001f }
            r4.<init>()     // Catch:{ zzfek -> 0x001f }
            com.google.android.gms.internal.ads.zzcab r5 = r3.zzf()     // Catch:{ zzfek -> 0x004d }
            if (r5 == 0) goto L_0x004d
            java.lang.String r6 = "sdk_version"
            java.lang.String r5 = r5.toString()     // Catch:{ zzfek -> 0x004d }
            r4.putString(r6, r5)     // Catch:{ zzfek -> 0x004d }
        L_0x004d:
            com.google.android.gms.internal.ads.zzcab r3 = r3.zze()     // Catch:{ zzfek -> 0x005c }
            if (r3 == 0) goto L_0x005c
            java.lang.String r5 = "adapter_version"
            java.lang.String r3 = r3.toString()     // Catch:{ zzfek -> 0x005c }
            r4.putString(r5, r3)     // Catch:{ zzfek -> 0x005c }
        L_0x005c:
            r1.putBundle(r2, r4)     // Catch:{ zzfek -> 0x001f }
            goto L_0x001f
        L_0x0060:
            com.google.android.gms.internal.ads.zzeqq r0 = new com.google.android.gms.internal.ads.zzeqq
            r2 = 0
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqo.zza():com.google.android.gms.internal.ads.zzeqq");
    }

    public final zzfxa<zzeqq> zzb() {
        if (zzfqr.zzd((String) zzbgq.zzc().zzb(zzblj.zzbc)) || this.zzd.zzb() || !this.zzc.zzs()) {
            return zzfwq.zzi(new zzeqq(new Bundle(), (zzeqp) null));
        }
        this.zzd.zza(true);
        return this.zza.zzb(new zzeqn(this));
    }
}
