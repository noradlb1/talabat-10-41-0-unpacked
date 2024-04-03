package com.google.android.gms.internal.ads;

public final class zzawv {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd = 0;

    public zzawv(byte[] bArr, int i11, int i12) {
        this.zza = bArr;
        this.zzc = i11;
        this.zzb = i12;
        zzg();
    }

    private final int zzf() {
        int i11 = 0;
        int i12 = 0;
        while (!zze()) {
            i12++;
        }
        int i13 = (1 << i12) - 1;
        if (i12 > 0) {
            i11 = zza(i12);
        }
        return i13 + i11;
    }

    private final void zzg() {
        int i11;
        int i12;
        int i13 = this.zzc;
        boolean z11 = false;
        if (i13 >= 0 && (i11 = this.zzd) >= 0 && i11 < 8 && (i13 < (i12 = this.zzb) || (i13 == i12 && i11 == 0))) {
            z11 = true;
        }
        zzawm.zze(z11);
    }

    private final boolean zzh(int i11) {
        if (i11 < 2 || i11 >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i11] == 3 && bArr[i11 + -2] == 0 && bArr[i11 + -1] == 0;
    }

    public final int zza(int i11) {
        int i12;
        byte b11;
        int i13;
        byte b12;
        int i14 = i11 >> 3;
        byte b13 = 0;
        for (int i15 = 0; i15 < i14; i15++) {
            if (zzh(this.zzc + 1)) {
                i13 = this.zzc + 2;
            } else {
                i13 = this.zzc + 1;
            }
            int i16 = this.zzd;
            if (i16 != 0) {
                byte[] bArr = this.zza;
                b12 = ((bArr[i13] & 255) >>> (8 - i16)) | ((bArr[this.zzc] & 255) << i16);
            } else {
                b12 = this.zza[this.zzc];
            }
            i11 -= 8;
            b13 |= (255 & b12) << i11;
            this.zzc = i13;
        }
        if (i11 > 0) {
            int i17 = this.zzd + i11;
            byte b14 = (byte) (255 >> (8 - i11));
            if (zzh(this.zzc + 1)) {
                i12 = this.zzc + 2;
            } else {
                i12 = this.zzc + 1;
            }
            if (i17 > 8) {
                byte[] bArr2 = this.zza;
                b11 = (b14 & (((255 & bArr2[i12]) >> (16 - i17)) | ((bArr2[this.zzc] & 255) << (i17 - 8)))) | b13;
                this.zzc = i12;
            } else {
                b11 = (b14 & ((255 & this.zza[this.zzc]) >> (8 - i17))) | b13;
                if (i17 == 8) {
                    this.zzc = i12;
                }
            }
            b13 = b11;
            this.zzd = i17 % 8;
        }
        zzg();
        return b13;
    }

    public final int zzb() {
        int zzf = zzf();
        return (zzf % 2 == 0 ? -1 : 1) * ((zzf + 1) / 2);
    }

    public final int zzc() {
        return zzf();
    }

    public final void zzd(int i11) {
        int i12 = this.zzc;
        int i13 = (i11 >> 3) + i12;
        this.zzc = i13;
        int i14 = this.zzd + (i11 & 7);
        this.zzd = i14;
        if (i14 > 7) {
            this.zzc = i13 + 1;
            this.zzd = i14 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.zzc) {
                zzg();
                return;
            } else if (zzh(i12)) {
                this.zzc++;
                i12 += 2;
            }
        }
    }

    public final boolean zze() {
        return zza(1) == 1;
    }
}
