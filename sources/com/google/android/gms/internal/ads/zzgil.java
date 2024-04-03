package com.google.android.gms.internal.ads;

public final class zzgil {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzgil(byte[] bArr) {
        for (int i11 = 0; i11 < 256; i11++) {
            this.zza[i11] = (byte) i11;
        }
        byte b11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            byte[] bArr2 = this.zza;
            byte b12 = bArr2[i12];
            b11 = (b11 + b12 + bArr[i12 % bArr.length]) & 255;
            bArr2[i12] = bArr2[b11];
            bArr2[b11] = b12;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i11 = this.zzb;
        int i12 = this.zzc;
        for (int i13 = 0; i13 < 256; i13++) {
            i11 = (i11 + 1) & 255;
            byte[] bArr2 = this.zza;
            byte b11 = bArr2[i11];
            i12 = (i12 + b11) & 255;
            bArr2[i11] = bArr2[i12];
            bArr2[i12] = b11;
            bArr[i13] = (byte) (bArr2[(bArr2[i11] + b11) & 255] ^ bArr[i13]);
        }
        this.zzb = i11;
        this.zzc = i12;
    }
}
