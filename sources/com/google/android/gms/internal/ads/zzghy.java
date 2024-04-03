package com.google.android.gms.internal.ads;

public final class zzghy {
    private final byte[] zza;

    private zzghy(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i12);
    }

    public static zzghy zza(byte[] bArr, int i11, int i12) {
        return new zzghy(bArr, 0, i12);
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
