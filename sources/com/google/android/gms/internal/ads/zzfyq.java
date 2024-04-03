package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Arrays;

final class zzfyq implements Comparable<zzfyq> {
    private final byte[] zza;

    public /* synthetic */ zzfyq(byte[] bArr, zzfyp zzfyp) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfyq zzfyq = (zzfyq) obj;
        int length = this.zza.length;
        int length2 = zzfyq.zza.length;
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
            byte b12 = zzfyq.zza[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
            i11++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfyq)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzfyq) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(r2 + r2);
        for (byte b11 : this.zza) {
            byte b12 = b11 & 255;
            sb2.append("0123456789abcdef".charAt(b12 >> 4));
            sb2.append("0123456789abcdef".charAt(b12 & Ascii.SI));
        }
        return sb2.toString();
    }
}
