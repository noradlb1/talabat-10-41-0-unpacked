package com.google.android.gms.internal.ads;

public final class zzcsu {
    private zzcqp zza;
    private zzcuk zzb;
    private zzfii zzc;
    private zzcuw zzd;
    private zzfez zze;

    private zzcsu() {
    }

    public /* synthetic */ zzcsu(zzcst zzcst) {
    }

    public final zzcqm zza() {
        zzgpz.zzc(this.zza, zzcqp.class);
        zzgpz.zzc(this.zzb, zzcuk.class);
        if (this.zzc == null) {
            this.zzc = new zzfii();
        }
        if (this.zzd == null) {
            this.zzd = new zzcuw();
        }
        if (this.zze == null) {
            this.zze = new zzfez();
        }
        return new zzcui(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzcuh) null);
    }

    public final zzcsu zzb(zzcqp zzcqp) {
        this.zza = zzcqp;
        return this;
    }

    public final zzcsu zzc(zzcuk zzcuk) {
        this.zzb = zzcuk;
        return this;
    }
}
