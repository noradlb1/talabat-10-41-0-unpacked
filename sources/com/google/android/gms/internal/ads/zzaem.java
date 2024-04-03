package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;

final class zzaem {
    private final zzfk zza = new zzfk(0);
    private final zzfd zzb = new zzfd();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;

    public static long zzc(zzfd zzfd) {
        zzfd zzfd2 = zzfd;
        int zzc2 = zzfd.zzc();
        if (zzfd.zza() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzfd2.zzB(bArr, 0, 9);
        zzfd2.zzF(zzc2);
        byte b11 = bArr[0];
        if ((b11 & 196) == 68) {
            byte b12 = bArr[2];
            if ((b12 & 4) == 4) {
                byte b13 = bArr[4];
                if ((b13 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j11 = (long) b11;
                    long j12 = (long) b12;
                    long j13 = (j11 & 3) << 28;
                    return ((((long) bArr[1]) & 255) << 20) | j13 | (((56 & j11) >> 3) << 30) | (((j12 & 248) >> 3) << 15) | ((j12 & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) b13) & 248) >> 3);
                }
            }
        }
        return C.TIME_UNSET;
    }

    private final int zzf(zzwq zzwq) {
        zzfd zzfd = this.zzb;
        byte[] bArr = zzfn.zzf;
        int length = bArr.length;
        zzfd.zzD(bArr, 0);
        this.zzc = true;
        zzwq.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i11 + 1] & 255) << Ascii.DLE) | ((bArr[i11 + 2] & 255) << 8);
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        boolean z11 = this.zze;
        long j11 = C.TIME_UNSET;
        if (!z11) {
            long zzc2 = zzwq.zzc();
            int min = (int) Math.min(20000, zzc2);
            long j12 = zzc2 - ((long) min);
            if (zzwq.zze() != j12) {
                zzxm.zza = j12;
                return 1;
            }
            this.zzb.zzC(min);
            zzwq.zzj();
            ((zzwk) zzwq).zzm(this.zzb.zzH(), 0, min, false);
            zzfd zzfd = this.zzb;
            int zzc3 = zzfd.zzc();
            int zzd2 = zzfd.zzd() - 4;
            while (true) {
                if (zzd2 < zzc3) {
                    break;
                }
                if (zzg(zzfd.zzH(), zzd2) == 442) {
                    zzfd.zzF(zzd2 + 4);
                    long zzc4 = zzc(zzfd);
                    if (zzc4 != C.TIME_UNSET) {
                        j11 = zzc4;
                        break;
                    }
                }
                zzd2--;
            }
            this.zzg = j11;
            this.zze = true;
            return 0;
        } else if (this.zzg == C.TIME_UNSET) {
            zzf(zzwq);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000, zzwq.zzc());
            if (zzwq.zze() != 0) {
                zzxm.zza = 0;
                return 1;
            }
            this.zzb.zzC(min2);
            zzwq.zzj();
            ((zzwk) zzwq).zzm(this.zzb.zzH(), 0, min2, false);
            zzfd zzfd2 = this.zzb;
            int zzc5 = zzfd2.zzc();
            int zzd3 = zzfd2.zzd();
            while (true) {
                if (zzc5 >= zzd3 - 3) {
                    break;
                }
                if (zzg(zzfd2.zzH(), zzc5) == 442) {
                    zzfd2.zzF(zzc5 + 4);
                    long zzc6 = zzc(zzfd2);
                    if (zzc6 != C.TIME_UNSET) {
                        j11 = zzc6;
                        break;
                    }
                }
                zzc5++;
            }
            this.zzf = j11;
            this.zzd = true;
            return 0;
        } else {
            long j13 = this.zzf;
            if (j13 == C.TIME_UNSET) {
                zzf(zzwq);
                return 0;
            }
            long zzb2 = this.zza.zzb(this.zzg) - this.zza.zzb(j13);
            this.zzh = zzb2;
            if (zzb2 < 0) {
                StringBuilder sb2 = new StringBuilder(65);
                sb2.append("Invalid duration: ");
                sb2.append(zzb2);
                sb2.append(". Using TIME_UNSET instead.");
                Log.w("PsDurationReader", sb2.toString());
                this.zzh = C.TIME_UNSET;
            }
            zzf(zzwq);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfk zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
