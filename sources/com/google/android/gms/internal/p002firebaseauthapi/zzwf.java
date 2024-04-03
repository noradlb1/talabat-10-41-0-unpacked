package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwf  reason: invalid package */
public final class zzwf {
    private final byte[] zza;

    private zzwf(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i12);
    }

    public static zzwf zzb(byte[] bArr) {
        if (bArr != null) {
            return new zzwf(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzwf)) {
            return false;
        }
        return Arrays.equals(((zzwf) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza2 = zzvt.zza(this.zza);
        return "Bytes(" + zza2 + ")";
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
