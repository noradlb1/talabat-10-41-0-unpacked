package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfcq extends zzfmb implements zzdgf, zzdeu, zzder, zzdfh, zzdhc, zzfaz, zzdmd {
    private final zzffj zza;
    private final AtomicReference<zzfmb> zzb = new AtomicReference<>();
    private final AtomicReference<zzcfg> zzc = new AtomicReference<>();
    private final AtomicReference<zzcfc> zzd = new AtomicReference<>();
    private final AtomicReference<zzcem> zze = new AtomicReference<>();
    private final AtomicReference<zzcfh> zzf = new AtomicReference<>();
    private final AtomicReference<zzceh> zzg = new AtomicReference<>();
    private final AtomicReference<zzbit> zzh = new AtomicReference<>();

    public zzfcq(zzffj zzffj) {
        this.zza = zzffj;
    }

    public final void zza(zzbew zzbew) {
        int i11 = zzbew.zza;
        zzfaq.zza(this.zzc, new zzfck(zzbew));
        zzfaq.zza(this.zzc, new zzfcf(i11));
        zzfaq.zza(this.zze, new zzfbu(i11));
    }

    public final void zzb(zzfmb zzfmb) {
        this.zzb.set(zzfmb);
    }

    public final void zzbD() {
        zzfaq.zza(this.zze, zzfbz.zza);
    }

    public final void zzbT(zzfaz zzfaz) {
        throw null;
    }

    public final void zzc(zzbit zzbit) {
        this.zzh.set(zzbit);
    }

    public final void zzd(zzcfc zzcfc) {
        this.zzd.set(zzcfc);
    }

    public final void zze(zzcfg zzcfg) {
        this.zzc.set(zzcfg);
    }

    @Deprecated
    public final void zzf(zzcem zzcem) {
        this.zze.set(zzcem);
    }

    public final void zzg(@NonNull zzbfk zzbfk) {
        zzfaq.zza(this.zzh, new zzfcl(zzbfk));
    }

    @Deprecated
    public final void zzh(zzceh zzceh) {
        this.zzg.set(zzceh);
    }

    public final void zzi(zzcfh zzcfh) {
        this.zzf.set(zzcfh);
    }

    public final void zzj() {
        this.zza.zza();
        zzfaq.zza(this.zzd, zzfcd.zza);
        zzfaq.zza(this.zze, zzfbv.zza);
    }

    public final void zzk(zzbew zzbew) {
        zzfaq.zza(this.zzd, new zzfci(zzbew));
        zzfaq.zza(this.zzd, new zzfcj(zzbew));
    }

    public final void zzm() {
        zzfaq.zza(this.zze, zzfbw.zza);
    }

    public final void zzn() {
        zzfaq.zza(this.zzc, zzfcg.zza);
        zzfaq.zza(this.zze, zzfbx.zza);
    }

    public final void zzo() {
        zzfaq.zza(this.zzd, zzfce.zza);
        zzfaq.zza(this.zze, zzfby.zza);
        zzfaq.zza(this.zzd, zzfcc.zza);
    }

    public final void zzp(zzceg zzceg, String str, String str2) {
        zzfaq.zza(this.zzd, new zzfcn(zzceg));
        zzfaq.zza(this.zzf, new zzfcp(zzceg, str, str2));
        zzfaq.zza(this.zze, new zzfcm(zzceg));
        zzfaq.zza(this.zzg, new zzfco(zzceg, str, str2));
    }

    public final void zzq() {
        zzfaq.zza(this.zzd, zzfcb.zza);
    }

    public final void zzr() {
        zzfaq.zza(this.zze, zzfca.zza);
    }

    public final void zzv() {
        zzfaq.zza(this.zzb, zzfch.zza);
    }
}
