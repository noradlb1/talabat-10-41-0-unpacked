package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcj  reason: invalid package */
final class zzcj implements Comparable {
    private final byte[] zza;

    public /* synthetic */ zzcj(byte[] bArr, zzci zzci) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzcj zzcj = (zzcj) obj;
        int length = this.zza.length;
        int length2 = zzcj.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i11 >= bArr.length) {
                return 0;
            }
            byte b11 = bArr[i11];
            byte b12 = zzcj.zza[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
            i11++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcj)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzcj) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzvt.zza(this.zza);
    }
}
