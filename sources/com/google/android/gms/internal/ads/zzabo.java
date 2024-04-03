package com.google.android.gms.internal.ads;

final class zzabo {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzfd zzf;
    private final zzfd zzg;
    private int zzh;
    private int zzi;

    public zzabo(zzfd zzfd, zzfd zzfd2, boolean z11) throws zzbj {
        this.zzg = zzfd;
        this.zzf = zzfd2;
        this.zze = z11;
        zzfd2.zzF(12);
        this.zza = zzfd2.zzn();
        zzfd.zzF(12);
        this.zzi = zzfd.zzn();
        zzwt.zzb(zzfd.zze() != 1 ? false : true, "first_chunk must be 1");
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
            j11 = this.zzf.zzt();
        } else {
            j11 = this.zzf.zzs();
        }
        this.zzd = j11;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzn();
            this.zzg.zzG(4);
            int i12 = -1;
            int i13 = this.zzi - 1;
            this.zzi = i13;
            if (i13 > 0) {
                i12 = -1 + this.zzg.zzn();
            }
            this.zzh = i12;
        }
        return true;
    }
}
