package com.google.android.libraries.places.api.model;

import androidx.annotation.Nullable;

abstract class zzu extends PlusCode {
    private final String zza;
    private final String zzb;

    public zzu(@Nullable String str, @Nullable String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlusCode) {
            PlusCode plusCode = (PlusCode) obj;
            String str = this.zza;
            if (str != null ? str.equals(plusCode.getCompoundCode()) : plusCode.getCompoundCode() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(plusCode.getGlobalCode()) : plusCode.getGlobalCode() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final String getCompoundCode() {
        return this.zza;
    }

    @Nullable
    public final String getGlobalCode() {
        return this.zzb;
    }

    public final int hashCode() {
        int i11;
        String str = this.zza;
        int i12 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i13 = (i11 ^ 1000003) * 1000003;
        String str2 = this.zzb;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 ^ i12;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length());
        sb2.append("PlusCode{compoundCode=");
        sb2.append(str);
        sb2.append(", globalCode=");
        sb2.append(str2);
        sb2.append("}");
        return sb2.toString();
    }
}
