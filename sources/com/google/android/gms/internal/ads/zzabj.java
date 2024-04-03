package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzabj implements zzabi {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzabj(long[] jArr, long[] jArr2, long j11, long j12) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j11;
        this.zzd = j12;
    }

    @Nullable
    public static zzabj zza(long j11, long j12, zzxj zzxj, zzfd zzfd) {
        int i11;
        int i12;
        long j13 = j11;
        zzxj zzxj2 = zzxj;
        zzfd zzfd2 = zzfd;
        zzfd2.zzG(10);
        int zze = zzfd.zze();
        if (zze <= 0) {
            return null;
        }
        int i13 = zzxj2.zzd;
        long j14 = (long) zze;
        if (i13 >= 32000) {
            i11 = 1152;
        } else {
            i11 = 576;
        }
        long zzt = zzfn.zzt(j14, ((long) i11) * 1000000, (long) i13);
        int zzo = zzfd.zzo();
        int zzo2 = zzfd.zzo();
        int zzo3 = zzfd.zzo();
        zzfd2.zzG(2);
        long j15 = j12 + ((long) zzxj2.zzc);
        long[] jArr = new long[zzo];
        long[] jArr2 = new long[zzo];
        int i14 = 0;
        long j16 = j12;
        while (i14 < zzo) {
            int i15 = zzo2;
            jArr[i14] = (((long) i14) * zzt) / ((long) zzo);
            long j17 = j15;
            jArr2[i14] = Math.max(j16, j17);
            if (zzo3 == 1) {
                i12 = zzfd.zzk();
            } else if (zzo3 == 2) {
                i12 = zzfd.zzo();
            } else if (zzo3 == 3) {
                i12 = zzfd.zzm();
            } else if (zzo3 != 4) {
                return null;
            } else {
                i12 = zzfd.zzn();
            }
            j16 += (long) (i12 * i15);
            i14++;
            j15 = j17;
            zzo2 = i15;
        }
        if (!(j13 == -1 || j13 == j16)) {
            StringBuilder sb2 = new StringBuilder(67);
            sb2.append("VBRI data size mismatch: ");
            sb2.append(j13);
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(j16);
            Log.w("VbriSeeker", sb2.toString());
        }
        return new zzabj(jArr, jArr2, zzt, j16);
    }

    public final long zzb() {
        return this.zzd;
    }

    public final long zzc(long j11) {
        return this.zza[zzfn.zzd(this.zzb, j11, true, true)];
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzxn zzg(long j11) {
        int zzd2 = zzfn.zzd(this.zza, j11, true, true);
        zzxq zzxq = new zzxq(this.zza[zzd2], this.zzb[zzd2]);
        if (zzxq.zzb < j11) {
            long[] jArr = this.zza;
            if (zzd2 != jArr.length - 1) {
                int i11 = zzd2 + 1;
                return new zzxn(zzxq, new zzxq(jArr[i11], this.zzb[i11]));
            }
        }
        return new zzxn(zzxq, zzxq);
    }

    public final boolean zzh() {
        return true;
    }
}
