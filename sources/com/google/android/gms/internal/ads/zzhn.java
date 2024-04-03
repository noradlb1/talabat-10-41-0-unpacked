package com.google.android.gms.internal.ads;

public final class zzhn {
    public zzif zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzhn(zzif zzif) {
        this.zza = zzif;
    }

    public final void zza(int i11) {
        boolean z11 = true;
        if (true != (this.zzg | i11)) {
            z11 = false;
        }
        this.zzg = z11;
        this.zzb += i11;
    }

    public final void zzb(int i11) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i11;
    }

    public final void zzc(zzif zzif) {
        this.zzg |= this.zza != zzif;
        this.zza = zzif;
    }

    public final void zzd(int i11) {
        boolean z11 = true;
        if (!this.zzc || this.zzd == 5) {
            this.zzg = true;
            this.zzc = true;
            this.zzd = i11;
            return;
        }
        if (i11 != 5) {
            z11 = false;
        }
        zzdy.zzd(z11);
    }
}
