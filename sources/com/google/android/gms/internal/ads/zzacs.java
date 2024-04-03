package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzacs extends zzadc {
    @Nullable
    private zzxd zza;
    @Nullable
    private zzacr zzb;

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    public final long zza(zzfd zzfd) {
        if (!zzd(zzfd.zzH())) {
            return -1;
        }
        int i11 = (zzfd.zzH()[2] & 255) >> 4;
        if (i11 != 6) {
            if (i11 == 7) {
                i11 = 7;
            }
            int zza2 = zzwy.zza(zzfd, i11);
            zzfd.zzF(0);
            return (long) zza2;
        }
        zzfd.zzG(4);
        zzfd.zzu();
        int zza22 = zzwy.zza(zzfd, i11);
        zzfd.zzF(0);
        return (long) zza22;
    }

    public final void zzb(boolean z11) {
        super.zzb(z11);
        if (z11) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfd zzfd, long j11, zzacz zzacz) {
        byte[] zzH = zzfd.zzH();
        zzxd zzxd = this.zza;
        if (zzxd == null) {
            zzxd zzxd2 = new zzxd(zzH, 17);
            this.zza = zzxd2;
            zzacz.zza = zzxd2.zzc(Arrays.copyOfRange(zzH, 9, zzfd.zzd()), (zzdd) null);
            return true;
        } else if ((zzH[0] & Byte.MAX_VALUE) == 3) {
            zzxc zzb2 = zzxa.zzb(zzfd);
            zzxd zzf = zzxd.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzacr(zzf, zzb2);
            return true;
        } else if (!zzd(zzH)) {
            return true;
        } else {
            zzacr zzacr = this.zzb;
            if (zzacr != null) {
                zzacr.zza(j11);
                zzacz.zzb = this.zzb;
            }
            zzacz.zza.getClass();
            return false;
        }
    }
}
