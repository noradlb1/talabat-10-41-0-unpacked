package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzxj {
    public int zza;
    @Nullable
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final boolean zza(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (!zzxk.zzm(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return false;
        }
        this.zza = i12;
        this.zzb = zzxk.zza[3 - i13];
        int i18 = zzxk.zzb[i15];
        this.zzd = i18;
        int i19 = 2;
        if (i12 == 2) {
            this.zzd = i18 / 2;
        } else if (i12 == 0) {
            this.zzd = i18 / 4;
        }
        int i21 = (i11 >>> 9) & 1;
        this.zzg = zzxk.zzl(i12, i13);
        if (i13 == 3) {
            if (i12 == 3) {
                i17 = zzxk.zzc[i14 - 1];
            } else {
                i17 = zzxk.zzd[i14 - 1];
            }
            this.zzf = i17;
            this.zzc = (((i17 * 12) / this.zzd) + i21) * 4;
        } else {
            int i22 = Opcodes.D2F;
            if (i12 == 3) {
                if (i13 == 2) {
                    i16 = zzxk.zze[i14 - 1];
                } else {
                    i16 = zzxk.zzf[i14 - 1];
                }
                this.zzf = i16;
                this.zzc = ((i16 * Opcodes.D2F) / this.zzd) + i21;
            } else {
                int i23 = zzxk.zzg[i14 - 1];
                this.zzf = i23;
                if (i13 == 1) {
                    i22 = 72;
                }
                this.zzc = ((i22 * i23) / this.zzd) + i21;
            }
        }
        if (((i11 >> 6) & 3) == 3) {
            i19 = 1;
        }
        this.zze = i19;
        return true;
    }
}
