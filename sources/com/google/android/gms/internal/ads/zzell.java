package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzell<AdT> implements zzfvx<zzfdz, AdT> {
    private final zzfie zza;
    private final zzdet zzb;
    private final zzfjp zzc;
    private final zzfjs zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzday<AdT> zzg;
    private final zzelg zzh;
    private final zzehy zzi;

    public zzell(zzfie zzfie, zzelg zzelg, zzdet zzdet, zzfjp zzfjp, zzfjs zzfjs, zzday<AdT> zzday, Executor executor, ScheduledExecutorService scheduledExecutorService, zzehy zzehy) {
        this.zza = zzfie;
        this.zzh = zzelg;
        this.zzb = zzdet;
        this.zzc = zzfjp;
        this.zzd = zzfjs;
        this.zzg = zzday;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzehy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzfxa zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzfdz r9 = (com.google.android.gms.internal.ads.zzfdz) r9
            com.google.android.gms.internal.ads.zzfdy r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfdq r0 = r0.zzb
            int r0 = r0.zze
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 == 0) goto L_0x0044
            if (r0 < r1) goto L_0x0027
            if (r0 >= r2) goto L_0x0027
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzdU
            com.google.android.gms.internal.ads.zzblh r3 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = "No fill."
            goto L_0x0046
        L_0x0027:
            if (r0 < r2) goto L_0x0030
            r3 = 400(0x190, float:5.6E-43)
            if (r0 >= r3) goto L_0x0030
            java.lang.String r0 = "No location header to follow redirect or too many redirects."
            goto L_0x0046
        L_0x0030:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 46
            r3.<init>(r4)
            java.lang.String r4 = "Received error HTTP response code: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = "No ad config."
        L_0x0046:
            com.google.android.gms.internal.ads.zzfdy r3 = r9.zzb
            com.google.android.gms.internal.ads.zzfdq r3 = r3.zzb
            com.google.android.gms.internal.ads.zzfdp r3 = r3.zzi
            if (r3 == 0) goto L_0x0052
            java.lang.String r0 = r3.zza()
        L_0x0052:
            com.google.android.gms.internal.ads.zzehy r3 = r8.zzi
            com.google.android.gms.internal.ads.zzfdy r4 = r9.zzb
            com.google.android.gms.internal.ads.zzfdq r4 = r4.zzb
            r3.zze(r4)
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzblj.zzgd
            com.google.android.gms.internal.ads.zzblh r4 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = 3
            if (r3 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzfdy r3 = r9.zzb
            com.google.android.gms.internal.ads.zzfdq r3 = r3.zzb
            int r3 = r3.zze
            if (r3 == 0) goto L_0x0085
            if (r3 < r1) goto L_0x007a
            if (r3 < r2) goto L_0x0085
        L_0x007a:
            com.google.android.gms.internal.ads.zzelj r9 = new com.google.android.gms.internal.ads.zzelj
            r9.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzfxa r9 = com.google.android.gms.internal.ads.zzfwq.zzh(r9)
            goto L_0x017f
        L_0x0085:
            com.google.android.gms.internal.ads.zzfie r1 = r8.zza
            com.google.android.gms.internal.ads.zzfhy r2 = com.google.android.gms.internal.ads.zzfhy.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzelj r3 = new com.google.android.gms.internal.ads.zzelj
            r3.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzfxa r0 = com.google.android.gms.internal.ads.zzfwq.zzh(r3)
            com.google.android.gms.internal.ads.zzfhv r0 = com.google.android.gms.internal.ads.zzfho.zzc(r0, r2, r1)
            com.google.android.gms.internal.ads.zzfhj r0 = r0.zza()
            com.google.android.gms.internal.ads.zzdet r1 = r8.zzb
            com.google.android.gms.internal.ads.zzcwm r2 = new com.google.android.gms.internal.ads.zzcwm
            com.google.android.gms.internal.ads.zzfjs r3 = r8.zzd
            com.google.android.gms.internal.ads.zzfjp r4 = r8.zzc
            r2.<init>(r9, r3, r4)
            java.util.concurrent.Executor r3 = r8.zze
            r1.zzj(r2, r3)
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzblj.zzge
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0106
            com.google.android.gms.internal.ads.zzfdy r1 = r9.zzb
            java.util.List<com.google.android.gms.internal.ads.zzfdn> r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
        L_0x00c4:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0106
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.ads.zzfdn r2 = (com.google.android.gms.internal.ads.zzfdn) r2
            com.google.android.gms.internal.ads.zzehy r3 = r8.zzi
            r3.zzc(r2)
            java.util.List<java.lang.String> r3 = r2.zza
            java.util.Iterator r3 = r3.iterator()
        L_0x00db:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00f8
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.internal.ads.zzday<AdT> r5 = r8.zzg
            int r6 = r2.zzb
            com.google.android.gms.internal.ads.zzeht r4 = r5.zza(r6, r4)
            if (r4 == 0) goto L_0x00db
            boolean r4 = r4.zzb(r9, r2)
            if (r4 == 0) goto L_0x00db
            goto L_0x00c4
        L_0x00f8:
            com.google.android.gms.internal.ads.zzehy r3 = r8.zzi
            r4 = 0
            r6 = 1
            r7 = 0
            com.google.android.gms.internal.ads.zzbew r6 = com.google.android.gms.internal.ads.zzfey.zzd(r6, r7, r7)
            r3.zzd(r2, r4, r6)
            goto L_0x00c4
        L_0x0106:
            com.google.android.gms.internal.ads.zzfdy r1 = r9.zzb
            java.util.List<com.google.android.gms.internal.ads.zzfdn> r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x010f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x017e
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzfdn r3 = (com.google.android.gms.internal.ads.zzfdn) r3
            java.util.List<java.lang.String> r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x0121:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x017b
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzday<AdT> r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzeht r6 = r6.zza(r7, r5)
            if (r6 == 0) goto L_0x0121
            boolean r7 = r6.zzb(r9, r3)
            if (r7 == 0) goto L_0x0121
            com.google.android.gms.internal.ads.zzfie r4 = r8.zza
            com.google.android.gms.internal.ads.zzfhy r7 = com.google.android.gms.internal.ads.zzfhy.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzfhv r0 = r4.zzb(r7, r0)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            int r4 = r4.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r4 = r4 + 26
            r7.<init>(r4)
            java.lang.String r4 = "render-config-"
            r7.append(r4)
            r7.append(r2)
            java.lang.String r4 = "-"
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = r7.toString()
            com.google.android.gms.internal.ads.zzfhv r0 = r0.zzh(r4)
            com.google.android.gms.internal.ads.zzelk r4 = new com.google.android.gms.internal.ads.zzelk
            r4.<init>(r8, r9, r3, r6)
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzfhv r0 = r0.zzc(r3, r4)
            com.google.android.gms.internal.ads.zzfhj r0 = r0.zza()
        L_0x017b:
            int r2 = r2 + 1
            goto L_0x010f
        L_0x017e:
            r9 = r0
        L_0x017f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzell.zza(java.lang.Object):com.google.android.gms.internal.ads.zzfxa");
    }

    public final /* synthetic */ zzfxa zzb(zzfdz zzfdz, zzfdn zzfdn, zzeht zzeht, Throwable th2) throws Exception {
        zzelg zzelg = this.zzh;
        zzfxa zzo = zzfwq.zzo(zzeht.zza(zzfdz, zzfdn), (long) zzfdn.zzO, TimeUnit.MILLISECONDS, this.zzf);
        zzelg.zze(zzfdz, zzfdn, zzo, this.zzc);
        return zzo;
    }
}
