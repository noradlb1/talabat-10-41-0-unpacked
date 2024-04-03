package com.google.android.gms.internal.ads;

public final class zzawt {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzawt() {
    }

    public zzawt(byte[] bArr, int i11) {
        this.zza = bArr;
        this.zzd = i11;
    }

    public final int zza(int i11) {
        int i12;
        int i13;
        byte b11;
        byte b12;
        int i14 = i11 >> 3;
        boolean z11 = false;
        byte b13 = 0;
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = this.zzc;
            if (i16 != 0) {
                byte[] bArr = this.zza;
                int i17 = this.zzb;
                b12 = ((bArr[i17 + 1] & 255) >>> (8 - i16)) | ((bArr[i17] & 255) << i16);
            } else {
                b12 = this.zza[this.zzb];
            }
            i11 -= 8;
            b13 |= (255 & b12) << i11;
            this.zzb++;
        }
        if (i11 > 0) {
            int i18 = this.zzc + i11;
            byte b14 = (byte) (255 >> (8 - i11));
            if (i18 > 8) {
                byte[] bArr2 = this.zza;
                int i19 = this.zzb;
                int i21 = i19 + 1;
                b11 = (b14 & (((255 & bArr2[i21]) >> (16 - i18)) | ((bArr2[i19] & 255) << (i18 - 8)))) | b13;
                this.zzb = i21;
            } else {
                byte[] bArr3 = this.zza;
                int i22 = this.zzb;
                b11 = (b14 & ((255 & bArr3[i22]) >> (8 - i18))) | b13;
                if (i18 == 8) {
                    this.zzb = i22 + 1;
                }
            }
            b13 = b11;
            this.zzc = i18 % 8;
        }
        int i23 = this.zzb;
        if (i23 >= 0 && (i12 = this.zzc) >= 0 && (i23 < (i13 = this.zzd) || (i23 == i13 && i12 == 0))) {
            z11 = true;
        }
        zzawm.zze(z11);
        return b13;
    }
}
