package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzagk {
    private final String zza;
    private final String zzb;

    public zzagk(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagk.class == obj.getClass()) {
            zzagk zzagk = (zzagk) obj;
            if (!TextUtils.equals(this.zza, zzagk.zza) || !TextUtils.equals(this.zzb, zzagk.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb2.append("Header[name=");
        sb2.append(str);
        sb2.append(",value=");
        sb2.append(str2);
        sb2.append("]");
        return sb2.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
