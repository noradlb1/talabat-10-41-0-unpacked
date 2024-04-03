package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;

public final class zzzw extends zzzu {
    public static final Parcelable.Creator<zzzw> CREATOR = new zzzv();
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzzw(Parcel parcel) {
        super(InternalFrame.ID);
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzw.class == obj.getClass()) {
            zzzw zzzw = (zzzw) obj;
            if (!zzfn.zzP(this.zzb, zzzw.zzb) || !zzfn.zzP(this.zza, zzzw.zza) || !zzfn.zzP(this.zzc, zzzw.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        String str = this.zza;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i11 + 527) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str3 = this.zzc;
        if (str3 != null) {
            i13 = str3.hashCode();
        }
        return i15 + i13;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        int length = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": domain=");
        sb2.append(str2);
        sb2.append(", description=");
        sb2.append(str3);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzzw(String str, String str2, String str3) {
        super(InternalFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
