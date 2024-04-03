package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class zzay {
    final String zzagg;
    final byte[] zzagh;

    public zzay(String str, byte[] bArr) {
        this.zzagg = str;
        this.zzagh = bArr;
    }

    public final String toString() {
        String str = this.zzagg;
        int hashCode = Arrays.hashCode(this.zzagh);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 54);
        sb2.append("KeyAndSerialized: key = ");
        sb2.append(str);
        sb2.append(" serialized hash = ");
        sb2.append(hashCode);
        return sb2.toString();
    }
}
