package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

final class zzadv {
    private final zzxt zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzadv(zzxt zzxt) {
        this.zza = zzxt;
    }

    public final void zza(byte[] bArr, int i11, int i12) {
        if (this.zzc) {
            int i13 = this.zzf;
            int i14 = (i11 + 1) - i13;
            if (i14 < i12) {
                this.zzd = ((bArr[i14] & 192) >> 6) == 0;
                this.zzc = false;
                return;
            }
            this.zzf = i13 + (i12 - i11);
        }
    }

    public final void zzb(long j11, int i11, boolean z11) {
        if (this.zze == 182 && z11 && this.zzb) {
            long j12 = this.zzh;
            if (j12 != C.TIME_UNSET) {
                long j13 = this.zzg;
                int i12 = (int) (j11 - j13);
                this.zza.zzs(j12, this.zzd ? 1 : 0, i12, i11, (zzxs) null);
            }
        }
        if (this.zze != 179) {
            this.zzg = j11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(int r5, long r6) {
        /*
            r4 = this;
            r4.zze = r5
            r0 = 0
            r4.zzd = r0
            r1 = 1
            r2 = 182(0xb6, float:2.55E-43)
            if (r5 == r2) goto L_0x0012
            r3 = 179(0xb3, float:2.51E-43)
            if (r5 != r3) goto L_0x0010
            r5 = r3
            goto L_0x0012
        L_0x0010:
            r3 = r0
            goto L_0x0013
        L_0x0012:
            r3 = r1
        L_0x0013:
            r4.zzb = r3
            if (r5 != r2) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            r4.zzc = r1
            r4.zzf = r0
            r4.zzh = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadv.zzc(int, long):void");
    }

    public final void zzd() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }
}
