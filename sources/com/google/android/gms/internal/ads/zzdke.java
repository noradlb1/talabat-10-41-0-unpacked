package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzdke {
    private final Set<zzdlw<zzbes>> zza;
    private final Set<zzdlw<zzdmd>> zzb;
    private final Set<zzdlw<zzder>> zzc;
    private final Set<zzdlw<zzdfl>> zzd;
    private final Set<zzdlw<zzdgq>> zze;
    private final Set<zzdlw<zzdgf>> zzf;
    private final Set<zzdlw<zzdgj>> zzg;
    private final Set<zzdlw<zzdeu>> zzh;
    private final Set<zzdlw<zzdfh>> zzi;
    private final Set<zzdlw<zzfmb>> zzj;
    private final Set<zzdlw<zzaop>> zzk;
    private final Set<zzdlw<zzdhc>> zzl;
    private final Set<zzdlw<zzo>> zzm;
    private final Set<zzdlw<zzdhm>> zzn;
    @Nullable
    private final zzfaz zzo;
    private zzdet zzp;
    private zzelg zzq;

    public /* synthetic */ zzdke(zzdkc zzdkc, zzdkd zzdkd) {
        this.zza = zzdkc.zzc;
        this.zzb = zzdkc.zzd;
        this.zzd = zzdkc.zzf;
        this.zze = zzdkc.zzg;
        this.zzc = zzdkc.zze;
        this.zzf = zzdkc.zzh;
        this.zzg = zzdkc.zza;
        this.zzh = zzdkc.zzi;
        this.zzi = zzdkc.zzl;
        this.zzj = zzdkc.zzj;
        this.zzk = zzdkc.zzk;
        this.zzl = zzdkc.zzm;
        this.zzo = zzdkc.zzo;
        this.zzm = zzdkc.zzn;
        this.zzn = zzdkc.zzb;
    }

    public final zzdet zza(Set<zzdlw<zzdeu>> set) {
        if (this.zzp == null) {
            this.zzp = new zzdet(set);
        }
        return this.zzp;
    }

    public final zzelg zzb(Clock clock, zzelh zzelh, zzehy zzehy, zzfjs zzfjs) {
        if (this.zzq == null) {
            this.zzq = new zzelg(clock, zzelh, zzehy, zzfjs);
        }
        return this.zzq;
    }

    @Nullable
    public final zzfaz zzc() {
        return this.zzo;
    }

    public final Set<zzdlw<zzo>> zzd() {
        return this.zzm;
    }

    public final Set<zzdlw<zzbes>> zze() {
        return this.zza;
    }

    public final Set<zzdlw<zzdeu>> zzf() {
        return this.zzh;
    }

    public final Set<zzdlw<zzdfh>> zzg() {
        return this.zzi;
    }

    public final Set<zzdlw<zzdfl>> zzh() {
        return this.zzd;
    }

    public final Set<zzdlw<zzder>> zzi() {
        return this.zzc;
    }

    public final Set<zzdlw<zzdgf>> zzj() {
        return this.zzf;
    }

    public final Set<zzdlw<zzdgj>> zzk() {
        return this.zzg;
    }

    public final Set<zzdlw<zzfmb>> zzl() {
        return this.zzj;
    }

    public final Set<zzdlw<zzdgq>> zzm() {
        return this.zze;
    }

    public final Set<zzdlw<zzdhc>> zzn() {
        return this.zzl;
    }

    public final Set<zzdlw<zzdhm>> zzo() {
        return this.zzn;
    }

    public final Set<zzdlw<zzaop>> zzp() {
        return this.zzk;
    }

    public final Set<zzdlw<zzdmd>> zzq() {
        return this.zzb;
    }
}
