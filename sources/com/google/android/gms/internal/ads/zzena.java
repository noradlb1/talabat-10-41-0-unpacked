package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

public final class zzena implements zzeht<zzcyw> {
    private final Context zza;
    private final zzczt zzb;
    @Nullable
    private final zzbme zzc;
    private final zzfxb zzd;
    private final zzfie zze;

    public zzena(Context context, zzczt zzczt, zzfie zzfie, zzfxb zzfxb, @Nullable zzbme zzbme) {
        this.zza = context;
        this.zzb = zzczt;
        this.zze = zzfie;
        this.zzd = zzfxb;
        this.zzc = zzbme;
    }

    public final zzfxa<zzcyw> zza(zzfdz zzfdz, zzfdn zzfdn) {
        zzcyx zza2 = this.zzb.zza(new zzdbk(zzfdz, zzfdn, (String) null), new zzemy(this, new View(this.zza), (zzcop) null, zzemw.zza, zzfdn.zzv.get(0)));
        zzemz zzk = zza2.zzk();
        zzfds zzfds = zzfdn.zzt;
        zzblz zzblz = new zzblz(zzk, zzfds.zzb, zzfds.zza);
        zzfie zzfie = this.zze;
        return zzfho.zzd(new zzemx(this, zzblz), this.zzd, zzfhy.CUSTOM_RENDER_SYN, zzfie).zzb(zzfhy.CUSTOM_RENDER_ACK).zzd(zzfwq.zzi(zza2.zza())).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfdz r1, com.google.android.gms.internal.ads.zzfdn r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbme r1 = r0.zzc
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzfds r1 = r2.zzt
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzena.zzb(com.google.android.gms.internal.ads.zzfdz, com.google.android.gms.internal.ads.zzfdn):boolean");
    }

    public final /* synthetic */ void zzc(zzblz zzblz) throws Exception {
        this.zzc.zze(zzblz);
    }
}
