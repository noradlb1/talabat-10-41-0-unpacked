package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class zzabk implements zzabi {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    @Nullable
    private final long[] zzf;

    private zzabk(long j11, int i11, long j12, long j13, @Nullable long[] jArr) {
        this.zza = j11;
        this.zzb = i11;
        this.zzc = j12;
        this.zzf = jArr;
        this.zzd = j13;
        this.zze = j13 != -1 ? j11 + j13 : -1;
    }

    @Nullable
    public static zzabk zza(long j11, long j12, zzxj zzxj, zzfd zzfd) {
        int zzn;
        long j13 = j11;
        zzxj zzxj2 = zzxj;
        int i11 = zzxj2.zzg;
        int i12 = zzxj2.zzd;
        int zze2 = zzfd.zze();
        if ((zze2 & 1) != 1 || (zzn = zzfd.zzn()) == 0) {
            return null;
        }
        long zzt = zzfn.zzt((long) zzn, ((long) i11) * 1000000, (long) i12);
        if ((zze2 & 6) != 6) {
            return new zzabk(j12, zzxj2.zzc, zzt, -1, (long[]) null);
        }
        long zzs = zzfd.zzs();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = (long) zzfd.zzk();
        }
        if (j13 != -1) {
            long j14 = j12 + zzs;
            if (j13 != j14) {
                StringBuilder sb2 = new StringBuilder(67);
                sb2.append("XING data size mismatch: ");
                sb2.append(j13);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(j14);
                Log.w("XingSeeker", sb2.toString());
            }
        }
        return new zzabk(j12, zzxj2.zzc, zzt, zzs, jArr);
    }

    private final long zzd(int i11) {
        return (this.zzc * ((long) i11)) / 100;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc(long j11) {
        long j12;
        double d11;
        long j13 = j11 - this.zza;
        if (!zzh() || j13 <= ((long) this.zzb)) {
            return 0;
        }
        long[] jArr = (long[]) zzdy.zzb(this.zzf);
        double d12 = (((double) j13) * 256.0d) / ((double) this.zzd);
        int zzd2 = zzfn.zzd(jArr, (long) d12, true, true);
        long zzd3 = zzd(zzd2);
        long j14 = jArr[zzd2];
        int i11 = zzd2 + 1;
        long zzd4 = zzd(i11);
        if (zzd2 == 99) {
            j12 = 256;
        } else {
            j12 = jArr[i11];
        }
        if (j14 == j12) {
            d11 = 0.0d;
        } else {
            d11 = (d12 - ((double) j14)) / ((double) (j12 - j14));
        }
        return zzd3 + Math.round(d11 * ((double) (zzd4 - zzd3)));
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzxn zzg(long j11) {
        double d11;
        if (!zzh()) {
            zzxq zzxq = new zzxq(0, this.zza + ((long) this.zzb));
            return new zzxn(zzxq, zzxq);
        }
        long zzo = zzfn.zzo(j11, 0, this.zzc);
        double d12 = (((double) zzo) * 100.0d) / ((double) this.zzc);
        double d13 = 0.0d;
        if (d12 > 0.0d) {
            if (d12 >= 100.0d) {
                d13 = 256.0d;
            } else {
                int i11 = (int) d12;
                long[] jArr = (long[]) zzdy.zzb(this.zzf);
                double d14 = (double) jArr[i11];
                if (i11 == 99) {
                    d11 = 256.0d;
                } else {
                    d11 = (double) jArr[i11 + 1];
                }
                d13 = d14 + ((d12 - ((double) i11)) * (d11 - d14));
            }
        }
        zzxq zzxq2 = new zzxq(zzo, this.zza + zzfn.zzo(Math.round((d13 / 256.0d) * ((double) this.zzd)), (long) this.zzb, this.zzd - 1));
        return new zzxn(zzxq2, zzxq2);
    }

    public final boolean zzh() {
        return this.zzf != null;
    }
}
