package com.google.android.libraries.places.internal;

final class zzdd extends zzdf {
    private final String zza;
    private final int zzb;
    private final int zzc;

    public /* synthetic */ zzdd(String str, int i11, int i12, zzdc zzdc) {
        this.zza = str;
        this.zzb = i11;
        this.zzc = i12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdf) {
            zzdf zzdf = (zzdf) obj;
            if (this.zza.equals(zzdf.zzb()) && this.zzb == zzdf.zza()) {
                int i11 = this.zzc;
                int zzc2 = zzdf.zzc();
                if (i11 == 0) {
                    throw null;
                } else if (i11 == zzc2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb) * 1000003;
        int i11 = this.zzc;
        if (i11 != 0) {
            return hashCode ^ i11;
        }
        throw null;
    }

    public final String toString() {
        String str = this.zza;
        int i11 = this.zzb;
        int i12 = this.zzc;
        String str2 = i12 != 1 ? i12 != 2 ? "null" : "AUTOCOMPLETE_WIDGET" : "PROGRAMMATIC_API";
        StringBuilder sb2 = new StringBuilder(str.length() + 68 + str2.length());
        sb2.append("ClientProfile{packageName=");
        sb2.append(str);
        sb2.append(", versionCode=");
        sb2.append(i11);
        sb2.append(", requestSource=");
        sb2.append(str2);
        sb2.append("}");
        return sb2.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzc;
    }
}
