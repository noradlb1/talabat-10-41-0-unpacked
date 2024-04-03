package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzcyp extends zzdav {
    @Nullable
    private final zzcop zzc;
    private final int zzd;
    private final Context zze;
    private final zzcxx zzf;
    private final zzdob zzg;
    private final zzdfe zzh;
    private boolean zzi = false;

    public zzcyp(zzdau zzdau, Context context, @Nullable zzcop zzcop, int i11, zzcxx zzcxx, zzdob zzdob, zzdfe zzdfe) {
        super(zzdau);
        this.zzc = zzcop;
        this.zze = context;
        this.zzd = i11;
        this.zzf = zzcxx;
        this.zzg = zzdob;
        this.zzh = zzdfe;
    }

    public final void zzT() {
        super.zzT();
        zzcop zzcop = this.zzc;
        if (zzcop != null) {
            zzcop.destroy();
        }
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzc(zzazn zzazn) {
        zzcop zzcop = this.zzc;
        if (zzcop != null) {
            zzcop.zzaj(zzazn);
        }
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.app.Activity r4, com.google.android.gms.internal.ads.zzbaa r5, boolean r6) throws android.os.RemoteException {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0004
            android.content.Context r4 = r3.zze
        L_0x0004:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzau
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0058
            com.google.android.gms.ads.internal.zzt.zzp()
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzK(r4)
            if (r0 == 0) goto L_0x0058
            java.lang.String r5 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzciz.zzj(r5)
            com.google.android.gms.internal.ads.zzdfe r5 = r3.zzh
            r5.zzb()
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzblj.zzav
            com.google.android.gms.internal.ads.zzblh r6 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r5 = r6.zzb(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00ae
            com.google.android.gms.internal.ads.zzfms r5 = new com.google.android.gms.internal.ads.zzfms
            android.content.Context r4 = r4.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbz r6 = com.google.android.gms.ads.internal.zzt.zzt()
            android.os.Looper r6 = r6.zzb()
            r5.<init>(r4, r6)
            com.google.android.gms.internal.ads.zzfdz r4 = r3.zza
            com.google.android.gms.internal.ads.zzfdy r4 = r4.zzb
            com.google.android.gms.internal.ads.zzfdq r4 = r4.zzb
            java.lang.String r4 = r4.zzb
            r5.zza(r4)
            return
        L_0x0058:
            boolean r0 = r3.zzi
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.internal.ads.zzciz.zzj(r0)
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzhi
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zzdfe r0 = r3.zzh
            r1 = 10
            r2 = 0
            com.google.android.gms.internal.ads.zzbew r1 = com.google.android.gms.internal.ads.zzfey.zzd(r1, r2, r2)
            r0.zza(r1)
        L_0x007f:
            boolean r0 = r3.zzi
            if (r0 != 0) goto L_0x00ae
            com.google.android.gms.internal.ads.zzdob r0 = r3.zzg     // Catch:{ zzdoa -> 0x008e }
            com.google.android.gms.internal.ads.zzdfe r1 = r3.zzh     // Catch:{ zzdoa -> 0x008e }
            r0.zza(r6, r4, r1)     // Catch:{ zzdoa -> 0x008e }
            r4 = 1
            r3.zzi = r4
            return
        L_0x008e:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzblj.zzhi
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r6 = r0.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzdfe r5 = r3.zzh
            r5.zze(r4)
            return
        L_0x00a7:
            com.google.android.gms.internal.ads.zzbew r4 = com.google.android.gms.internal.ads.zzfey.zza(r4)
            r5.zzd(r4)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyp.zzd(android.app.Activity, com.google.android.gms.internal.ads.zzbaa, boolean):void");
    }

    public final void zze(long j11, int i11) {
        this.zzf.zza(j11, i11);
    }
}
