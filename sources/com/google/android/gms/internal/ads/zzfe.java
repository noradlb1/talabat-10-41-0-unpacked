package com.google.android.gms.internal.ads;

public final class zzfe {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public zzfe(byte[] bArr, int i11, int i12) {
        this.zza = bArr;
        this.zzc = i11;
        this.zzb = i12;
        zzh();
    }

    private final int zzg() {
        int i11 = 0;
        int i12 = 0;
        while (!zzf()) {
            i12++;
        }
        int i13 = (1 << i12) - 1;
        if (i12 > 0) {
            i11 = zza(i12);
        }
        return i13 + i11;
    }

    private final void zzh() {
        int i11;
        int i12 = this.zzc;
        boolean z11 = false;
        if (i12 >= 0 && (i12 < (i11 = this.zzb) || (i12 == i11 && this.zzd == 0))) {
            z11 = true;
        }
        zzdy.zzf(z11);
    }

    private final boolean zzi(int i11) {
        if (i11 < 2 || i11 >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i11] == 3 && bArr[i11 + -2] == 0 && bArr[i11 + -1] == 0;
    }

    public final int zza(int i11) {
        int i12;
        int i13;
        this.zzd += i11;
        int i14 = 0;
        while (true) {
            i12 = this.zzd;
            i13 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.zzd = i15;
            byte[] bArr = this.zza;
            int i16 = this.zzc;
            i14 |= (bArr[i16] & 255) << i15;
            if (true != zzi(i16 + 1)) {
                i13 = 1;
            }
            this.zzc = i16 + i13;
        }
        byte[] bArr2 = this.zza;
        int i17 = this.zzc;
        int i18 = (-1 >>> (32 - i11)) & (i14 | ((bArr2[i17] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.zzd = 0;
            if (true != zzi(i17 + 1)) {
                i13 = 1;
            }
            this.zzc = i17 + i13;
        }
        zzh();
        return i18;
    }

    public final int zzb() {
        int zzg = zzg();
        return (zzg % 2 == 0 ? -1 : 1) * ((zzg + 1) / 2);
    }

    public final int zzc() {
        return zzg();
    }

    public final void zzd() {
        int i11 = 1;
        int i12 = this.zzd + 1;
        this.zzd = i12;
        if (i12 == 8) {
            this.zzd = 0;
            int i13 = this.zzc;
            if (true == zzi(i13 + 1)) {
                i11 = 2;
            }
            this.zzc = i13 + i11;
        }
        zzh();
    }

    public final void zze(int i11) {
        int i12 = this.zzc;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.zzc = i14;
        int i15 = this.zzd + (i11 - (i13 * 8));
        this.zzd = i15;
        if (i15 > 7) {
            this.zzc = i14 + 1;
            this.zzd = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.zzc) {
                zzh();
                return;
            } else if (zzi(i12)) {
                this.zzc++;
                i12 += 2;
            }
        }
    }

    public final boolean zzf() {
        boolean z11;
        if ((this.zza[this.zzc] & (128 >> this.zzd)) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzd();
        return z11;
    }
}
