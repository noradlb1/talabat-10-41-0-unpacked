package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C;
import java.io.IOException;

final class zzaev {
    private final zzfk zza = new zzfk(0);
    private final zzfd zzb = new zzfd();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;

    public zzaev(int i11) {
    }

    private final int zze(zzwq zzwq) {
        zzfd zzfd = this.zzb;
        byte[] bArr = zzfn.zzf;
        int length = bArr.length;
        zzfd.zzD(bArr, 0);
        this.zzc = true;
        zzwq.zzj();
        return 0;
    }

    public final int zza(zzwq zzwq, zzxm zzxm, int i11) throws IOException {
        if (i11 <= 0) {
            zze(zzwq);
            return 0;
        }
        boolean z11 = this.zze;
        long j11 = C.TIME_UNSET;
        if (!z11) {
            long zzc2 = zzwq.zzc();
            int min = (int) Math.min(112800, zzc2);
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
            int zzd2 = zzfd.zzd();
            int i12 = zzd2 - 188;
            while (true) {
                if (i12 < zzc3) {
                    break;
                }
                byte[] zzH = zzfd.zzH();
                int i13 = -4;
                int i14 = 0;
                while (true) {
                    if (i13 > 4) {
                        break;
                    }
                    int i15 = (i13 * 188) + i12;
                    if (i15 < zzc3 || i15 >= zzd2 || zzH[i15] != 71) {
                        i14 = 0;
                    } else {
                        i14++;
                        if (i14 == 5) {
                            long zzb2 = zzaff.zzb(zzfd, i12, i11);
                            if (zzb2 != C.TIME_UNSET) {
                                j11 = zzb2;
                                break;
                            }
                        }
                    }
                    i13++;
                }
                i12--;
            }
            this.zzg = j11;
            this.zze = true;
            return 0;
        } else if (this.zzg == C.TIME_UNSET) {
            zze(zzwq);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzwq.zzc());
            if (zzwq.zze() != 0) {
                zzxm.zza = 0;
                return 1;
            }
            this.zzb.zzC(min2);
            zzwq.zzj();
            ((zzwk) zzwq).zzm(this.zzb.zzH(), 0, min2, false);
            zzfd zzfd2 = this.zzb;
            int zzc4 = zzfd2.zzc();
            int zzd3 = zzfd2.zzd();
            while (true) {
                if (zzc4 >= zzd3) {
                    break;
                }
                if (zzfd2.zzH()[zzc4] == 71) {
                    long zzb3 = zzaff.zzb(zzfd2, zzc4, i11);
                    if (zzb3 != C.TIME_UNSET) {
                        j11 = zzb3;
                        break;
                    }
                }
                zzc4++;
            }
            this.zzf = j11;
            this.zzd = true;
            return 0;
        } else {
            long j13 = this.zzf;
            if (j13 == C.TIME_UNSET) {
                zze(zzwq);
                return 0;
            }
            long zzb4 = this.zza.zzb(this.zzg) - this.zza.zzb(j13);
            this.zzh = zzb4;
            if (zzb4 < 0) {
                StringBuilder sb2 = new StringBuilder(65);
                sb2.append("Invalid duration: ");
                sb2.append(zzb4);
                sb2.append(". Using TIME_UNSET instead.");
                Log.w("TsDurationReader", sb2.toString());
                this.zzh = C.TIME_UNSET;
            }
            zze(zzwq);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfk zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
