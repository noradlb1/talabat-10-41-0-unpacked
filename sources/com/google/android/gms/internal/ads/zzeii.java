package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;

final class zzeii implements zzdob {
    private final zzcjf zza;
    private final zzfxa<zzcyh> zzb;
    private final zzfdn zzc;
    private final zzcop zzd;
    private final zzfef zze;
    private final zzbrw zzf;
    private final boolean zzg;

    public zzeii(zzcjf zzcjf, zzfxa<zzcyh> zzfxa, zzfdn zzfdn, zzcop zzcop, zzfef zzfef, boolean z11, zzbrw zzbrw) {
        this.zza = zzcjf;
        this.zzb = zzfxa;
        this.zzc = zzfdn;
        this.zzd = zzcop;
        this.zze = zzfef;
        this.zzg = z11;
        this.zzf = zzbrw;
    }

    public final void zza(boolean z11, Context context, zzdfe zzdfe) {
        boolean z12;
        boolean z13;
        float f11;
        zzcyh zzcyh = (zzcyh) zzfwq.zzq(this.zzb);
        this.zzd.zzap(true);
        if (this.zzg) {
            z12 = this.zzf.zze(true);
        } else {
            z12 = true;
        }
        if (this.zzg) {
            z13 = this.zzf.zzd();
        } else {
            z13 = false;
        }
        boolean z14 = z13;
        if (this.zzg) {
            f11 = this.zzf.zza();
        } else {
            f11 = 0.0f;
        }
        zzj zzj = new zzj(z12, true, z14, f11, -1, z11, this.zzc.zzL, false);
        if (zzdfe != null) {
            zzdfe.zzf();
        }
        zzt.zzj();
        zzdnq zzg2 = zzcyh.zzg();
        zzcop zzcop = this.zzd;
        int i11 = this.zzc.zzN;
        if (i11 == -1) {
            zzbfo zzbfo = this.zze.zzj;
            if (zzbfo != null) {
                int i12 = zzbfo.zza;
                if (i12 == 1) {
                    i11 = 7;
                } else if (i12 == 2) {
                    i11 = 6;
                }
            }
            zzciz.zze("Error setting app open orientation; no targeting orientation available.");
            i11 = this.zzc.zzN;
        }
        int i13 = i11;
        zzcjf zzcjf = this.zza;
        zzfdn zzfdn = this.zzc;
        String str = zzfdn.zzC;
        zzfds zzfds = zzfdn.zzt;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzbes) null, (zzo) zzg2, (zzw) null, zzcop, i13, zzcjf, str, zzj, zzfds.zzb, zzfds.zza, this.zze.zzf, zzdfe);
        zzm.zza(context, adOverlayInfoParcel, true);
    }
}
