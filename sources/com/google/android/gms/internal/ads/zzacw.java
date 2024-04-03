package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzacw {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzfd zzg = new zzfd(255);

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzwq zzwq, boolean z11) throws IOException {
        zza();
        this.zzg.zzC(27);
        if (zzwt.zzc(zzwq, this.zzg.zzH(), 0, 27, z11) && this.zzg.zzs() == 1332176723) {
            if (this.zzg.zzk() == 0) {
                this.zza = this.zzg.zzk();
                this.zzb = this.zzg.zzp();
                this.zzg.zzq();
                this.zzg.zzq();
                this.zzg.zzq();
                int zzk = this.zzg.zzk();
                this.zzc = zzk;
                this.zzd = zzk + 27;
                this.zzg.zzC(zzk);
                if (zzwt.zzc(zzwq, this.zzg.zzH(), 0, this.zzc, z11)) {
                    for (int i11 = 0; i11 < this.zzc; i11++) {
                        this.zzf[i11] = this.zzg.zzk();
                        this.zze += this.zzf[i11];
                    }
                    return true;
                }
            } else if (z11) {
                return false;
            } else {
                throw zzbj.zzc("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean zzc(zzwq zzwq, long j11) throws IOException {
        boolean z11;
        int i11;
        if (zzwq.zze() == zzwq.zzd()) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        this.zzg.zzC(4);
        while (true) {
            i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
            if ((i11 == 0 || zzwq.zze() + 4 < j11) && zzwt.zzc(zzwq, this.zzg.zzH(), 0, 4, true)) {
                this.zzg.zzF(0);
                if (this.zzg.zzs() != 1332176723) {
                    ((zzwk) zzwq).zzo(1, false);
                } else {
                    zzwq.zzj();
                    return true;
                }
            }
        }
        do {
            if ((i11 != 0 && zzwq.zze() >= j11) || zzwq.zzb(1) == -1) {
                return false;
            }
            break;
        } while (zzwq.zzb(1) == -1);
        return false;
    }
}
