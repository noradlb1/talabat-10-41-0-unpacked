package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzaaz {
    private final zzfd zza = new zzfd(8);
    private int zzb;

    private final long zzb(zzwq zzwq) throws IOException {
        zzwk zzwk = (zzwk) zzwq;
        int i11 = 0;
        zzwk.zzm(this.zza.zzH(), 0, 1, false);
        byte b11 = this.zza.zzH()[0] & 255;
        if (b11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((b11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = b11 & (~i12);
        zzwk.zzm(this.zza.zzH(), 1, i13, false);
        while (i11 < i13) {
            i11++;
            i14 = (this.zza.zzH()[i11] & 255) + (i14 << 8);
        }
        this.zzb += i13 + 1;
        return (long) i14;
    }

    public final boolean zza(zzwq zzwq) throws IOException {
        long zzb2;
        int i11;
        long zzc = zzwq.zzc();
        int i12 = (zzc > -1 ? 1 : (zzc == -1 ? 0 : -1));
        long j11 = 1024;
        if (i12 != 0 && zzc <= 1024) {
            j11 = zzc;
        }
        int i13 = (int) j11;
        zzwk zzwk = (zzwk) zzwq;
        zzwk.zzm(this.zza.zzH(), 0, 4, false);
        long zzs = this.zza.zzs();
        this.zzb = 4;
        while (zzs != 440786851) {
            int i14 = this.zzb + 1;
            this.zzb = i14;
            if (i14 == i13) {
                return false;
            }
            zzwk.zzm(this.zza.zzH(), 0, 1, false);
            zzs = ((zzs << 8) & -256) | ((long) (this.zza.zzH()[0] & 255));
        }
        long zzb3 = zzb(zzwq);
        long j12 = (long) this.zzb;
        if (zzb3 != Long.MIN_VALUE && (i12 == 0 || j12 + zzb3 < zzc)) {
            while (true) {
                int i15 = (((long) this.zzb) > (j12 + zzb3) ? 1 : (((long) this.zzb) == (j12 + zzb3) ? 0 : -1));
                if (i15 < 0) {
                    if (zzb(zzwq) == Long.MIN_VALUE || zzb2 < 0) {
                        return false;
                    }
                    if (i11 != 0) {
                        int zzb4 = (int) (zzb2 = zzb(zzwq));
                        zzwk.zzl(zzb4, false);
                        this.zzb += zzb4;
                    }
                } else if (i15 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
