package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

public final class zzaae extends zzzu {
    public static final Parcelable.Creator<zzaae> CREATOR = new zzaad();
    @Nullable
    public final String zza;
    public final String zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaae(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzfn.zza
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.zza = r0
            java.lang.String r3 = r3.readString()
            r2.zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaae.<init>(android.os.Parcel):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaae.class == obj.getClass()) {
            zzaae zzaae = (zzaae) obj;
            if (!this.zzf.equals(zzaae.zzf) || !zzfn.zzP(this.zza, zzaae.zza) || !zzfn.zzP(this.zzb, zzaae.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (this.zzf.hashCode() + 527) * 31;
        String str = this.zza;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = (hashCode + i11) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zzb;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(": url=");
        sb2.append(str2);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzaae(String str, @Nullable String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }
}
