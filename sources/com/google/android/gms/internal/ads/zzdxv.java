package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzdxv implements zzdhm, zzdgf, zzdeu, zzdfl, zzbes, zzdjy {
    private final zzbay zza;
    @GuardedBy("this")
    private boolean zzb = false;

    public zzdxv(zzbay zzbay, @Nullable zzfbi zzfbi) {
        this.zza = zzbay;
        zzbay.zzc(2);
        if (zzfbi != null) {
            zzbay.zzc(1101);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzc(7);
            this.zzb = true;
            return;
        }
        this.zza.zzc(8);
    }

    public final void zza(zzbew zzbew) {
        switch (zzbew.zza) {
            case 1:
                this.zza.zzc(101);
                return;
            case 2:
                this.zza.zzc(102);
                return;
            case 3:
                this.zza.zzc(5);
                return;
            case 4:
                this.zza.zzc(103);
                return;
            case 5:
                this.zza.zzc(104);
                return;
            case 6:
                this.zza.zzc(105);
                return;
            case 7:
                this.zza.zzc(106);
                return;
            default:
                this.zza.zzc(4);
                return;
        }
    }

    public final void zzb() {
        this.zza.zzc(1109);
    }

    public final void zzc(zzbbr zzbbr) {
        this.zza.zzb(new zzdxr(zzbbr));
        this.zza.zzc(1103);
    }

    public final void zzd(zzcdq zzcdq) {
    }

    public final void zze(zzfdz zzfdz) {
        this.zza.zzb(new zzdxu(zzfdz));
    }

    public final void zzf(zzbbr zzbbr) {
        this.zza.zzb(new zzdxs(zzbbr));
        this.zza.zzc(1102);
    }

    public final void zzh(boolean z11) {
        this.zza.zzc(true != z11 ? 1108 : 1107);
    }

    public final void zzi(zzbbr zzbbr) {
        this.zza.zzb(new zzdxt(zzbbr));
        this.zza.zzc(1104);
    }

    public final void zzk(boolean z11) {
        this.zza.zzc(true != z11 ? 1106 : 1105);
    }

    public final synchronized void zzl() {
        this.zza.zzc(6);
    }

    public final void zzn() {
        this.zza.zzc(3);
    }
}
