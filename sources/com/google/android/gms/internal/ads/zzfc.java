package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;

public final class zzfc {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzfc() {
        this.zza = zzfn.zzf;
    }

    public zzfc(byte[] bArr, int i11) {
        this.zza = bArr;
        this.zzd = i11;
    }

    private final void zzm() {
        int i11;
        int i12 = this.zzb;
        boolean z11 = false;
        if (i12 >= 0 && (i12 < (i11 = this.zzd) || (i12 == i11 && this.zzc == 0))) {
            z11 = true;
        }
        zzdy.zzf(z11);
    }

    public final int zza() {
        return ((this.zzd - this.zzb) * 8) - this.zzc;
    }

    public final int zzb() {
        return (this.zzb * 8) + this.zzc;
    }

    public final int zzc(int i11) {
        int i12;
        if (i11 == 0) {
            return 0;
        }
        this.zzc += i11;
        int i13 = 0;
        while (true) {
            i12 = this.zzc;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.zzc = i14;
            byte[] bArr = this.zza;
            int i15 = this.zzb;
            this.zzb = i15 + 1;
            i13 |= (bArr[i15] & 255) << i14;
        }
        byte[] bArr2 = this.zza;
        int i16 = this.zzb;
        int i17 = (-1 >>> (32 - i11)) & (i13 | ((bArr2[i16] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.zzc = 0;
            this.zzb = i16 + 1;
        }
        zzm();
        return i17;
    }

    public final void zzd() {
        if (this.zzc != 0) {
            this.zzc = 0;
            this.zzb++;
            zzm();
        }
    }

    public final void zze(int i11, int i12) {
        int i13 = i11 & 16383;
        int min = Math.min(8 - this.zzc, 14);
        int i14 = this.zzc;
        int i15 = (8 - i14) - min;
        byte[] bArr = this.zza;
        int i16 = this.zzb;
        byte b11 = (byte) (((MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i14) | ((1 << i15) - 1)) & bArr[i16]);
        bArr[i16] = b11;
        int i17 = 14 - min;
        bArr[i16] = (byte) (b11 | ((i13 >>> i17) << i15));
        int i18 = i16 + 1;
        while (i17 > 8) {
            i17 -= 8;
            this.zza[i18] = (byte) (i13 >>> i17);
            i18++;
        }
        int i19 = 8 - i17;
        byte[] bArr2 = this.zza;
        byte b12 = (byte) (bArr2[i18] & ((1 << i19) - 1));
        bArr2[i18] = b12;
        bArr2[i18] = (byte) (((i13 & ((1 << i17) - 1)) << i19) | b12);
        zzj(14);
        zzm();
    }

    public final void zzf(byte[] bArr, int i11, int i12) {
        int i13 = i12 >> 3;
        for (int i14 = 0; i14 < i13; i14++) {
            byte[] bArr2 = this.zza;
            int i15 = this.zzb;
            int i16 = i15 + 1;
            this.zzb = i16;
            byte b11 = bArr2[i15];
            int i17 = this.zzc;
            byte b12 = (byte) (b11 << i17);
            bArr[i14] = b12;
            bArr[i14] = (byte) (((255 & bArr2[i16]) >> (8 - i17)) | b12);
        }
        int i18 = i12 & 7;
        if (i18 != 0) {
            byte b13 = (byte) (bArr[i13] & (255 >> i18));
            bArr[i13] = b13;
            int i19 = this.zzc;
            if (i19 + i18 > 8) {
                byte[] bArr3 = this.zza;
                int i21 = this.zzb;
                this.zzb = i21 + 1;
                b13 = (byte) (b13 | ((bArr3[i21] & 255) << i19));
                bArr[i13] = b13;
                i19 -= 8;
            }
            int i22 = i19 + i18;
            this.zzc = i22;
            byte[] bArr4 = this.zza;
            int i23 = this.zzb;
            bArr[i13] = (byte) (((byte) (((255 & bArr4[i23]) >> (8 - i22)) << (8 - i18))) | b13);
            if (i22 == 8) {
                this.zzc = 0;
                this.zzb = i23 + 1;
            }
            zzm();
        }
    }

    public final void zzg(byte[] bArr, int i11) {
        this.zza = bArr;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = i11;
    }

    public final void zzh(int i11) {
        int i12 = i11 / 8;
        this.zzb = i12;
        this.zzc = i11 - (i12 * 8);
        zzm();
    }

    public final void zzi() {
        int i11 = this.zzc + 1;
        this.zzc = i11;
        if (i11 == 8) {
            this.zzc = 0;
            this.zzb++;
        }
        zzm();
    }

    public final void zzj(int i11) {
        int i12 = i11 / 8;
        int i13 = this.zzb + i12;
        this.zzb = i13;
        int i14 = this.zzc + (i11 - (i12 * 8));
        this.zzc = i14;
        if (i14 > 7) {
            this.zzb = i13 + 1;
            this.zzc = i14 - 8;
        }
        zzm();
    }

    public final void zzk(int i11) {
        boolean z11;
        if (this.zzc == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        this.zzb += i11;
        zzm();
    }

    public final boolean zzl() {
        boolean z11;
        if ((this.zza[this.zzb] & (128 >> this.zzc)) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzi();
        return z11;
    }
}
