package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzeob extends zzbhf {
    @VisibleForTesting
    final zzfed zza;
    @VisibleForTesting
    final zzdql zzb = new zzdql();
    private final Context zzc;
    private final zzcqm zzd;
    private zzbgx zze;

    public zzeob(zzcqm zzcqm, Context context, String str) {
        zzfed zzfed = new zzfed();
        this.zza = zzfed;
        this.zzd = zzcqm;
        zzfed.zzs(str);
        this.zzc = context;
    }

    public final zzbhd zze() {
        zzdqn zzg = this.zzb.zzg();
        this.zza.zzA(zzg.zzi());
        this.zza.zzB(zzg.zzh());
        zzfed zzfed = this.zza;
        if (zzfed.zzg() == null) {
            zzfed.zzr(zzbfi.zzc());
        }
        return new zzeoc(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbpg zzbpg) {
        this.zzb.zza(zzbpg);
    }

    public final void zzg(zzbpj zzbpj) {
        this.zzb.zzb(zzbpj);
    }

    public final void zzh(String str, zzbpp zzbpp, @Nullable zzbpm zzbpm) {
        this.zzb.zzc(str, zzbpp, zzbpm);
    }

    public final void zzi(zzbui zzbui) {
        this.zzb.zzd(zzbui);
    }

    public final void zzj(zzbpt zzbpt, zzbfi zzbfi) {
        this.zzb.zze(zzbpt);
        this.zza.zzr(zzbfi);
    }

    public final void zzk(zzbpw zzbpw) {
        this.zzb.zzf(zzbpw);
    }

    public final void zzl(zzbgx zzbgx) {
        this.zze = zzbgx;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzq(adManagerAdViewOptions);
    }

    public final void zzn(zzbtz zzbtz) {
        this.zza.zzv(zzbtz);
    }

    public final void zzo(zzbnw zzbnw) {
        this.zza.zzz(zzbnw);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzC(publisherAdViewOptions);
    }

    public final void zzq(zzbhv zzbhv) {
        this.zza.zzO(zzbhv);
    }
}
