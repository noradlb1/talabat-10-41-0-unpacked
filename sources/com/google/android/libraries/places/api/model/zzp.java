package com.google.android.libraries.places.api.model;

import androidx.annotation.IntRange;

abstract class zzp extends PhotoMetadata {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;

    public zzp(String str, int i11, int i12, String str2) {
        if (str != null) {
            this.zza = str;
            this.zzb = i11;
            this.zzc = i12;
            if (str2 != null) {
                this.zzd = str2;
                return;
            }
            throw new NullPointerException("Null photoReference");
        }
        throw new NullPointerException("Null attributions");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PhotoMetadata) {
            PhotoMetadata photoMetadata = (PhotoMetadata) obj;
            if (!this.zza.equals(photoMetadata.getAttributions()) || this.zzb != photoMetadata.getHeight() || this.zzc != photoMetadata.getWidth() || !this.zzd.equals(photoMetadata.zza())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAttributions() {
        return this.zza;
    }

    @IntRange(from = 0)
    public int getHeight() {
        return this.zzb;
    }

    @IntRange(from = 0)
    public int getWidth() {
        return this.zzc;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ this.zzc) * 1000003) ^ this.zzd.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        int i11 = this.zzb;
        int i12 = this.zzc;
        String str2 = this.zzd;
        StringBuilder sb2 = new StringBuilder(str.length() + 84 + str2.length());
        sb2.append("PhotoMetadata{attributions=");
        sb2.append(str);
        sb2.append(", height=");
        sb2.append(i11);
        sb2.append(", width=");
        sb2.append(i12);
        sb2.append(", photoReference=");
        sb2.append(str2);
        sb2.append("}");
        return sb2.toString();
    }

    public final String zza() {
        return this.zzd;
    }
}
