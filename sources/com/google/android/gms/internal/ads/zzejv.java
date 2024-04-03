package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;

final class zzejv implements zzdob {
    private final Context zza;
    private final zzcjf zzb;
    private final zzfxa<zzdmx> zzc;
    private final zzfdn zzd;
    private final zzcop zze;
    private final zzfef zzf;
    private final zzbrw zzg;
    private final boolean zzh;

    public zzejv(Context context, zzcjf zzcjf, zzfxa<zzdmx> zzfxa, zzfdn zzfdn, zzcop zzcop, zzfef zzfef, boolean z11, zzbrw zzbrw) {
        this.zza = context;
        this.zzb = zzcjf;
        this.zzc = zzfxa;
        this.zzd = zzfdn;
        this.zze = zzcop;
        this.zzf = zzfef;
        this.zzg = zzbrw;
        this.zzh = z11;
    }

    public final void zza(boolean z11, Context context, zzdfe zzdfe) {
        boolean z12;
        boolean z13;
        float f11;
        zzdmx zzdmx = (zzdmx) zzfwq.zzq(this.zzc);
        this.zze.zzap(true);
        if (this.zzh) {
            z12 = this.zzg.zze(false);
        } else {
            z12 = false;
        }
        zzt.zzp();
        boolean zzM = com.google.android.gms.ads.internal.util.zzt.zzM(this.zza);
        if (this.zzh) {
            z13 = this.zzg.zzd();
        } else {
            z13 = false;
        }
        if (this.zzh) {
            f11 = this.zzg.zza();
        } else {
            f11 = 0.0f;
        }
        zzj zzj = new zzj(z12, zzM, z13, f11, -1, z11, this.zzd.zzL, false);
        if (zzdfe != null) {
            zzdfe.zzf();
        }
        zzt.zzj();
        zzdnq zzj2 = zzdmx.zzj();
        zzcop zzcop = this.zze;
        zzfdn zzfdn = this.zzd;
        int i11 = zzfdn.zzN;
        zzcjf zzcjf = this.zzb;
        String str = zzfdn.zzC;
        zzfds zzfds = zzfdn.zzt;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzbes) null, (zzo) zzj2, (zzw) null, zzcop, i11, zzcjf, str, zzj, zzfds.zzb, zzfds.zza, this.zzf.zzf, zzdfe);
        zzm.zza(context, adOverlayInfoParcel, true);
    }
}
