package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzle {
    public static final zzle zza = new zzle(new int[]{2}, 8);
    private static final zzle zzb = new zzle(new int[]{2, 5, 6}, 8);
    private final int[] zzc;
    private final int zzd = 8;

    public zzle(@Nullable int[] iArr, int i11) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzc = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzle) && Arrays.equals(this.zzc, ((zzle) obj).zzc)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzc) * 31) + 8;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzc);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb2.append("AudioCapabilities[maxChannelCount=8, supportedEncodings=");
        sb2.append(arrays);
        sb2.append("]");
        return sb2.toString();
    }
}
