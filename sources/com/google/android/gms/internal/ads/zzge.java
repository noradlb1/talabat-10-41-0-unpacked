package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzge implements zzht {
    private final zziv zza;
    private final zzgd zzb;
    @Nullable
    private zzil zzc;
    @Nullable
    private zzht zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzge(zzgd zzgd, zzdz zzdz) {
        this.zzb = zzgd;
        this.zza = new zziv(zzdz);
    }

    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z11) {
        zzil zzil = this.zzc;
        if (zzil == null || zzil.zzL() || (!this.zzc.zzM() && (z11 || this.zzc.zzF()))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzht zzht = this.zzd;
            zzht.getClass();
            long zza2 = zzht.zza();
            if (this.zze) {
                if (zza2 < this.zza.zza()) {
                    this.zza.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zzd();
                    }
                }
            }
            this.zza.zzb(zza2);
            zzbn zzc2 = zzht.zzc();
            if (!zzc2.equals(this.zza.zzc())) {
                this.zza.zzg(zzc2);
                this.zzb.zza(zzc2);
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzht zzht2 = this.zzd;
        zzht2.getClass();
        return zzht2.zza();
    }

    public final zzbn zzc() {
        zzht zzht = this.zzd;
        return zzht != null ? zzht.zzc() : this.zza.zzc();
    }

    public final void zzd(zzil zzil) {
        if (zzil == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzil zzil) throws zzgg {
        zzht zzht;
        zzht zzi = zzil.zzi();
        if (zzi != null && zzi != (zzht = this.zzd)) {
            if (zzht == null) {
                this.zzd = zzi;
                this.zzc = zzil;
                zzi.zzg(this.zza.zzc());
                return;
            }
            throw zzgg.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j11) {
        this.zza.zzb(j11);
    }

    public final void zzg(zzbn zzbn) {
        zzht zzht = this.zzd;
        if (zzht != null) {
            zzht.zzg(zzbn);
            zzbn = this.zzd.zzc();
        }
        this.zza.zzg(zzbn);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }
}
