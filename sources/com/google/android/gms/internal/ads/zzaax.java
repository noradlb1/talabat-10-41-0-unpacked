package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class zzaax {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    @RequiresNonNull({"#1.output"})
    public final void zza(zzaaw zzaaw) {
        if (this.zzc > 0) {
            zzaaw.zzV.zzs(this.zzd, this.zze, this.zzf, this.zzg, zzaaw.zzi);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    @RequiresNonNull({"#1.output"})
    public final void zzc(zzaaw zzaaw, long j11, int i11, int i12, int i13) {
        if (this.zzb) {
            int i14 = this.zzc;
            int i15 = i14 + 1;
            this.zzc = i15;
            if (i14 == 0) {
                this.zzd = j11;
                this.zze = i11;
                this.zzf = 0;
            }
            this.zzf += i12;
            this.zzg = i13;
            if (i15 >= 16) {
                zza(zzaaw);
            }
        }
    }

    public final void zzd(zzwq zzwq) throws IOException {
        if (!this.zzb) {
            ((zzwk) zzwq).zzm(this.zza, 0, 10, false);
            zzwq.zzj();
            byte[] bArr = this.zza;
            int i11 = zzvv.zza;
            if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
                this.zzb = true;
            }
        }
    }
}
