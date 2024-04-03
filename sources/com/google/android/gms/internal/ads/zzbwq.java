package com.google.android.gms.internal.ads;

public final class zzbwq {
    private final zzbvt zza;
    private zzfxa<zzbvu> zzb;

    public zzbwq(zzbvt zzbvt) {
        this.zza = zzbvt;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzcjr zzcjr = new zzcjr();
            this.zzb = zzcjr;
            this.zza.zzb((zzalt) null).zzi(new zzbwn(zzcjr), new zzbwm(zzcjr));
        }
    }

    public final <I, O> zzbwt<I, O> zza(String str, zzbwa<I> zzbwa, zzbvz<O> zzbvz) {
        zzd();
        return new zzbwt<>(this.zzb, "google.afma.activeView.handleUpdate", zzbwa, zzbvz);
    }

    public final void zzb(String str, zzbrt<? super zzbvu> zzbrt) {
        zzd();
        this.zzb = zzfwq.zzn(this.zzb, new zzbwp(str, zzbrt), zzcjm.zzf);
    }

    public final void zzc(String str, zzbrt<? super zzbvu> zzbrt) {
        this.zzb = zzfwq.zzm(this.zzb, new zzbwo(str, zzbrt), zzcjm.zzf);
    }
}
