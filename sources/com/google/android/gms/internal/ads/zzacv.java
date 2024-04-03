package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

final class zzacv {
    private final zzacw zza = new zzacw();
    private final zzfd zzb = new zzfd(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    private final int zzf(int i11) {
        int i12;
        int i13 = 0;
        this.zzd = 0;
        do {
            int i14 = this.zzd;
            int i15 = i11 + i14;
            zzacw zzacw = this.zza;
            if (i15 >= zzacw.zzc) {
                break;
            }
            int[] iArr = zzacw.zzf;
            this.zzd = i14 + 1;
            i12 = iArr[i15];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public final zzfd zza() {
        return this.zzb;
    }

    public final zzacw zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzC(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        if (this.zzb.zzH().length != 65025) {
            zzfd zzfd = this.zzb;
            zzfd.zzD(Arrays.copyOf(zzfd.zzH(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.zzb.zzd())), this.zzb.zzd());
        }
    }

    public final boolean zze(zzwq zzwq) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzC(0);
        }
        while (true) {
            boolean z11 = true;
            if (this.zze) {
                return true;
            }
            int i11 = this.zzc;
            if (i11 < 0) {
                if (!this.zza.zzc(zzwq, -1) || !this.zza.zzb(zzwq, true)) {
                    return false;
                }
                zzacw zzacw = this.zza;
                int i12 = zzacw.zzd;
                if ((zzacw.zza & 1) == 1 && this.zzb.zzd() == 0) {
                    i12 += zzf(0);
                    i11 = this.zzd;
                } else {
                    i11 = 0;
                }
                if (!zzwt.zze(zzwq, i12)) {
                    return false;
                }
                this.zzc = i11;
            }
            int zzf = zzf(i11);
            int i13 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzfd zzfd = this.zzb;
                zzfd.zzz(zzfd.zzd() + zzf);
                if (!zzwt.zzd(zzwq, this.zzb.zzH(), this.zzb.zzd(), zzf)) {
                    return false;
                }
                zzfd zzfd2 = this.zzb;
                zzfd2.zzE(zzfd2.zzd() + zzf);
                if (this.zza.zzf[i13 - 1] == 255) {
                    z11 = false;
                }
                this.zze = z11;
            }
            if (i13 == this.zza.zzc) {
                i13 = -1;
            }
            this.zzc = i13;
        }
        return false;
    }
}
