package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class zzapt {
    public static final zzapt zza = new zzapt(new int[]{2}, 2);
    private final int[] zzb;
    private final int zzc = 2;

    public zzapt(int[] iArr, int i11) {
        int[] copyOf = Arrays.copyOf(iArr, 1);
        this.zzb = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzapt) && Arrays.equals(this.zzb, ((zzapt) obj).zzb)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzb) * 31) + 2;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzb);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb2.append("AudioCapabilities[maxChannelCount=2, supportedEncodings=");
        sb2.append(arrays);
        sb2.append("]");
        return sb2.toString();
    }
}
