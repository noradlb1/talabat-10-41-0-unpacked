package com.google.android.gms.internal.ads;

public final class zzxu {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzxu(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final int zza() {
        return (this.zzc * 8) + this.zzd;
    }

    public final int zzb(int i11) {
        int i12 = this.zzc;
        int min = Math.min(i11, 8 - this.zzd);
        int i13 = i12 + 1;
        int i14 = ((this.zza[i12] & 255) >> this.zzd) & (255 >> (8 - min));
        while (min < i11) {
            i14 |= (this.zza[i13] & 255) << min;
            min += 8;
            i13++;
        }
        zzc(i11);
        return (-1 >>> (32 - i11)) & i14;
    }

    public final void zzc(int i11) {
        int i12;
        int i13 = i11 / 8;
        int i14 = this.zzc + i13;
        this.zzc = i14;
        int i15 = this.zzd + (i11 - (i13 * 8));
        this.zzd = i15;
        if (i15 > 7) {
            i14++;
            this.zzc = i14;
            i15 -= 8;
            this.zzd = i15;
        }
        boolean z11 = false;
        if (i14 >= 0 && (i14 < (i12 = this.zzb) || (i14 == i12 && i15 == 0))) {
            z11 = true;
        }
        zzdy.zzf(z11);
    }

    public final boolean zzd() {
        byte b11 = this.zza[this.zzc];
        int i11 = this.zzd;
        zzc(1);
        if (1 != (((b11 & 255) >> i11) & 1)) {
            return false;
        }
        return true;
    }
}
