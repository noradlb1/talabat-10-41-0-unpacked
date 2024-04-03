package com.google.android.gms.internal.ads;

final class zzash {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzawu zzf;
    private final zzawu zzg;
    private int zzh;
    private int zzi;

    public zzash(zzawu zzawu, zzawu zzawu2, boolean z11) {
        this.zzg = zzawu;
        this.zzf = zzawu2;
        this.zze = z11;
        zzawu2.zzv(12);
        this.zza = zzawu2.zzi();
        zzawu.zzv(12);
        this.zzi = zzawu.zzi();
        zzawm.zzf(zzawu.zze() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j11;
        int i11 = this.zzb + 1;
        this.zzb = i11;
        if (i11 == this.zza) {
            return false;
        }
        if (this.zze) {
            j11 = this.zzf.zzn();
        } else {
            j11 = this.zzf.zzm();
        }
        this.zzd = j11;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzi();
            this.zzg.zzw(4);
            int i12 = -1;
            int i13 = this.zzi - 1;
            this.zzi = i13;
            if (i13 > 0) {
                i12 = -1 + this.zzg.zzi();
            }
            this.zzh = i12;
        }
        return true;
    }
}
